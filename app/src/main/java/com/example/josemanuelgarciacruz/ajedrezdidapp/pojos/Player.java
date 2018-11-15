package com.example.josemanuelgarciacruz.ajedrezdidapp.pojos;

import android.graphics.Bitmap;

import com.example.josemanuelgarciacruz.ajedrezdidapp.constantes.G;

/**
 * Created by Tiburcio on 31/07/2016.
 */
public class Player {
    private int ID;
    private String nombre;
    private String nacionalidad;
    private int yearNacimiento;
    private int yearDefuncion;
    private int elo;
    private Bitmap imagen;

    public Player(){
        this.ID = G.SIN_VALOR_INT;
        this.nombre = G.SIN_VALOR_STRING;
        this.setNacionalidad(G.SIN_VALOR_STRING);
        this.setImagen(null);
    };

    public Player(int ID, String nombre, String nacionalidad, int yearNacimiento, int yearDefuncion, int elo, Bitmap imagen) {
        this.ID = ID;
        this.nombre = nombre;
        this.setNacionalidad(nacionalidad);
        this.yearNacimiento = yearNacimiento;
        this.yearDefuncion = yearDefuncion;
        this.elo = elo;
        this.imagen = imagen;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public int getID() {
        return ID;
    }
    public String getNombre() {
        return nombre;
    }
    public String getNacionalidad() { return nacionalidad; }
    public int getYearNacimiento() {
        return yearNacimiento;
    }
    public int getYearDefuncion() { return yearDefuncion; }
    public int getElo() {
        return elo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public void setYearNacimiento(int yearNacimiento) {
        this.yearNacimiento = yearNacimiento;
    }
    public void setYearDefuncion(int yearDefuncion) {
        this.yearDefuncion = yearDefuncion;
    }
    public void setElo(int elo) {this.elo = elo; }
}
