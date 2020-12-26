package com.example.calculator_oop_kotlin_project

import android.widget.TextView

open class Operator {
    open fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double
    {
        var mathClass = MathOperations()

        var tempValue1 = firstNumber
        var tempValue2 = secondNumber

        var result: Double = 0.0
        return result
    }
    open fun checkOneNumber(firstNumber: Double): Double
    {
        var mathClass = MathOperations()

        var tempValue1 = firstNumber

        var result: Double = 0.0
        return result
    }
}

class OperatorPlus : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstNumber
        var tempValue2 = secondNumber

        result = mathClass.add(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorMinus : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var result: Double = 0.0

                var mathClass = MathOperations()

                var tempValue1 = firstNumber
                var tempValue2 = secondNumber

                result = mathClass.subtract(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorMod : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstNumber
        var tempValue2 = secondNumber

        result = mathClass.mod(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorDegree : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstNumber
        var tempValue2 = secondNumber

        result = mathClass.degree(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorMultiply : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstNumber
        var tempValue2 = secondNumber

        result = mathClass.multiply(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorDivide : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstNumber
        var tempValue2 = secondNumber

        result = mathClass.divide(tempValue1.toDouble(), tempValue2.toDouble())

        return result
    }
}

class OperatorSin : Operator(){
    override fun checkOneNumber(firstNumber: Double): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstNumber

        result = mathClass.sin(tempValue1.toDouble())

        return result
    }
}

class OperatorCos : Operator(){
    override fun checkOneNumber(firstNumber: Double): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstNumber

        result = mathClass.cos(tempValue1.toDouble())

        return result
    }
}

class OperatorReciprocal : Operator(){
    override fun checkOneNumber(firstNumber: Double): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstNumber

        result = mathClass.reciprocal(tempValue1.toDouble())

        return result
    }
}

class OperatorPlusMinus : Operator(){
    override fun checkOneNumber(firstNumber: Double): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstNumber

        result = mathClass.plusMinus(tempValue1.toDouble())

        return result
    }
}
