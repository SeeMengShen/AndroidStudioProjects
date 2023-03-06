package my.edu.tarc.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Linking UI to code
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val buttonCal: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)

        buttonCal.setOnClickListener {
            if (editTextWeight.text.isEmpty()) {
                editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener
            }

            if (editTextHeight.text.isEmpty()) {
                editTextHeight.setError(getString(R.string.value_required))
                return@setOnClickListener
            }

            val weight = editTextWeight.text.toString().toFloat()
            val height = editTextHeight.text.toString().toFloat()

            val bmi = weight / (height / 100.0f).pow(2)

            if (bmi < 18.5f) {
                imageViewBMI.setImageResource(R.drawable.under)
                textViewStatus.text =
                    String.format("%s : %s", getString(R.string.status), getString(R.string.under))
            } else if (bmi >= 18.5f && bmi < 25.0f) {
                imageViewBMI.setImageResource(R.drawable.normal)
                textViewStatus.text =
                    String.format("%s : %s", getString(R.string.status), getString(R.string.normal))
            } else {
                imageViewBMI.setImageResource(R.drawable.over)
                textViewStatus.text =
                    String.format("%s : %s", getString(R.string.status), getString(R.string.over))
            }

            textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi), bmi)
        }

        buttonReset.setOnClickListener {
            imageViewBMI.setImageResource(R.drawable.empty)
            editTextHeight.text.clear()
            editTextWeight.text.clear()
            textViewBMI.text = getString(R.string.bmi)
            textViewStatus.text = getString(R.string.status)
        }
    }
}