package com.usalesiana.proy15.controller;

import com.usalesiana.proy15.model.PrestamoEquipo;
import com.usalesiana.proy15.service.EquipoService;
import com.usalesiana.proy15.service.LaboratorioService;
import com.usalesiana.proy15.service.PrestamoService;
import com.usalesiana.proy15.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// Controlador para la gestión de préstamos
@Controller
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;
    private final EquipoService equipoService;
    private final LaboratorioService laboratorioService;
    private final UsuarioService usuarioService;

    // Inyección de dependencias
    public PrestamoController(PrestamoService prestamoService, EquipoService equipoService,
                              LaboratorioService laboratorioService, UsuarioService usuarioService) {
        this.prestamoService = prestamoService;
        this.equipoService = equipoService;
        this.laboratorioService = laboratorioService;
        this.usuarioService = usuarioService;
    }

    // Maneja la solicitud GET para listar préstamos
    @GetMapping
    public String listPrestamos(HttpSession session, Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Añade datos al modelo
        model.addAttribute("prestamos", prestamoService.searchPrestamos(keyword));
        model.addAttribute("equipos", equipoService.getAllEquipos());
        model.addAttribute("laboratorios", laboratorioService.getAllLaboratorios());
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "dashboard";
    }

    // Maneja la solicitud POST para agregar un préstamo
    @PostMapping("/add")
    public String addPrestamo(@Valid @ModelAttribute PrestamoEquipo prestamo, BindingResult result, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Valida el formulario
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Errores en el formulario de préstamo");
            model.addAttribute("prestamos", prestamoService.getAllPrestamos());
            model.addAttribute("equipos", equipoService.getAllEquipos());
            model.addAttribute("laboratorios", laboratorioService.getAllLaboratorios());
            model.addAttribute("usuarios", usuarioService.getAllUsuarios());
            return "dashboard";
        }

        // Guarda el préstamo
        prestamoService.savePrestamo(prestamo);
        return "redirect:/dashboard#prestamos";
    }

    // Maneja la solicitud GET para editar un préstamo
    @GetMapping("/edit/{id}")
    public String editPrestamo(@PathVariable Integer id, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Añade el préstamo al modelo
        PrestamoEquipo prestamo = prestamoService.findById(id);
        model.addAttribute("prestamo", prestamo);
        model.addAttribute("equipos", equipoService.getAllEquipos());
        model.addAttribute("laboratorios", laboratorioService.getAllLaboratorios());
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "dashboard";
    }

    // Maneja la solicitud POST para actualizar un préstamo
    @PostMapping("/update")
    public String updatePrestamo(@Valid @ModelAttribute PrestamoEquipo prestamo, BindingResult result, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Valida el formulario
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Errores en el formulario de préstamo");
            model.addAttribute("prestamos", prestamoService.getAllPrestamos());
            model.addAttribute("equipos", equipoService.getAllEquipos());
            model.addAttribute("laboratorios", laboratorioService.getAllLaboratorios());
            model.addAttribute("usuarios", usuarioService.getAllUsuarios());
            return "dashboard";
        }

        // Actualiza el préstamo
        prestamoService.savePrestamo(prestamo);
        return "redirect:/dashboard#prestamos";
    }

    // Maneja la solicitud GET para eliminar un préstamo
    @GetMapping("/delete/{id}")
    public String deletePrestamo(@PathVariable Integer id, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Elimina el préstamo
        prestamoService.deletePrestamo(id);
        return "redirect:/dashboard#prestamos";
    }
}
