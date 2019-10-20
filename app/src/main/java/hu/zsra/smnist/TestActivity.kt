package hu.zsra.smnist

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrInterface
import hu.zsra.smnist.core.Test
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        confDefault()

        val test : Test = Test()

        setImageBackground(imgv_top, test)
        setImageBackground(imgv_bot, test)

        imgTopClickEventListener(test)
        imgBotClickEventListener(test)

    }

    private fun confDefault() : Unit {
        hideActionBar()
        val slidr : SlidrInterface = Slidr.attach(this)
        slidr.unlock()
    }

    private fun hideActionBar() {
        if(supportActionBar != null) {
            supportActionBar?.hide()
        }
    }

    private fun setImageBackground(imgView : ImageView, test : Test) : Unit {

        val resource = getImageResourcesRandom(test)
        imgView.setTag(resource)
        imgView.setImageResource(resource)

    }

    private fun imgTopClickEventListener(test : Test){
        imgv_top.setOnClickListener {

            setImageBackground(imgv_top, test)
        }
    }

    private fun imgBotClickEventListener(test : Test){
        imgv_bot.setOnClickListener {

            setImageBackground(imgv_bot, test)
        }
    }

    private fun getImageResourcesRandom(test : Test) : Int {
        when(test.randomAmountOfSnacks) {
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