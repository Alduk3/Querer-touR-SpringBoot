package com.riwi.querertourapi.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

/**
 * CrudService es una interfaz genérica que servirá y
 * funcionará para todos los servicios y un servicio en
 * específico si tome esa interfaz, es decir, que de
 * esta interfaz genérica, se crea la interfaz especial
 * y a través de la interfaz se inyecte en el servicio.
 *
 * Recordatorio: el controlador jamás debe inyectar el
 * servicio directamente, debe inyectar es a la interfaz
 * del servicio. El controlador a través de dto's va a
 * interactuar con nuestro cliente (Postman en este caso)
 * y así va a ser tanto de ida como de venida (ver diagrama).
 *
 *
 * RQ = Request
 * RS = Response
 * ID = Tipo de dato de la llave primaria de la entidad
 *
 * Todas las interfaces individuales van a extender de esta.
 * Puede tener más cosas en caso de que se requiera.
 * */
public interface CrudService <RQ,RS,ID>{
    /** Método getAll: si se hace con paginación como en este
     * caso, retorna un Page de tipo RS (response) y le
     * pasamos de manera opcional el page y el size */
    public Page<RS> getAll(int page, int size);

    /** Método getById: obtiene un Town por id */
    public RS getById(ID id);

    /** Método create: retorna un RS (un response) y recibe
     * por parámetro un RQ (un request) */
    public RS create(RQ request);

    /** Método update: retorna un RS (un response) y recibe
     * por parámetro el id tipo ID y un RQ (un request) */
    public RS update(ID id, RQ request);

    /** Método delete: recibe por parámetro el id a
     * eliminar de tipo ID genérico*/
    public void delete(ID id);
}
