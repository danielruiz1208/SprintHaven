package com.uritec.proyecto.Controller;




import com.uritec.proyecto.Model.Usuario;

import com.uritec.proyecto.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String usuario,
                              @RequestParam String contrasena,
                              Model model) {
        Usuario user = usuarioService.login(usuario, contrasena);
        if (user != null) {
            model.addAttribute("usuario", user);
            return "bienvenido";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
}