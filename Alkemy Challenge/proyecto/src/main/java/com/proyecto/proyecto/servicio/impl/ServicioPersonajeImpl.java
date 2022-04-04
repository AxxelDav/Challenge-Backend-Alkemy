package com.proyecto.proyecto.servicio.impl;

import com.proyecto.proyecto.dto.PersonajeDTO;
import com.proyecto.proyecto.modelo.Pelicula;
import com.proyecto.proyecto.modelo.Personaje;
import com.proyecto.proyecto.repositorio.RepositorioPelicula;
import com.proyecto.proyecto.repositorio.RepositorioPersonaje;
import com.proyecto.proyecto.servicio.ServicioPersonaje;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServicioPersonajeImpl implements ServicioPersonaje {

    @Autowired
    private RepositorioPersonaje repositorioPersonaje;

    @Autowired
    private RepositorioPelicula repositorioPelicula;


    @Override
    public Personaje crearPersonaje(Personaje personaje) {
        return repositorioPersonaje.save(personaje);
    }


    @Override
    public Personaje modificarPersonaje(Long idPersonaje, Personaje personaje) {
        Personaje personajeBuscado = repositorioPersonaje.getById(idPersonaje);
        personajeBuscado.setImagen(personaje.getImagen());
        personajeBuscado.setNombre(personaje.getNombre());
        personajeBuscado.setEdad(personaje.getEdad());
        personajeBuscado.setPeso(personaje.getPeso());
        personajeBuscado.setHistoria(personaje.getHistoria());

        return repositorioPersonaje.save(personajeBuscado);
    }

    @Override
    public boolean eliminarPersonaje(Long idPersonaje) {
        try {
            repositorioPersonaje.deleteById(idPersonaje);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Personaje detallePersonaje(Long idPersonaje) {
        return repositorioPersonaje.findById(idPersonaje).get();
    }


    @Override
    public List<PersonajeDTO> buscardePersonajes(String name, Integer age, Long idMovie) {
        if(name!=null && age == null && idMovie==null){
            List<PersonajeDTO> personajesDTO = new ArrayList<PersonajeDTO>();
            personajesDTO.add(new PersonajeDTO(repositorioPersonaje.findByNombreEquals(name)));
            return personajesDTO;
        }
        if(name==null && age != null && idMovie==null) {
            List<PersonajeDTO> personajesDTO = new ArrayList<PersonajeDTO>();
            personajesDTO.add(new PersonajeDTO(repositorioPersonaje.findByEdadEquals(age)));
            return personajesDTO;
        }

        if(name==null && age == null && idMovie!=null) {
            Pelicula pelicula = repositorioPelicula.getById(idMovie);
            List<Personaje> personajes = pelicula.getPersonajes();
            List<PersonajeDTO> personajesDTO = new ArrayList<PersonajeDTO>();
            for(Personaje value : personajes) {
                personajesDTO.add(new PersonajeDTO(value));
            }
            return personajesDTO;
        }

        return repositorioPersonaje.findAll().stream().map(PersonajeDTO::new).collect(Collectors.toList());
    }


}











