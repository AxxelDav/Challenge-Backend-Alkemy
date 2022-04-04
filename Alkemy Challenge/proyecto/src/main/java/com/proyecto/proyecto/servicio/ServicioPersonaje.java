package com.proyecto.proyecto.servicio;

import com.proyecto.proyecto.dto.PersonajeDTO;
import com.proyecto.proyecto.modelo.Personaje;

import java.util.List;


public interface ServicioPersonaje {

    Personaje crearPersonaje(Personaje personaje);

    Personaje modificarPersonaje(Long idPersonaje, Personaje personaje);

    boolean eliminarPersonaje(Long idPersonaje);

    Personaje detallePersonaje(Long idPersonaje);

    List<PersonajeDTO> buscardePersonajes(String name, Integer age, Long idMovie);

}

