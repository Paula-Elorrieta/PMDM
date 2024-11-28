package com.example.praktikagidatua_zerrenda.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.praktikagidatua_zerrenda.R;

import java.util.ArrayList;

public class GehituFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();

        View view = inflater.inflate(R.layout.fragment_gehitu, container, false);
        Button buttonItzuli = view.findViewById(R.id.buttonItzuli);
        Button buttonGehitu = view.findViewById(R.id.buttonGehitu);

        EditText editTextID = view.findViewById(R.id.editTextID);
        Log.e("ID", bundle.getInt("lastID") + "");
        editTextID.setText(bundle.getInt("lastID") + "");

        editTextID.setEnabled(false);

        ArrayList<String> listaEstados = new ArrayList<>();
        listaEstados.add("Si");
        listaEstados.add("No");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, listaEstados);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerEstado = view.findViewById(R.id.spinnerEstado);
        spinnerEstado.setAdapter(adapter);

        buttonItzuli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        buttonGehitu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editTextIzena = view.findViewById(R.id.editTextNombre);
                EditText editTextDeskribapena = view.findViewById(R.id.editTextDescripcion);
                Spinner spinnerEstado = view.findViewById(R.id.spinnerEstado);

                String izena = editTextIzena.getText().toString();
                String deskribapena = editTextDeskribapena.getText().toString();
                String egoera = spinnerEstado.getSelectedItem().toString();

                if (izena.isEmpty()) {
                    editTextIzena.setError("Introduce un nombre");
                    return;
                }

                if (deskribapena.isEmpty()) {
                    editTextDeskribapena.setError("Introduce una descripción");
                    return;
                }


                Bundle bundle = new Bundle();
                bundle.putInt("id", Integer.parseInt(editTextID.getText().toString()));
                bundle.putString("izena", izena);
                bundle.putString("deskribapena", deskribapena);
                bundle.putString("egoera", egoera);

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