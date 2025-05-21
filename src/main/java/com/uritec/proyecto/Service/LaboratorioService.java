package com.usalesiana.proy15.service;

import com.usalesiana.proy15.model.Laboratorio;
import java.util.List;

// Interfaz para el servicio de laboratorios
public interface LaboratorioService {

    // Obtiene todos los laboratorios
    List<Laboratorio> getAllLaboratorios();

    // Busca un laboratorio por ID
    Laboratorio findById(Integer id);

    // Guarda un laboratorio
    void saveLaboratorio(Laboratorio laboratorio);

    // Elimina un laboratorio por ID
    void deleteLaboratorio(Integer id);

    // Busca laboratorios por nombre
    List<Laboratorio> searchLaboratorios(String keyword);
}
