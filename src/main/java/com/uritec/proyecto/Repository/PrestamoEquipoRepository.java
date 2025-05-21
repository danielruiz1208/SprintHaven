package com.usalesiana.proy15.repository;

import com.usalesiana.proy15.model.PrestamoEquipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio para la tabla PRESTAMO_EQUIPO
public interface PrestamoEquipoRepository extends JpaRepository<PrestamoEquipo, Integer> {

    // Busca préstamos por usuario
    List<PrestamoEquipo> findByIdUsuario(Integer idUsuario);
}
