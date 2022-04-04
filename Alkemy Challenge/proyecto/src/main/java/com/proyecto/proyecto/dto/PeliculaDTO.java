package com.proyecto.proyecto.dto;

import com.proyecto.proyecto.modelo.Pelicula;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDTO {

    private Long id;
    private String imagen;
    private String titulo;
    private LocalDateTime fecha_de_creacion;

    public PeliculaDTO(Pelicula pelicula) {
        if(pelicula == null) return;
        id = pelicula.getId();
        imagen = pelicula.getImagen();
        titulo = pelicula.getTitulo();
        fecha_de_creacion = pelicula.getFecha_de_creacion();
    }




}
