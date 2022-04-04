package com.proyecto.proyecto.modelo;

//import com.proyecto.proyecto.dto.PeliculassDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "pelicula")
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pelicula_id")
    private Long id;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha_de_creacion")
    private LocalDateTime fecha_de_creacion;
    @Column(name = "calificacion")
    private Integer calificacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genero_id", referencedColumnName = "genero_id")
    private Genero genero;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "pelicula_personaje", joinColumns = {@JoinColumn(name = "pelicula_id")}, inverseJoinColumns = {@JoinColumn(name = "personaje_id")})
    private List<Personaje> personajes;

    @PrePersist
    public void prePersist() {
        fecha_de_creacion = LocalDateTime.now();
    }


}
