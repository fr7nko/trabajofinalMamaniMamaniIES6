package ies6.edu.ar.trabajofinal.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Component
@Entity
public class Vehiculo {
    @Id
    private Integer patente;
    
    @Column
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    private String marca;

    @Column
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    private String modelo;

    @Column
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    private String color;

    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipoVehiculo;

    @Column
    private Boolean estado;

     @OneToOne
    @JoinColumn(name = "dni_conductor")
     private Conductor conductor;

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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    

    
}