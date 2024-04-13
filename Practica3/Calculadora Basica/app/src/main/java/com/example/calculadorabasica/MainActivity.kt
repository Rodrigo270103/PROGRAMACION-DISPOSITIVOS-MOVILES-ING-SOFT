package com.example.calculadorabasica

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private var operand1 = ""
    private var operand2 = ""
    private var operator = ""
    private var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.texto_resultado)
    }

    fun onButtonClick(view: View) {
        val button = view as Button
        val buttonText = button.text.toString()

        when (buttonText) {
            "=" -> calculateResult()
            "+", "-", "x", "%" -> setOperator(buttonText)
            else -> appendOperand(buttonText)
        }
    }

    private fun appendOperand(digit: String) {
        if (isNewOperation) {
            textView.text = digit
            isNewOperation = false
        } else {
            textView.append(digit)
        }
    }

    private fun setOperator(operator: String) {
        this.operator = operator
        isNewOperation = true
        operand1 = textView.text.toString()
    }

    private fun calculateResult() {
        operand2 = textView.text.toString()

        var result = 0.0
        val op1 = operand1.toDouble()
        val op2 = operand2.toDouble()

        when (operator) {
            "+" -> result = op1 + op2
            "-" -> result = op1 - op2
            "x" -> result = op1 * op2
            "%" -> result = op1 / op2
        }

        textView.text = result.toString()
        isNewOperation = true
    }
}
