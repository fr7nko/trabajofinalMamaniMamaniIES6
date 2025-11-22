package ies6.edu.ar.trabajofinal.model;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Component
@Entity
public class Viaje {
     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
     private Integer codigo;


     @Enumerated(EnumType.STRING)
     @Column
     private TipoViaje tipoViaje;

     @Column
     private Double precio;
     
     @Column
     private LocalDate fechaViaje;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "dni")
     private Usuario usuario;


     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "patente")
     private Vehiculo vehiculo;


     public Viaje() {
     }




     public Viaje(Integer codigo, TipoViaje tipoViaje, Double precio, LocalDate fechaViaje, Usuario usuario,
            Vehiculo vehiculo) {
        this.codigo = codigo;
        this.tipoViaje = tipoViaje;
        this.precio = precio;
        this.fechaViaje = fechaViaje;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
    }





     public Integer getCodigo() {
         return codigo;
     }


     public void setCodigo(Integer codigo) {
         this.codigo = codigo;
     }


  


     public Double getPrecio() {
         return precio;
     }


     public void setPrecio(Double precio) {
         this.precio = precio;
     }


     public LocalDate getFechaViaje() {
         return fechaViaje;
     }


     public void setFechaViaje(LocalDate fechaViaje) {
         this.fechaViaje = fechaViaje;
     }


     public Usuario getUsuario() {
         return usuario;
     }


     public void setUsuario(Usuario usuario) {
         this.usuario = usuario;
     }


     public Vehiculo getVehiculo() {
         return vehiculo;
     }


     public void setVehiculo(Vehiculo vehiculo) {
         this.vehiculo = vehiculo;
     }




     public TipoViaje getTipoViaje() {
         return tipoViaje;
     }




     public void setTipoViaje(TipoViaje tipoViaje) {
         this.tipoViaje = tipoViaje;
     }

     
    

}
