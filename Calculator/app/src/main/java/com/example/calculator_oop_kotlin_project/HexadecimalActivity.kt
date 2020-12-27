package com.example.calculator_oop_kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_hexadecimal.*

class HexadecimalActivity : MainActivity() {
    override var operation: Char = ' '
    override lateinit var lastOperator: Operator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hexadecimal)
        firstNumber.text="0"
        val f_btn = findViewById<TextView>(R.id.f_btn)
        f_btn.setOnClickListener { appendText("F") }
        super.setOnClickListeners()
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


        findViewById<TextView>(R.id.e_btn).setOnClickListener { appendText("E") }
        findViewById<TextView>(R.id.d_btn).setOnClickListener { appendText("D") }
        findViewById<TextView>(R.id.c_btn).setOnClickListener { appendText("C") }
        findViewById<TextView>(R.id.b_btn).setOnClickListener { appendText("B") }
        findViewById<TextView>(R.id.a_btn).setOnClickListener { appendText("A") }
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
        firstNumber.text = result
        secondNumber.text = ""
        procedure.text=operation.toString()
    }

    override fun options()
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
