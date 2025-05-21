package com.usalesiana.proy15.repository;

import com.usalesiana.proy15.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repositorio para la tabla USUARIO
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Busca usuario por nombre de usuario
    Optional<Usuario> findByUsuario(String usuario);

    // Busca usuario por RU
    Optional<Usuario> findByRu(Integer ru);
}
