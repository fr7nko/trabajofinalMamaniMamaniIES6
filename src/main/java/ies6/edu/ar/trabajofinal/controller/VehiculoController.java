package ies6.edu.ar.trabajofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ies6.edu.ar.trabajofinal.model.Vehiculo;
import ies6.edu.ar.trabajofinal.service.ConductorServiceI;
import ies6.edu.ar.trabajofinal.service.VehiculoServiceI;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class VehiculoController {
    


    //NUEVO 
    @Qualifier("servicioConductorMySQL")
    @Autowired
    ConductorServiceI conductorService;

    //atributos
    
    @Qualifier("servicioVehiculoMySQL")
    @Autowired
    VehiculoServiceI vehiculoService;

   

    @GetMapping("/vehiculo")
    public ModelAndView getVehiculo(){

        //nuevoVehiculo.setNombre("matias");
        //Vehiculo nuevoVehiculo = new Vehiculo();

        //carrito de la vista
        ModelAndView modelAndView = new ModelAndView("vehiculo");
        //agrega el vehiculo vacio al formulario
        modelAndView.addObject("nuevoVehiculo", vehiculoService.crearNuevoVehiculo());
        //bandera q indaca q no es modificado
        modelAndView.addObject("band", false);
        //lista de los conductores activos
        modelAndView.addObject("listaConductores", conductorService.listarTodosConductorActivos());
         return modelAndView;
    }   


    @PostMapping("/guardarVehiculo")
    public ModelAndView saveVehiculo(@Valid @ModelAttribute("nuevoVehiculo") Vehiculo vehiculoParaGuardar,
            BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();
        //si hay errores 
        if (result.hasErrors()) {
            modelAndView.setViewName("vehiculo");
            modelAndView.addObject("nuevoVehiculo", vehiculoParaGuardar);
            //se envia la lista de los conductores
            modelAndView.addObject("listaConductores", conductorService.listarTodosConductorActivos());
        } else {
            try {
                //guarda el vehiculo
                vehiculoService.agregarVehiculo(vehiculoParaGuardar);
                //va a la lista de vehiculo
                modelAndView.setViewName("listaVehiculo");
                //mensaje si no hay problema
                modelAndView.addObject("correcto", "Vehiculo registrado con exito");
            } catch (Exception e) {
                //mensaje de error
                modelAndView.addObject("errorVehiculo", "Error al guardar el Vehiculo: " + e.getMessage());
            }
            //lista de los vehiculos actualizados
            modelAndView.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
        }
        return modelAndView;
    }
    
    //eliminar
    @GetMapping("/eliminarVehiculo/{patente}")
    public ModelAndView eliminarVehiculo(@PathVariable("patente") Integer patente) throws Exception {
       //carrito de la lista
        ModelAndView carritoDeEliminar = new ModelAndView("listaVehiculo");
       //llmado al service del metodo borrar (logico)
        vehiculoService.borraVehiculo(patente);
        //lista actualizada de los vehiculos
        carritoDeEliminar.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
        return carritoDeEliminar;
    }


      //modificar
    @GetMapping("/modificarVehiculo/{patente}")
    public ModelAndView buscarVehiculoParaModificar(@PathVariable("patente") Integer patente) throws Exception {
        ModelAndView carritoParaModificarVehiculo = new ModelAndView("vehiculo");
        carritoParaModificarVehiculo.addObject("nuevoVehiculo", vehiculoService.buscarUnVehiculo(patente));
        carritoParaModificarVehiculo.addObject("band", true);
        //NUEVO
        carritoParaModificarVehiculo.addObject("listaConductores", conductorService.listarTodosConductorActivos());
        return carritoParaModificarVehiculo;
    }

  @PostMapping("/modificarVehiculo")
    public ModelAndView modificarVehiculo(@ModelAttribute("nuevoVehiculo") Vehiculo vehiculoModificado){
        ModelAndView listadoEditado = new ModelAndView("listaVehiculo");
        vehiculoService.agregarVehiculo(vehiculoModificado);
        listadoEditado.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
        
        return listadoEditado;
        
    }

    // @GetMapping("/listarVehiculos")
    // public ModelAndView listarVehiculosActivos() {
    //     ModelAndView carritoParaMostrarVehiculos = new ModelAndView("listaVehiculos");
    //     carritoParaMostrarVehiculos.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
    //     return carritoParaMostrarVehiculos;
    // }

        //lista de vehiculos con botones para borrar y modificar
    @GetMapping("/listarVehiculo")
        public ModelAndView listarVehiculoActivos() {
            ModelAndView carritoParaMostrarVehiculo = new ModelAndView("listaVehiculo");
            carritoParaMostrarVehiculo.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
            return carritoParaMostrarVehiculo;
        }



}
