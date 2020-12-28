
package com.example.calculator_oop_kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AlertDialog
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
        options_btn.setOnClickListener { options() }
        clear_btn.setOnClickListener { clearAllText() }
        plus_minus_btn.setOnClickListener { calculate('±', OperatorPlusMinus(), true) }
        one_divide_x_btn.setOnClickListener { calculate('R', OperatorReciprocal(), true) }
        sin_btn.setOnClickListener { calculate('S', OperatorSin(), true) }
        cos_btn.setOnClickListener { calculate('C', OperatorCos(), true) }
        divide_btn.setOnClickListener { calculate('/', OperatorDivide(), false) }
        multiply_btn.setOnClickListener { calculate('*', OperatorMultiply(), false) }
        minus_btn.setOnClickListener { calculate('-', OperatorMinus(), false) }
        plus_btn.setOnClickListener { calculate('+', OperatorPlus(), false) }
        equals_btn.setOnClickListener { calculate(operation, lastOperator, false) }
        back_btn.setOnClickListener { clearLastCharacter() }
        mod_btn.setOnClickListener { calculate('%', OperatorMod(), false) }
        degree_btn.setOnClickListener { calculate('^', OperatorDegree(), false) }

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

    private fun calculate(operationChar: Char, OperatorClass: Operator, oneNumberOperation: Boolean) {
        // current operation
        operation = operationChar

        lastOperator = OperatorClass

        var tempValue1 = firstNumber.text.toString()
        var tempValue2 = secondNumber.text.toString()

        var result = tempValue1.toDouble()

        when {
            (firstNumber.text=="0.0" || firstNumber.text=="-0.0" ||
                    firstNumber.text=="Infinity" || firstNumber.text=="-Infinity")
                    && !secondNumber.text.isNullOrEmpty() -> {
                result = tempValue2.toDouble()
            }

            !firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() ->
            {
                result = OperatorClass.checkTwoNumbers(tempValue1.toDouble(), tempValue2.toDouble())
            }

            !firstNumber.text.isNullOrEmpty() ->{
                result = OperatorClass.checkOneNumber(tempValue1.toDouble())
            }

            firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                firstNumber.text = secondNumber.text
                firstNumber.append(".0")
                secondNumber.text = ""
            }
        }

        // do this after calling calculate
        firstNumber.text = result.toString()
        secondNumber.text = ""
        procedure.text=operation.toString()
    }

    private fun options()
    {
        var tempString = ""
        val listItems = arrayOf("Decimal", "Binary", "Hexadecimal")
        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Type of Calculator")
        mBuilder.setSingleChoiceItems(listItems, -1) { dialogInterface, i ->
            tempString = listItems[i]
            dialogInterface.dismiss()

            when (tempString) {
                "Decimal" -> {
                    var intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                "Binary" -> {
                    var intent = Intent(this,BinaryActivity::class.java)
                    startActivity(intent)
                }
                "Hexadecimal" -> {
                    var intent = Intent(this,HexadecimalActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        // Set the neutral/cancel button click listener
        mBuilder.setNeutralButton("Cancel") { dialog, which ->
            // Do something when click the neutral button
            dialog.cancel()
        }

        val mDialog = mBuilder.create()
        mDialog.show()
    }
}
