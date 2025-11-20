package ies6.edu.ar.trabajofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import ies6.edu.ar.trabajofinal.model.Viaje;
import ies6.edu.ar.trabajofinal.service.UsuarioServiceI;
import ies6.edu.ar.trabajofinal.service.VehiculoServiceI;
import ies6.edu.ar.trabajofinal.service.ViajeServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ViajeController {

    @Qualifier("servicioViajeMySQL")
    @Autowired
    ViajeServiceI viajeService;
    
    @Qualifier("servicioVehiculoMySQL")
    @Autowired
    VehiculoServiceI vehiculoService;

    @Qualifier("servicioUsuarioMySQL")
    @Autowired
    UsuarioServiceI usuarioService;



    @GetMapping("/viaje/{patente}")
    public ModelAndView getViaje(@PathVariable("patente") Integer patente) throws Exception{
        
      ModelAndView carrito = new ModelAndView("viaje");
      Viaje viajeNuevo = viajeService.crearNuevoViaje();
      viajeNuevo.setVehiculo(vehiculoService.buscarUnVehiculo(patente));
      carrito.addObject("nuevoViaje", viajeNuevo);
      carrito.addObject("listadoUsuario", usuarioService.listarTodosUsuariosActivos());
        return carrito;
    }

    @PostMapping("/guardarViaje")
    public ModelAndView saveViaje (@ModelAttribute("nuevoViaje") Viaje viajeParaGuardar) {
        ModelAndView modelAndView = new ModelAndView("index");
        try{
            viajeService.agregarViaje(viajeParaGuardar);

        }catch (Exception e){
            modelAndView.addObject("errorViaje", "Error al guardar el viaje: " + e.getMessage());
        }
        return modelAndView;
    }




       //vista para realizar el viaje
    //  @GetMapping("/viajar")
    //     public ModelAndView listarVehiculoActivos() {
    //     ModelAndView carritoParaMostrarVehiculo = new ModelAndView("listaVehiculo");
    //     carritoParaMostrarVehiculo.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
    //     return carritoParaMostrarVehiculo;
    // }

        //vista para listar los viajes
     @GetMapping("/listaViajes")
        public ModelAndView mostrarViajes() {
        ModelAndView carritoParaMostrarViajes = new ModelAndView("listaViajes");
        carritoParaMostrarViajes.addObject("listaViajes", viajeService.listarTodosViajes());
        return carritoParaMostrarViajes;
}


        //vista para realizar los viajes
         @GetMapping("/realizarViajes")
        public ModelAndView listarviaje() {
        ModelAndView carritoParaMostrarVehiculos = new ModelAndView("realizarViaje");
        carritoParaMostrarVehiculos.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
        return carritoParaMostrarVehiculos;
    }
}
    //ticket






