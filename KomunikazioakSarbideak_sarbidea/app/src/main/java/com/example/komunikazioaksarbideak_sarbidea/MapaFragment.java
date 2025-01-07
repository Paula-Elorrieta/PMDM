package com.example.komunikazioaksarbideak_sarbidea;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnSuccessListener;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MapaFragment extends Fragment {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 100;
    private FusedLocationProviderClient fusedLocationClient;
    private MapView mapaIkuspegia;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);

        Configuration.getInstance().setUserAgentValue(requireActivity().getPackageName());

        mapaIkuspegia = view.findViewById(R.id.mapaIkuspegia);
        mapaIkuspegia.setMultiTouchControls(true);
        mapaIkuspegia.getController().setZoom(18.0);

        GeoPoint Barakaldo = new GeoPoint(43.2894689,-3.0136389);

        Marker txintxeta = new Marker(mapaIkuspegia);
        txintxeta.setPosition(Barakaldo);
        txintxeta.setTitle("Barakaldo");
        mapaIkuspegia.getOverlays().add(txintxeta);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity());

        if (ActivityCompat.checkSelfPermission(requireActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(requireActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
            fusedLocationClient.getCurrentLocation(LocationRequest.PRIORITY_HIGH_ACCURACY, cancellationTokenSource.getToken())
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location kokapena) {
                            if (kokapena != null) {
                                Log.i("logKokapena", "Egungo kokapena gehitzen ...");

                                GeoPoint egungoKokapena = new GeoPoint(kokapena.getLatitude(),
                                                                        kokapena.getLongitude());
                                gehituTxintxeta(egungoKokapena, "Nire Egungo Kokapena");
                                mapaIkuspegia.getController().setCenter(egungoKokapena);

                                Log.i("logKokapena", "Egungo kokapena: " +
                                        kokapena.getLatitude() + " - " +
                                        kokapena.getLongitude());
                            } else {
                                Log.i("logKokapena", "Ez da kokapenik aurkitu ...");
                            }
                        }
                    });
        }

        return view;
    }

    private void gehituTxintxeta(GeoPoint kokapena, String izena) {
        Marker txintxeta = new Marker(mapaIkuspegia);
        txintxeta.setPosition(kokapena);
        txintxeta.setTitle(izena);
        mapaIkuspegia.getOverlays().add(txintxeta);
    }
}
