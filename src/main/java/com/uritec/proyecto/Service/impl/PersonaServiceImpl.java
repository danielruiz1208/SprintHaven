package com.usalesiana.proy15.service.impl;

import com.usalesiana.proy15.model.Persona;
import com.usalesiana.proy15.repository.PersonaRepository;
import com.usalesiana.proy15.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementación del servicio de personas
@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    // Inyección de dependencias
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    // Obtiene todas las personas
    @Override
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    // Busca una persona por RU
    @Override
    public Persona findByRu(Integer ru) {
        return personaRepository.findById(ru).orElse(null);
    }

    // Guarda una persona
    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    // Elimina una persona por RU
    @Override
    public void deletePersona(Integer ru) {
        personaRepository.deleteById(ru);
    }

    // Busca personas por nombre o apellido
    @Override
    public List<Persona> searchPersonas(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllPersonas();
        }
        return personaRepository.findByNombreContainingIgnoreCaseOrApellidoPaternoContainingIgnoreCaseOrApellidoMaternoContainingIgnoreCase(
                keyword, keyword, keyword);
    }
}
