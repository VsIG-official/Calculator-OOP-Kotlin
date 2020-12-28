package com.example.calculator_oop_kotlin_project

open class Operator {
    open fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double
    {
        var mathClass = MathOperations()

        var result: Double = 0.0
        return result
    }
    open fun checkOneNumber(firstNumber: Double): Double
    {
        var mathClass = MathOperations()

        var result: Double = 0.0
        return result
    }
}

class OperatorPlus : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var mathClass = MathOperations()

        return mathClass.add(firstNumber, secondNumber)
    }
}

class OperatorMinus : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var mathClass = MathOperations()

        return mathClass.subtract(firstNumber, secondNumber)
    }
}

class OperatorMod : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var mathClass = MathOperations()

        return mathClass.mod(firstNumber, secondNumber)
    }
}

class OperatorDegree : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var mathClass = MathOperations()

        return mathClass.degree(firstNumber, secondNumber)
    }
}

class OperatorMultiply : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var mathClass = MathOperations()

        return mathClass.multiply(firstNumber, secondNumber)
    }
}

class OperatorDivide : Operator(){
    override fun checkTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        var mathClass = MathOperations()

        return mathClass.divide(firstNumber, secondNumber)
    }
}

class OperatorSin : Operator(){
    override fun checkOneNumber(firstNumber: Double): Double {
        var mathClass = MathOperations()

        return mathClass.sin(firstNumber)
    }
}

class OperatorCos : Operator(){
    override fun checkOneNumber(firstNumber: Double): Double {
        var mathClass = MathOperations()

        return mathClass.cos(firstNumber)
    }
}

class OperatorReciprocal : Operator(){
    override fun checkOneNumber(firstNumber: Double): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstNumber

        result = mathClass.reciprocal(tempValue1)

        return result
    }
}

class OperatorPlusMinus : Operator(){
    override fun checkOneNumber(firstNumber: Double): Double {
        var result: Double = 0.0

        var mathClass = MathOperations()

        var tempValue1 = firstNumber

        result = mathClass.plusMinus(tempValue1)

        return result
    }
}
