package ies6.edu.ar.trabajofinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ies6.edu.ar.trabajofinal.model.Usuario;


@Repository
public interface UsuarioRepository extends CrudRepository <Usuario, Integer>{


    
}
