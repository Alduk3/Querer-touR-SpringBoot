package com.riwi.querertourapi.infrastructure.services;

import com.riwi.querertourapi.api.dto.request.TownRequest;
import com.riwi.querertourapi.api.dto.response.TownResponse;
import com.riwi.querertourapi.domain.entities.Town;
import com.riwi.querertourapi.domain.repositories.TownRepository;
import com.riwi.querertourapi.infrastructure.abstract_services.ITownService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Recordar: Cuando es de class a interface, se implementa
 * y entre interfaces, se extiende
 * */
@Service
/**
 * Con la palabra reservada final se creó una constante,
 * Por lo que obligatoriamente se debe crear un constructor
 * para darle el valor desde el inicio, pues al ser una
 * constante, el valor no puede cambiar
 * */
@AllArgsConstructor
public class TownService implements ITownService {

    /** Se hace inyección de dependencias ya que el
     * repositorio utiliza al servicio */
    @Autowired
    private final TownRepository townRepository;

    @Override
    public void delete(String s) {

    }

    /** Método para crear un Town */
    @Override
    public TownResponse create(TownRequest request) {

        /** Un request es lo que el usuario nos envía, entonces
         * debemos convertir ese request a la entidad para
         * guardarla en el repositorio (el repositorio solo
         * recibe entidades)
         * */

        Town town = this.requestToTown(request, new Town());

        return this.entityToEntityResponse(this.townRepository.save(town));
    }

    @Override
    public TownResponse update(String s, TownRequest request) {
        return null;
    }

    /** */
    @Override
    public Page<TownResponse> getAll(int page, int size) {
        /** Lo primero que hacemos es validar si la página
         * es menor a cero, entonces que la página sea cero.
         * Si el usuario envía la página -1, se envía por
         * defecto la página 0. Spring Boot empieza desde
         * la página 0.*/
        if (page < 0) {
            page = 1;

            /** Hacemos nuestro PageRequest con el método
             * of y le pasamos la página y el tamaño de lo
             * que queremos crear y eso lo guardamos en una
             * variable tipo pagination
             * */
        }

        PageRequest pagination = PageRequest.of(page, size);

        /** Después de crear la paginación, retornamos
         * el repositorio.
         *
         * Se debe hacer un mapeo de datos, en este caso,
         * convertir Town a TownResponse, entonces se
         * debe crear un método que se encargue de ello.
         * Este método se llama:
         *
         *
         * Desde Java 11 se aceptan expresiones lambda, conocidas
         * en JavaScript como expresiones flecha; entonces utilizamos
         * el .map, que recibe el iterable, flecha y lo que va a
         * hacer con ese iterable, el iterable puede llamarse
         * de cualquier manera, en este caso, se llamará town y
         * voy a convertir ese town en entityToEntityResponse*/

        // Sacar un iterador y enviárselo a esa función
        /**
         * Iteramos con map cada town y la convertimos
         * -> podemos hacerlo con expresión lambda flecha
         * o expresión lambda inferencial ::
         */
        /** return this.townRepository.findAll(pagination)
                .map(town -> this.entityToEntityResponse(town)); */

        /** Expresión lambda inferencial */
        return this.townRepository.findAll(pagination)
                .map(this::entityToEntityResponse);
    }

    @Override
    public TownResponse getById(String id) {
        /** Flujo del método: primero se llama lo que está
         * más adentro en los paréntesis, es decir que lo
         * primero que se va a ejecutar es this.find(id)
         * Luego, en el método find, se le pasa el id y
         * va y busca el id en la DB this.townRepository.findById(id)
         * y si no lo encuentra saca el error orElseThrow().
         * Después de encontrar el id this.townRepository.findById(id)
         * se lo pasa al método entityToEntityResponse que lo
         * convierte a un TownResponse */
        return this.entityToEntityResponse(this.find(id));
    }

    /** Método find para simplificar el manejo de errores
     * en por ejemplo, los caracteres que pueda ingresar de
     * más un usuario, o un id que no corresponda
     *
     * Este método nos sirve para no repetir los orElseThrow
     * en los demás métodos, ya que el método find se encargará
     * de ello
     * */
    private Town find(String id){
        return this.townRepository.findById(id).orElseThrow();
    }

    /**
     *  Método encargado de convertir un objeto Town a TownResponse.
     *
     *  Como mecanismo de acceso, lo colocamos private, ya
     *  que solamente lo necesitaremos en esta clase
     *
     *  */
    private TownResponse entityToEntityResponse(Town entity){
        /** Acá estamos utilizando new, pero podemos utilizar
         * el patrón de diseño builder */
        TownResponse response = new TownResponse();

        /** Esto es una forma de mapear los datos
         * Pero existe dentro de Spring Boot una utilidad
         * para no tener que escribir todo esto */
        /**
         response.setId(entity.getId());
         response.setName(entity.getName());
         response.setImg(entity.getImg());
         response.setAudio(entity.getAudio());
         response.setLocation(entity.getLocation());
         response.setDescription(entity.getDescription());
         response.setShort_description(entity.getShort_description());
         response.setQr(entity.getQr());
         */

        /** Mapeo de datos con la utilidad de Spring Boot
         * que nos permite copiar una clase dentro de otra.
         *
         * Lo que hace es mutar directamente response, es
         * decir: de la entidad Town cópiele toda la
         * información en response
         *
         * Eso es como el push en las listas de JS, como
         * el sort
         * */
        BeanUtils.copyProperties(entity, response);

        return response;
    }

    /** Método para convertir un objeto TownResponse a Town */

    private Town requestToTown (TownRequest request, Town town){

        /**
         * Realizamos la copia de todas las propiedades que tiene
         * request y las va a pegar en town para retornar la
         * entidad town con esas propiedades
         * */

        BeanUtils.copyProperties(request, town);
        return town;
    }

}
