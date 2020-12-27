package com.example.calculator_oop_kotlin_project

import kotlin.math.pow

class MathOperations() {

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
}