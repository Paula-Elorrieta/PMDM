package com.example.praktikagidatua_zerrenda;

public class Item {

    private int id;
    private String izena;
    private String deskribapena;
    private String egoera;

    public Item(int id, String izena, String deskribapena, String egoera) {
        this.id = id;
        this.izena = izena;
        this.deskribapena = deskribapena;
        this.egoera = egoera;
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
}
