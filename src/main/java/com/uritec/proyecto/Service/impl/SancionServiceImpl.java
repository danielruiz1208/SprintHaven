package com.usalesiana.proy15.service.impl;

import com.usalesiana.proy15.model.Sancion;
import com.usalesiana.proy15.repository.SancionRepository;
import com.usalesiana.proy15.service.SancionService;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementación del servicio de sanciones
@Service
public class SancionServiceImpl implements SancionService {

    private final SancionRepository sancionRepository;

    // Inyección de dependencias
    public SancionServiceImpl(SancionRepository sancionRepository) {
        this.sancionRepository = sancionRepository;
    }

    // Obtiene todas las sanciones
    @Override
    public List<Sancion> getAllSanciones() {
        return sancionRepository.findAll();
    }

    // Busca una sanción por ID
    @Override
    public Sancion findById(Integer id) {
        return sancionRepository.findById(id).orElse(null);
    }

    // Guarda una sanción
    @Override
    public void saveSancion(Sancion sancion) {
        sancionRepository.save(sancion);
    }

    // Elimina una sanción por ID
    @Override
    public void deleteSancion(Integer id) {
        sancionRepository.deleteById(id);
    }

    // Busca sanciones por usuario o descripción
    @Override
    public List<Sancion> searchSanciones(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllSanciones();
        }
        // Nota: Implementar lógica de búsqueda más específica si es necesario
        return sancionRepository.findAll();
    }
}
