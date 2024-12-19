package com.example.zerrendasqllite;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class LehenengoFragment extends Fragment {

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lehenengo, container, false);
        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        activity.getSupportActionBar().setTitle("Lehenengo");

        EditText editTextIzena = view.findViewById(R.id.editTextIzena);
        EditText editTextDeskribapena = view.findViewById(R.id.editTextDeskr);

        Button buttonGorde = view.findViewById(R.id.buttonGorde);
        Button buttonErakutsi = view.findViewById(R.id.buttonErakutsi);
        listView = view.findViewById(R.id.listView);

        buttonGorde.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Gorde nahi duzu?").setTitle("Gorde");
            builder.setPositiveButton("Bai", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    String izena = editTextIzena.getText().toString();
                    String deskribapena = editTextDeskribapena.getText().toString();
                    gehituLengoaia(izena, deskribapena);
                    editTextIzena.setText("");
                    editTextDeskribapena.setText("");
                }
            });
            builder.setNegativeButton("Ez", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    editTextIzena.setText("");
                    editTextDeskribapena.setText("");
                }
            });
            builder.show();
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

    public void erakutsiLengoaiak() {
        ZerrendaDAO zerrendaDAO = new ZerrendaDAO(requireContext());
        List<String> lengoaiak = zerrendaDAO.lortuLengoaiak();
        for (String lengoaia : lengoaiak) {
            Log.i("Lengoaia", lengoaia);
        }
        ZerrendaAdapter adapter = new ZerrendaAdapter(requireContext(),
                (ArrayList<String>) lengoaiak);
        listView.setAdapter(adapter);
    }

    public void gehituLengoaia(String izena, String deskribapena) {
        ZerrendaDAO zerrendaDAO = new ZerrendaDAO(requireContext());
        long id = zerrendaDAO.gehituLengoaia(izena, deskribapena);
    }

    public void itxi() {
        requireActivity().finish();
    }

}