package hu.zsra.smnist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS",
    "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)
class ResultActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        txt_FinishedTestContainer.text = intent.getStringExtra("NumberOfTests")
        txt_ChosenSnacksContainer.text = intent.getStringExtra("ChosenMoreSnacks")
        txtPercentage.text = intent.getStringExtra("Percentage") + "%"
        backToMain()
    }


    /***
     * Add click event to ok button that return back to main menu.
     *
     */
    private fun backToMain(){
        backToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
