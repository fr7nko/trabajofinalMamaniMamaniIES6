package ies6.edu.ar.trabajofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Conductor;
import ies6.edu.ar.trabajofinal.model.Usuario;
import ies6.edu.ar.trabajofinal.repository.ConductorRepository;
import ies6.edu.ar.trabajofinal.repository.UsuarioRepository;

@Service
@Qualifier("servicioConductorMySQL")
public class ConductorServiceMySQL implements ConductorServiceI {


    @Autowired
    Conductor nuevoConductor;

    @Autowired
    ConductorRepository conductorRepository; 

    @Override
    public void borraConductor(Integer dni) throws Exception {
        Conductor conductorBorrar = conductorRepository.findById(dni).orElseThrow(()-> new Exception("Conductor no encontrado"));
        conductorBorrar.setEstado(false);
        conductorRepository.save(conductorBorrar);
    }

    @Override
    public void agregarConductor(Conductor conductor) {
        conductor.setEstado(true);
        conductorRepository.save(conductor);
    
    }

    @Override
    public void modificarConductor(Conductor conductor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarConductor'");
    }

    @Override
    public List<Conductor> listarTodosConductor() {
       return (List<Conductor>) conductorRepository.findAll();
    }

    @Override
    public Conductor buscarUnConductor(Integer dni) throws Exception {
       return conductorRepository.findById(dni).orElseThrow(()-> new Exception("COnductor no encontrado"));
    }

    @Override
    public Conductor crearNuevoConductor() {
       return nuevoConductor;
    }

    @Override
    public List<Conductor> listarTodosConductorActivos() {
        return conductorRepository.findByEstado(true);
    }


}
