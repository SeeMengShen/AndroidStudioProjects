package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View binding
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener() {
            var basic: Int = 0
            var extra: Int = 0
            var total: Int = 0

            // Get age group
            val age = binding.spinnerAge.selectedItemPosition
            basic = when (age) {
                0 -> 60
                1 -> 70
                2 -> 90
                3 -> 120
                else -> 150
            }

            // Get gender
            val gender = binding.radioGroupGender.checkedRadioButtonId
            if (gender == binding.radioButtonMale.id) {
                // Calculate extra premium for male
                extra += when (age) {
                    0 -> 0
                    1 -> 50
                    2 -> 100
                    3 -> 150
                    else -> 200
                }
            }

            // Get smoker status
            val smoker = binding.checkBoxSmoker.isChecked
            if (smoker) {
                // Calculate extra premium for smoker
                extra += when (age) {
                    0 -> 0
                    1 -> 100
                    2 -> 150
                    3 -> 200
                    4 -> 250
                    else -> 300
                }
            }

            total = basic + extra

            binding.myPremium = Premium(basic, extra, total)
        }

        binding.buttonReset.setOnClickListener() {
            binding.spinnerAge.setSelection(0)
            binding.radioButtonMale.isChecked = true
            binding.checkBoxSmoker.isChecked = false
            binding.myPremium = Premium()
        }
    }
}