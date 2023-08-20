package com.akshay.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private lateinit var editNum: EditText
    private lateinit var editNumTwo: EditText
    private lateinit var result: TextView

    private lateinit var buttonAdd: Button
    private lateinit var buttonMinus: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivision: Button

    private val operation : ArithmeticOperation = ArithmeticOperation()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editNum = findViewById(R.id.editNumOne)
        editNumTwo = findViewById(R.id.editNumTwo)

        result = findViewById(R.id.result)


        buttonAdd = findViewById(R.id.button_add)
        buttonMinus = findViewById(R.id.button_minus)
        buttonMultiply = findViewById(R.id.button_multiply)
        buttonDivision = findViewById(R.id.button_division)

        buttonAdd.isEnabled = false
        buttonMinus.isEnabled = false
        buttonMultiply.isEnabled = false
        buttonDivision.isEnabled = false

        buttonAdd.setOnClickListener {
            setSum()
        }
        buttonMinus.setOnClickListener {
            setSubtraction()
        }
        buttonMultiply.setOnClickListener {
            setMultiplication()
        }
        buttonDivision.setOnClickListener {
            setDivide()
        }

        editNum.addTextChangedListener {
            setButtonVisibility()
        }
        editNumTwo.addTextChangedListener {
            setButtonVisibility()
        }
    }

    private fun setSum() {
        if (operation.getNum1() != null && operation.getNum2() != null) {
            result.text = operation.add().toString()
        }
    }

    private fun setDivide() {
        if (operation.getNum1() != null && operation.getNum2() != null) {
            result.text = operation.divide().toString()
        }
    }

    private fun setSubtraction() {
        if (operation.getNum1() != null && operation.getNum2() != null) {
            result.text = operation.subtract().toString()
        }
    }

    private fun setMultiplication() {
        if (operation.getNum1() != null && operation.getNum2() != null) {
            result.text = operation.multiply().toString()
        }
    }

    private fun setButtonVisibility() {
        operation.setNum1(null)
        operation.setNum2(null)

        if (editNum.text.toString().isNotEmpty()) {
            operation.setNum1(editNum.text.toString().toFloatOrNull())
        }

        if (editNumTwo.text.toString().isNotEmpty()) {
            operation.setNum2(editNumTwo.text.toString().toFloatOrNull())
        }
        if (operation.getNum1() != null && operation.getNum2() != null) {
            buttonAdd.isEnabled = true
            buttonMinus.isEnabled = true
            buttonMultiply.isEnabled = true
            buttonDivision.isEnabled = operation.getNum2()!!.isNonZero()
        } else {
            buttonAdd.isEnabled = false
            buttonMinus.isEnabled = false
            buttonMultiply.isEnabled = false
            buttonDivision.isEnabled = false
        }
    }

}