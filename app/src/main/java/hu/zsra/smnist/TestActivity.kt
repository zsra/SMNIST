package hu.zsra.smnist

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrInterface
import hu.zsra.smnist.core.Test
import hu.zsra.smnist.core.TestCollector
import hu.zsra.smnist.core.TestService
import kotlinx.android.synthetic.main.activity_test.*

/***
 * The test activity where the test will be running.
 */
@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class TestActivity : AppCompatActivity() {

    var TestIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        confDefault()


        //intent.getStringExtra("TestsNumber").toInt()
        val testCollector = TestCollector(intent.getStringExtra("TestsNumber").toInt())
        val testService = TestService()

        runTest(testCollector, testService)
    }

    /***
     * Call the hideActionBar() method and activity the slide function.
     */
    private fun confDefault() {
        hideActionBar()
        val slidr : SlidrInterface = Slidr.attach(this)
        slidr.unlock()
    }

    /***
     * Hide the action bar.
     */
    private fun hideActionBar() {
        if(supportActionBar != null) {
            supportActionBar?.hide()
        }
    }

    /***
     * Create a new Test. Generate random numbers to get resource file, Reset a
     * background color of the image, set the dog snacks image and add click event lisntener.
     */
    private fun newTest(testCollector: TestCollector, testService: TestService) {
        // GENERATE a random number to get resources.
        var topResourceNumber = testService.randomAmountOfSnacks
        var botResourceNumber = testService.randomAmountOfSnacks
        // IF these variable are equals, generate a different number to bot ImageView.
        while(topResourceNumber == botResourceNumber) {
            botResourceNumber = testService.randomAmountOfSnacks
        }

        val test = Test(topResourceNumber, botResourceNumber)

        enableButton()

        // RESET a background colors.
        imgv_top.setBackgroundColor(Color.TRANSPARENT)
        imgv_bot.setBackgroundColor(Color.TRANSPARENT)

        // SET the dog snacks.
        setImageBackground(imgv_top, getImageResourcesRandom(topResourceNumber))
        setImageBackground(imgv_bot, getImageResourcesRandom(botResourceNumber))

        // ADD click event listeners to ImageViews.
        imgTopClickEventListener(testCollector, test)
        imgBotClickEventListener(testCollector, test)


    }

    /***
     * Set background of ImageView.
     */
    private fun setImageBackground(imgView : ImageView,imageIndex : Int) {
        imgView.setImageResource(imageIndex)
    }

    /***
     * Run tests until the Index not equals with number of tests.
     */
    private fun runTest(testCollector: TestCollector, testService: TestService) {

        if(TestIndex == testCollector.numberOfTest - 1) {
            showResult(testCollector, testService)
            TestIndex = 0
        }
        newTest(testCollector, testService)
        btn_next.setOnClickListener {
            runTest(testCollector, testService)
            TestIndex++

        }
    }

    /***
     * Set setOnClickListener event on top ImageView.
     */
    private fun imgTopClickEventListener(testCollector: TestCollector, test : Test){
        imgv_top.setOnClickListener {
            test.isChooseBigger = test.top_number > test.bot_number
            testCollector.AddTestToCollector(test) // ADD test to the collector
            // SET background to red if the dog choose this.
            imgv_top.setBackgroundResource(R.color.colorTestBackgroundClicked)
            disableButton()
        }
    }

    /***
     * Set setOnClickListener event on bot ImageView.
     */
    private fun imgBotClickEventListener(testCollector: TestCollector, test : Test){
        imgv_bot.setOnClickListener {
            test.isChooseBigger = test.top_number < test.bot_number
            testCollector.AddTestToCollector(test) // ADD test to the collector
            // SET background to red if the dog choose this.
            imgv_bot.setBackgroundResource(R.color.colorTestBackgroundClicked)
            disableButton()
        }
    }

    /***
     * Make buttons disable if the dog chosen.
     */
    private fun disableButton() {
        imgv_top.isClickable = false
        imgv_bot.isClickable = false
    }

    /***
     * Make buttons enable if a new test start.
     */
    private fun enableButton() {
        imgv_top.isClickable = true
        imgv_bot.isClickable = true
    }

    /***
     * Get Resource id from the generated number.
     */
    private fun getImageResourcesRandom(generateIndex : Int) : Int {
        when(generateIndex) {
            1 -> return R.drawable.dog_snack1
            2 -> return R.drawable.dog_snack2
            3 -> return R.drawable.dog_snack3
            4 -> return R.drawable.dog_snack4
            5 -> return R.drawable.dog_snack5
            6 -> return R.drawable.dog_snack6
        }
        return 0
    }

    /***
     * After tests finished open the TestActivity.
     */
    private fun showResult(testCollector: TestCollector, testService: TestService) {
        val intent = Intent(applicationContext, ResultActivity::class.java)
        intent.putExtra("NumberOfTests", testCollector.numberOfTest.toString())
        intent.putExtra("ChosenMoreSnacks", testService.getAllTestsBigger(testCollector).toString())
        Log.d("Percent: ", testService.calcPercentage(testCollector).toString())
        intent.putExtra("Percentage", "%.2f".format(testService.calcPercentage(testCollector)))
        startActivity(intent)
    }
}