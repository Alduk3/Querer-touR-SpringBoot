package com.riwi.querertourapi.api.error_handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/** Esta base es reutilizable para múltiples excepciones y
 * múltiples respuestas.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
/** SuperBuilder: crea un constructor con el super
 * de Serializable, la cual es una interfaz para
 * responder errores
 * */
@SuperBuilder
public class BaseErrorResponse implements Serializable {
    /**
     * Este método como mínimo recibirá dos
     * parámetros: status y code
     * */
    private String status;
    private Integer code;
}
