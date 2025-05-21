package com.usalesiana.proy15.repository;

import com.usalesiana.proy15.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio para la tabla MANTENIMIENTO
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {

    // Busca mantenimientos por equipo
    List<Mantenimiento> findByIdEquipo(Integer idEquipo);
}
