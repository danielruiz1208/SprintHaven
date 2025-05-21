package com.usalesiana.proy15.repository;

import com.usalesiana.proy15.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repositorio para la tabla ESTUDIANTES
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    // Busca estudiante por RU
    Optional<Estudiante> findByRu(Integer ru);
}
