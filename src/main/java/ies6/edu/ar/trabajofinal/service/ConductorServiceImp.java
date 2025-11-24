package ies6.edu.ar.trabajofinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Conductor;
import ies6.edu.ar.trabajofinal.model.Usuario;

@Service
@Qualifier("servicioConductorArrayList")
public class ConductorServiceImp implements ConductorServiceI{

  List<Conductor> listadoConductor = new ArrayList<Conductor>();

    @Autowired
    Conductor nuevoConductor;

    @Override
    public void borraConductor(Integer dni) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borraConductor'");
    }

    @Override
    public void agregarConductor(Conductor conductor) {
         listadoConductor.add(conductor);
    }

    @Override
    public void modificarConductor(Conductor conductor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarConductor'");
    }

    @Override
    public List<Conductor> listarTodosConductor() {
         return listadoConductor;
    }

    @Override
    public Conductor buscarUnConductor(Integer dni) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnConductor'");
    }

    @Override
    public Conductor crearNuevoConductor() {
        return nuevoConductor;
    }

    @Override
    public List<Conductor> listarTodosConductorActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodosConductorActivos'");
    }

    @Override
    public List<Conductor> listarConductoresLibres() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarConductoresLibres'");
    }
    
}
