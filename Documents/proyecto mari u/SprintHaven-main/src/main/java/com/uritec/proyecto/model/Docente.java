package com.usalesiana.proy15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

// Entidad para la tabla DOCENTES
@Data
@Entity
@Table(name = "DOCENTES")
public class Docente {

    // Identificador único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Integer idDocente;

    // RU del docente, referencia a PERSONA
    @NotNull(message = "El RU es obligatorio")
    @Min(value = 10000, message = "El RU debe tener 5 dígitos")
    @Max(value = 99999, message = "El RU debe tener 5 dígitos")
    @Column(name = "ru", nullable = false, unique = true)
    private Integer ru;

    // Especialidad del docente
    @NotBlank(message = "La especialidad es obligatoria")
    @Size(max = 100, message = "La especialidad no puede exceder 100 caracteres")
    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    // Años de experiencia
    @Min(value = 0, message = "Los años de experiencia no pueden ser negativos")
    @Column(name = "experiencia_anos")
    private Integer experienciaAnos;

    // Estado del docente
    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estado estado = Estado.Activo;

    // Fecha de creación
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Fecha de actualización
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relación con PERSONA
    @ManyToOne
    @JoinColumn(name = "ru", referencedColumnName = "ru", insertable = false, updatable = false)
    private Persona persona;

    // Enum para el estado del docente
    public enum Estado {
        Activo,
        Inactivo
    }
}
