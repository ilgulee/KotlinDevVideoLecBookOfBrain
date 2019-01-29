package ilgulee.com.kotlindevvideolecbookofbrain

import android.content.Context
import android.widget.Toast

fun Context.showText(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}