package com.usalesiana.proy15.repository;

import com.usalesiana.proy15.model.DetallePrestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio para la tabla DETALLE_PRESTAMO
public interface DetallePrestamoRepository extends JpaRepository<DetallePrestamo, Integer> {

    // Busca detalles por préstamo
    List<DetallePrestamo> findByIdPrestamoEquipo(Integer idPrestamoEquipo);
}
