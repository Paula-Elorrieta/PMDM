package com.example.examenrepaso.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.examenrepaso.Erabiltzaile;
import com.example.examenrepaso.R;

import java.util.ArrayList;

public class ZerrendaAdapter extends ArrayAdapter<Erabiltzaile> {

    ArrayList<Erabiltzaile> erabiltzaileak;
    ArrayList<Erabiltzaile> erabiltzaileFiltratuta = new ArrayList<>();

    // El ArrayAdapter necesita un constructor que reciba el contexto y la lista de elementos
    public ZerrendaAdapter(Context context, ArrayList<Erabiltzaile> items) {
        super(context, 0, items);
        this.erabiltzaileak = items;
        this.erabiltzaileFiltratuta.addAll(items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.errenkada, parent, false);
        }

        Erabiltzaile erabiltzaile = getItem(position);
        TextView textName = convertView.findViewById(R.id.textName);
        TextView textID = convertView.findViewById(R.id.textID);
        TextView textGeneroa = convertView.findViewById(R.id.textGeneroa);
        TextView textLana = convertView.findViewById(R.id.textLana);
        TextView textHerria = convertView.findViewById(R.id.textHerria);

        textName.setText(erabiltzaile.getIzena());
        textID.setText(erabiltzaile.getId() + "");
        textGeneroa.setText("Generoa: " + erabiltzaile.getGeneroa());
        textLana.setText("Lana: " + erabiltzaile.getLana());
        textHerria.setText("Herria: " + erabiltzaile.getHerria());


        return convertView;
    }

    public void filtraketaEgin(String texto) {

        erabiltzaileak.clear();

        if (texto.isEmpty()) {
            erabiltzaileak.addAll(erabiltzaileFiltratuta);
        } else {
            texto = texto.toLowerCase();
            for (Erabiltzaile erabiltzaile : erabiltzaileFiltratuta) {
                if (erabiltzaile.getIzena().toLowerCase().contains(texto)) {
                    erabiltzaileak.add(erabiltzaile);
                }
            }
        }
        notifyDataSetChanged();
    }
}
