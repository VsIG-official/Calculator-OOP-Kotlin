package com.example.calculator_oop_kotlin_project

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MathOperations(firstTextView: TextView, secondTextView: TextView) {

    private var firstNumber = firstTextView
    private var secondNumber = secondTextView

    fun Add(firstNumber: Double, secondNumber: Double)
    {
        operation = '+'
        finishSecondNumber()
        procedure.text=operation.toString()
    }

    fun Substract()
    {
        operation = '-'
        finishSecondNumber()
        procedure.text=operation.toString()
    }

    fun Divide()
    {
        operation = '/'
        finishSecondNumber()
        procedure.text=operation.toString()
    }

    fun Multiply()
    {
        operation = '*'
        finishSecondNumber()
        procedure.text=operation.toString()
    }

    fun Mod()
    {
        operation = '%'
        changeOneNumber()
        procedure.text=operation.toString()
    }

    fun Degree()
    {
        operation = '^'
        changeOneNumber()
        procedure.text=operation.toString()
    }

    fun PlusMinus()
    {
        var tempOperation = operation
        operation = '±'
        changeOneNumber()
        operation = tempOperation
    }

    fun Reciprocal()
    {
        var tempOperation = operation
        operation = 'R'
        changeOneNumber()
        operation = tempOperation
    }

    fun Calculate(): Double
    {
        if(firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty())
        {
            // DO NOTHING
        }
        else if (!secondNumber.text.isNullOrEmpty())
        {
            val tempValue1 = firstNumber.text.toString()
            val tempValue2 = secondNumber.text.toString()

            var result: Double = 0.0
            when (operation) {
                '+' -> {
                    result = tempValue1.toDouble() + tempValue2.toDouble()
                }
                '-' -> {
                    result = tempValue1.toDouble() - tempValue2.toDouble()
                }
                '/' -> {
                    result = tempValue1.toDouble() / tempValue2.toDouble()
                }
                '*' -> {
                    result = tempValue1.toDouble() * tempValue2.toDouble()
                }
                '^' -> {
                    when {
                        !firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                            var tempValue3: Double = 0.0
                            tempValue3=firstNumber.text.toString().toDouble()
                            for (i in tempValue2) {
                                tempValue3 = tempValue1.toDouble() * tempValue2.toDouble()
                            }
                            result = tempValue3
                        }
                    }
                }
                '%' -> {
                    when {
                        !firstNumber.text.isNullOrEmpty() && secondNumber.text.isNullOrEmpty() -> {
                            // DO NOTHING
                            result = tempValue1.toDouble()
                        }
                        firstNumber.text=="0.0" && !secondNumber.text.isNullOrEmpty() -> {
                            result = tempValue2.toDouble()
                        }
                        !firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                            result = tempValue1.toDouble() % tempValue2.toDouble()
                        }
                    }
                }
                '^' -> {
                    when {
                        !firstNumber.text.isNullOrEmpty() && secondNumber.text.isNullOrEmpty() -> {
                            // DO NOTHING
                            result = tempValue1.toDouble()
                        }
                        firstNumber.text=="0.0" && !secondNumber.text.isNullOrEmpty() -> {
                            result = tempValue2.toDouble()
                        }
                        !firstNumber.text.isNullOrEmpty() && !secondNumber.text.isNullOrEmpty() -> {
                            var tempValue3: Double = 0.0
                            tempValue3=firstNumber.text.toString().toDouble()
                            for (i in tempValue2) {
                                tempValue3 = tempValue1.toDouble() * tempValue2.toDouble()
                            }
                            result = tempValue3
                        }
                    }
                }
            }

            return result

            // do this after calling calculate
            firstNumber.text = result.toString()
            secondNumber.text = ""
        }
    }

    fun ChangeOneNumber()
    {
        when {
            !first_numbers.text.isNullOrEmpty() -> {
                val tempValue1 = first_numbers.text.toString()
                val tempValue2 = second_numbers.text.toString()

                var result: Double = 0.0
                when (operation) {
                    '±' -> {
                        result = tempValue1.toDouble() * -1
                    }
                    'R' -> {
                        when {
                            first_numbers.text=="0.0" && !second_numbers.text.isNullOrEmpty() -> {
                                result = 1 / tempValue2.toDouble()
                            }
                            else -> {
                                result = 1 / tempValue1.toDouble()
                            }
                        }
                    }
                    '%' -> {
                        when {
                            !first_numbers.text.isNullOrEmpty() && second_numbers.text.isNullOrEmpty() -> {
                                // DO NOTHING
                                result = tempValue1.toDouble()
                            }
                            first_numbers.text=="0.0" && !second_numbers.text.isNullOrEmpty() -> {
                                result = tempValue2.toDouble()
                            }
                            !first_numbers.text.isNullOrEmpty() && !second_numbers.text.isNullOrEmpty() -> {
                                result = tempValue1.toDouble() % tempValue2.toDouble()
                            }
                        }
                    }
                    '^' -> {
                        when {
                            !first_numbers.text.isNullOrEmpty() && second_numbers.text.isNullOrEmpty() -> {
                                // DO NOTHING
                                result = tempValue1.toDouble()
                            }
                            first_numbers.text=="0.0" && !second_numbers.text.isNullOrEmpty() -> {
                                result = tempValue2.toDouble()
                            }
                            !first_numbers.text.isNullOrEmpty() && !second_numbers.text.isNullOrEmpty() -> {
                                var tempValue3: Double = 0.0
                                tempValue3=first_numbers.text.toString().toDouble()
                                for (i in tempValue2) {
                                    tempValue3 = tempValue1.toDouble() * tempValue2.toDouble()
                                }
                                result = tempValue3
                            }
                        }
                    }
                }
                first_numbers.text = result.toString()
                second_numbers.text = ""
            }
        }
    }
}