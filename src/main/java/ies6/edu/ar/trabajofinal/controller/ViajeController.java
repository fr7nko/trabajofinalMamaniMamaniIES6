package ies6.edu.ar.trabajofinal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import ies6.edu.ar.trabajofinal.model.TipoVehiculo;
import ies6.edu.ar.trabajofinal.model.TipoViaje;
import ies6.edu.ar.trabajofinal.model.Vehiculo;
import ies6.edu.ar.trabajofinal.model.Viaje;
import ies6.edu.ar.trabajofinal.service.UsuarioServiceI;
import ies6.edu.ar.trabajofinal.service.VehiculoServiceI;
import ies6.edu.ar.trabajofinal.service.ViajeServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;



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
        
        //carrito para la vista
      ModelAndView carrito = new ModelAndView("viaje");
      //crea un viaje nuevo
      Viaje viajeNuevo = viajeService.crearNuevoViaje();
      //asiga el vehiculando usando la patente
      viajeNuevo.setVehiculo(vehiculoService.buscarUnVehiculo(patente));
      //agrega al carrito el viaje vacio pero con el vehiculo ya cargado
      carrito.addObject("nuevoViaje", viajeNuevo);
      //lista de los usuarios 
      carrito.addObject("listadoUsuario", usuarioService.listarTodosUsuariosActivos());
        return carrito;
    }


@PostMapping("/guardarViaje")
public ModelAndView saveViaje(@ModelAttribute("nuevoViaje") Viaje viajeParaGuardar) {

    ModelAndView modelAndView = new ModelAndView("ticketViaje");

    try {
        // 1️⃣ Obtener la patente y el dni desde el objeto viaje
        Integer patente = viajeParaGuardar.getVehiculo().getPatente();
        Integer dni = viajeParaGuardar.getUsuario().getDni();

        // 2️⃣ Volver a buscar los objetos completos en la BD
        viajeParaGuardar.setVehiculo(vehiculoService.buscarUnVehiculo(patente));
        viajeParaGuardar.setUsuario(usuarioService.buscarUnUsuario(dni));

        // 3️⃣ Calcular el precio
        TipoViaje tipoViaje = viajeParaGuardar.getTipoViaje();
        TipoVehiculo tipoVehiculo = viajeParaGuardar.getVehiculo().getTipoVehiculo();
        double precioFinal = viajeService.calcularPrecio(tipoViaje, tipoVehiculo);
        viajeParaGuardar.setPrecio(precioFinal);

        // 4️⃣ Guardar el viaje completo
        Viaje viajeGuardado = viajeService.agregarViaje(viajeParaGuardar);

        // 5️⃣ Enviar el viaje guardado a la vista ticket
        modelAndView.addObject("viaje", viajeGuardado);

    } catch (Exception e) {
        modelAndView.setViewName("viaje"); // si hay error, vuelve al formulario
        modelAndView.addObject("errorViaje", "Error al guardar el viaje: " + e.getMessage());
    }

    return modelAndView;
}



// @PostMapping("/guardarViaje")
// public ModelAndView saveViaje(@ModelAttribute("nuevoViaje") Viaje viajeParaGuardar) {

//     ModelAndView modelAndView = new ModelAndView("index");

//     try {
//         // 1️⃣ Obtener la patente y el dni desde el objeto viaje
//         Integer patente = viajeParaGuardar.getVehiculo().getPatente();
//         Integer dni = viajeParaGuardar.getUsuario().getDni();

//         // 2️⃣ Volver a buscar los objetos completos en la BD
//         viajeParaGuardar.setVehiculo(vehiculoService.buscarUnVehiculo(patente));
//         viajeParaGuardar.setUsuario(usuarioService.buscarUnUsuario(dni));

//         // 3️⃣ Calcular el precio
//         TipoViaje tipoViaje = viajeParaGuardar.getTipoViaje();
//         TipoVehiculo tipoVehiculo = viajeParaGuardar.getVehiculo().getTipoVehiculo();
//         double precioFinal = viajeService.calcularPrecio(tipoViaje, tipoVehiculo);
//         viajeParaGuardar.setPrecio(precioFinal);

//         // 4️⃣ Guardar el viaje completo
//         viajeService.agregarViaje(viajeParaGuardar);

//     } catch (Exception e) {
//         modelAndView.addObject("errorViaje", "Error al guardar el viaje: " + e.getMessage());
//     }

//     return modelAndView;
// }


    // @PostMapping("/guardarViaje")
    // public ModelAndView saveViaje (@ModelAttribute("nuevoViaje") Viaje viajeParaGuardar) {
    //     //si todo se guarda redirecciona la index
    //     ModelAndView modelAndView = new ModelAndView("index");
    //     try{
    //         //guara el viaje
    //         viajeService.agregarViaje(viajeParaGuardar);

    //     }catch (Exception e){
    //         //mensaje de error 
    //         modelAndView.addObject("errorViaje", "Error al guardar el viaje: " + e.getMessage());
    //     }
    //     return modelAndView;
    // }

        //vista para listar los viajes
     @GetMapping("/listarViajes")
        public ModelAndView mostrarViajes() {
        ModelAndView carritoParaMostrarViajes = new ModelAndView("listaViajes");
        carritoParaMostrarViajes.addObject("listadoViajes", viajeService.listarTodosViajes());
        return carritoParaMostrarViajes;
}


        //vista de los vehiculo para realizar los viajes
         @GetMapping("/realizarViajes")
        public ModelAndView listarviaje() {
        ModelAndView carritoParaMostrarVehiculos = new ModelAndView("realizarViaje");
        carritoParaMostrarVehiculos.addObject("listadoVehiculo", vehiculoService.listarTodosVehiculosActivos());
        return carritoParaMostrarVehiculos;
    }




    //nuevo
//     @GetMapping("/calcularPrecio/{patente}/{tipoViaje}")
// @ResponseBody
// public Map<String, Object> calcularPrecio(@PathVariable Integer patente,
//                                           @PathVariable String tipoViaje) throws Exception {

//     // Buscar vehículo
//     Vehiculo vehiculo = vehiculoService.buscarUnVehiculo(patente);

//     // Calcular precio
//     double precio = viajeService.calcularPrecio(
//             TipoViaje.valueOf(tipoViaje),
//             vehiculo.getTipoVehiculo()
//     );

//     // Respuesta JSON
//     Map<String, Object> respuesta = new HashMap<>();
//     respuesta.put("precio", precio);

//     return respuesta;
//}


}
  









































        //  ticket
 
       // ViajeController.java

// ... (imports y autowired)

// @PostMapping("/guardarViaje")
// public ModelAndView saveViaje (@ModelAttribute("nuevoViaje") Viaje viajeParaGuardar) {
    
//     try{
//         // 1. Guarda el viaje en la base de datos
//         viajeService.agregarViaje(viajeParaGuardar);

//         // 2. Si se guarda exitosamente, redirige a la vista del ticket
//         ModelAndView modelAndView = new ModelAndView("ticket"); // <--- Nuevo nombre de vista
//         modelAndView.addObject("viajeRegistrado", viajeParaGuardar); // <--- Pasamos el objeto Viaje
//         return modelAndView;

//     }catch (Exception e){
//         // 3. Si hay un error, redirige a la vista de error (o al index con el mensaje)
//         ModelAndView modelAndView = new ModelAndView("index");
//         modelAndView.addObject("errorViaje", "Error al guardar el viaje: " + e.getMessage());
//         return modelAndView;
//     }






