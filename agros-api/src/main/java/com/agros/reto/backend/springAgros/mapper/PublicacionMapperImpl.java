package com.agros.reto.backend.springAgros.mapper;

import com.agros.reto.backend.springAgros.dto.PublicacionDTO;
import com.agros.reto.backend.springAgros.model.Publicacion;
import org.springframework.stereotype.Component;

@Component
public class PublicacionMapperImpl implements PublicacionMapper {

    /* Utilizamos el Mapper para no acceder directamente a la base.
    Lo implementamos en el PublicacionServiceImpl a traves del @Autowired
     */

    /* Esta funcion recibe como parametro una publicacion
     * y en base a el parametro recibido genera una nueva instancia
     * de publicacion DTO.*/

    @Override
    public PublicacionDTO toDTO(Publicacion entity) {
        if ( entity == null ) {
            return null;
        }

        PublicacionDTO publicacionDTO = new PublicacionDTO();

        publicacionDTO.setId( entity.getId() );
        publicacionDTO.setTitulo( entity.getTitulo() );
        publicacionDTO.setDescripcion( entity.getDescripcion() );
        publicacionDTO.setAutor( entity.getAutor() );
        publicacionDTO.setCategoria( entity.getCategoria() );

        return publicacionDTO;
    }

    /* Esta funcion recibe como parametro un PublicacionDTO
     * y hacemos un generamos una nueva instancia de Publicacion */
    @Override
    public Publicacion fromDTO(PublicacionDTO entity) {
        if ( entity == null ) {
            return null;
        }

        Publicacion publicacion = new Publicacion();

        publicacion.setId( entity.getId() );
        publicacion.setTitulo( entity.getTitulo() );
        publicacion.setDescripcion( entity.getDescripcion() );
        publicacion.setAutor( entity.getAutor() );
        publicacion.setCategoria( entity.getCategoria() );

        return publicacion;
    }
}

