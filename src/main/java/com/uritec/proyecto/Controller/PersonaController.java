package com.usalesiana.proy15.controller;

import com.usalesiana.proy15.model.Persona;
import com.usalesiana.proy15.service.PersonaService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// Controlador para la gestión de personas
@Controller
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService personaService;

    // Inyección de dependencias
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    // Maneja la solicitud GET para listar personas
    @GetMapping
    public String listPersonas(HttpSession session, Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Añade datos al modelo
        model.addAttribute("personas", personaService.searchPersonas(keyword));
        return "dashboard";
    }

    // Maneja la solicitud POST para agregar una persona
    @PostMapping("/add")
    public String addPersona(@Valid @ModelAttribute Persona persona, BindingResult result, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Valida el formulario
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Errores en el formulario de persona");
            model.addAttribute("personas", personaService.getAllPersonas());
            return "dashboard";
        }

        // Guarda la persona
        personaService.savePersona(persona);
        return "redirect:/dashboard#usuarios";
    }

    // Maneja la solicitud GET para editar una persona
    @GetMapping("/edit/{ru}")
    public String editPersona(@PathVariable Integer ru, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Añade la persona al modelo
        Persona persona = personaService.findByRu(ru);
        model.addAttribute("persona", persona);
        return "dashboard";
    }

    // Maneja la solicitud POST para actualizar una persona
    @PostMapping("/update")
    public String updatePersona(@Valid @ModelAttribute Persona persona, BindingResult result, Model model, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Valida el formulario
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Errores en el formulario de persona");
            model.addAttribute("personas", personaService.getAllPersonas());
            return "dashboard";
        }

        // Actualiza la persona
        personaService.savePersona(persona);
        return "redirect:/dashboard#usuarios";
    }

    // Maneja la solicitud GET para eliminar una persona
    @GetMapping("/delete/{ru}")
    public String deletePersona(@PathVariable Integer ru, HttpSession session) {
        // Verifica autenticación
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Elimina la persona
        personaService.deletePersona(ru);
        return "redirect:/dashboard#usuarios";
    }
}
