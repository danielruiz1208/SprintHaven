package com.usalesiana.proy15.repository;

import com.usalesiana.proy15.model.Sancion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio para la tabla SANCION
public interface SancionRepository extends JpaRepository<Sancion, Integer> {

    // Busca sanciones por usuario
    List<Sancion> findByIdUsuario(Integer idUsuario);
}
