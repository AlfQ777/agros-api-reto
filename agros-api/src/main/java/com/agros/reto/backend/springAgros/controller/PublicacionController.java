package com.agros.reto.backend.springAgros.controller;

import com.agros.reto.backend.springAgros.dto.PublicacionDTO;
import com.agros.reto.backend.springAgros.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Controller de Publicacion</p>
 * Aca se exponen los metodos que seran accesibles via HttpRequest por medio de los path declarados,
 * estos seran accesibles por dichas llamadas por medio de fetch (front), RestTemplate(Otras apis)
 * o postman
 */
@RestController //Se indica por medio de Springboot Annotation que es un RestController
@CrossOrigin //Esta anotacion permite llamadas desde cualquier origen, si no estuviera este deberia ser indicado en property
@RequestMapping("springAgros/api/publicacion") //El path por el cual se accede a este controller
public class PublicacionController {

    //Esta sera la property final en la cual se aloje la memoria instanciada del Publicacion service
    //se pone final para que no pueda ser modificada una vez instanciada
    private final PublicacionService publicacionService;

    /*
    Aca se utiliza la anotacion Autowired, esta anotacion de springboot se encarga de enlazar todos los componentes,
    va ligada a la inyeccion de dependencias, en este caso como se usa por constructor se declara el Spring Prototype
    Autowired arriba del constructor, de esta forma se asegura que al momento de instanciacion del componente, los modulos
    a los cuales se declara y se necesitan usar esten disponibles para su instanciacion, de este modo al momento de ser llamados
    se instancian momentaneamente, se llama a la funcion requerida y se desinstancia, es el concepto de hollywood, IoC inversion
    of control, No nos llames; nosotros te llamaremos
     */
    @Autowired
    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    /*
     * Aca se esta exponiendo por medio del controller un metodo del service, en este caso particular llamado
     * listAll que devuelve todos los Publicacion, se le indica por medio del annotation de springboot GetMapping
     * que se va a llamar por medio de un request del tipo Get al path definido en el componente RequestMapping,
     * en este caso no tiene parametros de entrada ni por path (link) ni por body, de retorno indica que deberia dar
     * un ResponseEntity que contiene una lista de Publicacion, en cual se construye al momento del retorno del service
     * por medio del ResponseEntity.ok() con un HttpStatus.Ok (200)*/
    @GetMapping
    public ResponseEntity<List<PublicacionDTO>> listAll() {
        return ResponseEntity.ok(publicacionService.listAll());
    }

    /*
     * En este caso se devuelve un Publicacion particular, como se vera en el GetMapping se le indica
     * que se le agrega al path el /id y por medio de @PathVariable se indica que se obtiene dicho parametro
     * por el path de la llamada request, de la misma forma se llama al service y se devuelve el ResponseEntity
     * con el Publicacion adentro (body) del response*/

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(publicacionService.getById(id));
    }

    @GetMapping("/categoria/{cat}")
    public ResponseEntity<List<PublicacionDTO>> getByCategoria(@PathVariable int cat) {
        return ResponseEntity.ok(publicacionService.getByCategoria(cat));
    }

    /*
     * En este caso se expone un metodo Post request, y por medio de la anotacion de @RequestBody
     * se solicita como parametro un objeto de tipo PublicacionDto que le va a entrar como JSON por la llamada
     * (Spring lo transforma automaticamente) y lo utiliza como parametro de entrada en el service*/
    @PostMapping
    public ResponseEntity<PublicacionDTO> savePublicacion(@RequestBody PublicacionDTO publicacion) {
        PublicacionDTO savePublicacion = publicacionService.save(publicacion);
        return new ResponseEntity<>(savePublicacion, HttpStatus.CREATED);
    }

    /*
     * Aca se ven ambos casos, se solicita un ID que se obtiene por PathVariable como parametro de entrada,
     * y un DTO de PublicacionDto que se obtiene por medio de RequestBody como parametro, se utiliza para identificar
     * el id del Publicacion que se quiere modificar y reemplazar sus valores con el body del request, que entra como Json
     * Object y el sistema lo parsea automaticamente a objeto al momento de la llamada al controller, tambien se declara
     * que esto es un metodo PUT*/
    @PutMapping("/{id}")
    public ResponseEntity<PublicacionDTO> updateProducto(@PathVariable Long id, @RequestBody PublicacionDTO publicacion) {
        publicacion.setId(id);
        PublicacionDTO updatePublicacion = publicacionService.update(publicacion);
        return ResponseEntity.ok(updatePublicacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        publicacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
	


