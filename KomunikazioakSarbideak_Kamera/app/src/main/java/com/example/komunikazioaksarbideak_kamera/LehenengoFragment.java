package com.example.komunikazioaksarbideak_kamera;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import java.io.File;

public class LehenengoFragment extends Fragment {

    private ImageView imgAurreikuspena;
    private Uri argazkiUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lehenengo, container, false);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 100);
        }

        Button btnArgazkiaAtera = view.findViewById(R.id.btnArgazkiaAtera);
        imgAurreikuspena = view.findViewById(R.id.imgAurreikuspena);

        btnArgazkiaAtera.setOnClickListener(v -> kameraZabaldu());

        return view;
    }

    private void kameraZabaldu() {
        File argazkia = new File(getActivity().getExternalFilesDir(null),
                "foto_" + System.currentTimeMillis() + ".jpg");

        argazkiUri = FileProvider.getUriForFile(getContext(),
                "com.example.komunikazioaksarbideak_kamera.fileprovider", argazkia);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, argazkiUri);
        startActivityForResult(intent, 200);
    }

}
