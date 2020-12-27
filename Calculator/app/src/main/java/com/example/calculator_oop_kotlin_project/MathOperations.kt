package com.example.calculator_oop_kotlin_project

import kotlin.math.pow

class MathOperations {

    fun add(firstNumber: Float, secondNumber: Float): Float
    {
        return firstNumber + secondNumber
    }

    fun subtract(firstNumber: Float, secondNumber: Float): Float
    {
        return firstNumber - secondNumber
    }

    fun divide(firstNumber: Float, secondNumber: Float): Float
    {
        return firstNumber / secondNumber
    }

    fun multiply(firstNumber: Float, secondNumber: Float): Float
    {
        return firstNumber * secondNumber
    }

    fun mod(firstNumber: Float, secondNumber: Float): Float
    {
        return firstNumber % secondNumber
    }

    fun degree(firstNumber: Float, secondNumber: Float): Float
    {
        return firstNumber.pow(secondNumber)
    }

    fun plusMinus(firstNumber: Float): Float
    {
        return firstNumber * -1
    }

    fun reciprocal(firstNumber: Float): Float
    {
        return 1 / firstNumber
    }

    fun sin(firstNumber: Float): Float
    {
        return kotlin.math.sin(firstNumber)
    }

    fun cos(firstNumber: Float): Float
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