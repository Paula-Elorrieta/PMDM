package com.example.examenrepaso;

import java.io.Serializable;

public class Erabiltzaile implements Serializable {
    private int id;
    private String izena;
    private String herria;
    private String pasahitza;
    private int telefonoa;
    private String generoa;
    private String lana;

    public Erabiltzaile(int id, String izena, String herria, String pasahitza, int telefonoa, String generoa, String lana) {
        this.id = id;
        this.izena = izena;
        this.herria = herria;
        this.pasahitza = pasahitza;
        this.telefonoa = telefonoa;
        this.generoa = generoa;
        this.lana = lana;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getHerria() {
        return herria;
    }

    public void setHerria(String herria) {
        this.herria = herria;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    public int getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(int telefonoa) {
        this.telefonoa = telefonoa;
    }

    public String getGeneroa() {
        return generoa;
    }

    public void setGeneroa(String generoa) {
        this.generoa = generoa;
    }

    public String getLana() {
        return lana;
    }

    public void setLana(String lana) {
        this.lana = lana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
