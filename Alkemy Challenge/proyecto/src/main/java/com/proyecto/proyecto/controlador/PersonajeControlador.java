package com.proyecto.proyecto.controlador;

import com.proyecto.proyecto.modelo.Personaje;
import com.proyecto.proyecto.servicio.ServicioPersonaje;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personaje")
@AllArgsConstructor
public class PersonajeControlador {

    @Autowired
    private ServicioPersonaje servicioPersonaje;

    //PUNTO 2)
    @PostMapping
    public ResponseEntity<Personaje> crearPersonaje(@RequestBody Personaje personaje) {
     return new ResponseEntity(servicioPersonaje.crearPersonaje(personaje), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personaje> modificarPersonaje(@PathVariable("id") Long idPersonaje, Personaje personaje) {
        return ResponseEntity.ok(servicioPersonaje.modificarPersonaje(idPersonaje, personaje));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarPersonaje(@PathVariable("id") Long idPersonaje) {
     return ResponseEntity.ok(servicioPersonaje.eliminarPersonaje(idPersonaje));
    }

    //PUNTO 4)
    @GetMapping("/{id}")
    public ResponseEntity<Personaje> detallePersonaje(@PathVariable("id") Long idPersonaje) {
        return ResponseEntity.ok(servicioPersonaje.detallePersonaje(idPersonaje));
    }

    //PUNTO 5)

    @GetMapping("/characters")
    public ResponseEntity<?> buscarNombrePersonaje(@RequestParam(required = false) String name,
                                                   @RequestParam(required = false) Integer age,
                                                   @RequestParam(required = false) Long idMovie) {
        return ResponseEntity.ok(servicioPersonaje.buscardePersonajes(name, age, idMovie));
    }

}




