package com.example.coletanea.model;

import java.io.Serializable;

/**
 * Created by LCCS on 26/06/2017.
 */

public class Musica implements Serializable {

    private String titulo;
    private String letra;

    public Musica() {
    }

    public Musica(String titulo, String letra) {
        this.titulo = titulo;
        this.letra = letra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Override
    public String toString(){
        return titulo;
    }
}
