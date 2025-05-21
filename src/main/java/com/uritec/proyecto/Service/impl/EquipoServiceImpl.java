package com.usalesiana.proy15.service.impl;

import com.usalesiana.proy15.model.Equipo;
import com.usalesiana.proy15.repository.EquipoRepository;
import com.usalesiana.proy15.service.EquipoService;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementación del servicio de equipos
@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    // Inyección de dependencias
    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    // Obtiene todos los equipos
    @Override
    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    // Busca un equipo por ID
    @Override
    public Equipo findById(Integer id) {
        return equipoRepository.findById(id).orElse(null);
    }

    // Guarda un equipo
    @Override
    public void saveEquipo(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    // Elimina un equipo por ID
    @Override
    public void deleteEquipo(Integer id) {
        equipoRepository.deleteById(id);
    }

    // Busca equipos por nombre o número de serie
    @Override
    public List<Equipo> searchEquipos(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllEquipos();
        }
        return equipoRepository.findByNombreContainingIgnoreCaseOrNroSerieContainingIgnoreCase(keyword, keyword);
    }
}
