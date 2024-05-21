package com.riwi.querertourapi.api.controllers;

import com.riwi.querertourapi.api.dto.request.TownRequest;
import com.riwi.querertourapi.api.dto.response.TownResponse;
import com.riwi.querertourapi.infrastructure.abstract_services.ITownService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

/** En el controlador inyectamos la interfaz del servicio */
@RestController
@RequestMapping
@AllArgsConstructor
/** Con Tag podemos cambiar el nombre en Swagger*/
@Tag(name = "Towns") // Usando el Swagger
public class TownController {

    @Autowired
    private final ITownService iTownService;

    @Operation( // Usando el Swagger
            summary = "Lista todos los pueblos con paginación",
            description = "Debes enviar la página y el tamaño de la página para recibir u obtener todos los pueblos correspondientes."
    )
    @GetMapping(path = "/public/town")
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

    //ApiResponse nos ayuda a crear un nuevo esquema (dto) de respuesta
    @ApiResponse(
            responseCode = "400",
            description = "Cuando el id no es válido",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema =  @Schema(implementation = ErrorResponse.class)
                    )
            }
    )
    @Operation( // Usando el Swagger
            summary = "Lista un pueblo por ID",
            description = "Debes enviar el id del pueblo a buscar, para obtener el pueblo correspondiente."
    )
    @GetMapping(path = "/public/town/{id}")
    public ResponseEntity<TownResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(this.iTownService.getById(id));
    }

    /** Controlador que llama al servicio para crear registros
     * de Town en la DB */

    @Operation( // Usando el Swagger
            summary = "Crea un pueblo",
            description = "Debes enviar los valores correspondientes para crear un pueblo"
    )
    @PostMapping(path = "/town")
    public ResponseEntity<TownResponse> insert(
            @Validated /** Uso de la librería validation, siempre va antes del @RequestBody */
            @RequestBody TownRequest town){
        return ResponseEntity.ok(this.iTownService.create(town));
    }

    @ApiResponse(
            responseCode = "400",
            description = "Cuando el id no es válido",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema =  @Schema(implementation = ErrorResponse.class)
                    )
            }
    )
    @Operation( // Usando el Swagger
            summary = "Elimina un pueblo por id",
            description = "Debes enviar el id del pueblo a eliminar."
    )
    @DeleteMapping(path = "/town/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){

        this.iTownService.delete(id);

        /** Responde un 204, es decir, que no hay contenido, es decir, qie si eliminó */
        return ResponseEntity.noContent().build();
    }

    @ApiResponse(
            responseCode = "400",
            description = "Cuando el id no es válido",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema =  @Schema(implementation = ErrorResponse.class)
                    )
            }
    )
    @Operation( // Usando el Swagger
            summary = "Actualiza un pueblo por id",
            description = "Actualiza un pueblo por id"
    )
    @PutMapping(path = "/town/{id}")
    public ResponseEntity<TownResponse> update(
            @PathVariable String id, /** id por url */
            @Validated /** Uso de la librería validation, siempre va antes del @RequestBody */
            @RequestBody TownRequest town /** town actualizado */
    ){
        return ResponseEntity.ok(this.iTownService.update(id, town));
    }

}
