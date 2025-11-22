package ies6.edu.ar.trabajofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.TipoVehiculo;
import ies6.edu.ar.trabajofinal.model.TipoViaje;
import ies6.edu.ar.trabajofinal.model.Viaje;

@Service
public interface ViajeServiceI {

    // declaracion de metodos
    //acciones que se pueden hacer


    public void borraViaje(Integer codigo) throws Exception;
    public Viaje agregarViaje(Viaje viaje);
    public void modificarViaje(Viaje viaje);
    public List<Viaje> listarTodosViajes();
    public Viaje buscarUnViaje(Integer codigo) throws Exception;
    public Viaje crearNuevoViaje();
    public double calcularPrecio(TipoViaje tipoViaje, TipoVehiculo tipoVehiculo);
    //public List<Us> listarTodosUsuariosActivos();
}
