package com.example.zerrendasqllite;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class LehenengoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lehenengo, container, false);
        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        activity.getSupportActionBar().setTitle("Lenguaiak");

        ListView listView = view.findViewById(R.id.listView);

        ZerrendaDAO zerrendaDAO = new ZerrendaDAO(requireContext());
        List<Lenguaia> lengoaiak = zerrendaDAO.lortuLengoaiak();

        if (lengoaiak.isEmpty()) {
            zerrendaDAO.gehituLengoaia("Java", "Java lengoaia", false);
        }

        ZerrendaAdapter adapter = new ZerrendaAdapter(requireContext(),
                (ArrayList<Lenguaia>) lengoaiak);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Lenguaia lenguaia = (Lenguaia) parent.getItemAtPosition(position);
            LayoutInflater inflater1 = LayoutInflater.from(requireContext());
            View dialogView = inflater1.inflate(R.layout.dialog_lenguaia, null);

            Button btnAldatu = dialogView.findViewById(R.id.btnAldatu);
            Button btnEzabatu = dialogView.findViewById(R.id.btnEzabatu);

            AlertDialog dialog = new AlertDialog.Builder(requireContext())
                    .setView(dialogView)
                    .create();

            btnEzabatu.setOnClickListener(v -> {
                AlertDialog alertDialog = new AlertDialog.Builder(requireContext())
                        .setTitle("Ezabatu")
                        .setMessage("Ziur zaude ezabatu nahi duzula?")
                        .setPositiveButton("Bai", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                zerrendaDAO.ezabatuLengoaia(getID(lenguaia, lengoaiak));
                                adapter.remove(lenguaia);
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Ez", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                alertDialog.show();
            });


            dialog.show();

        });

        return view;
    }


    public void itxi() {
        requireActivity().finish();
    }

    public int getID (Lenguaia lenguaia, List<Lenguaia> lenguaiak) {
        for (int i = 0; i < lenguaiak.size(); i++) {
            if (lenguaiak.get(i).equals(lenguaia)) {
                return i + 1;
            }
        }
        return 0;
    }

}