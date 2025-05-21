package com.usalesiana.proy15.service;

import com.usalesiana.proy15.model.Equipo;
import java.util.List;

// Interfaz para el servicio de equipos
public interface EquipoService {

    // Obtiene todos los equipos
    List<Equipo> getAllEquipos();

    // Busca un equipo por ID
    Equipo findById(Integer id);

    // Guarda un equipo
    void saveEquipo(Equipo equipo);

    // Elimina un equipo por ID
    void deleteEquipo(Integer id);

    // Busca equipos por nombre o número de serie
    List<Equipo> searchEquipos(String keyword);
}