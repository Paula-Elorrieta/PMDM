package com.example.buttonandtextview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private  Button myButton = null;
    private  TextView myTextView = null;

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
        myTextView = (TextView) findViewById(R.id.textView);

    }

    public void onClick (View v) {
        String textViewText = myTextView.getText().toString();
        String textPulsa = getString(R.string.text_pulsa);
        String textHola = getString(R.string.text_hola_mundo);

        if (textViewText.equalsIgnoreCase(textPulsa)) {
            myTextView.setText(textHola);
        }else {
            myTextView.setText(textPulsa);
        }
    }

}