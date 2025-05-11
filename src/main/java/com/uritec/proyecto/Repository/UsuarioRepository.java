package com.uritec.proyecto.Repository;


import com.uritec.proyecto.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsuarioAndContrasena(String usuario, String contrasena);
}