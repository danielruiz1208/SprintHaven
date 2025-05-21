package com.usalesiana.proy15.controller;

import com.usalesiana.proy15.model.Equipo;
import com.usalesiana.proy15.service.EquipoService;
import com.usalesiana.proy15.service.LaboratorioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// Controlador para la gestión de equipos
@Controller
@RequestMapping("/equipos")
public class EquipoController {

    private final EquipoService equipoService;
    private final LaboratorioService laboratorioService;

    // Inyección de dependencias
    public EquipoController(EquipoService equipoService, LaboratorioService laboratorioService) {
        this.equipoService = equipoService;
        this.laboratorioService = laboratorioService;
    }

    // Maneja la solicitud GET para listar equipos
    @GetMapping
    public String listEquipos(HttpSession session, Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Añade datos al modelo
        model.addAttribute("equipos", equipoService.searchEquipos(keyword));
        model.addAttribute("laboratorios", laboratorioService.getAllLaboratorios());
        return "dashboard";
    }

    // Maneja la solicitud POST para agregar un equipo
    @PostMapping("/add")
    public String addEquipo(@Valid @ModelAttribute Equipo equipo, BindingResult result, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Valida el formulario
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Errores en el formulario de equipo");
            model.addAttribute("equipos", equipoService.getAllEquipos());
            model.addAttribute("laboratorios", laboratorioService.getAllLaboratorios());
            return "dashboard";
        }

        // Guarda el equipo
        equipoService.saveEquipo(equipo);
        return "redirect:/dashboard#equipos";
    }

    // Maneja la solicitud GET para editar un equipo
    @GetMapping("/edit/{id}")
    public String editEquipo(@PathVariable Integer id, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Añade el equipo al modelo
        Equipo equipo = equipoService.findById(id);
        model.addAttribute("equipo", equipo);
        model.addAttribute("laboratorios", laboratorioService.getAllLaboratorios());
        return "dashboard";
    }

    // Maneja la solicitud POST para actualizar un equipo
    @PostMapping("/update")
    public String updateEquipo(@Valid @ModelAttribute Equipo equipo, BindingResult result, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Valida el formulario
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Errores en el formulario de equipo");
            model.addAttribute("equipos", equipoService.getAllEquipos());
            model.addAttribute("laboratorios", laboratorioService.getAllLaboratorios());
            return "dashboard";
        }

        // Actualiza el equipo
        equipoService.saveEquipo(equipo);
        return "redirect:/dashboard#equipos";
    }

    // Maneja la solicitud GET para eliminar un equipo
    @GetMapping("/delete/{id}")
    public String deleteEquipo(@PathVariable Integer id, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Elimina el equipo
        equipoService.deleteEquipo(id);
        return "redirect:/dashboard#equipos";
    }
}
