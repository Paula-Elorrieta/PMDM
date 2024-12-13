package com.example.zerrendasqllite;

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

import java.util.List;


public class LehenengoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lehenengo, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Lehenengo");

        EditText editTextIzena = view.findViewById(R.id.editTextIzena);
        EditText editTextDeskribapena = view.findViewById(R.id.editTextDeskr);

        Button buttonGorde = view.findViewById(R.id.buttonGorde);
        Button buttonErakutsi = view.findViewById(R.id.buttonErakutsi);

        buttonGorde.setOnClickListener(v -> {
            String izena = editTextIzena.getText().toString();
            String deskribapena = editTextDeskribapena.getText().toString();

            ZerrendaDAO zerrendaDAO = new ZerrendaDAO(requireContext());
            long id = zerrendaDAO.gehituLengoaia(izena, deskribapena);
            editTextIzena.setText("");
            editTextDeskribapena.setText("");
        });

        buttonErakutsi.setOnClickListener(v -> {
            ZerrendaDAO zerrendaDAO = new ZerrendaDAO(requireContext());
            List<String> lengoaiak = zerrendaDAO.lortuLengoaiak();
            for (String lengoaia : lengoaiak) {
                Log.i("Lengoaia", lengoaia);
            }
        });

        return view;
    }
}