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

        var result:Float=0.0f
        var tempResult:Float=0.0f

        var tempValue1 = firstNumber.text.toString()
        var tempValue2 = secondNumber.text.toString()

        when {
            !firstNumber.text.isNullOrEmpty()  && secondNumber.text.isNullOrEmpty() -> {
                result = tempValue1.toFloat()
            }

            (firstNumber.text=="0.0" || firstNumber.text=="-0.0" ) && !secondNumber.text.isNullOrEmpty() -> {
                result = tempValue2.toFloat()
            }

            !firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() ->
            {
                // convert to binary
                //val intBits1 = java.lang.Float.floatToIntBits(tempValue1.toFloat())
                //val binary1 = Integer.toBinaryString(intBits1)

                //val intBits2 = java.lang.Float.floatToIntBits(tempValue1.toFloat())
                //val binary2 = Integer.toBinaryString(intBits2)

                //var tempBinaryValue1 = Float.toBinaryString(tempValue1)
                //var tempBinaryValue2 = Integer.toBinaryString(tempValue2.toInt())
                tempValue1 = tempValue1.toInt().toString()
                // convert to decimal
                var tempDecimalValue1 = Integer.parseInt(tempValue1, 2)
                var tempDecimalValue2 = Integer.parseInt(tempValue2, 2)

                tempResult = OperatorClass.checkTwoNumbers(tempDecimalValue1.toFloat(), tempDecimalValue2.toFloat())
                result = Integer.toBinaryString(tempResult.toInt()).toFloat()
            }

            firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                firstNumber.text = secondNumber.text
                firstNumber.append(".0")
                secondNumber.text = ""
            }

            !firstNumber.text.isNullOrEmpty() ->{
                result = OperatorClass.checkOneNumber(tempValue1.toFloat())
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