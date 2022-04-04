package com.proyecto.proyecto.repositorio;

//import com.proyecto.proyecto.dto.PersonajeDTO;
import com.proyecto.proyecto.modelo.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPersonaje extends JpaRepository<Personaje, Long> {

    Personaje findByNombreEquals(String name);

    Personaje findByEdadEquals(Integer age);

}
