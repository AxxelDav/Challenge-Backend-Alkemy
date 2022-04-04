package com.proyecto.proyecto.controlador;

import com.proyecto.proyecto.modelo.Pelicula;
import com.proyecto.proyecto.modelo.Personaje;
import com.proyecto.proyecto.servicio.ServicioPelicula;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pelicula")
@AllArgsConstructor
public class PeliculaControlador {

   @Autowired
   private ServicioPelicula servicioPelicula;

   //PUNTO 6)
   @GetMapping("/{id}")
   public ResponseEntity<Pelicula> detallePelicula(@PathVariable("id") Long id) {
      return ResponseEntity.ok(servicioPelicula.detallePelicula(id));
   }

   //PUNTO 7)
   @PostMapping
   public ResponseEntity<Pelicula> crearPelicula(@RequestBody Pelicula pelicula) {
      return ResponseEntity.ok(servicioPelicula.crearPelicula(pelicula));
   }

   @PutMapping("/{id}")
   public ResponseEntity<Pelicula> modificarPelicula(@PathVariable("id") Long idPelicula, Pelicula pelicula) {
      return ResponseEntity.ok(servicioPelicula.modificarPelicula(idPelicula, pelicula));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Boolean> eliminarPelicula(@PathVariable("id") Long idPelicula) {
         return ResponseEntity.ok(servicioPelicula.eliminarPelicula(idPelicula));
   }


   //PUNTO 8)
   //Los comentarios de su fincionamiento se encuentra en la Implementacion del servicio de Pelicula.
//   @GetMapping("/movies")
//   public ResponseEntity<?> busquedaDePelicula(@RequestParam(required = false) String name,
//                                               @RequestParam(required = false) Long genre,
//                                               @RequestParam(defaultValue = "ASC", required = false) String order) {
//      return ResponseEntity.ok(servicioPelicula.busquedaDePelicula(name, genre, order));
//   }


   //Punto 9)
   @PostMapping("/movies/{idMovie}/characters/{idCharacter}")
   public ResponseEntity<Pelicula> agregarPersonajeAPelicula(@PathVariable("idMovie") Long idPelicula,
                                                             @PathVariable("idCharacter") Long idPersonaje,
                                                             @RequestBody Personaje personaje) {
      return ResponseEntity.ok(servicioPelicula.agregarPersonajeaPelicula(idPelicula, idPersonaje, personaje));

   }

   @DeleteMapping("/movies/{idMovie}/characters/{idCharacter}")
   public ResponseEntity<Boolean> eliminarPersonajeDePelicula(@PathVariable("idMovie") Long idPelicula, @PathVariable("idCharacter") Long idPersonaje) {
      return ResponseEntity.ok(servicioPelicula.eliminarPersonajeaPelicula(idPelicula, idPersonaje));
   }

}





