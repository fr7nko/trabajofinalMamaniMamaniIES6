package ies6.edu.ar.trabajofinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ies6.edu.ar.trabajofinal.model.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UsuarioController {
    

    List<Usuario> listadoUsuarios = new ArrayList<Usuario>();
    Usuario nuevoUsuario = new Usuario();

    @GetMapping("/usuario")
    public ModelAndView getUsuario(){

        //nuevoUsuario.setNombre("franco");

        ModelAndView modelAndView = new ModelAndView("usuario");
        modelAndView.addObject("nuevoUsuario", nuevoUsuario);
         return modelAndView;
    }
    




    @PostMapping("/guardarUsuario")
    public ModelAndView saveUsuario (@ModelAttribute("nuevoUsuario") Usuario usuarioParaGuardar){
         

        listadoUsuarios.add(usuarioParaGuardar);

        ModelAndView modelAndView = new ModelAndView("listaUsuario");
        modelAndView.addObject("listadoUsuario", listadoUsuarios);
        return modelAndView;
    }

    
}
