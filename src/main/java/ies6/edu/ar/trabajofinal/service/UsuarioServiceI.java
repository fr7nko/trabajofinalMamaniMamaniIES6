package ies6.edu.ar.trabajofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Usuario;

@Service
public interface UsuarioServiceI {
    // declaracion de metodos
    //acciones que se pueden hacer


    public void borraUsuario(Integer dni);
    public void agregarUsuario(Usuario usuario);
    public void modificarUsuario(Usuario usuario);
    public List<Usuario> listarTodosUsuario();
    public Usuario buscarUnUsuario(Integer dni) throws Exception;
    public Usuario crearNuevoUsuario();


}


