package com.example.kotlin_calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val Botones = listOf(R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                            R.id.button4, R.id.button5, R.id.button6,
                            R.id.button7, R.id.button8, R.id.button9)
        val btnSuma: Button = findViewById(R.id.buttonSuma)
        val btnResta : Button = findViewById(R.id.buttonResta)
        val btnCalcular : Button = findViewById(R.id.buttonCalcular)
        val editText: EditText = findViewById(R.id.editTextNumber)
        val textView: TextView = findViewById(R.id.textView)

        editText.isEnabled = false
        editText.isClickable = false

        for (i in Botones) {
            findViewById<Button>(i).setOnClickListener {
                editText.append(findViewById<Button>(i).text)
            }
        }

        btnResta.setOnClickListener() {
            editText.append("-")
            setEnabled(btnResta, btnSuma)
        }

        btnSuma.setOnClickListener() {
            editText.append("+")
            setEnabled(btnResta, btnSuma)
        }

        val text = editText.text.toString()
        btnCalcular.setOnClickListener {
            val result = try {
                Operations.doOperation(text)
        } catch (e: Exception) {
                textView.text = "error"
        }

    }

    }
    private fun setEnabled(btnResta : Button, btnSuma : Button) {
        btnResta.isEnabled = false
        btnSuma.isEnabled = false
    }



}