package com.example.komunikazioaksarbideak_sarbidea;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AukeraFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aukera, container, false);

        Button btnMapa = view.findViewById(R.id.btnMapa);
        Button btnWifi = view.findViewById(R.id.btnWifi);
        Button btnBlutuh = view.findViewById(R.id.btnBlutuh);
        Button btnKamera = view.findViewById(R.id.btnKamera);
        Button btnNFC = view.findViewById(R.id.btnNFC);

        btnMapa.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new KokapenaFragment())
                    .addToBackStack(null)
                    .commit();
        });

        btnWifi.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new WifiFragment())
                    .addToBackStack(null)
                    .commit();
        });

        btnBlutuh.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new BlutuhFragment())
                    .addToBackStack(null)
                    .commit();
        });

        btnKamera.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new KameraFragment())
                    .addToBackStack(null)
                    .commit();
        });

        btnNFC.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new NFCFragment())
                    .addToBackStack(null)
                    .commit();
        });


        return view;
    }
}