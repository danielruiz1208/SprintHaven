package com.usalesiana.proy15.service.impl;

import com.usalesiana.proy15.model.DetallePrestamo;
import com.usalesiana.proy15.repository.DetallePrestamoRepository;
import com.usalesiana.proy15.service.DetallePrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementación del servicio de detalles de préstamos
@Service
public class DetallePrestamoServiceImpl implements DetallePrestamoService {

    private final DetallePrestamoRepository detallePrestamoRepository;

    // Inyección de dependencias
    public DetallePrestamoServiceImpl(DetallePrestamoRepository detallePrestamoRepository) {
        this.detallePrestamoRepository = detallePrestamoRepository;
    }

    // Obtiene todos los detalles de un préstamo
    @Override
    public List<DetallePrestamo> getDetallesByPrestamoId(Integer prestamoId) {
        return detallePrestamoRepository.findByIdPrestamoEquipo(prestamoId);
    }

    // Guarda un detalle de préstamo
    @Override
    public void saveDetallePrestamo(DetallePrestamo detalle) {
        detallePrestamoRepository.save(detalle);
    }

    // Elimina un detalle de préstamo por ID
    @Override
    public void deleteDetallePrestamo(Integer id) {
        detallePrestamoRepository.deleteById(id);
    }
}
