package com.usalesiana.proy15.service.impl;

import com.usalesiana.proy15.model.Laboratorio;
import com.usalesiana.proy15.repository.LaboratorioRepository;
import com.usalesiana.proy15.service.LaboratorioService;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementación del servicio de laboratorios
@Service
public class LaboratorioServiceImpl implements LaboratorioService {

    private final LaboratorioRepository laboratorioRepository;

    // Inyección de dependencias
    public LaboratorioServiceImpl(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    // Obtiene todos los laboratorios
    @Override
    public List<Laboratorio> getAllLaboratorios() {
        return laboratorioRepository.findAll();
    }

    // Busca un laboratorio por ID
    @Override
    public Laboratorio findById(Integer id) {
        return laboratorioRepository.findById(id).orElse(null);
    }

    // Guarda un laboratorio
    @Override
    public void saveLaboratorio(Laboratorio laboratorio) {
        laboratorioRepository.save(laboratorio);
    }

    // Elimina un laboratorio por ID
    @Override
    public void deleteLaboratorio(Integer id) {
        laboratorioRepository.deleteById(id);
    }

    // Busca laboratorios por nombre
    @Override
    public List<Laboratorio> searchLaboratorios(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllLaboratorios();
        }
        return laboratorioRepository.findByNombreContainingIgnoreCase(keyword);
    }
}
