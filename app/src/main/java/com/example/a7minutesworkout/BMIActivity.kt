package com.example.a7minutesworkout

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a7minutesworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {
    private var binding: ActivityBmiBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarBmiActivity)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "CALCULATE BMI"
        }
        binding?.toolbarBmiActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        binding?.btnCalculateUnits?.setOnClickListener {
            if (validateMetricUnits()) {
                val heightValue: Float =
                    binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
                val weighttValue: Float = binding?.etMetricUnitWeight?.text.toString().toFloat()
                val bmi = weighttValue / (heightValue * heightValue)
                displayBMIResult(bmi)
            } else {
                Toast.makeText(this@BMIActivity, "Please enter valid values", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
    private fun validateMetricUnits():Boolean{
        var isValid=true
        if (binding?.etMetricUnitWeight?.text.toString().isEmpty()){
            isValid=false
        }
        else if(binding?.etMetricUnitHeight?.text.toString().isEmpty()) {
            isValid = false
        }
        return isValid
    }


    private fun displayBMIResult(bmi:Float){

        var bmiLabel:String=""
        var bmiDescription : String=""

        if (bmi.compareTo(15f)<=0){
            bmiLabel="severelu underweight"
            bmiDescription="Oops! You really need to take better care of yourself! Eat more"
        }
        else if (bmi.compareTo(16f)>0 && bmi.compareTo(18.5f)<=0){
            bmiLabel="underweight"
            bmiDescription="Oops! You really need to take better care of yourself! Eat more  "

        }
        if (bmi.compareTo(18.5f)>0 && bmi.compareTo(25f)<=0)
        {
            bmiLabel="Normal"
            bmiDescription= "You are normal weight"
        }
        if (bmi.compareTo(30f)>0 && bmi.compareTo(35f)<=0)
        {
            bmiLabel="Obese Class"
            bmiDescription= "Workout more"
        }


        binding?.llDiplayBMIResult?.visibility = View.VISIBLE
        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()

        binding?.tvBMIValue?.text = bmiValue
        binding?.tvBMIType?.text = bmiLabel
        binding?.tvBMIDescription?.text = bmiDescription


    }


}