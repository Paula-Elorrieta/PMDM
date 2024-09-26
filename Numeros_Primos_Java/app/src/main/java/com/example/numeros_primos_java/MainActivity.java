package com.example.numeros_primos_java;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button myButton = null;
    private EditText myEditTextNumber = null;
    private TextView myTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(this);
        myEditTextNumber = (EditText) findViewById(R.id.editTextNumber);
        myTextView = (TextView) findViewById(R.id.TextView);

    }

    @Override
    public void onClick(View view) {
        if (myButton.getText().equals(getString(R.string.reiniciar))) {
            myEditTextNumber.setText("");
            myTextView.setText(R.string.introducir);
            myButton.setText(R.string.comprobar);
        }
        else if (myButton.getText().equals(getString(R.string.comprobar))) {
            String inputText = myEditTextNumber.getText().toString();
            if (!inputText.isEmpty()) {
                try {
                    int number = Integer.parseInt(inputText);

                    if (isPrime(number)) {
                        myTextView.setText(R.string.si_primo);
                    } else {
                        myTextView.setText(R.string.no_primo);
                    }

                    myButton.setText(R.string.reiniciar);

                } catch (NumberFormatException e) {
                    myTextView.setText(R.string.error_numero);
                }
            } else {
                myTextView.setText(R.string.error_numero);
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}