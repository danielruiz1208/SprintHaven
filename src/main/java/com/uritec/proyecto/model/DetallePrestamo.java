package com.usalesiana.proy15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

// Entidad para la tabla DETALLE_PRESTAMO
@Data
@Entity
@Table(name = "DETALLE_PRESTAMO")
public class DetallePrestamo {

    // Identificador único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    // Préstamo asociado
    @NotNull(message = "El préstamo es obligatorio")
    @Column(name = "id_prestamo_equipo", nullable = false)
    private Integer idPrestamoEquipo;

    // Equipo asociado
    @NotNull(message = "El equipo es obligatorio")
    @Column(name = "id_equipo", nullable = false)
    private Integer idEquipo;

    // Cantidad de equipos
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    // Fecha de creación
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Relación con PRESTAMO_EQUIPO
    @ManyToOne
    @JoinColumn(name = "id_prestamo_equipo", referencedColumnName = "id_prestamo_equipo", insertable = false, updatable = false)
    private PrestamoEquipo prestamoEquipo;

    // Relación con EQUIPO
    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false)
    private Equipo equipo;
}
