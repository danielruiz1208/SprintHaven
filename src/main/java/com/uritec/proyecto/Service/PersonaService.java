package com.usalesiana.proy15.service;

import com.usalesiana.proy15.model.Persona;

import java.util.List;

// Interfaz para el servicio de personas
public interface PersonaService {

    // Obtiene todas las personas
    List<Persona> getAllPersonas();

    // Busca una persona por RU
    Persona findByRu(Integer ru);

    // Guarda una persona
    void savePersona(Persona persona);

    // Elimina una persona por RU
    void deletePersona(Integer ru);

    // Busca personas por nombre o apellido
    List<Persona> searchPersonas(String keyword);
}
