package com.example.calculator_oop_kotlin_project

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListeners()
    }

    private fun setOnClickListeners()
    {
        options_btn.setOnClickListener {  }
        clear_btn.setOnClickListener { clearAllText() }
        plus_minus_btn.setOnClickListener {  }
        one_divide_x_btn.setOnClickListener {  }
        divide_btn.setOnClickListener {  }
        multiply_btn.setOnClickListener {  }
        minus_btn.setOnClickListener {  }
        plus_minus_btn.setOnClickListener {  }
        equals_btn.setOnClickListener {  }
        back_btn.setOnClickListener { clearLastCharacter() }

        nine_btn.setOnClickListener { appendText("9") }
        eight_btn.setOnClickListener { appendText("8") }
        seven_btn.setOnClickListener { appendText("7") }
        six_btn.setOnClickListener { appendText("6") }
        five_btn.setOnClickListener { appendText("5") }
        four_btn.setOnClickListener { appendText("4") }
        three_btn.setOnClickListener { appendText("3") }
        two_btn.setOnClickListener { appendText("2") }
        one_btn.setOnClickListener { appendText("1") }
        zero_btn.setOnClickListener { appendText("0") }
        dot_btn.setOnClickListener { appendText(".") }
    }

    private fun appendText(number: String)
    {
        second_numbers.append(number);
    }

    private fun clearAllText()
    {
        first_numbers.text=""
        second_numbers.text=""
    }

    private fun clearLastCharacter()
    {
        val tempString = second_numbers.text.toString()
        if (tempString.isNotEmpty())
        {
            second_numbers.text = tempString.substring(0, tempString.length-1)
        }
        //second_numbers
    }

    private fun finishSecondNumber()
    {
        first_numbers.text = second_numbers.text
        second_numbers.text=""
    }
}
