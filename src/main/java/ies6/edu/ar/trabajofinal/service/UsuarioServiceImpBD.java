package ies6.edu.ar.trabajofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ies6.edu.ar.trabajofinal.model.Usuario;
import ies6.edu.ar.trabajofinal.repository.UsuarioRepository;

@Service
@Qualifier("servicioUsuarioMySQL")
public class UsuarioServiceImpBD implements UsuarioServiceI {



    @Autowired
    Usuario nuevoUsuario;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void borraUsuario(Integer dni) {
    
        usuarioRepository.deleteById(dni);
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        
        usuarioRepository.save(usuario);
    
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarUsuario'");
    }

    @Override
    public List<Usuario> listarTodosUsuario() {
        return (List<Usuario>) usuarioRepository.findAll();
        
    }

    @Override
    public Usuario buscarUnUsuario(Integer dni) throws Exception {
        return usuarioRepository.findById(dni).orElseThrow(()-> new Exception("Usuario no encontrado"));
    }

    @Override
    public Usuario crearNuevoUsuario() {
       return nuevoUsuario;
    }
    
}
