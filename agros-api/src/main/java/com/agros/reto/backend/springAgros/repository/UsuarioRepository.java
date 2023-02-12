package com.agros.reto.backend.springAgros.repository;

import com.agros.reto.backend.springAgros.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Aca va la anotacion Repository para indicar que es un repositorio y pueda ser detectado por el autowired
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByOrderByNombreAsc();
    public abstract List<Usuario> findByDni(String dni);
    //public abstract List<Usuario> findByCorreo(String correo);

}
