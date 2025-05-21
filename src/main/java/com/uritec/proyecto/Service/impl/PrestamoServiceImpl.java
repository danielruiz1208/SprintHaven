package com.usalesiana.proy15.service.impl;

import com.usalesiana.proy15.model.PrestamoEquipo;
import com.usalesiana.proy15.repository.PrestamoEquipoRepository;
import com.usalesiana.proy15.service.PrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementación del servicio de préstamos
@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoEquipoRepository prestamoEquipoRepository;

    // Inyección de dependencias
    public PrestamoServiceImpl(PrestamoEquipoRepository prestamoEquipoRepository) {
        this.prestamoEquipoRepository = prestamoEquipoRepository;
    }

    // Obtiene todos los préstamos
    @Override
    public List<PrestamoEquipo> getAllPrestamos() {
        return prestamoEquipoRepository.findAll();
    }

    // Busca un préstamo por ID
    @Override
    public PrestamoEquipo findById(Integer id) {
        return prestamoEquipoRepository.findById(id).orElse(null);
    }

    // Guarda un préstamo
    @Override
    public void savePrestamo(PrestamoEquipo prestamo) {
        prestamoEquipoRepository.save(prestamo);
    }

    // Elimina un préstamo por ID
    @Override
    public void deletePrestamo(Integer id) {
        prestamoEquipoRepository.deleteById(id);
    }

    // Busca préstamos por usuario o equipo
    @Override
    public List<PrestamoEquipo> searchPrestamos(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllPrestamos();
        }
        // Nota: Implementar lógica de búsqueda más específica si es necesario
        return prestamoEquipoRepository.findAll();
    }
}
