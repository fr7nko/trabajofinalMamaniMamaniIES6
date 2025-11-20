package ies6.edu.ar.trabajofinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Viaje;

@Service
@Qualifier("servicioViajeArrayList")
public class ViajeServiceImp implements ViajeServiceI {

    private List<Viaje> listadoViajes = new ArrayList<>();

    @Autowired
    Viaje nuevoViaje;

    @Override
    public void borraViaje(Integer codigo) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borraViaje'");
    }

    @Override
    public Viaje agregarViaje(Viaje viaje) {
        listadoViajes.add(viaje);
        return viaje;
        }

    @Override
    public void modificarViaje(Viaje viaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarViaje'");
    }

    @Override
    public List<Viaje> listarTodosViajes() {
        return listadoViajes;
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
