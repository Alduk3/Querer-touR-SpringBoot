
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

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {

    @ExceptionHandler(IdNotFoundException.class)
    public BaseErrorResponse handleIdNotFound(IdNotFoundException exception){

        //PUt the son of the BaseErrorResponse class
        return ErrorResponse.builder().code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name()).message(exception.getMessage()).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleErrors(MethodArgumentNotValidException exception) {
        List<String> errors = new ArrayList<>();

        exception.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));

        return ErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors).build();
    }
}
