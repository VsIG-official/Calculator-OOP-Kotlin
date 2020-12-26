
package com.example.calculator_oop_kotlin_project

import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    var operation: Char = ' '

    lateinit var lastOperator: Operator

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstNumber.text="0.0"
        setOnClickListeners()
    }

    private fun setOnClickListeners()
    {
        options_btn.setOnClickListener {  }
        clear_btn.setOnClickListener { clearAllText() }
        plus_minus_btn.setOnClickListener { calculate('±', OperatorPlusMinus()) }
        one_divide_x_btn.setOnClickListener { calculate('R', OperatorReciprocal()) }
        sin_btn.setOnClickListener { calculate('S', OperatorSin()) }
        cos_btn.setOnClickListener { calculate('C', OperatorCos()) }
        divide_btn.setOnClickListener { calculate('/', OperatorDivide()) }
        multiply_btn.setOnClickListener { calculate('*', OperatorMultiply()) }
        minus_btn.setOnClickListener { calculate('-', OperatorMinus()) }
        plus_btn.setOnClickListener { calculate('+', OperatorPlus()) }
        equals_btn.setOnClickListener { calculate(operation, lastOperator) }
        back_btn.setOnClickListener { clearLastCharacter() }
        mod_btn.setOnClickListener { calculate('%', OperatorMod()) }
        degree_btn.setOnClickListener { calculate('^', OperatorDegree()) }

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
        secondNumber.append(number);
        second_scroll.post { second_scroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT) }
    }

    private fun clearAllText()
    {
        firstNumber.text="0.0"
        secondNumber.text=""
        operation=' '
        procedure.text=""
    }

    private fun clearLastCharacter()
    {
        val tempString = secondNumber.text.toString()
        if (tempString.isNotEmpty())
        {
            secondNumber.text = tempString.substring(0, tempString.length - 1)
        }
    }

    private fun calculate(operationChar: Char, OperatorClass: Operator) {
        // current operation
        operation = operationChar

        lastOperator = OperatorClass

        var result:Double=0.0

        var tempValue1 = firstNumber.text.toString()
        var tempValue2 = secondNumber.text.toString()

        when {
            !firstNumber.text.isNullOrEmpty()  && secondNumber.text.isNullOrEmpty() -> {
                result = tempValue1.toDouble()
            }

            (firstNumber.text=="0.0" || firstNumber.text=="-0.0" ) && !secondNumber.text.isNullOrEmpty() -> {
                result = tempValue2.toDouble()
            }

            !firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() ->
            {
                result = OperatorClass.checkTwoNumbers(firstNumber, secondNumber)
            }

            firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                firstNumber.text = secondNumber.text
                firstNumber.append(".0")
                secondNumber.text = ""
            }

            !firstNumber.text.isNullOrEmpty() ->{
                result = OperatorClass.checkOneNumber(firstNumber)
            }
        }

        // do this after calling calculate
        firstNumber.text = result.toString()
        secondNumber.text = ""
        procedure.text=operation.toString()
    }
}
