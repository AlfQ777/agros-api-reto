package com.agros.reto.backend.springAgros.service;

import com.agros.reto.backend.springAgros.dto.UsuarioDTO;

import java.util.List;

/**
 * <p>Service de Usuario</p>
 * Este componente sera el encargado de aplicar la logica de negocio a los jugadores antes de persistirlos en la base de datos
 * o de devolver dichas entradas desde la base de datos, es necesario que contenga el spring prototype @Service para su funcionamiento
 * ya que es la forma de declarar al momento de la inyeccion de dependencias que se trata de un service
 */
public interface UsuarioService {

    /**
     * <p>
     *     Obtiene el listado de todos los Usuarios
     * </p>
     *
     * @return List<UsuarioDto>
     */
    List<UsuarioDTO> listAll();

    /**
     * <p>
     *     Obtiene el Usuario de id recibido
     * </p>
     *
     * @param id
     * @return UsuarioDto
     */
    UsuarioDTO getById(Long id);


    /**
     * <p>
     *     Guarda el Usuario recibido. Si el id del Usuario recibido ya existe en la
     *     base se hace throw de una exception "IllegalArgumentException"
     * </p>
     * @param usuario
     * @return UsuarioDto
     */
    UsuarioDTO save(UsuarioDTO usuario);

    /**
     * <p>
     *     Actualiza la información del Usuario recibido.
     *     Busca el id del Usuario recibido en la base, si existe actualiza la información,
     *     caso contrario se hace throw de una exception "NoSuchElementException"
     * </p>
     * @param usuario
     * @return UsuarioDto
     */
    UsuarioDTO update(UsuarioDTO usuario);


    /**
     * <p>
     *     Borra de la base de datos el Usuario que tiene el id recibido.
     *     Si no se encuentra ningun Usuario con el id recibido se hace throw de
     *     una exception "NoSuchElementException"
     * </p>
     * @param id
     */
    void delete(Long id);


}