package ies6.edu.ar.trabajofinal.model;

import org.springframework.stereotype.Component;


@Component

public class Vehiculo {


    private Integer patente;

    private String marca;

    private String modelo;

    private String color;

    public Vehiculo() {
    }

    public Vehiculo(Integer patente, String marca, String modelo, String color) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public Integer getPatente() {
        return patente;
    }

    public void setPatente(Integer patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    

    
}
