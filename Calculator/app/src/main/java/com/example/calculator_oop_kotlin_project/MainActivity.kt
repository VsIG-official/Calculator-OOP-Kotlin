
package com.example.calculator_oop_kotlin_project

import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.example.calculator_oop_kotlin_project.MathOperations

class MainActivity : AppCompatActivity()
{
    var operation: Char = ' '
    lateinit var MathClass: MathOperations

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstNumber.text="0.0"
        MathClass = MathOperations()
        setOnClickListeners()
    }

    private fun setOnClickListeners()
    {
        options_btn.setOnClickListener {  }
        clear_btn.setOnClickListener { clearAllText() }
        plus_minus_btn.setOnClickListener { calculate('±') }
        //one_divide_x_btn.setOnClickListener { reciprocalFunction() }
        divide_btn.setOnClickListener { calculate('/') }
        multiply_btn.setOnClickListener { calculate('*') }
        minus_btn.setOnClickListener { calculate('-') }
        plus_btn.setOnClickListener { calculate('+') }
        equals_btn.setOnClickListener { calculate(operation) }
        back_btn.setOnClickListener { clearLastCharacter() }
        mod_btn.setOnClickListener { calculate('%') }
        degree_btn.setOnClickListener { calculate('^') }

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

    private fun calculate(operationChar: Char) {
        // last operation
        var tempOperation = operation
        // current operation
        operation = operationChar

        var tempValue1 = firstNumber.text.toString()
        var tempValue2 = secondNumber.text.toString()
        var result: Double = 0.0

        when {
                !firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() ->
                {
                    when (operation) {

                    '+' -> {
                        result = MathClass.Add(tempValue1.toDouble(), tempValue2.toDouble())
                    }

                    '-' -> {
                        result = MathClass.Substract(tempValue1.toDouble(), tempValue2.toDouble())
                    }

                    '/' -> {
                        result = when {
                            firstNumber.text=="0.0" && !secondNumber.text.isNullOrEmpty() -> {
                                tempValue2.toDouble()
                            }
                            else -> {
                                MathClass.Divide(tempValue1.toDouble(), tempValue2.toDouble())
                            }
                        }
                    }

                    '*' -> {
                        result = when {
                            firstNumber.text=="0.0" && !secondNumber.text.isNullOrEmpty() -> {
                                tempValue2.toDouble()
                            }
                            else -> {
                                MathClass.Multiply(tempValue1.toDouble(), tempValue2.toDouble())
                            }
                        }
                    }

                    '^' -> {
                        result = when {
                            firstNumber.text=="0.0" && !secondNumber.text.isNullOrEmpty() -> {
                                tempValue2.toDouble()
                            }
                            else -> {
                                MathClass.Degree(tempValue1.toDouble(), tempValue2.toDouble())
                            }
                        }
                    }

                    '%' -> {
                        result = when {
                            firstNumber.text=="0.0" && !secondNumber.text.isNullOrEmpty() -> {
                                tempValue2.toDouble()
                            }
                            else -> {
                                MathClass.Mod(tempValue1.toDouble(), tempValue2.toDouble())
                            }
                        }
                    }
                }

                // do this after calling calculate
                firstNumber.text = result.toString()
                secondNumber.text = ""
            }

            !firstNumber.text.isNullOrEmpty() -> {
                when(operation) {

                }
                firstNumber.text = result.toString()
            }

            firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                firstNumber.text = secondNumber.text
                firstNumber.append(".0")
                secondNumber.text = ""
            }
        }
        procedure.text=operation.toString()
    }

    fun changeOneNumber(operationChar: Char) {
        when {
            !firstNumber.text.isNullOrEmpty() -> {
                val tempValue1 = firstNumber.text.toString()
                val tempValue2 = secondNumber.text.toString()

                var result: Double = 0.0
                when (operationChar) {

                    '±' -> {
                        var tempOperation = operation
                        operation = '±'
                        result = tempValue1.toDouble() * -1
                        operation = tempOperation
                    }

                    'R' -> {
                        when {
                            firstNumber.text=="0.0" && !secondNumber.text.isNullOrEmpty() -> {
                                result = 1 / tempValue2.toDouble()
                            }
                            else -> {
                                result = 1 / tempValue1.toDouble()
                            }
                        }
                    }
                }
                firstNumber.text = result.toString()
                secondNumber.text = ""
            }
        }
    }
}
