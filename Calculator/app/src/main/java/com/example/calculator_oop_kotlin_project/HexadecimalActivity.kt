package com.example.calculator_oop_kotlin_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_hexadecimal.*

class HexadecimalActivity : AppCompatActivity() {
    var operation: Char = ' '
    lateinit var lastOperator: Operator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hexadecimal)
        firstNumber.text="0"
        setOnClickListeners()
    }

    // set listener for every button
    private fun setOnClickListeners()
    {
        options_btn.setOnClickListener { options() }
        clear_btn.setOnClickListener { clearAllText() }
        plus_minus_btn.setOnClickListener { calculate('±', OperatorPlusMinus(), true) }
        divide_btn.setOnClickListener { calculate('/', OperatorDivide(), false) }
        multiply_btn.setOnClickListener { calculate('*', OperatorMultiply(), false) }
        minus_btn.setOnClickListener { calculate('-', OperatorMinus(), false) }
        plus_btn.setOnClickListener { calculate('+', OperatorPlus(), false) }
        equals_btn.setOnClickListener { calculate(operation, lastOperator, false) }
        back_btn.setOnClickListener { clearLastCharacter() }
        mod_btn.setOnClickListener { calculate('%', OperatorMod(), false) }
        degree_btn.setOnClickListener { calculate('^', OperatorDegree(), false) }

        f_btn.setOnClickListener { appendText("F") }
        e_btn.setOnClickListener { appendText("E") }
        d_btn.setOnClickListener { appendText("D") }
        c_btn.setOnClickListener { appendText("C") }
        b_btn.setOnClickListener { appendText("B") }
        a_btn.setOnClickListener { appendText("A") }
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
    }

    // add text to second TextView and automatically scrolls to the end
    private fun appendText(number: String)
    {
        secondNumber.append(number);
        second_scroll.post { second_scroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT) }
    }

    // clear all text
    private fun clearAllText()
    {
        firstNumber.text="0"
        secondNumber.text=""
        operation=' '
        procedure.text=""
    }

    // clear last character
    private fun clearLastCharacter()
    {
        val tempString = secondNumber.text.toString()
        if (tempString.isNotEmpty())
        {
            secondNumber.text = tempString.substring(0, tempString.length - 1)
        }
    }

    // main function for calculating
    private fun calculate(operationChar: Char, OperatorClass: Operator, oneNumberOperation: Boolean) {
        // current operation
        operation = operationChar

        lastOperator = OperatorClass

        var tempResult:Int=0

        var tempValue1 = firstNumber.text.toString()
        var tempValue2 = secondNumber.text.toString()

        var result = tempValue1

        when {
            (firstNumber.text=="0" || firstNumber.text=="-0" ||
                    firstNumber.text=="Infinity" || firstNumber.text=="-Infinity")
                    && !secondNumber.text.isNullOrEmpty() -> {
                result = tempValue2
            }

            !firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() ->
            {
                // convert to decimal
                var tempDecimalValue1 = Integer.parseInt(tempValue1,16)
                var tempDecimalValue2 = Integer.parseInt(tempValue2,16)

                tempResult = OperatorClass.checkTwoNumbers(tempDecimalValue1.toDouble(),
                        tempDecimalValue2.toDouble()).toInt()

                result = Integer.toHexString(tempResult)
            }

            !firstNumber.text.isNullOrEmpty() && oneNumberOperation -> {
                result = OperatorClass.checkOneNumber(tempValue1.toDouble()).toInt().toString()
            }

            firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                firstNumber.text = secondNumber.text
                secondNumber.text = ""
            }
        }

        // do this after calling calculate
        firstNumber.text = result.toUpperCase()
        secondNumber.text = ""
        procedure.text=operation.toString()
    }

    // options button
    private fun options()
    {
        var tempString = ""
        val listItems = arrayOf("Decimal", "Binary", "Hexadecimal")
        val mBuilder = AlertDialog.Builder(this@HexadecimalActivity)
        mBuilder.setTitle("Type of Calculator")
        mBuilder.setSingleChoiceItems(listItems, -1) { dialogInterface, i ->
            tempString = listItems[i]
            dialogInterface.dismiss()

            when (tempString) {
                "Decimal" -> {
                    startActivity(Intent(this,MainActivity::class.java))
                }
                "Binary" -> {
                    startActivity(Intent(this,BinaryActivity::class.java))
                }
                "Hexadecimal" -> {
                    startActivity(Intent(this,HexadecimalActivity::class.java))
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
