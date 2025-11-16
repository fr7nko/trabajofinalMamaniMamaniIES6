package ies6.edu.ar.trabajofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Vehiculo;

//@Service
public interface VehiculoServiceI {
    // declaracion de metodos
    //acciones que se pueden hacer


    public void borraVehiculo(Integer patente);
    public void agregarVehiculo(Vehiculo vehiculo);
    public void modificarVehiculo(Vehiculo vehiculo);
    public List<Vehiculo> listarTodosVehiculo();
    public Vehiculo buscarUnVehiculo(Integer patente) throws Exception;
    public Vehiculo crearNuevoVehiculo();
    public List<Vehiculo> listarTodosVehiculosActivos();


}