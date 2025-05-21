package com.usalesiana.proy15.repository;

import com.usalesiana.proy15.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio para la tabla EQUIPO
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    // Busca equipos por nombre o número de serie
    List<Equipo> findByNombreContainingIgnoreCaseOrNroSerieContainingIgnoreCase(String nombre, String nroSerie);
}
