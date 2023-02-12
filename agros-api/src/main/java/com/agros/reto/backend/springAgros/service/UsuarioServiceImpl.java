package com.agros.reto.backend.springAgros.service;

import com.agros.reto.backend.springAgros.repository.UsuarioRepository;
import com.agros.reto.backend.springAgros.dto.UsuarioDTO;
import com.agros.reto.backend.springAgros.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

//Aca va la anotacion @Service para declarar que es un servicio y pueda ser detectado por el autowired
@Service
public class UsuarioServiceImpl implements UsuarioService {

    //String que se utilizan para las respuestas de los exception handler
    public static final String PLAYER_WITH_ID = "Player with id = ";
    public static final String DOES_NOT_EXIST = " does not exist.";
    public static final String ALREADY_EXISTS = " already exists.";

    //Estas son las variables donde se alojaran las instanciaciones del repository y el mapper al momento
    //de utilizarlas por medio de Autowired, son final para que no se puedan modificar una vez instanciadas
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    /*
    Aca se utiliza la anotacion Autowired, esta anotacion de springboot se encarga de enlazar todos los componentes,
    va ligada a la inyeccion de dependencias, en este caso como se usa por constructor se declara el Spring Prototype
    Autowired arriba del constructor, de esta forma se asegura que al momento de instanciacion del componente, los modulos
    a los cuales se declara y se necesitan usar esten disponibles para su instanciacion, de este modo al momento de ser llamados
    se instancian momentaneamente, se llama a la funcion requerida y se desinstancia, es el concepto de hollywood, IoC inversion
    of control, No nos llames; nosotros te llamaremos
     */
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                                  UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }


    @Override
    public List<UsuarioDTO> listAll() {
        /*
         * Se obtiene una collection de Usuarios (entidad) del repository,
         * se transforma a una collection de Usuarios (DTO) y luego
         * se lo transforma en un ArrayList para devolverlo al controller*/
        return usuarioRepository.findAllByOrderByNombreAsc().stream()
                .map(this.usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public UsuarioDTO getById(Long id) {
        /*Llama al repository en el metodo findById, para obtener una entidad Usuario, la cual la transforma
         * a DTO con el .map() en caso de que el .map arroje conjunto vacio arroja una excepcion de tipo NoSuchElementException*/
        return usuarioRepository.findById(id).map(this.usuarioMapper::toDTO)
                .orElseThrow(() -> new NoSuchElementException(PLAYER_WITH_ID + id + DOES_NOT_EXIST));
    }


    @Override
    public UsuarioDTO save(UsuarioDTO publicacion) {
        /*
         * instancia un booleano llamado exist, el cual lo iguala a la respuesta de getById del DTO entrante por parametro
         * get id, si es distinto de null y ademas el repository en metodo existById devuelve un ID se carga con True caso contrario false*/
        boolean exists = publicacion.getId() != null && usuarioRepository.existsById(publicacion.getId());
        if (exists) { //Si existe arroja una nueva excepcion del tipo IllegalArgumentException
            throw new IllegalArgumentException(PLAYER_WITH_ID + publicacion.getId() + ALREADY_EXISTS);
        }
        //En caso de que la verificacion anterior no suceda, continua el flujo y guarda la entidad con el save
        //Tambien devuelve el jugador guardado ya que el repository lo devuelve....
        return this.usuarioMapper.toDTO(usuarioRepository.save(this.usuarioMapper.fromDTO(publicacion)));
    }


    @Override
    public UsuarioDTO update(UsuarioDTO publicacion) {
        boolean exists = usuarioRepository.existsById(publicacion.getId());
        if (!exists) {
            throw new NoSuchElementException(PLAYER_WITH_ID + publicacion.getId() + DOES_NOT_EXIST);
        }
        return this.usuarioMapper.toDTO(usuarioRepository.save(this.usuarioMapper.fromDTO(publicacion)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = usuarioRepository.existsById(id);
        if (!exists) {
            throw new NoSuchElementException(PLAYER_WITH_ID + id + DOES_NOT_EXIST);
        }
        usuarioRepository.deleteById(id);
    }

}