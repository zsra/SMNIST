package hu.zsra.smnist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrInterface

class TestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        hideActionBar()

        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        val slidr : SlidrInterface = Slidr.attach(this)
        slidr.unlock()
    }

    private fun hideActionBar() {
        if(supportActionBar != null) {
            supportActionBar?.hide()
        }
    }
}