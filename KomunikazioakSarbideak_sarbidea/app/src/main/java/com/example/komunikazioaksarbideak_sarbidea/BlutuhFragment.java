package com.example.komunikazioaksarbideak_sarbidea;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;


public class BlutuhFragment extends Fragment {
    private BluetoothAdapter bluetoothAdapter;
    private TextView txtBluetooth;
    private ActivityResultLauncher<Intent> bluetoothEnableLauncher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_blutuh, container, false);
            txtBluetooth = rootView.findViewById(R.id.txtBluthu);
            Button btnAtzera = rootView.findViewById(R.id.btnAtzera);

            btnAtzera.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().popBackStack();
            });

            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

            if (bluetoothAdapter == null) {
                txtBluetooth.setText("Bluetooth ez dago eskuragarri");
            } else {
                if (bluetoothAdapter.isEnabled()) {
                    txtBluetooth.setText("Bluetooth aktibatuta dago");
                } else {
                    txtBluetooth.setText("Bluetooth desaktibatuta dago");
                }
            }

            bluetoothEnableLauncher = registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (bluetoothAdapter.isEnabled()) {
                            txtBluetooth.setText("Bluetooth está activado");
                        } else {
                            txtBluetooth.setText("Bluetooth está desactivado");
                        }
                    }
            );

            txtBluetooth.setOnClickListener(v -> {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                bluetoothEnableLauncher.launch(intent);
            });

            return rootView;
        }
}