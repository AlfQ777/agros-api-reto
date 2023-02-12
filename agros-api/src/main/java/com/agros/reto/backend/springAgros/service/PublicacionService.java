package com.agros.reto.backend.springAgros.service;

import com.agros.reto.backend.springAgros.dto.PublicacionDTO;

import java.util.List;

/**
 * <p>Service de Publicacion</p>
 * Este componente sera el encargado de aplicar la logica de negocio a los jugadores antes de persistirlos en la base de datos
 * o de devolver dichas entradas desde la base de datos, es necesario que contenga el spring prototype @Service para su funcionamiento
 * ya que es la forma de declarar al momento de la inyeccion de dependencias que se trata de un service
 */
public interface PublicacionService {

	/**
	 * <p>
	 *     Obtiene el listado de todos los Publicaciones
	 * </p>
	 *
	 * @return List<PublicacionDto>
	 */
	List<PublicacionDTO> listAll();

	/**
	 * <p>
	 *     Obtiene la Publicacion de id recibido
	 * </p>
	 *
	 * @param id
	 * @return PublicacionDto
	 */
	PublicacionDTO getById(Long id);

	/**
	 * <p>
	 *     Obtiene las Publicacion con la categoria recibida
	 * </p>
	 *
	 * @param categoria
	 * @return PublicacionDto
	 */
	List<PublicacionDTO>  getByCategoria(int categoria);

	/**
	 * <p>
	 *     Guarda la Publicacion recibida. Si el id de la Publicacion recibido ya existe en la
	 *     base se hace throw de una exception "IllegalArgumentException"
	 * </p>
	 * @param publicacion
	 * @return PublicacionDto
	 */
	PublicacionDTO save(PublicacionDTO publicacion);

	/**
	 * <p>
	 *     Actualiza la información de la Publicacion recibido.
	 *     Busca el id de la Publicacion recibido en la base, si existe actualiza la información,
	 *     caso contrario se hace throw de una exception "NoSuchElementException"
	 * </p>
	 * @param publicacion
	 * @return PublicacionDto
	 */
	PublicacionDTO update(PublicacionDTO publicacion);


	/**
	 * <p>
	 *     Borra de la base de datos el Publicacion que tiene el id recibido.
	 *     Si no se encuentra ningun jugador con el id recibido se hace throw de
	 *     una exception "NoSuchElementException"
	 * </p>
	 * @param id
	 */
	void delete(Long id);


}
