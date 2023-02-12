package com.agros.reto.backend.springAgros.mapper;

import com.agros.reto.backend.springAgros.dto.UsuarioDTO;
import com.agros.reto.backend.springAgros.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    /* Utilizamos el Mapper para no acceder directamente a la base.
    Lo implementamos en el JugadorServiceImpl a traves del @Autowired
     */

    /* Esta funcion recibe como parametro un Jugador
     * y en base a el parametro recibido genera una nueva instancia
     * de usuario DTO.*/

    @Override
    public UsuarioDTO toDTO(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( entity.getId() );
        usuarioDTO.setNombre( entity.getNombre() );
        usuarioDTO.setApellido( entity.getApellido() );
        usuarioDTO.setDni( entity.getDni() );
        usuarioDTO.setCorreo( entity.getCorreo() );

        return usuarioDTO;
    }

    /* Esta funcion recibe como parametro un UsuarioDTO
     * y hacemos un generamos una nueva instancia de Usuario */
    @Override
    public Usuario fromDTO(UsuarioDTO entity) {
        if ( entity == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( entity.getId() );
        usuario.setNombre( entity.getNombre() );
        usuario.setApellido( entity.getApellido() );
        usuario.setDni( entity.getDni() );
        usuario.setCorreo( entity.getCorreo() );

        return usuario;
    }
}
