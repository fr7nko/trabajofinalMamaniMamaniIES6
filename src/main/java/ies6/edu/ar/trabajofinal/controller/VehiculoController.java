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

import ies6.edu.ar.trabajofinal.model.Vehiculo;
import ies6.edu.ar.trabajofinal.service.VehiculoServiceI;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class VehiculoController {
    
    //atributos
    
    @Qualifier("servicioVehiculoMySQL")
    @Autowired
    VehiculoServiceI vehiculoService;

   

    @GetMapping("/vehiculo")
    public ModelAndView getVehiculo(){

        //nuevoVehiculo.setNombre("matias");
        //Vehiculo nuevoVehiculo = new Vehiculo();
        ModelAndView modelAndView = new ModelAndView("vehiculo");
        modelAndView.addObject("nuevoVehiculo", vehiculoService.crearNuevoVehiculo());
        modelAndView.addObject("band", false);
         return modelAndView;
    }


    @PostMapping("/guardarVehiculo")
    public ModelAndView saveVehiculo (@ModelAttribute("nuevoVehiculo") Vehiculo vehiculoParaGuardar){
         
        vehiculoService.agregarVehiculo(vehiculoParaGuardar);

        ModelAndView modelAndView = new ModelAndView("listaVehiculo");
        modelAndView.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculo());
        return modelAndView;
    }

    
    //eliminar
    @GetMapping("/eliminarVehiculo/{patente}")
    public ModelAndView eliminarVehiculo(@PathVariable("patente") Integer patente) {
        ModelAndView carritoDeEliminar = new ModelAndView("listaVehiculo");
        vehiculoService.borraVehiculo(patente);
        carritoDeEliminar.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculos());
        return carritoDeEliminar;
    }


      //modificar
    @GetMapping("/modificarVehiculo/{patente}")
    public ModelAndView buscarVehiculoParaModificar(@PathVariable("patente") Integer patente) throws Exception {
        ModelAndView carritoParaModificarVehiculo = new ModelAndView("vehiculo");
        carritoParaModificarVehiculo.addObject("nuevoVehiculo", vehiculoService.buscarUnVehiculo(patente));
        carritoParaModificarVehiculo.addObject("band", true);
        return carritoParaModificarVehiculo;
    }

  @PostMapping("/modificarVehiculo")
    public ModelAndView modificarVehiculo(@ModelAttribute("nuevoVehiculo") Vehiculo vehiculoModificado){
        ModelAndView listadoEditado = new ModelAndView("listaVehiculo");
        vehiculoService.agregarVehiculo(vehiculoModificado);
        listadoEditado.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculo());
        
        return listadoEditado;
        
    }




}