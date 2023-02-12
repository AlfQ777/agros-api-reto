package com.agros.reto.backend.springAgros.repository;

import com.agros.reto.backend.springAgros.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Aca va la anotacion Repository para indicar que es un repositorio y pueda ser detectado por el autowired
@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    List<Publicacion> findAllByOrderByTituloAsc();
    public abstract List<Publicacion> findByCategoria(int cat);

}
