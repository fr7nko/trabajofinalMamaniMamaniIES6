package ies6.edu.ar.trabajofinal.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;


@Component
public class Usuario {
    private Integer dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private Boolean estado;
    



    //constructo por defecto
    public Usuario() {
    }



    //Constructor parametrizado
    public Usuario(Integer dni, String nombre, String apellido, LocalDate fechaNac, Boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.estado = estado;
    }



    //Metodos accesores
    public Integer getDni() {
        return dni;
    }
    public void setDni(Integer dni) {
        this.dni = dni;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public LocalDate getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }



    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    
    
}
