package com.example.calculator_oop_kotlin_project

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MathOperations() {

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
}