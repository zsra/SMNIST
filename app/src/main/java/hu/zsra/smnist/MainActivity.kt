package hu.zsra.smnist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var DogAgeInMonth = ""
    var NumberOfTests = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            getDogAgeFromInputs()
            getNumberOfTestFromInput()

            val intent = Intent(this, TestActivity::class.java)

            //SEND values to TestActivity
            intent.putExtra("DogAge", DogAgeInMonth)
            intent.putExtra("TestsNumber", NumberOfTests)

            startActivity(intent)
        }
    }

    /***
     * Copy the age from the input_dogage and add to DogAgeInMonth.
     */
    private fun getDogAgeFromInputs() {
        DogAgeInMonth = input_dogage.text.toString()
    }

    /***
     * Copy the Number of Tests from the input_numberoftests and add to NumberOfTests.
     */
    private fun getNumberOfTestFromInput() {
        NumberOfTests = input_numberoftest.text.toString()
    }
}
