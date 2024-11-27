package com.example.praktikagidatua_zerrenda.Fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.praktikagidatua_zerrenda.Item;
import com.example.praktikagidatua_zerrenda.R;

import java.util.ArrayList;

public class ZerrendaAdapter extends ArrayAdapter<Item> {

    // El ArrayAdapter necesita un constructor que reciba el contexto y la lista de elementos
    public ZerrendaAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.errenkada_item, parent, false);
        }

        Item item = getItem(position);
        TextView textName = convertView.findViewById(R.id.textName);
        TextView textDescripcion = convertView.findViewById(R.id.textDescripcion);
        TextView textID = convertView.findViewById(R.id.textID);
        TextView textEstado = convertView.findViewById(R.id.textEstado);

        textName.setText(item.getIzena());
        textDescripcion.setText(item.getDeskribapena());
        textID.setText(item.getId() + "");
        textEstado.setText("Esta vivo/a: " + item.getEgoera());

        return convertView;
    }
}
