package com.riwi.querertourapi.api.controllers.errors;

import com.riwi.querertourapi.api.error_handler.BaseErrorResponse;
import com.riwi.querertourapi.api.error_handler.ErrorResponse;
import com.riwi.querertourapi.api.error_handler.ErrorsResponse;
import com.riwi.querertourapi.util.exceptions.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/** Este controlador observa todo el aplicativo,
 * por eso nunca se llama en ningún sitio, y
 * si algo llega a fallar, entra en acción
 * revisa el error y responde con lo que nosotros
 * le hayamos dicho
 * */

/**
 * @RestControllerAdvice: Controlador de errores
 * */
@RestControllerAdvice
/**
 * Status de error del controlador
 * */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {

    @ExceptionHandler(IdNotFoundException.class)
    public BaseErrorResponse handleIdNotFound(IdNotFoundException exception){
        /** Tenemos que responder con BaseErrorResponse o
         * con alguno de sus hijos */
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }

    /**
     * Método para responder una lista de errores,
     * aquí configuramos la librería validation.
     *
     * Esta librería se utiliza para validar los dto's
     * de entrada, es decir, los request.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleErrors(MethodArgumentNotValidException exception){

        /** Debemos guardar todos los errores en una lista */
        List<String> errors = new ArrayList<>();

        exception.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));

        return ErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();
    }
}
