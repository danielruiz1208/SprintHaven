package com.usalesiana.proy15.service.impl;

import com.usalesiana.proy15.model.Mantenimiento;
import com.usalesiana.proy15.repository.MantenimientoRepository;
import com.usalesiana.proy15.service.MantenimientoService;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementación del servicio de mantenimientos
@Service
public class MantenimientoServiceImpl implements MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;

    // Inyección de dependencias
    public MantenimientoServiceImpl(MantenimientoRepository mantenimientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
    }

    // Obtiene todos los mantenimientos
    @Override
    public List<Mantenimiento> getAllMantenimientos() {
        return mantenimientoRepository.findAll();
    }

    // Busca un mantenimiento por ID
    @Override
    public Mantenimiento findById(Integer id) {
        return mantenimientoRepository.findById(id).orElse(null);
    }

    // Guarda un mantenimiento
    @Override
    public void saveMantenimiento(Mantenimiento mantenimiento) {
        mantenimientoRepository.save(mantenimiento);
    }

    // Elimina un mantenimiento por ID
    @Override
    public void deleteMantenimiento(Integer id) {
        mantenimientoRepository.deleteById(id);
    }

    // Busca mantenimientos por equipo o problema
    @Override
    public List<Mantenimiento> searchMantenimientos(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllMantenimientos();
        }
        // Nota: Implementar lógica de búsqueda más específica si es necesario
        return mantenimientoRepository.findAll();
    }
}