package com.usalesiana.proy15.service;

import com.usalesiana.proy15.model.Usuario;

import java.util.List;

// Interfaz para el servicio de usuarios
public interface UsuarioService {

    // Autentica un usuario
    boolean authenticate(String username, String password);

    // Busca un usuario por nombre de usuario
    Usuario findByUsername(String username);

    // Registra un nuevo usuario
    void registerUser(String username, String password, String email, Integer ru, String rol);

    // Obtiene todos los usuarios
    List<Usuario> getAllUsuarios();
}
