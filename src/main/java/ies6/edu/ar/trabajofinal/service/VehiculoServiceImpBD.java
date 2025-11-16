package ies6.edu.ar.trabajofinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Vehiculo;

@Service("servicioVehiculoMySQL")
public class VehiculoServiceImpBD implements VehiculoServiceI {

    private List<Vehiculo> lista = new ArrayList<>();

    @Override
    public void borraVehiculo(Integer patente) {
        lista.removeIf(v -> v.getPatente().equals(patente));
    }

    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        lista.add(vehiculo);
    }

    @Override
    public void modificarVehiculo(Vehiculo vehiculo) {
        borraVehiculo(vehiculo.getPatente());
        agregarVehiculo(vehiculo);
    }

    @Override
    public List<Vehiculo> listarTodosVehiculo() {
        return lista;
    }

    @Override
    public Vehiculo buscarUnVehiculo(Integer patente) {
        return lista.stream()
                    .filter(v -> v.getPatente().equals(patente))
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public Vehiculo crearNuevoVehiculo() {
        return new Vehiculo();
    }

    @Override
    public List<Vehiculo> listarTodosVehiculosActivos() {
        return lista;
    }
}
