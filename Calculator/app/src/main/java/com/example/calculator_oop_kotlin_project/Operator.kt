package com.example.calculator_oop_kotlin_project

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

open class Operator {
    open fun checkTwoNumbers(firstTextView: TextView, secondTextView: TextView): Double
    {
        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()
        var tempValue2 = secondTextView.text.toString()

        var result: Double = 0.0
        return result
    }
    open fun checkOneNumber(firstTextView: TextView, secondTextView: TextView): Double
    {
        var mathClass = MathOperations()
        var result: Double = 0.0
        return result
    }
}

class OperatorPlus : Operator(){
    override fun checkTwoNumbers(firstTextView: TextView, secondTextView: TextView): Double {
        var result: Double = 0.0
        when {
            !firstTextView.text.isNullOrEmpty() && !secondTextView.text.isNullOrEmpty() -> {
                var mathClass = MathOperations()

                var tempValue1 = firstTextView.text.toString()
                var tempValue2 = secondTextView.text.toString()

                result = mathClass.Add(tempValue1.toDouble(), tempValue2.toDouble())
            }
        }
        return result
    }

    override fun checkOneNumber(firstTextView: TextView, secondTextView: TextView): Double {
        // do nothing
        return 0.0
    }
}