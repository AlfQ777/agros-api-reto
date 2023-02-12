package com.agros.reto.backend.springAgros.model;

import org.json.JSONObject;
import javax.persistence.*;

/**
 * <p>Entidad usuario</p>
 * Esta entidad sera la que mapee el JPA para transformarlo en una tabla con sus respectivas columnas.
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    /**
     * <p>Clase usuario</p>
     * Declaramos los atributos que va tener nuestro objeto.
     *
     * @param id
     * Accesibilidad: private.
     * Tipo de dato: Long (No es lo mismo que el primitivo long).
     * @param nombre
     * Accesibilidad: private.
     * Tipo de dato: String.
     * @param apellido
     * Accesibilidad: private.
     * Tipo de dato: String.
     */

    /*Atributos privados de la clase*/

    @Id /* Sera el index de nuestra tabla */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Valor Auto-generado con la estategia: GenerationType.IDENTITY */
    private Long id;

    @Column(name = "nombre",nullable = false) /* No podemos recibir este valor como nulo "null" */
    private String nombre;

    @Column(name = "apellido",nullable = false)
    private String apellido;

    @Column(name = "dni",nullable = false)
    private String dni;

    @Column(name = "correo",nullable = false)
    private String correo;


    /* Construtores de nuestro modelo de dato */

    /* Los constructores se utilizan al momento de instanciar nuesta clase y darle espacio en memoria,
     * los atributos de nuesta clase que no contengan instanciacion en el constructor quedaran con valor null
     * los constructores pueden ser overraideados y contener instanciaciones para varios atributos distintos o
     * incluso el constructor vacio*/

    public Usuario(){} //Por ejemplo aca tenemos un constructor vacio

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /* Metodo para retornar nuestro objeto en un formato JSON */
    /*Este metodo es muy utilizado para poder transformar el objeto a JSON en caso de ser necesario para retorno*/

    public JSONObject toJSONObject() {
        JSONObject jo = new JSONObject();
        jo.put("id",getId());
        jo.put("nombre",getNombre());
        jo.put("apellido",getApellido());
        jo.put("dni",getDni());
        jo.put("correo",getCorreo());
        return jo;
    }

}

