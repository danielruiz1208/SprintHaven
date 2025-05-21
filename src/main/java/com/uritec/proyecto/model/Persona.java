package com.usalesiana.proy15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.time.LocalDate;

// Entidad para la tabla PERSONA
@Data
@Entity
@Table(name = "PERSONA")
public class Persona {

    // Identificador único (RU de 5 dígitos)
    @Id
    @Column(name = "ru")
    @Min(value = 10000, message = "El RU debe tener 5 dígitos")
    @Max(value = 99999, message = "El RU debe tener 5 dígitos")
    private Integer ru;

    // Nombre de la persona
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    // Apellido paterno
    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 100, message = "El apellido paterno no puede exceder 100 caracteres")
    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;

    // Apellido materno
    @NotBlank(message = "El apellido materno es obligatorio")
    @Size(max = 100, message = "El apellido materno no puede exceder 100 caracteres")
    @Column(name = "apellido_materno", nullable = false)
    private String apellidoMaterno;

    // Correo electrónico
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe ser válido")
    @Size(max = 100, message = "El correo no puede exceder 100 caracteres")
    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    // Teléfono
    @Size(max = 15, message = "El teléfono no puede exceder 15 caracteres")
    @Column(name = "telefono")
    private String telefono;

    // Fecha de nacimiento
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    // Fecha de creación
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Fecha de actualización
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
