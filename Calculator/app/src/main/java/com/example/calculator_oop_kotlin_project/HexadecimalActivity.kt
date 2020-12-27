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

    private fun setOnClickListeners()
    {
        options_btn.setOnClickListener { options() }
        clear_btn.setOnClickListener { clearAllText() }
        plus_minus_btn.setOnClickListener { calculate('±', OperatorPlusMinus()) }
        one_divide_x_btn.setOnClickListener { calculate('R', OperatorReciprocal()) }
        divide_btn.setOnClickListener { calculate('/', OperatorDivide()) }
        multiply_btn.setOnClickListener { calculate('*', OperatorMultiply()) }
        minus_btn.setOnClickListener { calculate('-', OperatorMinus()) }
        plus_btn.setOnClickListener { calculate('+', OperatorPlus()) }
        equals_btn.setOnClickListener { calculate(operation, lastOperator) }
        back_btn.setOnClickListener { clearLastCharacter() }
        mod_btn.setOnClickListener { calculate('%', OperatorMod()) }
        degree_btn.setOnClickListener { calculate('^', OperatorDegree()) }

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

    private fun appendText(number: String)
    {
        secondNumber.append(number);
        second_scroll.post { second_scroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT) }
    }

    private fun clearAllText()
    {
        firstNumber.text="0"
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

        var result:String="0"
        var tempResult:Int=0

        var tempValue1 = firstNumber.text.toString()
        var tempValue2 = secondNumber.text.toString()

        when {
            !firstNumber.text.isNullOrEmpty()  && secondNumber.text.isNullOrEmpty() -> {
                result = tempValue1
            }

            (firstNumber.text=="0" || firstNumber.text=="-0" ) && !secondNumber.text.isNullOrEmpty() -> {
                result = tempValue2
            }

            !firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() ->
            {
                // convert to decimal WORK
                var tempDecimalValue1 = Integer.parseInt(tempValue1,16)
                var tempDecimalValue2 = Integer.parseInt(tempValue2,16)

                tempResult = OperatorClass.checkTwoNumbers(tempDecimalValue1.toFloat(),tempDecimalValue2.toFloat()).toInt()

                result = Integer.toHexString(tempResult)
            }

            firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                firstNumber.text = secondNumber.text
                secondNumber.text = ""
            }

            !firstNumber.text.isNullOrEmpty() ->{
                // convert to decimal
                result = OperatorClass.checkOneNumber(tempValue1.toFloat()).toString()
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
        val mBuilder = AlertDialog.Builder(this@HexadecimalActivity)
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
