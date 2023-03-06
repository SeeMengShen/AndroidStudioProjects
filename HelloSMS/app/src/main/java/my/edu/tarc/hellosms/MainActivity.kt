package my.edu.tarc.hellosms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

// Instance Name : Class Name
class MainActivity : AppCompatActivity() {

    //  onCreate = main function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //  Load UI to the memory
        //  R = resources class
        setContentView(R.layout.activity_main)

        //  Declare UI variables
        //  val = value, var = variable

        val textViewName    : TextView  = findViewById(R.id.textViewName)
        val imageViewQR     : ImageView = findViewById(R.id.imageViewQR)
        val buttonShow      : Button    = findViewById(R.id.buttonShow)
        val buttonHide                  = findViewById<Button>(R.id.buttonHide)

        //  Declare event handler
        buttonShow.setOnClickListener() {
            textViewName.visibility = View.VISIBLE
            imageViewQR.visibility = View.VISIBLE
        }

        buttonHide.setOnClickListener() {
            textViewName.visibility = View.INVISIBLE
            imageViewQR.visibility = View.INVISIBLE
        }
    }
}