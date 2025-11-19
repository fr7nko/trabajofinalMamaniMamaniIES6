package ies6.edu.ar.trabajofinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Usuario;
import ies6.edu.ar.trabajofinal.model.Viaje;
import ies6.edu.ar.trabajofinal.repository.ViajeRepository;

@Service
@Qualifier("servicioViajeMySQL")
public class ViajeServiceImpBD implements ViajeServiceI {

    @Autowired
    Viaje nuevoViaje;

    @Autowired
    ViajeRepository viajeRepository;


    @Override
    public void borraViaje(Integer codigo) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borraViaje'");
    }

    @Override
    public Viaje agregarViaje(Viaje viaje) {
       return viajeRepository.save(viaje);
    }

    @Override
    public void modificarViaje(Viaje viaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarViaje'");
    }

    @Override
    public List<Viaje> listarTodosViajes() {
        return viajeRepository.findAll();
        // List<Viaje> lista = new ArrayList<>();
        // viajeRepository.findAll().forEach(lista::add);
        // return lista;
    }

    @Override
    public Viaje buscarUnViaje(Integer codigo) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnViaje'");
    }

    @Override
    public Viaje crearNuevoViaje() {
       return nuevoViaje;
    }

  
    
}
