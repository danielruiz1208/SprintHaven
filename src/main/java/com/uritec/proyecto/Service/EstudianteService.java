package com.usalesiana.proy15.service;

import com.usalesiana.proy15.model.Estudiante;

import java.util.List;

// Interfaz para el servicio de estudiantes
public interface EstudianteService {

    // Obtiene todos los estudiantes
    List<Estudiante> getAllEstudiantes();

    // Busca un estudiante por RU
    Estudiante findByRu(Integer ru);

    // Guarda un estudiante
    void saveEstudiante(Estudiante estudiante);

    // Elimina un estudiante por ID
    void deleteEstudiante(Integer id);
}
