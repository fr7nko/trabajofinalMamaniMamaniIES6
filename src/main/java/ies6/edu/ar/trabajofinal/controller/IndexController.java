package ies6.edu.ar.trabajofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
     @GetMapping("/")
    public String getUsuario() {
        return "index";
    }
}
