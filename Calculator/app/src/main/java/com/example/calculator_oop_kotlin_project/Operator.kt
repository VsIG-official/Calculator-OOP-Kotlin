package com.example.calculator_oop_kotlin_project

import android.widget.TextView

open class Operator {
    open fun checkTwoNumbers(firstTextView: TextView, secondTextView: TextView): Double
    {
        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()
        var tempValue2 = secondTextView.text.toString()

        var result: Double = 0.0
        return result
    }
    open fun checkOneNumber(firstTextView: TextView): Double
    {
        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()

        var result: Double = 0.0
        return result
    }
}

class OperatorPlus : Operator(){
    override fun checkTwoNumbers(firstTextView: TextView, secondTextView: TextView): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()
        var tempValue2 = secondTextView.text.toString()

        result = mathClass.add(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorMinus : Operator(){
    override fun checkTwoNumbers(firstTextView: TextView, secondTextView: TextView): Double {
        var result: Double = 0.0

                var mathClass = MathOperations()

                var tempValue1 = firstTextView.text.toString()
                var tempValue2 = secondTextView.text.toString()

                result = mathClass.subtract(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorMod : Operator(){
    override fun checkTwoNumbers(firstTextView: TextView, secondTextView: TextView): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()
        var tempValue2 = secondTextView.text.toString()

        result = mathClass.mod(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorDegree : Operator(){
    override fun checkTwoNumbers(firstTextView: TextView, secondTextView: TextView): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()
        var tempValue2 = secondTextView.text.toString()

        result = mathClass.degree(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorMultiply : Operator(){
    override fun checkTwoNumbers(firstTextView: TextView, secondTextView: TextView): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()
        var tempValue2 = secondTextView.text.toString()

        result = mathClass.multiply(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorDivide : Operator(){
    override fun checkTwoNumbers(firstTextView: TextView, secondTextView: TextView): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()
        var tempValue2 = secondTextView.text.toString()

        result = mathClass.divide(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorSin : Operator(){
    override fun checkOneNumber(firstTextView: TextView): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()

        result = mathClass.sin(tempValue1.toDouble())

        return result
    }
}

class OperatorCos : Operator(){
    override fun checkOneNumber(firstTextView: TextView): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()

        result = mathClass.cos(tempValue1.toDouble())

        return result
    }
}

class OperatorReciprocal : Operator(){
    override fun checkOneNumber(firstTextView: TextView): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()

        result = mathClass.reciprocal(tempValue1.toDouble())

        return result
    }
}

class OperatorPlusMinus : Operator(){
    override fun checkOneNumber(firstTextView: TextView): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstTextView.text.toString()

        result = mathClass.plusMinus(tempValue1.toDouble())

        return result
    }
}
