package ilgulee.com.kotlindevvideolecbookofbrain.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ilgulee.com.kotlindevvideolecbookofbrain.R
import ilgulee.com.kotlindevvideolecbookofbrain.showText
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val message = bundle!!.getString("user_message")
        showText(message!!)
        textView_intent_message.text = message


    }
}