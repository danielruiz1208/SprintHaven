package com.usalesiana.proy15.service.impl;

import com.usalesiana.proy15.model.Persona;
import com.usalesiana.proy15.model.Usuario;
import com.usalesiana.proy15.repository.PersonaRepository;
import com.usalesiana.proy15.repository.UsuarioRepository;
import com.usalesiana.proy15.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

// Implementación del servicio de usuarios
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;

    // Inyección de dependencias
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }

    // Autentica un usuario
    @Override
    public boolean authenticate(String username, String password) {
        return usuarioRepository.findByUsuario(username)
                .map(usuario -> usuario.getContrasena().equals(password))
                .orElse(false);
    }

    // Busca un usuario por nombre de usuario
    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsuario(username).orElse(null);
    }

    // Registra un nuevo usuario
    @Override
    public void registerUser(String username, String password, String email, Integer ru, String rol) {
        // Verifica si el RU existe en PERSONA
        Persona persona = personaRepository.findById(ru)
                .orElseThrow(() -> new RuntimeException("RU no encontrado"));

        // Verifica si el correo ya está registrado
        if (personaRepository.findByCorreo(email) != null) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // Actualiza el correo en PERSONA
        persona.setCorreo(email);
        personaRepository.save(persona);

        // Crea el usuario
        Usuario usuario = new Usuario();
        usuario.setUsuario(username);
        usuario.setContrasena(password); // Nota: Considerar encriptar la contraseña en producción
        usuario.setRol(Usuario.RolUsuario.valueOf(rol)); // Conversión de String a RolUsuario
        usuario.setRu(ru);
        usuario.setEstado(Usuario.EstadoUsuario.Activo); // Asignación directa del enum
        usuarioRepository.save(usuario);
    }

    // Obtiene todos los usuarios
    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
}