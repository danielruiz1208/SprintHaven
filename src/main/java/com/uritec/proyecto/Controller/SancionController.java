package com.usalesiana.proy15.controller;

import com.usalesiana.proy15.model.Sancion;
import com.usalesiana.proy15.service.SancionService;
import com.usalesiana.proy15.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// Controlador para la gestión de sanciones
@Controller
@RequestMapping("/sanciones")
public class SancionController {

    private final SancionService sancionService;
    private final UsuarioService usuarioService;

    // Inyección de dependencias
    public SancionController(SancionService sancionService, UsuarioService usuarioService) {
        this.sancionService = sancionService;
        this.usuarioService = usuarioService;
    }

    // Maneja la solicitud GET para listar sanciones
    @GetMapping
    public String listSanciones(HttpSession session, Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Añade datos al modelo
        model.addAttribute("sanciones", sancionService.searchSanciones(keyword));
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "dashboard";
    }

    // Maneja la solicitud POST para agregar una sanción
    @PostMapping("/add")
    public String addSancion(@Valid @ModelAttribute Sancion sancion, BindingResult result, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Valida el formulario
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Errores en el formulario de sanción");
            model.addAttribute("sanciones", sancionService.getAllSanciones());
            model.addAttribute("usuarios", usuarioService.getAllUsuarios());
            return "dashboard";
        }

        // Guarda la sanción
        sancionService.saveSancion(sancion);
        return "redirect:/dashboard#sanciones";
    }

    // Maneja la solicitud GET para editar una sanción
    @GetMapping("/edit/{id}")
    public String editSancion(@PathVariable Integer id, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Añade la sanción al modelo
        Sancion sancion = sancionService.findById(id);
        model.addAttribute("sancion", sancion);
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "dashboard";
    }

    // Maneja la solicitud POST para actualizar una sanción
    @PostMapping("/update")
    public String updateSancion(@Valid @ModelAttribute Sancion sancion, BindingResult result, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Valida el formulario
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Errores en el formulario de sanción");
            model.addAttribute("sanciones", sancionService.getAllSanciones());
            model.addAttribute("usuarios", usuarioService.getAllUsuarios());
            return "dashboard";
        }

        // Actualiza la sanción
        sancionService.saveSancion(sancion);
        return "redirect:/dashboard#sanciones";
    }

    // Maneja la solicitud GET para eliminar una sanción
    @GetMapping("/delete/{id}")
    public String deleteSancion(@PathVariable Integer id, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Elimina la sanción
        sancionService.deleteSancion(id);
        return "redirect:/dashboard#sanciones";
    }
}
