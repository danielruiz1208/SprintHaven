package com.uritec.proyecto.Service;

import com.uritec.proyecto.Model.Usuario;
import com.uritec.proyecto.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(String usuario, String contrasena) {
        return usuarioRepository.findByUsuarioAndContrasena(usuario, contrasena).orElse(null);
    }
}