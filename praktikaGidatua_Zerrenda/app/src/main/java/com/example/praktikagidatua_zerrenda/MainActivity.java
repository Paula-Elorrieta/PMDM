package com.example.praktikagidatua_zerrenda;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.praktikagidatua_zerrenda.Fragments.ZerrendaFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Item> items = new ArrayList<>();
        Item vi = new Item(1, "Vi",
                "Una luchadora fuerte y decidida, conocida " +
                        "por sus guantes Hextech y su carácter impulsivo.", "Si", "Femenino");
        Item jinx = new Item(2, "Jinx", "Hermana de Vi, una pistolera caótica y " +
                "explosiva con un pasado traumático.", "No (?)", "Femenino");

        Item jayce = new Item(3, "Jayce", "Un inventor brillante de Piltover, " +
                "creador de la tecnología Hextech.", "No", "Masculino");

        Item caitlyn = new Item(4, "Caitlyn", "La mejor tiradora de Piltover, " +
                "comprometida con la justicia.", "Si", "Femenino");

        Item ekko = new Item(5, "Ekko", "Un joven genio con la habilidad de " +
                "manipular el tiempo, líder de los Firelights.", "Si", "Masculino");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ZerrendaFragment())
                    .commit();
        }
    }
}