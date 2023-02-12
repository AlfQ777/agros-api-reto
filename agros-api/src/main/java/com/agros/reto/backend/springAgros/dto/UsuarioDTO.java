package com.agros.reto.backend.springAgros.dto;

import org.json.JSONObject;

/**
 * <p>Data transfer object de Usuario (Clase)</p>
 * clase utilizada como DTO de Usuario
 */
public class UsuarioDTO {

    /* UsuarioDTO tiene la misma estructura de nuestra entidad Usuario, esto se debe
     * a que es un DTO = Data Transfer Object, estos DTO se utilizan para poder modificar los valores
     * de los DTO, filtrarlos, etc., sin persistir en base de datos, tambien es utilizado para poder devolver
     * una entidad transformada como response ignorando atributos sensibles, como por EJ una contrasea,
     */

    /*Atributos privados de la clase*/

    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    private String correo;


    /* Los constructores se utilizan al momento de instanciar nuesta clase y darle espacio en memoria,
     * los atributos de nuesta clase que no contengan instanciacion en el constructor quedaran con valor null
     * los constructores pueden ser overraideados y contener instanciaciones para varios atributos distintos o
     * incluso el constructor vacio*/

    /* Constructor vacio */
    public UsuarioDTO(){}


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