package com.riwi.querertourapi.api.error_handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/** Clase para responder cuando el id no
 * sea correcto
 * */

/**
 * El EqualsAndHashCode(callSuper = true) es para evitar
 * que se dupliquen los identificadores de las clases
 * o hash code
 * */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ErrorResponse extends BaseErrorResponse{
    private String message;
}
