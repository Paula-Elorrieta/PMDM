package com.example.examenrepaso.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import com.example.examenrepaso.Erabiltzaile;
import com.example.examenrepaso.R;

import java.util.ArrayList;

public class ZerrendaFragment extends Fragment {
    static Data data = new Data();
    ArrayList<Erabiltzaile> erabiltzaileak = data.getErabiltzaileak();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zerrenda, container, false);

        // Toolbar para el titulo del fragment. Modificar solo el setTitle.
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Zerranda");

        // Asignarle el adapter a la lista
        ListView listView = view.findViewById(R.id.listView);
        ZerrendaAdapter adapter = new ZerrendaAdapter(getContext(), erabiltzaileak);
        listView.setAdapter(adapter);


        return view;
    }
}