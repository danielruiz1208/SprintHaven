package com.usalesiana.proy15.repository;

import com.usalesiana.proy15.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio para la tabla PERSONA
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    // Busca personas por nombre o apellido
    List<Persona> findByNombreContainingIgnoreCaseOrApellidoPaternoContainingIgnoreCaseOrApellidoMaternoContainingIgnoreCase(
            String nombre, String apellidoPaterno, String apellidoMaterno);

    // Busca persona por correo
    Persona findByCorreo(String correo);
}
