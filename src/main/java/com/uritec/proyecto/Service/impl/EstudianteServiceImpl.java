package com.usalesiana.proy15.service.impl;

import com.usalesiana.proy15.model.Estudiante;
import com.usalesiana.proy15.repository.EstudianteRepository;
import com.usalesiana.proy15.service.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementación del servicio de estudiantes
@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    // Inyección de dependencias
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    // Obtiene todos los estudiantes
    @Override
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    // Busca un estudiante por RU
    @Override
    public Estudiante findByRu(Integer ru) {
        return estudianteRepository.findByRu(ru).orElse(null);
    }

    // Guarda un estudiante
    @Override
    public void saveEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    // Elimina un estudiante por ID
    @Override
    public void deleteEstudiante(Integer id) {
        estudianteRepository.deleteById(id);
    }
}
