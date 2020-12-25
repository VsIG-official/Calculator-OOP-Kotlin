
package com.example.calculator_oop_kotlin_project

import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.example.calculator_oop_kotlin_project.MathOperations

class MainActivity : AppCompatActivity()
{
    var operation: Char = ' '
    var firstNumberToOperate: Double = 0.0
    var secondNumberToOperate: Double = 0.0
    lateinit var MathClass: MathOperations

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first_numbers.text="0.0"
        MathClass = MathOperations(first_numbers, second_numbers)
        setOnClickListeners()
    }

    private fun setOnClickListeners()
    {
        options_btn.setOnClickListener {  }
        clear_btn.setOnClickListener { clearAllText() }
        plus_minus_btn.setOnClickListener { plusMinusFunction() }
        one_divide_x_btn.setOnClickListener { reciprocalFunction() }
        divide_btn.setOnClickListener { divideFunction() }
        multiply_btn.setOnClickListener { multiplyFunction() }
        minus_btn.setOnClickListener { minusFunction() }
        plus_btn.setOnClickListener { MathClass.Add() }
        equals_btn.setOnClickListener { equalsFunction() }
        back_btn.setOnClickListener { clearLastCharacter() }
        mod_btn.setOnClickListener { modFunction() }
        degree_btn.setOnClickListener { degreeFunction() }

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
        second_scroll.post { second_scroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT) }
    }

    private fun clearAllText()
    {
        first_numbers.text="0.0"
        second_numbers.text=""
        operation=' '
        procedure.text=""
    }

    private fun clearLastCharacter()
    {
        val tempString = second_numbers.text.toString()
        if (tempString.isNotEmpty())
        {
            second_numbers.text = tempString.substring(0, tempString.length - 1)
        }
    }

    private fun finishSecondNumber()
    {
        if  (!first_numbers.text.isNullOrEmpty() && !second_numbers.text.isNullOrEmpty())
        {
            equalsFunction()
        }
        else if (!second_numbers.text.isNullOrEmpty())
        {
            first_numbers.text = second_numbers.text
            first_numbers.append(".0")
            second_numbers.text = ""
        }
    }


}
