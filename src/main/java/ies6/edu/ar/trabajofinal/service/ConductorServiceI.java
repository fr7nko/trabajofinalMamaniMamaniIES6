package ies6.edu.ar.trabajofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Conductor;


@Service
public interface ConductorServiceI {
    // declaracion de metodos
    //acciones que se pueden hacer


    public void borraConductor(Integer dni) throws Exception;
    public void agregarConductor(Conductor conductor);
    public void modificarConductor(Conductor conductor);
    public List<Conductor> listarTodosConductor();
    public Conductor buscarUnConductor(Integer dni) throws Exception;
    public Conductor crearNuevoConductor();
    public List<Conductor> listarTodosConductorActivos();


}