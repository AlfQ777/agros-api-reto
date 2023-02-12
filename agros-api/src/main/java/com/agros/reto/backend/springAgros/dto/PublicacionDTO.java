package com.agros.reto.backend.springAgros.dto;

import com.agros.reto.backend.springAgros.model.Usuario;
import org.json.JSONObject;

/**
 * <p>Data transfer object de Publicacion (Clase)</p>
 * clase utilizada como DTO de Publicacion
 */
public class PublicacionDTO {

	/* PublicacionDTO tiene la misma estructura de nuestra entidad Publicacion, esto se debe
	 * a que es un DTO = Data Transfer Object, estos DTO se utilizan para poder modificar los valores
	 * de los DTO, filtrarlos, etc., sin persistir en base de datos, tambien es utilizado para poder devolver
	 * una entidad transformada como response ignorando atributos sensibles, como por EJ una contrasea,
	 */

	/*Atributos privados de la clase*/

	private Long id;

	private String titulo;

	private String descripcion;

	private Usuario autor;

	private int categoria;


	/* Los constructores se utilizan al momento de instanciar nuesta clase y darle espacio en memoria,
	 * los atributos de nuesta clase que no contengan instanciacion en el constructor quedaran con valor null
	 * los constructores pueden ser overraideados y contener instanciaciones para varios atributos distintos o
	 * incluso el constructor vacio*/

	public PublicacionDTO(){}


	/* Getters & Setters */

	/* Los getters y setters se utilizan para acceder a los atributos de nuestro objeto,
	como estos son PRIVADOS solo pueden ser accedidos desde metodos publicos, los cuales llamamos
	getters y setters, estos permiten modificar o obtener los atributos privados de la clase,
	si queremos que un atributo no sea accesible para cambio ni obtenerlo simplemente borramos el getter
	y el setter, de forma natural no habria forma de acceder a dicho atributo fuera de la instanciacion
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	/* Metodo para retornar nuestro objeto en un formato JSON */
	/*Este metodo es muy utilizado para poder transformar el objeto a JSON en caso de ser necesario para retorno*/

	public JSONObject toJSONObject() {
		JSONObject jo = new JSONObject();
		jo.put("id",getId());
		jo.put("titulo",getTitulo());
		jo.put("descripcion",getDescripcion());
		jo.put("autor",getAutor());
		jo.put("categoria",getCategoria());
		return jo;
	}

}