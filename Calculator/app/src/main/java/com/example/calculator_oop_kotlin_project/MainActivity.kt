package com.example.calculator_oop_kotlin_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tvOne.setOnClickListener{ appendExpression("1",true)}
        tvTwo.setOnClickListener{ appendExpression("2",true)}
        tvThree.setOnClickListener{ appendExpression("3",true)}
        tvFour.setOnClickListener{ appendExpression("4",true)}
        tvFive.setOnClickListener{ appendExpression("5",true)}
        tvSix.setOnClickListener{ appendExpression("6",true)}
        tvSeven.setOnClickListener{ appendExpression("7",true)}
        tvEight.setOnClickListener{ appendExpression("8",true)}
        tvNine.setOnClickListener{ appendExpression("9",true)}
        tvZero.setOnClickListener{ appendExpression("0",true)}
        tvDot.setOnClickListener{ appendExpression(".",true)}

        //Operators
        tvPlus.setOnClickListener { appendExpression("+",false) }
        tvMinus.setOnClickListener { appendExpression("-",false) }
        tvMultiply.setOnClickListener { appendExpression("*",false) }
        tvDivide.setOnClickListener { appendExpression("/",false) }
        tvOpenPar.setOnClickListener { appendExpression("(",false) }
        tvClosePar.setOnClickListener { appendExpression(")",false) }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty())
            {
                tvExpression.text=string.substring(0,string.length-1)
            }
            tvResult.text=""
        }
    }

    fun appendExpression(string: String, canClear: Boolean){
        if (canClear)
        {
            tvResult.text = ""
            tvExpression.append(string)
        }

        else
        {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text=""
        }
    }
}
