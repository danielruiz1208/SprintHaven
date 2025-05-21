package com.example.proyectomaria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    private int ru;

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "cedula_identidad")
    private int cedulaIdentidad;

    private String carrera;
    private String paralelo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @Column(nullable = false)
    private String contrasena; // Nuevo campo

    public enum Rol {
        ESTUDIANTE,
        DOCENTE
    }
}