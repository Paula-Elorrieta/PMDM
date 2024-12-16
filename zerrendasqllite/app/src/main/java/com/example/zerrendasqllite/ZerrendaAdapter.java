package com.example.zerrendasqllite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.zerrendasqllite.R;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ZerrendaAdapter extends ArrayAdapter<String> {

    ArrayList<String> items;
    ArrayList<String> itemsFiltratuta = new ArrayList<>();

    public ZerrendaAdapter(Context context, ArrayList<String> items) {
        super(context, 0, items);
        this.items = items;
        this.itemsFiltratuta.addAll(items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.errenkada, parent, false);
        }

        String item = getItem(position);
        TextView textItem = convertView.findViewById(R.id.textItem);

        textItem.setText(item);

        return convertView;
    }

//    public void filtraketaEgin(String texto) {
//
//        items.clear();
//
//        if (texto.isEmpty()) {
//            items.addAll(itemsFiltratuta);
//        } else {
//            texto = texto.toLowerCase();
//            for (Item item : itemsFiltratuta) {
//                if (item.getIzena().toLowerCase().contains(texto)) {
//                    items.add(item);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }
}