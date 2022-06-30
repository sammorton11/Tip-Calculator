package com.example.tipcalculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

//Todo: add comments to code -- documentation -- finish tests -- upload to github

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calcButton = binding.calculateButton
        binding.tipResult.text = "" // hide the result text until the calculate button is pressed

        calcButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip(){

        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull() // cast the string from the edit field to a double

        // assign different percentages to the variable depending on which radio button is checked
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        // if the edit field is empty then return from here -- prevents app crash
        if (cost == null) {
            Toast.makeText(applicationContext, "Please Enter a Total", Toast.LENGTH_SHORT).show()
            return
        }

        var tip = tipPercentage * cost

        // if the round up switch is checked, round up to the nearest dollar
        if(binding.roundUpSwitch.isChecked){
            tip = kotlin.math.ceil(tip)
            displayTip(tip)
        }
    }

    private fun displayTip(tip: Double){
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}