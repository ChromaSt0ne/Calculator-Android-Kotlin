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
        var num: Float? = null
        var num2: Float? = null
        if (editNum.text.toString().isNotEmpty()) {
            num = editNum.text.toString().toFloatOrNull()
        }
        if (editNumTwo.text.toString().isNotEmpty()) {
            num2 = editNumTwo.text.toString().toFloatOrNull()
        }
        if (num != null && num2 != null) {
            val sum = num + num2
            result.text = sum.toString()
        }
    }

    private fun setDivide() {
        var num: Float? = null
        var num2: Float? = null
        if (editNum.text.toString().isNotEmpty()) {
            num = editNum.text.toString().toFloatOrNull()
        }
        if (editNumTwo.text.toString().isNotEmpty()) {
            num2 = editNumTwo.text.toString().toFloatOrNull()
        }
        if (num != null && num2 != null) {
            val sum = num / num2
            result.text = sum.toString()
        }
    }

    private fun setSubtraction() {
        var num: Float? = null
        var num2: Float? = null
        if (editNum.text.toString().isNotEmpty()) {
            num = editNum.text.toString().toFloatOrNull()
        }
        if (editNumTwo.text.toString().isNotEmpty()) {
            num2 = editNumTwo.text.toString().toFloatOrNull()
        }
        if (num != null && num2 != null) {
            val sum = num - num2
            result.text = sum.toString()
        }
    }

    private fun setMultiplication() {
        var num: Float? = null
        var num2: Float? = null
        if (editNum.text.toString().isNotEmpty()) {
            num = editNum.text.toString().toFloatOrNull()
        }
        if (editNumTwo.text.toString().isNotEmpty()) {
            num2 = editNumTwo.text.toString().toFloatOrNull()
        }
        if (num != null && num2 != null) {
            val sum = num * num2
            result.text = sum.toString()
        }
    }

    private fun setButtonVisibility() {
        var num: Float? = null
        var num2: Float? = null
        if (editNum.text.toString().isNotEmpty()) {
            num = editNum.text.toString().toFloatOrNull()
        }
        if (editNumTwo.text.toString().isNotEmpty()) {
            num2 = editNumTwo.text.toString().toFloatOrNull()
        }
        if (num != null && num2 != null) {
            buttonAdd.isEnabled = true
            buttonMinus.isEnabled = true
            buttonMultiply.isEnabled = true
            buttonDivision.isEnabled = num > 0 && num2 > 0

        } else {
            buttonAdd.isEnabled = false
            buttonMinus.isEnabled = false
            buttonMultiply.isEnabled = false
            buttonDivision.isEnabled = false
        }
    }
}