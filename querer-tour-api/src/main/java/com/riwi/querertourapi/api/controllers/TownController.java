package com.riwi.querertourapi.api.controllers;

import com.riwi.querertourapi.api.dto.request.TownRequest;
import com.riwi.querertourapi.api.dto.response.TownResponse;
import com.riwi.querertourapi.infrastructure.abstract_services.ITownService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

/** En el controlador inyectamos la interfaz del servicio */
@RestController
@RequestMapping("/town")
@AllArgsConstructor
public class TownController {

    @Autowired
    private final ITownService iTownService;

    @GetMapping
    /** Estamos respondiendo una entidad que va a tener como
     * genérico un page que tiene como genérico un TownResponse
     * */
    public ResponseEntity<Page<TownResponse>> get(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size){

        /** .ok y llamamos a la interfaz de nuestro servicio
         * osea iTownService, el método para obtener y
         * le pasamos la página y el tamaño.
         * Le restamos 1 unidad al page para que el usuario
         * la página 1 wn realidad para nosotros sea la
         * página cero
         * */
        return ResponseEntity.ok(this.iTownService.getAll(page - 1, size));
    }

    /** No pueden existir dos @GetMapping, por lo que el va a
     * traer un id como parámetro que va a ser dinámico.
     *
     * Para traer ese id, se hace con la notación @PathVariable
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<TownResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(this.iTownService.getById(id));
    }

    /** Controlador que llama al servicio para crear registros
     * de Town en la DB */
    @PostMapping
    public ResponseEntity<TownResponse> insert(@RequestBody TownRequest town){
        return ResponseEntity.ok(this.iTownService.create(town));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){

        this.iTownService.delete(id);

        /** Responde un 204, es decir, que no hay contenido, es decir, qie si eliminó */
        return ResponseEntity.noContent().build();
    }

}
