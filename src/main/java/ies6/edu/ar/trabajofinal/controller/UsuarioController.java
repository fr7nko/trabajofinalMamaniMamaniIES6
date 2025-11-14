package ies6.edu.ar.trabajofinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ies6.edu.ar.trabajofinal.model.Usuario;
import ies6.edu.ar.trabajofinal.service.UsuarioServiceI;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class UsuarioController {
    
    //atributos
    
    @Qualifier("servicioUsuarioMySQL")
    @Autowired
    UsuarioServiceI usuarioService;

   

    @GetMapping("/usuario")
    public ModelAndView getUsuario(){

        //nuevoUsuario.setNombre("franco");
        //Usuario nuevoUsuario = new Usuario();
        ModelAndView modelAndView = new ModelAndView("usuario");
        modelAndView.addObject("nuevoUsuario", usuarioService.crearNuevoUsuario());
        modelAndView.addObject("band", false);
         return modelAndView;
    }


    @PostMapping("/guardarUsuario")
    public ModelAndView saveUsuario (@ModelAttribute("nuevoUsuario") Usuario usuarioParaGuardar){
         
        usuarioService.agregarUsuario(usuarioParaGuardar);

        ModelAndView modelAndView = new ModelAndView("listaUsuario");
        modelAndView.addObject("listadoUsuario", usuarioService.listarTodosUsuario());
        return modelAndView;
    }

    
    //eliminar
    @GetMapping("/eliminarUsuario/{dni}")
    public ModelAndView eliminarUsuario(@PathVariable("dni") Integer dni) {
        ModelAndView carritoDeEliminar = new ModelAndView("listaUsuario");
        usuarioService.borraUsuario(dni);
        carritoDeEliminar.addObject("listadoUsuario", usuarioService.listarTodosUsuario());
        return carritoDeEliminar;
    }


      //modificar
    @GetMapping("/modificarUsuario/{dni}")
    public ModelAndView buscarUsuarioParaModificar(@PathVariable("dni") Integer dni) throws Exception {
        ModelAndView carritoParaModificarUsuario = new ModelAndView("usuario");
        carritoParaModificarUsuario.addObject("nuevoUsuario", usuarioService.buscarUnUsuario(dni));
        carritoParaModificarUsuario.addObject("band", true);
        return carritoParaModificarUsuario;
    }

  @PostMapping("/modificarUsuario")
    public ModelAndView modificarUsuario(@ModelAttribute("nuevoUsuario") Usuario usuarioModificado){
        ModelAndView listadoEditado = new ModelAndView("listaUsuario");
        usuarioService.agregarUsuario(usuarioModificado);
        listadoEditado.addObject("listadoUsuario", usuarioService.listarTodosUsuario());
        
        return listadoEditado;
    }




}
