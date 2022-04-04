package com.proyecto.proyecto.servicio;

//import com.proyecto.proyecto.dto.PeliculassDTO;
import com.proyecto.proyecto.dto.PeliculaDTO;
import com.proyecto.proyecto.modelo.Pelicula;
import com.proyecto.proyecto.modelo.Personaje;

import java.util.List;

public interface ServicioPelicula {

    Pelicula detallePelicula(Long id);

    Pelicula crearPelicula(Pelicula pelicula);

    Pelicula modificarPelicula(Long idPelicula, Pelicula pelicula);

    boolean eliminarPelicula(Long idPelicula);

    Pelicula agregarPersonajeaPelicula(Long idPelicula, Long idPersonaje, Personaje personaje);

    boolean eliminarPersonajeaPelicula(Long idPelicula, Long idPersonaje);

}
