package com.proyecto.proyecto.controlador;

import com.proyecto.proyecto.modelo.Genero;
import com.proyecto.proyecto.servicio.ServicioGenero;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genero")
@AllArgsConstructor
public class GeneroControlador {

    @Autowired
    private ServicioGenero servicioGenero;

    //PUNTO 3)
    @PostMapping
    public ResponseEntity<Genero> creacionGenero(@RequestBody Genero genero) {
        return ResponseEntity.ok(servicioGenero.creacionGenero(genero));
    }

}



