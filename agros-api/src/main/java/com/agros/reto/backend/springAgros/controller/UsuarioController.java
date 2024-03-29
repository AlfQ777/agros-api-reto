package com.agros.reto.backend.springAgros.controller;

import com.agros.reto.backend.springAgros.dto.UsuarioDTO;
import com.agros.reto.backend.springAgros.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Controller de Usuario</p>
 * Aca se exponen los metodos que seran accesibles via HttpRequest por medio de los path declarados,
 * estos seran accesibles por dichas llamadas por medio de fetch (front), RestTemplate(Otras apis)
 * o postman
 */
@RestController //Se indica por medio de Springboot Annotation que es un RestController
@CrossOrigin //Esta anotacion permite llamadas desde cualquier origen, si no estuviera este deberia ser indicado en property
@RequestMapping("springAgros/api/usuario") //El path por el cual se accede a este controller
public class UsuarioController {

    //Esta sera la property final en la cual se aloje la memoria instanciada del Usuario service
    //se pone final para que no pueda ser modificada una vez instanciada
    private final UsuarioService usuarioService;

    /*
    Aca se utiliza la anotacion Autowired, esta anotacion de springboot se encarga de enlazar todos los componentes,
    va ligada a la inyeccion de dependencias, en este caso como se usa por constructor se declara el Spring Prototype
    Autowired arriba del constructor, de esta forma se asegura que al momento de instanciacion del componente, los modulos
    a los cuales se declara y se necesitan usar esten disponibles para su instanciacion, de este modo al momento de ser llamados
    se instancian momentaneamente, se llama a la funcion requerida y se desinstancia, es el concepto de hollywood, IoC inversion
    of control, No nos llames; nosotros te llamaremos
     */
    @Autowired
    public UsuarioController(UsuarioService publicacionService) {
        this.usuarioService = publicacionService;
    }

    /*
     * Aca se esta exponiendo por medio del controller un metodo del service, en este caso particular llamado
     * listAll que devuelve todos los jugadores, se le indica por medio del annotation de springboot GetMapping
     * que se va a llamar por medio de un request del tipo Get al path definido en el componente RequestMapping,
     * en este caso no tiene parametros de entrada ni por path (link) ni por body, de retorno indica que deberia dar
     * un ResponseEntity que contiene una lista de jugadores, en cual se construye al momento del retorno del service
     * por medio del ResponseEntity.ok() con un HttpStatus.Ok (200)*/
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listAll() {
        return ResponseEntity.ok(usuarioService.listAll());
    }

    /*
     * En este caso se devuelve un Usuario particular, como se vera en el GetMapping se le indica
     * que se le agrega al path el /id y por medio de @PathVariable se indica que se obtiene dicho parametro
     * por el path de la llamada request, de la misma forma se llama al service y se devuelve el ResponseEntity
     * con el Usuario adentro (body) del response*/

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.getById(id));
    }

    /*
     * En este caso se expone un metodo Post request, y por medio de la anotacion de @RequestBody
     * se solicita como parametro un objeto de tipo UsuarioDto que le va a entrar como JSON por la llamada
     * (Spring lo transforma automaticamente) y lo utiliza como parametro de entrada en el service*/
    @PostMapping
    public ResponseEntity<UsuarioDTO> saveUsuario(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO saveUsuario = usuarioService.save(usuario);
        return new ResponseEntity<>(saveUsuario, HttpStatus.CREATED);
    }

    /*
     * Aca se ven ambos casos, se solicita un ID que se obtiene por PathVariable como parametro de entrada,
     * y un DTO de JugadorDto que se obtiene por medio de RequestBody como parametro, se utiliza para identificar
     * el id del jugador que se quiere modificar y reemplazar sus valores con el body del request, que entra como Json
     * Object y el sistema lo parsea automaticamente a objeto al momento de la llamada al controller, tambien se declara
     * que esto es un metodo PUT*/
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateProducto(@PathVariable Long id, @RequestBody UsuarioDTO publicacion) {
        publicacion.setId(id);
        UsuarioDTO updatePublicacion = usuarioService.update(publicacion);
        return ResponseEntity.ok(updatePublicacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


