package com.usalesiana.proy15.model;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

// Entidad para la tabla EQUIPO
@Data
@Entity
@Table(name = "EQUIPO")
public class Equipo {

    // Identificador único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Integer idEquipo;

    // Nombre del equipo
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    // Marca del equipo
    @NotBlank(message = "La marca es obligatoria")
    @Size(max = 100, message = "La marca no puede exceder 100 caracteres")
    @Column(name = "marca", nullable = false)
    private String marca;

    // Modelo del equipo
    @NotBlank(message = "El modelo es obligatorio")
    @Size(max = 100, message = "El modelo no puede exceder 100 caracteres")
    @Column(name = "modelo", nullable = false)
    private String modelo;

    // Número de serie
    @NotBlank(message = "El número de serie es obligatorio")
    @Size(max = 100, message = "El número de serie no puede exceder 100 caracteres")
    @Column(name = "nro_serie", nullable = false, unique = true)
    private String nroSerie;

    // Número de activo fijo
    @NotBlank(message = "El número de activo fijo es obligatorio")
    @Size(max = 100, message = "El número de activo fijo no puede exceder 100 caracteres")
    @Column(name = "nro_activo_fijo", nullable = false, unique = true)
    private String nroActivoFijo;

    // Categoría del equipo
    @NotNull(message = "La categoría es obligatoria")
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false)
    private Categoria categoria;

    // Descripción del equipo
    @Size(max = 200, message = "La descripción no puede exceder 200 caracteres")
    @Column(name = "descripcion")
    private String descripcion;

    // Cantidad de unidades
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    // Estado del equipo
    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoEquipo estado = EstadoEquipo.Disponible;


    // Laboratorio al que pertenece
    @NotNull(message = "El laboratorio es obligatorio")
    @Column(name = "id_laboratorio", nullable = false)
    private Integer idLaboratorio;

    // Fecha de creación
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Fecha de actualización
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relación con LABORATORIO
    @ManyToOne
    @JoinColumn(name = "id_laboratorio", referencedColumnName = "id_laboratorio", insertable = false, updatable = false)
    private Laboratorio laboratorio;

    // Enum para la categoría del equipo
    public enum Categoria {
        Electronica,
        Hardware,
        Redes,
        Telecomunicaciones
    }
    // Enum para el estado del equipo
    public enum EstadoEquipo {
        Disponible,
        En_uso,
        Mantenimiento,
        Dañado
    }



}
