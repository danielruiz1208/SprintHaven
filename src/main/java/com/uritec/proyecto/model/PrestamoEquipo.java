package com.usalesiana.proy15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

// Entidad para la tabla PRESTAMO_EQUIPO
@Data
@Entity
@Table(name = "PRESTAMO_EQUIPO")
public class PrestamoEquipo {

    // Identificador único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo_equipo")
    private Integer idPrestamoEquipo;

    // Fecha de solicitud
    @NotNull(message = "La fecha de solicitud es obligatoria")
    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDateTime fechaSolicitud;

    // Fecha de préstamo
    @NotNull(message = "La fecha de préstamo es obligatoria")
    @Column(name = "fecha_prestamo", nullable = false)
    private LocalDateTime fechaPrestamo;

    // Fecha de devolución estimada
    @NotNull(message = "La fecha de devolución estimada es obligatoria")
    @Column(name = "fecha_devolucion_estimada", nullable = false)
    private LocalDateTime fechaDevolucionEstimada;

    // Estado del préstamo
    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoPrestamo estado;

    // Usuario que solicita
    @NotNull(message = "El usuario es obligatorio")
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    // Laboratorio (opcional)
    @Column(name = "id_laboratorio")
    private Integer idLaboratorio;

    // Administrador que aprueba
    @NotNull(message = "El administrador es obligatorio")
    @Column(name = "id_administrador", nullable = false)
    private Integer idAdministrador;

    // Observaciones
    @Size(max = 500, message = "Las observaciones no pueden exceder 500 caracteres")
    @Column(name = "observaciones")
    private String observaciones;

    // Fecha de creación
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Fecha de actualización
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relación con USUARIO (solicitante)
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    // Relación con LABORATORIO
    @ManyToOne
    @JoinColumn(name = "id_laboratorio", referencedColumnName = "id_laboratorio", insertable = false, updatable = false)
    private Laboratorio laboratorio;

    // Relación con USUARIO (administrador)
    @ManyToOne
    @JoinColumn(name = "id_administrador", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Usuario administrador;

    // Detalles del préstamo
    @OneToMany(mappedBy = "prestamoEquipo", cascade = CascadeType.ALL)
    private List<DetallePrestamo> detalles;

    // Enum para el estado del préstamo
    public enum EstadoPrestamo {
        Pendiente,
        Prestado,
        Devuelto,
        Retrasado
    }
}
