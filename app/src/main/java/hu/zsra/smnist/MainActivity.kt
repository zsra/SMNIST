package hu.zsra.smnist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {

            val intent = Intent(applicationContext, TestActivity::class.java)

            //SEND values to TestActivity
            intent.putExtra("TestsNumber", input_numberoftest.text.toString())

            startActivity(intent)
        }
    }

}
