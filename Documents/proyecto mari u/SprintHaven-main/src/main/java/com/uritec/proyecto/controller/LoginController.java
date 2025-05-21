package com.usalesiana.proy15.controller;

import com.usalesiana.proy15.model.Usuario;
import com.usalesiana.proy15.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

// Controlador para la autenticación y registro de usuarios
@Controller
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class.getName());
    private final UsuarioService usuarioService;

    // Inyección de dependencias
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Maneja la solicitud GET para mostrar la página de login
    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "success", required = false) String success,
                                @RequestParam(value = "error", required = false) String error,
                                Model model) {
        // Muestra mensajes de éxito o error
        if ("true".equals(success)) {
            model.addAttribute("successMessage", "¡Te registraste correctamente! Inicia sesión para continuar.");
        }
        if ("true".equals(error)) {
            model.addAttribute("error", model.getAttribute("error"));
            model.addAttribute("showRegister", true);
        }
        return "login";
    }

    // Maneja la solicitud POST para autenticar al usuario
    @PostMapping("/login")
    public String login(@RequestParam @NotBlank String username,
                        @RequestParam @NotBlank String password,
                        HttpSession session,
                        Model model) {
        // Valida campos vacíos
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            model.addAttribute("error", "Usuario y contraseña son obligatorios");
            return "login";
        }

        // Autentica al usuario
        if (usuarioService.authenticate(username, password)) {
            Usuario usuario = usuarioService.findByUsername(username);
            if (usuario.getEstado().equals("Inactivo")) {
                model.addAttribute("error", "La cuenta está inactiva");
                return "login";
            }
            // Guarda información en la sesión
            session.setAttribute("username", username);
            session.setAttribute("role", usuario.getRol());
            session.setAttribute("ru", usuario.getRu());
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

    // Maneja la solicitud GET para cerrar sesión
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalida la sesión
        session.invalidate();
        return "redirect:/";
    }

    // Maneja la solicitud POST para registrar un nuevo usuario
    @PostMapping("/register")
    public String register(@RequestParam @NotBlank String username,
                           @RequestParam @NotBlank String password,
                           @RequestParam @NotBlank String email,
                           @RequestParam Integer ru,
                           @RequestParam String rol,
                           Model model) {
        logger.info("Iniciando registro de usuario: " + username + ", email: " + email);
        try {
            // Registra el usuario
            usuarioService.registerUser(username, password, email, ru, rol);
            logger.info("Usuario registrado exitosamente: " + username);
            return "redirect:/login?success=true";
        } catch (Exception e) {
            logger.severe("Error al registrar usuario: " + e.getMessage());
            model.addAttribute("error", "Error al registrar el usuario: " + e.getMessage());
            return "redirect:/?error=true";
        }
    }
}