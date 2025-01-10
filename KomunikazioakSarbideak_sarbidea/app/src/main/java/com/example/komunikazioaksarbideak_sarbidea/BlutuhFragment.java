package com.example.komunikazioaksarbideak_sarbidea;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;


public class BlutuhFragment extends Fragment {
    private BluetoothAdapter bluetoothAdapter;
    private TextView txtBluetooth;
    private ActivityResultLauncher<Intent> bluetoothEnableLauncher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_blutuh, container, false);
            txtBluetooth = rootView.findViewById(R.id.txtBluetooth);

            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

            if (bluetoothAdapter == null) {
                txtBluetooth.setText("Bluetooth no soportado");
            } else {
                if (bluetoothAdapter.isEnabled()) {
                    txtBluetooth.setText("Bluetooth está activado");
                } else {
                    txtBluetooth.setText("Bluetooth está desactivado");
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