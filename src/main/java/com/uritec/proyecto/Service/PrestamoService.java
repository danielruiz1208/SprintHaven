package com.usalesiana.proy15.service;

import com.usalesiana.proy15.model.PrestamoEquipo;
import java.util.List;

// Interfaz para el servicio de préstamos
public interface PrestamoService {

    // Obtiene todos los préstamos
    List<PrestamoEquipo> getAllPrestamos();

    // Busca un préstamo por ID
    PrestamoEquipo findById(Integer id);

    // Guarda un préstamo
    void savePrestamo(PrestamoEquipo prestamo);

    // Elimina un préstamo por ID
    void deletePrestamo(Integer id);

    // Busca préstamos por usuario o equipo
    List<PrestamoEquipo> searchPrestamos(String keyword);
}
