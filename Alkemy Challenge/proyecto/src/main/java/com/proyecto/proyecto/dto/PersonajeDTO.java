package com.proyecto.proyecto.dto;

import com.proyecto.proyecto.modelo.Personaje;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDTO {

    private Long id;
    private String imagen;
    private String nombre;

    public PersonajeDTO(Personaje personaje) {
        if(personaje == null) return;
        id = personaje.getId();
        imagen = personaje.getImagen();
        nombre = personaje.getNombre();
    }

}
