package com.example.calculator_oop_kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class BinaryActivity : AppCompatActivity() {
    var operation: Char = ' '

    lateinit var lastOperator: Operator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binary)
        firstNumber.text="0.0"
        setOnClickListeners()
    }

    private fun setOnClickListeners()
    {
        options_btn.setOnClickListener { options() }
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
        var tempResult:Double=0.0

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
                // convert to binary
                //val intBits = java.lang.Double.doubleToIntBits(yourFloat)
                //val binary = Integer.toBinaryString(intBits)

                //var tempBinaryValue1 = Double.toBinaryString(tempValue1)
                //var tempBinaryValue2 = Integer.toBinaryString(tempValue2.toInt())

                // convert to decimal
                //tempValue1 = Integer.parseDouble(tempBinaryValue1, 2).toString()
                //tempValue2 = Integer.parseInt(tempBinaryValue2, 2).toString()

                tempResult = OperatorClass.checkTwoNumbers(
                    tempValue1.toDouble(),
                    tempValue2.toDouble()
                )
                result = Integer.toBinaryString(tempResult.toInt()).toDouble()
            }

            firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                firstNumber.text = secondNumber.text
                firstNumber.append(".0")
                secondNumber.text = ""
            }

            !firstNumber.text.isNullOrEmpty() ->{
                result = OperatorClass.checkOneNumber(tempValue1.toDouble())
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
        val mBuilder = AlertDialog.Builder(this@BinaryActivity)
        mBuilder.setTitle("Type of Calculator")
        mBuilder.setSingleChoiceItems(listItems, -1) { dialogInterface, i ->
            tempString = listItems[i]
            dialogInterface.dismiss()
            when (tempString) {
                "Decimal" -> {
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                "Binary" -> {
                    var intent = Intent(this, BinaryActivity::class.java)
                    startActivity(intent)
                }
                "Hexadecimal" -> {
                    var intent = Intent(this, HexadecimalActivity::class.java)
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