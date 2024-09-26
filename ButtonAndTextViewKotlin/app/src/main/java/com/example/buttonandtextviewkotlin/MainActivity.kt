package com.example.buttonandtextviewkotlin

import android.os.Bundle
import android.widget.Button
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

        // No hace falta el tipo de dato de dato pero se puede poner
        val textView : TextView = findViewById(R.id.TextView)
        val button = findViewById<Button>(R.id.button)

        // Val es una variable inmutable y var es una variable mutable

        // Los parentesis son opcionales
        button.setOnClickListener() {

            val textViewTest = textView.text.toString()

            val textOk = getString(R.string.text_ok)
            val textHola = getString(R.string.text_hola_mundo)

            // Los corchetes son opcionales
            textView.text =
                if (textViewTest == textOk) {
                    textHola
                }else {
                    textOk
                }

        }

    }
}