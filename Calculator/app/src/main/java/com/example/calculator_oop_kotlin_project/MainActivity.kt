
package com.example.calculator_oop_kotlin_project

import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    var operation: Char = ' '
    var firstNumberToOperate: Double = 0.0
    var secondNumberToOperate: Double = 0.0

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
        plus_minus_btn.setOnClickListener { plusMinusFunction() }
        one_divide_x_btn.setOnClickListener { reciprocalFunction() }
        divide_btn.setOnClickListener { divideFunction() }
        multiply_btn.setOnClickListener { multiplyFunction() }
        minus_btn.setOnClickListener { minusFunction() }
        plus_btn.setOnClickListener { plusFunction() }
        equals_btn.setOnClickListener { equalsFunction() }
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
        second_scroll.post { second_scroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT) }
    }

    private fun clearAllText()
    {
        first_numbers.text=""
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

    private fun plusFunction()
    {
        operation = '+'
        finishSecondNumber()
        procedure.text=operation.toString()
    }

    private fun minusFunction()
    {
        operation = '-'
        finishSecondNumber()
        procedure.text=operation.toString()
    }

    private fun divideFunction()
    {
        operation = '/'
        finishSecondNumber()
        procedure.text=operation.toString()
    }

    private fun multiplyFunction()
    {
        operation = '*'
        finishSecondNumber()
        procedure.text=operation.toString()
    }

    private fun plusMinusFunction()
    {
        var tempOperation = operation
        operation = '±'
        changeOneNumber()
        operation = tempOperation
    }

    private fun reciprocalFunction()
    {
        var tempOperation = operation
        operation = 'R'
        changeOneNumber()
        operation = tempOperation
    }

    private fun equalsFunction()
    {
        if(first_numbers.text.isNullOrEmpty() && !second_numbers.text.isNullOrEmpty())
        {
            // DO NOTHING
        }
        else if (!second_numbers.text.isNullOrEmpty())
        {
            val tempValue1 = first_numbers.text.toString()
            val tempValue2 = second_numbers.text.toString()

            var result: Double = 0.0
            if (operation == '+') {
                result = tempValue1.toDouble() + tempValue2.toDouble()
            } else if (operation == '-') {
                result = tempValue1.toDouble() - tempValue2.toDouble()
            } else if (operation == '/')
            {
                result = tempValue1.toDouble() / tempValue2.toDouble()
            }
            else if (operation == '*')
            {
                result = tempValue1.toDouble() * tempValue2.toDouble()
            }

            first_numbers.text = result.toString()
            second_numbers.text = ""
        }
    }

    private fun changeOneNumber()
    {
        if(!first_numbers.text.isNullOrEmpty())
        {
            val tempValue1 = first_numbers.text.toString()

            var result: Double = 0.0
            if (operation == '±')
            {
                result = tempValue1.toDouble() * -1
            }
            else if (operation == 'R')
            {
                result = 1 / tempValue1.toDouble()
            }
            first_numbers.text = result.toString()
        }
    }
}
