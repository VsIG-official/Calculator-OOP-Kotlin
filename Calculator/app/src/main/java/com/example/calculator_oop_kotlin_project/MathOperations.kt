package com.example.calculator_oop_kotlin_project

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MathOperations(firstTextView: TextView, secondTextView: TextView, procedureTextView: TextView, operationChar: Char) {

    private var firstNumber = firstTextView
    private var secondNumber = secondTextView
    private var procedure = procedureTextView
    private var operation = operationChar

    fun Add(firstNumber: Double, secondNumber: Double): Double
    {
        operation = '+'
        finishSecondNumber()
        procedure.text=operation.toString()

        return firstNumber.toDouble() + secondNumber.toDouble()
    }

    fun Substract()
    {
        operation = '-'
        finishSecondNumber()
        procedure.text=operation.toString()
    }

    fun Divide()
    {
        operation = '/'
        finishSecondNumber()
        procedure.text=operation.toString()
    }

    fun Multiply()
    {
        operation = '*'
        finishSecondNumber()
        procedure.text=operation.toString()
    }

    fun Mod()
    {
        operation = '%'
        changeOneNumber()
        procedure.text=operation.toString()
    }

    fun Degree()
    {
        operation = '^'
        changeOneNumber()
        procedure.text=operation.toString()
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