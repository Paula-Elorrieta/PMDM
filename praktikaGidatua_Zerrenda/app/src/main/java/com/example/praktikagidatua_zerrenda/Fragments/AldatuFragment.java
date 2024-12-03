package com.example.praktikagidatua_zerrenda.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.praktikagidatua_zerrenda.Item;
import com.example.praktikagidatua_zerrenda.R;

import java.util.ArrayList;

public class AldatuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aldatu, container, false);
        Bundle bundle = getArguments();

        ArrayList<Item> items = (ArrayList<Item>) bundle.getSerializable("itemsArrayList");
        int id = bundle.getInt("selectedId");

        EditText editTextID2 = view.findViewById(R.id.editTextID2);
        EditText editTextNombre2 = view.findViewById(R.id.editTextNombre2);
        EditText editTextDescripcion2 = view.findViewById(R.id.editTextDescripcion2);
        bundle.putInt("id", 0);

        for (Item item : items) {
            if (item.getId() == id)  {
                editTextID2.setText(String.valueOf(item.getId()));
                editTextNombre2.setText(item.getIzena());
                editTextDescripcion2.setText(item.getDeskribapena());
            }
        }
        editTextID2.setEnabled(false);

        Button buttonItzuli = view.findViewById(R.id.buttonItzuli);
        Button buttonGorde = view.findViewById(R.id.buttonGorde);
        Button buttonEzabatu = view.findViewById(R.id.buttonEzabatu);

        buttonItzuli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        // Aldatu botoia sakatzean, datuak aldatu eta zerrendaFragment-era itzuli
        buttonGorde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextNombre2.getText().toString().isEmpty()) {
                    editTextNombre2.setError("Izena sartu behar duzu");
                    return;
                }

                if (editTextDescripcion2.getText().toString().isEmpty()) {
                    editTextDescripcion2.setError("Deskribapena sartu behar duzu");
                    return;
                }

                for (Item item : items) {
                    if (item.getId() == id) {
                        item.setIzena(editTextNombre2.getText().toString());
                        item.setDeskribapena(editTextDescripcion2.getText().toString());
                        Toast.makeText(getContext(), "Elementua aldatu da",
                                                                        Toast.LENGTH_SHORT).show();
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("itemsArrayList", items);
                ZerrendaFragment fragment = new ZerrendaFragment();
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        // Ezabatu botoia sakatzean, item-a ezabatu eta zerrendaFragment-era itzuli
        buttonEzabatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Item item : items) {
                    if (item.getId() == id) {
                        items.remove(item);
                        Toast.makeText(getContext(), "Elementua ezabatu da",
                                                                        Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("itemsArrayList", items);
                ZerrendaFragment fragment = new ZerrendaFragment();
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


        return view;
    }

}