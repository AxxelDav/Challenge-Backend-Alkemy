package com.proyecto.proyecto.modelo;//package com.Challenge_Backend.Challenge_Backend.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "genero")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genero_id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "imagen")
    private String imagen;
    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Pelicula> peliculas;



}
