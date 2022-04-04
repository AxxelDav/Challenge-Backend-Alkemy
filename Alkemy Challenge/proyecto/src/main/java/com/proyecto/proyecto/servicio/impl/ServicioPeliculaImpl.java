package com.proyecto.proyecto.servicio.impl;

import com.proyecto.proyecto.modelo.Pelicula;
import com.proyecto.proyecto.modelo.Personaje;
import com.proyecto.proyecto.repositorio.RepositorioPelicula;
import com.proyecto.proyecto.repositorio.RepositorioPersonaje;
import com.proyecto.proyecto.servicio.ServicioPelicula;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ServicioPeliculaImpl implements ServicioPelicula {

    @Autowired
    private RepositorioPelicula repositorioPelicula;

    @Autowired
    private RepositorioPersonaje repositorioPersonaje;

    @Override
    public Pelicula detallePelicula(Long id) {
        return repositorioPelicula.findById(id).get();
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return repositorioPelicula.save(pelicula);
    }

    @Override
    public Pelicula modificarPelicula(Long idPelicula, Pelicula pelicula) {
        Pelicula peliculaBuscada = repositorioPelicula.getById(idPelicula);
        peliculaBuscada.setImagen(pelicula.getImagen());
        peliculaBuscada.setTitulo(pelicula.getTitulo());
        peliculaBuscada.setFecha_de_creacion(pelicula.getFecha_de_creacion());
        peliculaBuscada.setCalificacion(pelicula.getCalificacion());
        peliculaBuscada.setGenero(pelicula.getGenero());

        return repositorioPelicula.save(peliculaBuscada);
    }

    @Override
    public boolean eliminarPelicula(Long idPelicula) {
        try {
            repositorioPelicula.deleteById(idPelicula);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Pelicula agregarPersonajeaPelicula(Long idPelicula, Long idPersonaje, Personaje personaje) {
        Personaje personaje1 = repositorioPersonaje.findById(idPersonaje).get();
        Pelicula pelicula1 = repositorioPelicula.findById(idPelicula).get();
        pelicula1.getPersonajes().add(personaje1);
        return pelicula1;
    }

    @Override
    public boolean eliminarPersonajeaPelicula(Long idPelicula, Long idPersonaje) {
        try {
                Personaje personaje1 = repositorioPersonaje.findById(idPersonaje).get();
                Pelicula pelicula1 = repositorioPelicula.findById(idPelicula).get();
                pelicula1.getPersonajes().remove(personaje1);
                return  true;

        } catch (Exception e) {
            return false;
        }
    }


    // PUNTO 8)

    //Correspondiente al ejercicio 8) se intenta validar cada parametro ingresado (si es o no NULL) y segun corresponda se ejecuta algun metodo, o @Query en Repositorio de Pelicula.
    //El metodo no funciona, por falta de tiempo no pude corregirlo.

//    @Override
//    public List<PeliculaDTO> busquedaDePelicula(String name, Long idGenero, String order) {
//        if(name!=null && idGenero == null && (order == "ASC " | order == "DESC")){
//            List<PeliculaDTO> peliculaDTO = new ArrayList<PeliculaDTO>();
//            peliculaDTO.add(new PeliculaDTO(repositorioPelicula.findByTituloEquals(name)));
//            return peliculaDTO;
//        }
//
//        if(order == "ASC") {
//            if (idGenero == null && name==null) {
//                return repositorioPelicula.devuelveTodosAsc().stream().map(PeliculaDTO::new).collect(Collectors.toList());
//
//            } else if (idGenero != null){
//                return repositorioPelicula.devuelveGeneroAsc(idGenero).stream().map(PeliculaDTO::new).collect(Collectors.toList());
//            }
//        }
//        if(order == "DESC") {
//            if (idGenero == null && name==null) {
//                return repositorioPelicula.devuelveTodosDesc().stream().map(PeliculaDTO::new).collect(Collectors.toList());
//
//            } else if (idGenero != null){
//                return repositorioPelicula.devuelveGeneroDesc(idGenero).stream().map(PeliculaDTO::new).collect(Collectors.toList());
//            }
//        }
//            return repositorioPelicula.devuelveTodosAsc().stream().map(PeliculaDTO::new).collect(Collectors.toList());
//        }

}




