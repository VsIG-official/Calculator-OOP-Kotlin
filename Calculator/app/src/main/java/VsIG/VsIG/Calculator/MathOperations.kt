package VsIG.VsIG.Calculator

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
        var decNum = 0
        var i = 0
        var residual: Float
        while (num != 0f) {
            residual = num % 10
            num /= 10
            decNum += (residual * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decNum
    }

    fun convertDecimalToBinary(n: Float): Int {
        var n = n
        var binNum: Int = 0
        var residual: Int
        var i = 1
        while (n != 0f) {
            residual = (n % 2).toInt()
            n /= 2
            binNum += (residual * i)
            i *= 10
        }
        return binNum
    }
}
