package com.usalesiana.proy15.repository;

import com.usalesiana.proy15.model.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio para la tabla LABORATORIO
public interface LaboratorioRepository extends JpaRepository<Laboratorio, Integer> {

    // Busca laboratorios por nombre
    List<Laboratorio> findByNombreContainingIgnoreCase(String nombre);
}