package com.example.praktikagidatua_zerrenda.Fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.praktikagidatua_zerrenda.Item;
import com.example.praktikagidatua_zerrenda.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ZerrendaAdapter extends ArrayAdapter<Item> {

    ArrayList<Item> items;
    ArrayList<Item> itemsFiltratuta = new ArrayList<>();

    // El ArrayAdapter necesita un constructor que reciba el contexto y la lista de elementos
    public ZerrendaAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
        this.items = items;
        this.itemsFiltratuta.addAll(items);
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
        TextView textGeneroa = convertView.findViewById(R.id.textGeneroa);

        textName.setText(item.getIzena());
        textDescripcion.setText(item.getDeskribapena());
        textID.setText(item.getId() + "");
        textEstado.setText("Bizirik dago: " + item.getEgoera());
        textGeneroa.setText("Generoa: " + item.getGeneroa());

        return convertView;
    }

    public void filtraketaEgin(String texto) {

        items.clear();

        if (texto.isEmpty()) {
            items.addAll(itemsFiltratuta);
        } else {
            texto = texto.toLowerCase();
            for (Item item : itemsFiltratuta) {
                if (item.getIzena().toLowerCase().contains(texto)) {
                    items.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
