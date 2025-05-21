package com.usalesiana.proy15.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Configuración de rutas de vistas estáticas
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Configura la ruta raíz ("/") para redirigir a la página de inicio
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
}