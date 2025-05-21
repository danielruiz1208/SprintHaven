package com.usalesiana.proy15.service;

import com.usalesiana.proy15.model.DetallePrestamo;
import java.util.List;

// Interfaz para el servicio de detalles de préstamos
public interface DetallePrestamoService {

    // Obtiene todos los detalles de un préstamo
    List<DetallePrestamo> getDetallesByPrestamoId(Integer prestamoId);

    // Guarda un detalle de préstamo
    void saveDetallePrestamo(DetallePrestamo detalle);

    // Elimina un detalle de préstamo por ID
    void deleteDetallePrestamo(Integer id);
}
