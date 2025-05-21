package com.usalesiana.proy15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

// Entidad para la tabla ESTUDIANTES
@Data
@Entity
@Table(name = "ESTUDIANTES")
public class Estudiante {

    // Identificador único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    // RU del estudiante, referencia a PERSONA
    @NotNull(message = "El RU es obligatorio")
    @Min(value = 10000, message = "El RU debe tener 5 dígitos")
    @Max(value = 99999, message = "El RU debe tener 5 dígitos")
    @Column(name = "ru", nullable = false, unique = true)
    private Integer ru;

    // Carrera del estudiante
    @NotBlank(message = "La carrera es obligatoria")
    @Size(max = 100, message = "La carrera no puede exceder 100 caracteres")
    @Column(name = "carrera", nullable = false)
    private String carrera;

    // Semestre del estudiante
    @NotBlank(message = "El semestre es obligatorio")
    @Size(max = 20, message = "El semestre no puede exceder 20 caracteres")
    @Column(name = "semestre", nullable = false)
    private String semestre;

    // Materia (opcional)
    @Size(max = 100, message = "La materia no puede exceder 100 caracteres")
    @Column(name = "materia")
    private String materia;

    // Paralelo (opcional)
    @Pattern(regexp = "[A-Z]?", message = "El paralelo debe ser una letra mayúscula")
    @Column(name = "paralelo")
    private String paralelo;

    // Estado del estudiante
    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoEstudiante estado = EstadoEstudiante.Activo;

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

    // Enum para el estado del estudiante
    public enum EstadoEstudiante {
        Activo,
        Inactivo,
        Graduado
    }
}
