package com.example.calculator_oop_kotlin_project

import kotlin.math.pow

class MathOperations {

    fun add(firstNumber: Double, secondNumber: Double): Double
    {
        return firstNumber + secondNumber
    }

    fun subtract(firstNumber: Double, secondNumber: Double): Double
    {
        return firstNumber - secondNumber
    }

    fun divide(firstNumber: Double, secondNumber: Double): Double
    {
        return firstNumber / secondNumber
    }

    fun multiply(firstNumber: Double, secondNumber: Double): Double
    {
        return firstNumber * secondNumber
    }

    fun mod(firstNumber: Double, secondNumber: Double): Double
    {
        return firstNumber % secondNumber
    }

    fun degree(firstNumber: Double, secondNumber: Double): Double
    {
        return firstNumber.pow(secondNumber)
    }

    fun plusMinus(firstNumber: Double): Double
    {
        return firstNumber * -1
    }

    fun reciprocal(firstNumber: Double): Double
    {
        return 1 / firstNumber
    }

    fun sin(firstNumber: Double): Double
    {
        return kotlin.math.sin(firstNumber)
    }

    fun cos(firstNumber: Double): Double
    {
        return kotlin.math.cos(firstNumber)
    }

    fun convertBinaryToDecimal(num: Float): Int {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Float
        while (num != 0f) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }

    fun convertDecimalToBinary(n: Float): Int {
        var n = n
        var binaryNumber: Int = 0
        var remainder: Int
        var i = 1
        var step = 1
        while (n != 0f) {
            remainder = (n % 2).toInt()
            n /= 2
            binaryNumber += (remainder * i)
            i *= 10
        }
        return binaryNumber
    }
}