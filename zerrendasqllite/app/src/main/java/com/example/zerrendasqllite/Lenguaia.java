package com.example.zerrendasqllite;

public class Lenguaia {

    private int id;
    private String izena;
    private String deskribapena;

    public Lenguaia(int id, String izena, String deskribapena) {
        this.id = id;
        this.izena = izena;
        this.deskribapena = deskribapena;
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
}
