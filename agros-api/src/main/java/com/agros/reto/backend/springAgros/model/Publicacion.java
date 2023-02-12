package com.agros.reto.backend.springAgros.model;

import org.json.JSONObject;
import javax.persistence.*;

/**
 * <p>Entidad Publicacion</p>
 * Esta entidad sera la que mapee el JPA para transformarlo en una tabla con sus respectivas columnas.
 */
@Entity
@Table(name = "publicacion")
public class Publicacion {

	/**
	 * <p>Clase publicacion</p>
	 * Declaramos los atributos que va tener nuestro objeto.
	 *
	 * @param id
	 * Accesibilidad: private.
	 * Tipo de dato: Long (No es lo mismo que el primitivo long).
	 * @param titulo
	 * Accesibilidad: private.
	 * Tipo de dato: String.
	 * @param descripcion
	 * Accesibilidad: private.
	 * Tipo de dato: String.
	 */

	/*Atributos privados de la clase*/

	@Id /* Sera el index de nuestra tabla */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titulo",nullable = false) /* No podemos recibir este valor como nulo "null" */
	private String titulo;

	@Column(name = "descripcion",nullable = false)
	private String descripcion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario", nullable = false)
	private Usuario autor;

	@Column(name = "categoria",nullable = false)
	private int categoria;


	/* Construtores de nuestro modelo de dato */

	/* Los constructores se utilizan al momento de instanciar nuesta clase y darle espacio en memoria,
	 * los atributos de nuesta clase que no contengan instanciacion en el constructor quedaran con valor null
	 * los constructores pueden ser overraideados y contener instanciaciones para varios atributos distintos o
	 * incluso el constructor vacio*/

	public Publicacion(){} //Por ejemplo aca tenemos un constructor vacio

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

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	/* Metodo para retornar nuestro objeto en un formato JSON */
	/*Este metodo es muy utilizado para poder transformar el objeto
	a JSON en caso de ser necesario para retorno*/

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

