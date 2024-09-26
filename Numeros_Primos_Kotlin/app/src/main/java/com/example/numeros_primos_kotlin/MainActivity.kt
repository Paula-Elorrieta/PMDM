package com.example.numeros_primos_kotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.NumberFormatException

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

        val myBoton = findViewById<android.widget.Button>(R.id.button)
        val myTextView = findViewById<android.widget.TextView>(R.id.TextView)
        val myEditText = findViewById<android.widget.EditText>(R.id.editTextNumber)

        myBoton.setOnClickListener {

            if (myBoton.text.equals(getText(R.string.reiniciar))) {
                myBoton.text = getText(R.string.comprobar)
                myEditText.setText("")
                myTextView.text = getText(R.string.insertar)

            } else if (myBoton.text.equals(getText(R.string.comprobar))) {
                var numero = myEditText.text.toString().toInt()
                if (myEditText.text.toString().isNotEmpty()) {

                    try {
                        if (esPrimo(numero)) {
                            myTextView.text = getText(R.string.es_primo)
                        } else {
                            myTextView.text = getText(R.string.no_es_primo)
                        }

                        myBoton.text = getText(R.string.reiniciar)
                    }catch (e: NumberFormatException){
                        myTextView.text = getText(R.string.error)
                    }
                }else {
                    myTextView.text = getText(R.string.error)
                }
            }
        }
    }

    private fun esPrimo(numero: Int): Boolean {
        var contador = 2
        var primo = true
        while (primo && contador != numero) {
            if (numero % contador == 0)
                primo = false
            contador++
        }
        return primo
    }

}