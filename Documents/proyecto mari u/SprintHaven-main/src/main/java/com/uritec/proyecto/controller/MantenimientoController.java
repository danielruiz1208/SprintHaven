package com.usalesiana.proy15.controller;

import com.usalesiana.proy15.model.Mantenimiento;
import com.usalesiana.proy15.service.EquipoService;
import com.usalesiana.proy15.service.MantenimientoService;
import com.usalesiana.proy15.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// Controlador para la gestión de mantenimientos
@Controller
@RequestMapping("/mantenimientos")
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;
    private final EquipoService equipoService;
    private final UsuarioService usuarioService;

    // Inyección de dependencias
    public MantenimientoController(MantenimientoService mantenimientoService, EquipoService equipoService, UsuarioService usuarioService) {
        this.mantenimientoService = mantenimientoService;
        this.equipoService = equipoService;
        this.usuarioService = usuarioService;
    }

    // Maneja la solicitud GET para listar mantenimientos
    @GetMapping
    public String listMantenimientos(HttpSession session, Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Añade datos al modelo
        model.addAttribute("mantenimientos", mantenimientoService.searchMantenimientos(keyword));
        model.addAttribute("equipos", equipoService.getAllEquipos());
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "dashboard";
    }

    // Maneja la solicitud POST para agregar un mantenimiento
    @PostMapping("/add")
    public String addMantenimiento(@Valid @ModelAttribute Mantenimiento mantenimiento, BindingResult result, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Valida el formulario
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Errores en el formulario de mantenimiento");
            model.addAttribute("mantenimientos", mantenimientoService.getAllMantenimientos());
            model.addAttribute("equipos", equipoService.getAllEquipos());
            model.addAttribute("usuarios", usuarioService.getAllUsuarios());
            return "dashboard";
        }

        // Guarda el mantenimiento
        mantenimientoService.saveMantenimiento(mantenimiento);
        return "redirect:/dashboard#mantenimiento";
    }

    // Maneja la solicitud GET para editar un mantenimiento
    @GetMapping("/edit/{id}")
    public String editMantenimiento(@PathVariable Integer id, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Añade el mantenimiento al modelo
        Mantenimiento mantenimiento = mantenimientoService.findById(id);
        model.addAttribute("mantenimiento", mantenimiento);
        model.addAttribute("equipos", equipoService.getAllEquipos());
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "dashboard";
    }

    // Maneja la solicitud POST para actualizar un mantenimiento
    @PostMapping("/update")
    public String updateMantenimiento(@Valid @ModelAttribute Mantenimiento mantenimiento, BindingResult result, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Valida el formulario
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Errores en el formulario de mantenimiento");
            model.addAttribute("mantenimientos", mantenimientoService.getAllMantenimientos());
            model.addAttribute("equipos", equipoService.getAllEquipos());
            model.addAttribute("usuarios", usuarioService.getAllUsuarios());
            return "dashboard";
        }

        // Actualiza el mantenimiento
        mantenimientoService.saveMantenimiento(mantenimiento);
        return "redirect:/dashboard#mantenimiento";
    }

    // Maneja la solicitud GET para eliminar un mantenimiento
    @GetMapping("/delete/{id}")
    public String deleteMantenimiento(@PathVariable Integer id, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Elimina el mantenimiento
        mantenimientoService.deleteMantenimiento(id);
        return "redirect:/dashboard#mantenimiento";
    }
}
