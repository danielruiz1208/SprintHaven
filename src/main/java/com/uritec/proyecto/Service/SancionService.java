package com.usalesiana.proy15.service;

import com.usalesiana.proy15.model.Sancion;
import java.util.List;

// Interfaz para el servicio de sanciones
public interface SancionService {

    // Obtiene todas las sanciones
    List<Sancion> getAllSanciones();

    // Busca una sanción por ID
    Sancion findById(Integer id);

    // Guarda una sanción
    void saveSancion(Sancion sancion);

    // Elimina una sanción por ID
    void deleteSancion(Integer id);

    // Busca sanciones por usuario o descripción
    List<Sancion> searchSanciones(String keyword);
}
