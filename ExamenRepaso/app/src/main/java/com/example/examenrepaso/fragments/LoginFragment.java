package com.example.examenrepaso.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.examenrepaso.R;

public class LoginFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar2);
        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Login");

        EditText editTextErabiltzailea = view.findViewById(R.id.editTextErabiltzailea);
        EditText editTextPasahitza = view.findViewById(R.id.editTextPasahitza);

        Button buttonLogin = view.findViewById(R.id.buttonLogin);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String erabiltzailea = editTextErabiltzailea.getText().toString();
                String pasahitza = editTextPasahitza.getText().toString();

                if (erabiltzailea.equals("")) {
                    editTextErabiltzailea.setError("Erabiltzailea ezin da hutsik egon");
                }

                if (pasahitza.equals("")) {
                    editTextPasahitza.setError("Pasahitza ezin da hutsik egon");
                }

                if (pasahitza.length() <= 2) {
                    editTextPasahitza.setError("Pasahitza motzegia da");
                }

                if (erabiltzailea.equals("admin") && pasahitza.equals("admin")) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new ZerrendaFragment())
                            .addToBackStack(null)
                            .commit();
                } else if (erabiltzailea.equals("admin") && !pasahitza.equals("admin")) {
                    editTextPasahitza.setError("Pasahitza okerra");
                } else {
                    editTextErabiltzailea.setError("Erabiltzailea okerra");
                }
            }
        });

        return view;
    }
}