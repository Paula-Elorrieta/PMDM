package com.example.komunikazioaksarbideak_sarbidea;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class NFCFragment extends Fragment {

    private NfcAdapter nfcAdapter;
    private TextView txtNfc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_n_f_c, container, false);

        txtNfc = view.findViewById(R.id.txtNFC);
        Button btnAtzera = view.findViewById(R.id.btnAtzera);

        btnAtzera.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        nfcAdapter = NfcAdapter.getDefaultAdapter(getContext());

        if (nfcAdapter == null) {
            txtNfc.setText("NFC ez dago eskuragarri");
        } else {
            if (nfcAdapter.isEnabled()) {
                txtNfc.setText("NFC aktibatuta dago");
            } else {
                txtNfc.setText("NFC desaktibatuta dago");
            }
        }

        txtNfc.setOnClickListener(v -> {
            if (nfcAdapter != null && !nfcAdapter.isEnabled()) {
                Intent intent = new Intent(android.provider.Settings.ACTION_NFC_SETTINGS);
                startActivity(intent);
            }
        });

        return view;
    }


}