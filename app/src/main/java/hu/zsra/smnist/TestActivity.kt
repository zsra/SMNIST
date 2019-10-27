package hu.zsra.smnist

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrInterface
import hu.zsra.smnist.core.Test
import hu.zsra.smnist.core.TestCollector
import hu.zsra.smnist.core.TestService
import kotlinx.android.synthetic.main.activity_test.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/***
 * The test activity where the test will be running.
 */
@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class TestActivity : AppCompatActivity() {

    /***
     * How many test finished in one session.
     */
    private var TestIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        confDefault()

        val testCollector =  TestCollector(20, 5)
        val testService = TestService()

        testCollector.numberOfTest = intent.getStringExtra("TestsNumber").toString().toInt()
        testCollector.dogAgeInMonth = intent.getStringExtra("DogAge").toString().toInt()


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
    private fun newTest(collector: TestCollector, service : TestService) {
        // GENERATE a random number to get resources.
        var topResourceNumber = service.randomAmountOfSnacks
        var botResourceNumber = service.randomAmountOfSnacks
        // IF these variable are equals, generate a different number to bot ImageView.
        while(topResourceNumber == botResourceNumber) {
            botResourceNumber = service.randomAmountOfSnacks
        }

        val test = Test(topResourceNumber, botResourceNumber)

        // RESET a background colors.
        imgv_top.setBackgroundColor(Color.TRANSPARENT)
        imgv_bot.setBackgroundColor(Color.TRANSPARENT)

        // SET the dog snacks.
        setImageBackground(imgv_top, getImageResourcesRandom(topResourceNumber))
        setImageBackground(imgv_bot, getImageResourcesRandom(botResourceNumber))

        // ADD click event listeners to ImageViews.
        imgTopClickEventListener(collector, test)
        imgBotClickEventListener(collector, test)
    }

    /***
     * Set background of ImageView.
     */
    private fun setImageBackground(imgView : ImageView,imageIndex : Int) {
        imgView.tag = imageIndex
        imgView.setImageResource(imageIndex)
    }

    /***
     * Run tests until the TestIndex not equals with number of tests.
     */
    private fun runTest(collector: TestCollector, service: TestService) {

        newTest(collector, service)
        TestIndex += 1
        while(TestIndex < collector.numberOfTest) {
            //WAIT until the next button not clicked by "test-runner"
            btn_next.setOnClickListener {
                newTest(collector, service)
            }
            TestIndex += 1
        }
        TestIndex = 0
    }

    /***
     * Set setOnClickListener event on top ImageView.
     */
    private fun imgTopClickEventListener(collector: TestCollector, test : Test){
        imgv_top.setOnClickListener {
            test.isChooseBigger = test.top_number > test.bot_number
            collector.AddTestToCollector(test) // ADD test to the collector
            // SET background to red if the dog choose this.
            imgv_top.setBackgroundResource(R.color.colorTestBackgroundClicked)
        }
    }

    /***
     * Set setOnClickListener event on bot ImageView.
     */
    private fun imgBotClickEventListener(collector: TestCollector, test : Test){
        imgv_bot.setOnClickListener {
            test.isChooseBigger = test.top_number < test.bot_number
            collector.AddTestToCollector(test) // ADD test to the collector
            // SET background to red if the dog choose this.
            imgv_bot.setBackgroundResource(R.color.colorTestBackgroundClicked)
        }
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
}