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

    fun Mod()
    {
        operation = '%'
        changeOneNumber()
        procedure.text=operation.toString()
    }

    fun Degree(firstNumber: Double, secondNumber: Double): Double
    {
        var tempValue: Double = 0.0
        tempValue=firstNumber
        for (i in secondNumber.toString()) {
            tempValue = firstNumber * secondNumber
        }
        return tempValue
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


}