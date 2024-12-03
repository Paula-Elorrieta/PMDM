package com.example.praktikagidatua_zerrenda;

import java.io.Serializable;

public class Item implements Serializable {

    private int id;
    private String izena;
    private String deskribapena;
    private String egoera;
    private String generoa;

    public Item(int id, String izena, String deskribapena, String egoera, String generoa) {
        this.id = id;
        this.izena = izena;
        this.deskribapena = deskribapena;
        this.egoera = egoera;
        this.generoa = generoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

    public String getEgoera() {
        return egoera;
    }

    public void setEgoera(String egoera) {
        this.egoera = egoera;
    }

    public String getGeneroa() {
        return generoa;
    }

    public void setGeneroa(String generoa) {
        this.generoa = generoa;
    }
}
