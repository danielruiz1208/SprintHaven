package com.usalesiana.proy15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

// Entidad para la tabla MANTENIMIENTO
@Data
@Entity
@Table(name = "MANTENIMIENTO")
public class Mantenimiento {

    // Identificador único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento")
    private Integer idMantenimiento;

    // Equipo asociado
    @NotNull(message = "El equipo es obligatorio")
    @Column(name = "id_equipo", nullable = false)
    private Integer idEquipo;

    // Administrador que realiza el mantenimiento
    @NotNull(message = "El administrador es obligatorio")
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    // Fecha de inicio
    @NotNull(message = "La fecha de inicio es obligatoria")
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    // Fecha de fin
    @NotNull(message = "La fecha de fin es obligatoria")
    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    // Tipo de mantenimiento
    @NotNull(message = "El tipo de mantenimiento es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_mantenimiento", nullable = false)
    private TipoMantenimiento tipoMantenimiento;

    // Estado inicial del equipo
    @NotNull(message = "El estado inicial es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_inicial", nullable = false)
    private EstadoEquipo estadoInicial;

    // Estado final del equipo
    @NotNull(message = "El estado final es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_final", nullable = false)
    private EstadoEquipo estadoFinal;

    // Problema detectado
    @NotBlank(message = "El problema es obligatorio")
    @Size(max = 200, message = "El problema no puede exceder 200 caracteres")
    @Column(name = "problema", nullable = false)
    private String problema;

    // Solución aplicada
    @NotBlank(message = "La solución es obligatoria")
    @Size(max = 200, message = "La solución no puede exceder 200 caracteres")
    @Column(name = "solucion", nullable = false)
    private String solucion;

    // Estado del mantenimiento
    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoMantenimiento estado;

    // Fecha de creación
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Fecha de actualización
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relación con EQUIPO
    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false)
    private Equipo equipo;

    // Relación con USUARIO
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    // Enum para el tipo de mantenimiento
    public enum TipoMantenimiento {
        Preventivo,
        Correctivo,
        Colectivo
    }

    // Enum para el estado del equipo
    public enum EstadoEquipo {
        Bueno,
        Regular,
        Dañado
    }

    // Enum para el estado del mantenimiento
    public enum EstadoMantenimiento {
        Pendiente,
        Resuelto
    }
}
