package com.riwi.querertourapi.api.controllers;

import com.riwi.querertourapi.api.dto.response.TownResponse;
import com.riwi.querertourapi.infrastructure.abstract_services.ITownService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
