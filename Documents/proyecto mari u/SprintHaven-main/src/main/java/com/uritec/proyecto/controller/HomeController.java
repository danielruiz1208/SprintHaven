package com.usalesiana.proy15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Controlador para la página de inicio
@Controller
public class HomeController {

    // Maneja la solicitud GET para la ruta raíz
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
