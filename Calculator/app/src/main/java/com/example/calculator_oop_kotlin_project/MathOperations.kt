package com.example.calculator_oop_kotlin_project

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

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
        return firstNumber.pow(secondNumber)
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