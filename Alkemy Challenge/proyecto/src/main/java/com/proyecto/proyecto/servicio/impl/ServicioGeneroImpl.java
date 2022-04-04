package com.proyecto.proyecto.servicio.impl;

import com.proyecto.proyecto.modelo.Genero;
import com.proyecto.proyecto.repositorio.RepositorioGenero;
import com.proyecto.proyecto.servicio.ServicioGenero;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServicioGeneroImpl implements ServicioGenero {

    @Autowired
    private RepositorioGenero repositorioGenero;

    @Override
    public Genero creacionGenero(Genero genero) {
        return repositorioGenero.save(genero);
    }
}
