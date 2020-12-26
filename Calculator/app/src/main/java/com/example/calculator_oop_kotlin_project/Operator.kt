package com.example.calculator_oop_kotlin_project

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

open class Operator {
    open fun check(firstTextView: TextView, secondTextView: TextView): Double
    {
        var mathClass = MathOperations()
        var result: Double = 0.0
        return result
    }
}

class OperatorPlus : Operator(){
    override fun check(firstTextView: TextView, secondTextView: TextView): Double {
        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()
        var tempValue2 = secondTextView.text.toString()

        return mathClass.Add(tempValue1.toDouble(),tempValue2.toDouble())
    }
}