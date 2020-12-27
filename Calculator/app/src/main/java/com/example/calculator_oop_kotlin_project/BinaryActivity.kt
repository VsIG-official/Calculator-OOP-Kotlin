package com.example.calculator_oop_kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_binary.*

class BinaryActivity : MainActivity() {
    override var operation: Char = ' '
    var mathClass = MathOperations()
    override lateinit var lastOperator: Operator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binary)
        setOnClickListeners()
        firstNumber.text="0"
    }

    override fun setOnClickListeners()
    {
        options_btn.setOnClickListener { options() }
        clear_btn.setOnClickListener { clearAllText() }
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
    }

    override fun clearAllText()
    {
        firstNumber.text="0"
        secondNumber.text=""
        operation=' '
        procedure.text=""
    }

    override fun calculate(operationChar: Char, OperatorClass: Operator) {
        // current operation
        operation = operationChar

        lastOperator = OperatorClass

        var result:Int=0
        var tempResult:Int=0

        var tempValue1 = firstNumber.text.toString()
        var tempValue2 = secondNumber.text.toString()

        when {
            !firstNumber.text.isNullOrEmpty()  && secondNumber.text.isNullOrEmpty() -> {
                result = tempValue1.toInt()
            }

            (firstNumber.text=="0" || firstNumber.text=="-0" ) && !secondNumber.text.isNullOrEmpty() -> {
                result = tempValue2.toInt()
            }

            !firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() ->
            {
                // convert to decimal
                var tempDecimalValue1 = mathClass.convertBinaryToDecimal(tempValue1.toFloat())
                var tempDecimalValue2 = mathClass.convertBinaryToDecimal(tempValue2.toFloat())

                tempResult = OperatorClass.checkTwoNumbers(tempDecimalValue1.toFloat(),tempDecimalValue2.toFloat()).toInt()

                result = mathClass.convertDecimalToBinary(tempResult.toFloat())
            }

            firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                firstNumber.text = secondNumber.text
                secondNumber.text = ""
            }

            !firstNumber.text.isNullOrEmpty() ->{
                // convert to decimal
                result = OperatorClass.checkOneNumber(tempValue1.toFloat()).toInt()
            }
        }

        // do this after calling calculate
        firstNumber.text = result.toString()
        secondNumber.text = ""
        procedure.text=operation.toString()
    }

    override fun options()
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
