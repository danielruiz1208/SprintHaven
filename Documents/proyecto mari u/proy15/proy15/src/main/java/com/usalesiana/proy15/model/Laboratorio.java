// Laboratorio.java
package com.usalesiana.proy15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "LABORATORIO")
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratorio")
    private Integer idLaboratorio;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    // Enum anidado para tipo de laboratorio
    public static enum TipoLaboratorio {
        Electronica,
        Hardware,
        Redes,
        Telecomunicaciones
    }

    @NotNull(message = "El tipo es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoLaboratorio tipo;

    @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
    @Column(name = "descripcion")
    private String descripcion;

    @NotBlank(message = "La ubicación es obligatoria")
    @Size(max = 100, message = "La ubicación no puede exceder 100 caracteres")
    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Min(value = 1, message = "La capacidad debe ser al menos 1")
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    // Enum anidado para estado del laboratorio
    public static enum EstadoLaboratorio {
        Activo,
        Inactivo,
        Mantenimiento
    }

    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoLaboratorio estado = EstadoLaboratorio.Activo;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;
}
