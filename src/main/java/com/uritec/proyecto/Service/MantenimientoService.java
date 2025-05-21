package com.usalesiana.proy15.service;

import com.usalesiana.proy15.model.Mantenimiento;
import java.util.List;

// Interfaz para el servicio de mantenimientos
public interface MantenimientoService {

    // Obtiene todos los mantenimientos
    List<Mantenimiento> getAllMantenimientos();

    // Busca un mantenimiento por ID
    Mantenimiento findById(Integer id);

    // Guarda un mantenimiento
    void saveMantenimiento(Mantenimiento mantenimiento);

    // Elimina un mantenimiento por ID
    void deleteMantenimiento(Integer id);

    // Busca mantenimientos por equipo o problema
    List<Mantenimiento> searchMantenimientos(String keyword);
}
