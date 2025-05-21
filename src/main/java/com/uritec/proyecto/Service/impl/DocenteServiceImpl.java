package com.usalesiana.proy15.service.impl;

import com.usalesiana.proy15.model.Docente;
import com.usalesiana.proy15.repository.DocenteRepository;
import com.usalesiana.proy15.service.DocenteService;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementación del servicio de docentes
@Service
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;

    // Inyección de dependencias
    public DocenteServiceImpl(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    // Obtiene todos los docentes
    @Override
    public List<Docente> getAllDocentes() {
        return docenteRepository.findAll();
    }

    // Busca un docente por RU
    @Override
    public Docente findByRu(Integer ru) {
        return docenteRepository.findByRu(ru).orElse(null);
    }

    // Guarda un docente
    @Override
    public void saveDocente(Docente docente) {
        docenteRepository.save(docente);
    }

    // Elimina un docente por ID
    @Override
    public void deleteDocente(Integer id) {
        docenteRepository.deleteById(id);
    }
}
