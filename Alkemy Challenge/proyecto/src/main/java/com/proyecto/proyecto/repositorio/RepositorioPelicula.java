package com.proyecto.proyecto.repositorio;

import com.proyecto.proyecto.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPelicula extends JpaRepository<Pelicula, Long> {

//    @Query(value = "select movie from Pelicula movie where (movie.titulo = :name) and (movie.genero.id = :idGenero) order by movie.fecha_de_creacion ASC", nativeQuery = true)
//    List<Pelicula> findByParams(@Param("name") String name, @Param("idGenero") Long idGenero, @Param("order") String order);

//    Pelicula findByTituloEquals(String name);
//
//    Pelicula findById_generoEquals(Long idGenero);
//
//    @Query(value ="select p from Pelicula order by p.fecha_de_creacion ASC", nativeQuery = true)
//    List<Pelicula> devuelveTodosAsc();
//
//    @Query(value ="select p from Pelicula order by p.fecha_de_creacion DESC", nativeQuery = true)
//    List<Pelicula> devuelveTodosDesc();
//
//    @Query(value ="select p from Pelicula where p.genero.id = ?1 order by p.fecha_de_creacion ASC", nativeQuery = true)
//    List<Pelicula> devuelveGeneroAsc(Long idGenero);
//
//    @Query(value ="select p from Pelicula where p.genero.id = ?1 order by p.fecha_de_creacion DESC", nativeQuery = true)
//    List<Pelicula> devuelveGeneroDesc(Long idGenero);


}
