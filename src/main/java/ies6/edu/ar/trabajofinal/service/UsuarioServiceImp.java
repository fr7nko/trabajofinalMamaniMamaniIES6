package ies6.edu.ar.trabajofinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Usuario;



@Service
@Qualifier("servicioUsuarioArrayList")
public class UsuarioServiceImp implements UsuarioServiceI {

    List<Usuario> listadoUsuarios = new ArrayList<Usuario>();

    @Autowired
    Usuario nuevoUsuario;



    @Override
    public void borraUsuario(Integer dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borraUsuario'");
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
      
        listadoUsuarios.add(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarUsuario'");
    }

    @Override
    public List<Usuario> listarTodosUsuario() {
        
        return listadoUsuarios;
    }

    @Override
    public Usuario buscarUnUsuario(Integer dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnUsuario'");
    }

    @Override
    public Usuario crearNuevoUsuario() {
        
        //Usuario nuevoUsuario = new Usuario();
        return nuevoUsuario;
    }

}
