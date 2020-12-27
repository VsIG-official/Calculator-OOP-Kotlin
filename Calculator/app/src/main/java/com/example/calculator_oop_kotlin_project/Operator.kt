package com.example.calculator_oop_kotlin_project

open class Operator {
    open fun checkTwoNumbers(firstNumber: Float, secondNumber: Float): Float
    {
        var mathClass = MathOperations()

        var result: Float = 0.0f
        return result
    }
    open fun checkOneNumber(firstNumber: Float): Float
    {
        var mathClass = MathOperations()

        var result: Float = 0.0f
        return result
    }
}

class OperatorPlus : Operator(){
    override fun checkTwoNumbers(firstNumber: Float, secondNumber: Float): Float {
        var mathClass = MathOperations()

        return mathClass.add(firstNumber, secondNumber)
    }
}

class OperatorMinus : Operator(){
    override fun checkTwoNumbers(firstNumber: Float, secondNumber: Float): Float {
        var mathClass = MathOperations()

        return mathClass.subtract(firstNumber, secondNumber)
    }
}

class OperatorMod : Operator(){
    override fun checkTwoNumbers(firstNumber: Float, secondNumber: Float): Float {
        var mathClass = MathOperations()

        return mathClass.mod(firstNumber, secondNumber)
    }
}

class OperatorDegree : Operator(){
    override fun checkTwoNumbers(firstNumber: Float, secondNumber: Float): Float {
        var mathClass = MathOperations()

        return mathClass.degree(firstNumber, secondNumber)
    }
}

class OperatorMultiply : Operator(){
    override fun checkTwoNumbers(firstNumber: Float, secondNumber: Float): Float {
        var mathClass = MathOperations()

        return mathClass.multiply(firstNumber, secondNumber)
    }
}

class OperatorDivide : Operator(){
    override fun checkTwoNumbers(firstNumber: Float, secondNumber: Float): Float {
        var mathClass = MathOperations()

        return mathClass.divide(firstNumber, secondNumber)
    }
}

class OperatorSin : Operator(){
    override fun checkOneNumber(firstNumber: Float): Float {
        var mathClass = MathOperations()

        return mathClass.sin(firstNumber)
    }
}

class OperatorCos : Operator(){
    override fun checkOneNumber(firstNumber: Float): Float {
        var mathClass = MathOperations()

        return mathClass.cos(firstNumber)
    }
}

class OperatorReciprocal : Operator(){
    override fun checkOneNumber(firstNumber: Float): Float {
        var mathClass = MathOperations()

        return mathClass.reciprocal(firstNumber)
    }
}

class OperatorPlusMinus : Operator(){
    override fun checkOneNumber(firstNumber: Float): Float {
        var mathClass = MathOperations()

        return mathClass.plusMinus(firstNumber)
    }
}
