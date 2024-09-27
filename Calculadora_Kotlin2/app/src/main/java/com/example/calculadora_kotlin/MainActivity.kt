package com.example.calculadora_kotlin

import android.os.Bundle
import android.view.View
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

        val Botons = arrayOf(R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                        R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9)
        val btnOperators = arrayOf(R.id.buttonResta, R.id.buttonSuma)
        val btnCalcular = R.id.buttonCalcular
        val TextView = findViewById<TextView>(R.id.textView)
        val EditText = findViewById<EditText>(R.id.editTextNumber)

        // Asignar el listener a los botones
        Botons.forEach { id ->
            findViewById<View>(id).setOnClickListener {
                // it es el botón que se ha pulsado y se puede hacer un casting a TextView
                EditText.append((it as TextView).text)
            }
        }


    }
}