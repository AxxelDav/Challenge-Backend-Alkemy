package com.proyecto.proyecto.repositorio;

import com.proyecto.proyecto.modelo.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioGenero extends JpaRepository<Genero, Long> {
}
