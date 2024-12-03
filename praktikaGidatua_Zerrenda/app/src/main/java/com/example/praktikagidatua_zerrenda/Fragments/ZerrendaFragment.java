package com.example.praktikagidatua_zerrenda.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.praktikagidatua_zerrenda.Item;
import com.example.praktikagidatua_zerrenda.R;

import java.util.ArrayList;

public class ZerrendaFragment extends Fragment {
    static Data data = new Data();
    static ArrayList<Item> items = data.getItems();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate es un método que se utiliza para convertir un archivo XML en un objeto de vista.
        View view = inflater.inflate(R.layout.fragment_zerrenda, container, false);
        Button buttonGehitu = view.findViewById(R.id.buttonGehitu);

        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.getInt("id") != 0) {
                String izena = bundle.getString("izena");
                String deskribapena = bundle.getString("deskribapena");
                String egoera = bundle.getString("egoera");
                String generoa = bundle.getString("generoa");
                int id = bundle.getInt("id");

                Item itemberria = new Item(id, izena, deskribapena, egoera, generoa);
                items.add(itemberria);
            }
        }

        ListView zerrendaBista = view.findViewById(R.id.VistaZerrenda);

        ZerrendaAdapter adapter = new ZerrendaAdapter(getContext(), items);
        zerrendaBista.setAdapter(adapter);

        Button buttonGarbitu = view.findViewById(R.id.buttonGarbitu);
        Button buttonBilatu = view.findViewById(R.id.buttonBilatu);

        EditText editTextBilatu = view.findViewById(R.id.editTextBilatu);

        buttonBilatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.filtraketaEgin(editTextBilatu.getText().toString());
            }
        });

        buttonGarbitu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextBilatu.setText("");
                adapter.filtraketaEgin("");
            }
        });

        buttonGehitu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("lastID", getLastId() + 1);
                GehituFragment fragment = new GehituFragment();
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        zerrendaBista.setOnItemClickListener((parent, view1, position, id) -> {
            Item selectedItem = items.get(position);

            Bundle itemBundle = new Bundle();
            itemBundle.putInt("selectedId", selectedItem.getId());
            itemBundle.putSerializable("itemsArrayList", items);

            AldatuFragment fragment = new AldatuFragment();
            fragment.setArguments(itemBundle);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();

        });

        return view;
    }

    public int getLastId() {

        if (items.size() == 0) {
            return 0;
        }

        return items.get(items.size() - 1).getId();
    }
}