package ies6.edu.ar.trabajofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Usuario;
import ies6.edu.ar.trabajofinal.model.Vehiculo;
import ies6.edu.ar.trabajofinal.repository.UsuarioRepository;
import ies6.edu.ar.trabajofinal.repository.VehiculoRepository;

@Service
@Qualifier("servicioVehiculoMySQL")
public class VehiculoServiceImpBD implements VehiculoServiceI {


     @Autowired
    Vehiculo nuevoVehiculo;

    @Autowired
    VehiculoRepository vehiculoRepository; 


    @Override
    public void borraVehiculo(Integer patente) throws Exception {
        Vehiculo vehiculoBorrar = vehiculoRepository.findById(patente).orElseThrow(()-> new Exception("Vehiculo no encontrado"));
        vehiculoBorrar.setEstado(false);
        vehiculoRepository.save(vehiculoBorrar);
       // vehiculoRepository.deleteById(patente);
    }

    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculo.setEstado(true);
        vehiculoRepository.save(vehiculo);
    }

    @Override
    public void modificarVehiculo(Vehiculo vehiculo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarVehiculo'");
    }

    @Override
    public List<Vehiculo> listarTodosVehiculo() {
        return(List<Vehiculo>) vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo buscarUnVehiculo(Integer patente) throws Exception {
        return vehiculoRepository.findById(patente).orElseThrow(()-> new Exception("Usuario no encontrado"));
    }

    @Override
    public Vehiculo crearNuevoVehiculo() {
        return nuevoVehiculo;
    }

    @Override
    public List<Vehiculo> listarTodosVehiculosActivos() {
        return vehiculoRepository.findByEstado(true);
    }



    
    
}
