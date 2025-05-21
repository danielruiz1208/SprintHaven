package com.usalesiana.proy15.service;

import com.usalesiana.proy15.model.Docente;

import java.util.List;

// Interfaz para el servicio de docentes
public interface DocenteService {

    // Obtiene todos los docentes
    List<Docente> getAllDocentes();

    // Busca un docente por RU
    Docente findByRu(Integer ru);

    // Guarda un docente
    void saveDocente(Docente docente);

    // Elimina un docente por ID
    void deleteDocente(Integer id);
}
