package com.usalesiana.proy15.model

import jakarta.persistence.*
import jakarta.validation.constraints.*
import java.time.LocalDateTime

@Entity
@Table(name = "USUARIO")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    var idUsuario: Int = 0,

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Column(name = "usuario", nullable = false)
    var usuario: String,

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(name = "contrasena", nullable = false)
    var contrasena: String,

    @NotNull(message = "El rol es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    var rol: RolUsuario = RolUsuario.Estudiante,

    @NotNull(message = "El RU es obligatorio")
    @Min(value = 10000, message = "El RU debe tener 5 dígitos")
    @Max(value = 99999, message = "El RU debe tener 5 dígitos")
    @Column(name = "ru", nullable = false)
    var ru: Int,

    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    var estado: EstadoUsuario = EstadoUsuario.Activo,

    @Column(name = "created_at", updatable = false)
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null
) {
    // Constructor vacío requerido por JPA
    constructor() : this(0, "", "", RolUsuario.Estudiante, 0, EstadoUsuario.Activo, null, null)

    // Enum para el estado del usuario
    enum class EstadoUsuario {
        Activo,
        Inactivo,
        Suspendido
    }

    // Enum para el rol del usuario
    enum class RolUsuario {
        Administrador,
        Docente,
        Estudiante
    }
}