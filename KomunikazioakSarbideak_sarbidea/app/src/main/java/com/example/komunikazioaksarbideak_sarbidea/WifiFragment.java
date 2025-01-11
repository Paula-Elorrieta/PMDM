package com.example.komunikazioaksarbideak_sarbidea;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WifiFragment extends Fragment {
    private TextView connectionStatus;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wifi, container, false);

        connectionStatus = view.findViewById(R.id.egoera);
        Button btnAtzera = view.findViewById(R.id.btnAtzera);
        String status = checkConnectionType(requireContext());
        connectionStatus.setText(status);

        btnAtzera.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }

    private String checkConnectionType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        return "WiFi konexioa erabiliz konektatuta";
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        return "Sare mugikorra erabiliz konektatuta";
                    }
                }
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                        return "WiFi konexioa erabiliz konektatuta";
                    } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                        return "Sare mugikorra erabiliz konektatuta";
                    }
                }
            }
        }
        return "Ez dago konektatuta";
    }
}
