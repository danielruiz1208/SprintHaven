package com.usalesiana.proy15.repository;

import com.usalesiana.proy15.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repositorio para la tabla DOCENTES
public interface DocenteRepository extends JpaRepository<Docente, Integer> {

    // Busca docente por RU
    Optional<Docente> findByRu(Integer ru);
}
