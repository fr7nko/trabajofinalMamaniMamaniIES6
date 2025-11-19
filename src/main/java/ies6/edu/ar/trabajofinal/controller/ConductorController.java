package ies6.edu.ar.trabajofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ies6.edu.ar.trabajofinal.model.Conductor;
import ies6.edu.ar.trabajofinal.model.Usuario;
import ies6.edu.ar.trabajofinal.service.ConductorServiceI;
import ies6.edu.ar.trabajofinal.service.UsuarioServiceI;
import jakarta.validation.Valid;

@Controller
public class ConductorController {
    
    // atributos

    @Qualifier("servicioConductorMySQL")
    @Autowired
    ConductorServiceI conductorService;

    @GetMapping("/conductor")
    public ModelAndView getConductor() {

        // nuevoUsuario.setNombre("franco");
        // Usuario nuevoUsuario = new Usuario();
        ModelAndView modelAndView = new ModelAndView("conductor");
        modelAndView.addObject("nuevoConductor", conductorService.crearNuevoConductor());
        modelAndView.addObject("band", false);
        return modelAndView;
    }

    @PostMapping("/guardarConductor")
    public ModelAndView saveConductor(@Valid @ModelAttribute("nuevoConductor") Conductor conductorParaGuardar,
            BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("conductor");
            modelAndView.addObject("nuevoConductor", conductorParaGuardar);
        } else {
            try {
                conductorService.agregarConductor(conductorParaGuardar);
                modelAndView.setViewName("listaConductor");
                modelAndView.addObject("correcto", "Conductor registrado con exito");
            } catch (Exception e) {
                modelAndView.addObject("errorConductor", "Error al guardar el Usuario: " + e.getMessage());
            }
            modelAndView.addObject("listadoConductor", conductorService.listarTodosConductorActivos());
        }
        return modelAndView;
    }

    // eliminar
    @GetMapping("/eliminarConductor/{dni}")
    public ModelAndView eliminarConductor(@PathVariable("dni") Integer dni) throws Exception {
        ModelAndView carritoDeEliminar = new ModelAndView("listaUsuario");
        conductorService.borraConductor(dni);
        carritoDeEliminar.addObject("listadoConductor", conductorService.listarTodosConductorActivos());
        return carritoDeEliminar;
    }

    // modificar
    @GetMapping("/modificarConductor/{dni}")
    public ModelAndView buscarUsuarioParaModificar(@PathVariable("dni") Integer dni) throws Exception {
        ModelAndView carritoParaModificaConductor = new ModelAndView("usuario");
        carritoParaModificaConductor.addObject("nuevoConductor", conductorService.buscarUnConductor(dni));
        carritoParaModificaConductor.addObject("band", true);
        return carritoParaModificaConductor;
    }

    @PostMapping("/modificarConductor")
    public ModelAndView modificarConductor(@ModelAttribute("nuevoConductor") Conductor conductorModificado) {
        ModelAndView listadoEditado = new ModelAndView("listaConductor");
        conductorService.agregarConductor(conductorModificado);
        listadoEditado.addObject("listadoConductor", conductorService.listarTodosConductorActivos());

        return listadoEditado;
    }

    @GetMapping("/listarConductor")
    public ModelAndView listarConductorActivos() {
        ModelAndView carritoParaMostrarConductor = new ModelAndView("listaConductor");
        carritoParaMostrarConductor.addObject("listadoConductor", conductorService.listarTodosConductorActivos());
        return carritoParaMostrarConductor;
    }
}
