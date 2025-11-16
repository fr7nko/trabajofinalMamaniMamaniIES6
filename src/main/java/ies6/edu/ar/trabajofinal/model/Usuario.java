package ies6.edu.ar.trabajofinal.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Component
@Entity
public class Usuario {
    @Id
    private Integer dni;
    @Column
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    private String nombre;
    @Column
    @NotBlank (message = "apellido es requerido")
    @NotNull (message = "el apellido es requerido")
    @Size (min = 4, max = 10, message = "debe tener mas de 4 letras y menos de 10")
    private String apellido;
    @Column
    private LocalDate fechaNac;
    @Column
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
