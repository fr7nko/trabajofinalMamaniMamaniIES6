package ies6.edu.ar.trabajofinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Usuario;
import ies6.edu.ar.trabajofinal.model.Vehiculo;


@Service
@Qualifier("servicioVehiculoArrayList")
public class VehiculoServiceImp implements VehiculoServiceI {


    List<Vehiculo> listadoVehiculos = new ArrayList<Vehiculo>();

    @Autowired
    Vehiculo nuevoVehiculo;


    @Override
    public void borraVehiculo(Integer patente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borraVehiculo'");
    }

    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
       listadoVehiculos.add(vehiculo);
    }

    @Override
    public void modificarVehiculo(Vehiculo vehiculo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarVehiculo'");
    }

    @Override
    public List<Vehiculo> listarTodosVehiculo() {
        return listadoVehiculos;
    }

    @Override
    public Vehiculo buscarUnVehiculo(Integer patente) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnVehiculo'");
    }

    @Override
    public Vehiculo crearNuevoVehiculo() {
        return nuevoVehiculo;
    }

    @Override
    public List<Vehiculo> listarTodosVehiculosActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodosVehiculosActivos'");
    }


    
}