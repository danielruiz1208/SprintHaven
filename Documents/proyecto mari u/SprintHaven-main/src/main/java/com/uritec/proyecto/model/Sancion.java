package com.usalesiana.proy15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

// Entidad para la tabla SANCION
@Data
@Entity
@Table(name = "SANCION")
public class Sancion {

    // Identificador único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sancion")
    private Integer idSancion;

    // Usuario sancionado
    @NotNull(message = "El usuario es obligatorio")
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

    // Estado de la sanción
    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoSancion estado;

    // Descripción de la sanción
    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 200, message = "La descripción no puede exceder 200 caracteres")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    // Fecha de creación
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Fecha de actualización
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relación con USUARIO
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    // Enum para el estado de la sanción
    public enum EstadoSancion {
        Activa,
        Inactiva,
        Cumplida
    }
}
