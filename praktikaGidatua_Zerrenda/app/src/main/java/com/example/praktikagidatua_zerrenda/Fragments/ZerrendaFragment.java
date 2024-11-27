package com.example.praktikagidatua_zerrenda.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.praktikagidatua_zerrenda.Item;
import com.example.praktikagidatua_zerrenda.R;

import java.util.ArrayList;

public class ZerrendaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate es un método que se utiliza para convertir un archivo XML en un objeto de vista.
        View view = inflater.inflate(R.layout.fragment_zerrenda, container, false);
        Button buttonGehitu = view.findViewById(R.id.buttonGehitu);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(1, "Vi",
                "Una luchadora fuerte y decidida, conocida " +
                        "por sus guantes Hextech y su carácter impulsivo.", "Si"));
        items.add(new Item(2, "Jinx",
                "Hermana de Vi, una pistolera caótica y " +
                        "explosiva con un pasado traumático.", "No (?)"));
        items.add(new Item(3, "Jayce",
                "Un inventor brillante de Piltover, " +
                        "creador de la tecnología Hextech.", "No"));
        items.add(new Item(4, "Caitlyn",
                "La mejor tiradora de Piltover, " +
                        "comprometida con la justicia.", "Si"));
        items.add(new Item(5, "Ekko",
                "Un joven genio con la habilidad de " +
                        "manipular el tiempo, líder de los Firelights.", "Si"));

        Bundle bundle = getArguments();
        if (bundle != null) {
            String izena = bundle.getString("izena");
            String deskribapena = bundle.getString("deskribapena");
            String egoera = bundle.getString("egoera");
            int id = bundle.getInt("id");

            Item itemberria = new Item(id, izena, deskribapena, egoera);
            items.add(itemberria);
        }

        ListView zerrendaBista = view.findViewById(R.id.VistaZerrenda);

        ZerrendaAdapter adapter = new ZerrendaAdapter(getContext(), items);
        zerrendaBista.setAdapter(adapter);


        buttonGehitu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new GehituFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


        return view;
    }
}