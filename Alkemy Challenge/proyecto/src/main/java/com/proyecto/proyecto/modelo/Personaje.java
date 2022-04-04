package com.proyecto.proyecto.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="personaje")
@AllArgsConstructor
@NoArgsConstructor
public class Personaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "personaje_id")
    private Long id;
    @Column(name= "imagen")
    private String imagen;
    @Column(name= "nombre")
    private String nombre;
    @Column(name= "edad")
    private Integer edad;
    @Column(name= "peso")
    private float peso;
    @Column(name= "historia")
    private String historia;
    @ManyToMany(mappedBy = "personajes")
    private List<Pelicula> peliculas;


}
