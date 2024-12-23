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
import android.widget.Toast;

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

        return view;
    }

    public void gehituLengoaia(String izena, String deskribapena) {
        ZerrendaDAO zerrendaDAO = new ZerrendaDAO(requireContext());
        long id = zerrendaDAO.gehituLengoaia(izena, deskribapena, false);
    }

    public void itxi() {
        requireActivity().finish();
    }

}