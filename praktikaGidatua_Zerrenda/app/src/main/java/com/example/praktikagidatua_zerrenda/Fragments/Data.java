package com.example.praktikagidatua_zerrenda.Fragments;

import com.example.praktikagidatua_zerrenda.Item;

import java.util.ArrayList;

public class Data {

    static public ArrayList<Item> items = new ArrayList<>();
    Item vi = new Item(1, "Vi",
            "Una luchadora fuerte y decidida, conocida " +
                    "por sus guantes Hextech y su carácter impulsivo.", "Si", "Emakumezkoa");
    Item jinx = new Item(2, "Jinx", "Hermana de Vi, una pistolera caótica y " +
            "explosiva con un pasado traumático.", "No (?)", "Emakumezkoa");

    Item jayce = new Item(3, "Jayce", "Un inventor brillante de Piltover, " +
            "creador de la tecnología Hextech.", "No", "Gizonezkoa");

    Item caitlyn = new Item(4, "Caitlyn", "La mejor tiradora de Piltover, " +
            "comprometida con la justicia.", "Si", "Emakumezkoa");

    Item ekko = new Item(5, "Ekko", "Un joven genio con la habilidad de " +
            "manipular el tiempo, líder de los Firelights.", "Si", "Gizonezkoa");

    public Data() {
        items.add(vi);
        items.add(jinx);
        items.add(jayce);
        items.add(caitlyn);
        items.add(ekko);
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

}
