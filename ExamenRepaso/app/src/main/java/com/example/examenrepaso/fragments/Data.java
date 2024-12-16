package com.example.examenrepaso.fragments;

import com.example.examenrepaso.Erabiltzaile;

import java.util.ArrayList;

public class Data {

    static public ArrayList<Erabiltzaile> erabiltzaileak = new ArrayList<>();

    Erabiltzaile erabiltzaile1 = new Erabiltzaile(1, "Ane", "Bilbo",
            "1234", 666666666, "Emakumea", "Ikasle");
    Erabiltzaile erabiltzaile2 = new Erabiltzaile(2, "Jon", "Donostia",
            "1234", 666666666, "Gizona", "Irakasle");
    Erabiltzaile erabiltzaile3 = new Erabiltzaile(3, "Mikel", "Bilbo",
            "1234", 666666666, "Gizona", "Ikasle");
    Erabiltzaile erabiltzaile4 = new Erabiltzaile(4, "Miren", "Bilbo",
            "1234", 666666666, "Emakumea", "Ikasle");
    Erabiltzaile erabiltzaile5 = new Erabiltzaile(5, "Ander", "Donostia",
            "1234", 666666666, "Gizona", "Irakasle");
    Erabiltzaile erabiltzaile6 = new Erabiltzaile(6, "Raúl", "Bilbo",
            "1234", 666666666, "Gizona", "Ikasle");

    public Data() {
        erabiltzaileak.add(erabiltzaile1);
        erabiltzaileak.add(erabiltzaile2);
        erabiltzaileak.add(erabiltzaile3);
        erabiltzaileak.add(erabiltzaile4);
        erabiltzaileak.add(erabiltzaile5);
        erabiltzaileak.add(erabiltzaile6);
    }

    public static ArrayList<Erabiltzaile> getErabiltzaileak() {
        return erabiltzaileak;
    }
}
