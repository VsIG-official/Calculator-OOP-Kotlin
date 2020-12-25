package com.example.calculator_oop_kotlin_project

import kotlinx.android.synthetic.main.activity_main.*

class MathOperations() {

    fun Add(firstNumber: Double, secondNumber: Double): Double
    {
        return firstNumber + secondNumber
    }

    fun Substract(firstNumber: Double, secondNumber: Double): Double
    {
        return firstNumber - secondNumber
    }

    fun Divide(firstNumber: Double, secondNumber: Double): Double
    {
        return firstNumber / secondNumber
    }

    fun Multiply(firstNumber: Double, secondNumber: Double): Double
    {
        return firstNumber * secondNumber
    }

    fun Mod(firstNumber: Double, secondNumber: Double): Double
    {
        return firstNumber % secondNumber
    }

    fun Degree(firstNumber: Double, secondNumber: Double): Double
    {
        var result: Double = 1.0
        var tempValue = secondNumber

        while (tempValue != 0.0) {
            result *= firstNumber.toLong()
            --tempValue
        }

        return result
    }

    fun PlusMinus()
    {
        //var tempOperation = operation
        //operation = '±'
        //changeOneNumber()
        //operation = tempOperation
    }

    fun Reciprocal()
    {
        //var tempOperation = operation
        //operation = 'R'
        //changeOneNumber()
        //operation = tempOperation
    }


}