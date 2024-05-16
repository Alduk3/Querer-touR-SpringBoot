package com.riwi.querertourapi.api.error_handler;

import com.riwi.querertourapi.api.dto.errors.BaseErrorResponse;
import com.riwi.querertourapi.api.dto.errors.ErrorsResponse;
import com.riwi.querertourapi.utils.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice

@ResponseStatus(code = HttpStatus.BAD_REQUEST)

public class BadRequestController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleBadRequest(MethodArgumentNotValidException exception){

        List<Map<String,String>> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(e -> {
            Map<String,String> error = new HashMap<>();
            error.put("error", e.getDefaultMessage()); //agregar al map el error
            error.put("field", e.getField()); //agregar al map en donde ocurrió el error
            errors.add(error);
        });

        return ErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value()) //400
                .status(HttpStatus.BAD_REQUEST.name()) //BAD_REQUEST
                .errors(errors)
                .build();
    }


    @ExceptionHandler(BadRequestException.class)
    public BaseErrorResponse handleError(BadRequestException exception){
        List<Map<String,String>> errors = new ArrayList<>();

        Map<String,String> error = new HashMap<>();

        error.put("id", exception.getMessage());

        errors.add(error);


        return ErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();

    }
}
