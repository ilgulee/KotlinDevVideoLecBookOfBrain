package ilgulee.com.kotlindevvideolecbookofbrain.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ilgulee.com.kotlindevvideolecbookofbrain.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_show_toast.setOnClickListener {
            Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show()
        }

        button_send_intent.setOnClickListener {
            val message: String = editText_message.text.toString()
            //Toast.makeText(this, "Your message " + message, Toast.LENGTH_LONG).show()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }

        button_send_implicit.setOnClickListener {
            val message: String = editText_message.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "plain/text"
            startActivity(Intent.createChooser(intent, "Share to: "))
        }

        button_hobby_list.setOnClickListener {
            val intent = Intent(this, HobbyListActivity::class.java)
            startActivity(intent)
        }
    }
}
