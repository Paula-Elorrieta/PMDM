package com.example.komunikazioaksarbideak_sarbidea;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class KokapenaFragment extends Fragment {
    private TextView txtLocation;
    private LocationManager locationManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_kokapena, container, false);
        txtLocation = rootView.findViewById(R.id.txtKokapena);
        Button btnAtzera = rootView.findViewById(R.id.btnAtzera);

        // Botón para volver atrás
        btnAtzera.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        // Inicialización del LocationManager
        locationManager = (LocationManager) requireContext().getSystemService(Context.LOCATION_SERVICE);

        if (locationManager == null) {
            txtLocation.setText("Kokapena ez dago eskuragarri");
        } else {
            if (isLocationEnabled()) {
                txtLocation.setText("Kokapena aktibatuta dago");
            } else {
                txtLocation.setText("Kokapena desaktibatuta dago");
            }
        }

        txtLocation.setOnClickListener(v -> {
            if (!isLocationEnabled()) {
                Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });

        return rootView;
    }

    private boolean isLocationEnabled() {
        return locationManager != null && (
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                        locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        );
    }
}
