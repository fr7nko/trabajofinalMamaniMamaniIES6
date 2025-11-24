package ies6.edu.ar.trabajofinal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ies6.edu.ar.trabajofinal.model.Usuario;
import ies6.edu.ar.trabajofinal.service.UsuarioServiceI;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    // atributos

    @Qualifier("servicioUsuarioMySQL")
    @Autowired
    UsuarioServiceI usuarioService;

    @GetMapping("/usuario")
    public ModelAndView getUsuario() {

        // nuevoUsuario.setNombre("franco");
        // Usuario nuevoUsuario = new Usuario();

        //carrito para el nuevo usuario -- constructor (vista del usuario)
        ModelAndView modelAndView = new ModelAndView("usuario");
        // al carrito añade un obejo vacio, nombre que recibe la vista en el formulario, metodo creado en service
        modelAndView.addObject("nuevoUsuario", usuarioService.crearNuevoUsuario());
        //crea una bandera para crear o modificar
        modelAndView.addObject("band", false);
        //devuelve el carrito
        return modelAndView;
    }

    @PostMapping("/guardarUsuario")
    //recibe al usuario desde la vista <--  @modelAttribut y lo valida @valid, es de tipo usuario y un nombre
    public ModelAndView saveUsuario(@Valid @ModelAttribute("nuevoUsuario") Usuario usuarioParaGuardar,
            BindingResult result) {
                //crea un objeto (carrito) sin vista agregada
        ModelAndView modelAndView = new ModelAndView();
        //if si hay errores en el formulario
        if (result.hasErrors()) {
            //se ve el formulario con los datos agregados
            modelAndView.setViewName("usuario");
            modelAndView.addObject("nuevoUsuario", usuarioParaGuardar);
        } else {
            try {
                //guarda el usuario si no hay errores
                usuarioService.agregarUsuario(usuarioParaGuardar);
                //vista dnd se mostrara 
                modelAndView.setViewName("listaUsuario");
                //mjs de guardado
                modelAndView.addObject("correcto", "Usuario registrado con exito");
            } catch (Exception e) {
                modelAndView.addObject("errorUsuario", "Error al guardar el Usuario: " + e.getMessage());
            }
            //añade a la lista actualizado de los usuarios activos (true, false)
            modelAndView.addObject("listadoUsuario", usuarioService.listarTodosUsuariosActivos());
        }
        return modelAndView;
    }

    // eliminar
    @GetMapping("/eliminarUsuario/{dni}")
    //path obtiene valores q viene d la url (dni)
    public ModelAndView eliminarUsuario(@PathVariable("dni") Integer dni) throws Exception {
        //creacion del carrito para la vista
        ModelAndView carritoDeEliminar = new ModelAndView("listaUsuario");
        //llama al servicio para el borrado
        usuarioService.borraUsuario(dni);
        //añade la lista actualizada
        carritoDeEliminar.addObject("listadoUsuario", usuarioService.listarTodosUsuariosActivos());
        return carritoDeEliminar;
    }

    // modificar
    @GetMapping("/modificarUsuario/{dni}")
    //path obtiene valores desde la url (dni)
    public ModelAndView buscarUsuarioParaModificar(@PathVariable("dni") Integer dni) throws Exception {
        //carrito para la vista
        ModelAndView carritoParaModificarUsuario = new ModelAndView("usuario");
        //añade al carrito el usuario x el dni
        carritoParaModificarUsuario.addObject("nuevoUsuario", usuarioService.buscarUnUsuario(dni));
        //cambia la bandera a true
        carritoParaModificarUsuario.addObject("band", true);
        return carritoParaModificarUsuario;
    }

    @PostMapping("/modificarUsuario")    
    public ModelAndView modificarUsuario(@ModelAttribute("nuevoUsuario") Usuario usuarioModificado) {
        //crear el carrito para la vista
        ModelAndView listadoEditado = new ModelAndView("listaUsuario");
        //agrea los cambios del usuario
        usuarioService.agregarUsuario(usuarioModificado);
        //añade la lista actualizada de los usuarios
        listadoEditado.addObject("listadoUsuario", usuarioService.listarTodosUsuariosActivos());

        return listadoEditado;
    }

    @GetMapping("/listarUsuario")
    public ModelAndView listarUsuariosActivos() {
        //crea el carrito para la vista
        ModelAndView carritoParaMostrarUsuarios = new ModelAndView("listaUsuario");
        //añade la lista de los usuarios activos
        carritoParaMostrarUsuarios.addObject("listadoUsuario", usuarioService.listarTodosUsuariosActivos());
        return carritoParaMostrarUsuarios;
    }

}
