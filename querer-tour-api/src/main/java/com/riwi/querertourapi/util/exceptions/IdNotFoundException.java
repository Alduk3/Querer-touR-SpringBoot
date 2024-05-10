package com.riwi.querertourapi.util.exceptions;

/**
 * RuntimeException: clase general para manejo de errores en Java.
 * Se utilizará para implementar su constructor en esta clase
 * y generar el error personalizado
 * */
public class IdNotFoundException extends RuntimeException{

    /** El %s es una variable correspondiente a la entidad que vamos a insertar */
    private static final String ERROR_MESSAGE = "No hay registros en la entidad %s con el id suministrado";

    /**
     * Utilizamos el constructor de RuntimeException
     * el cual es personalizado (por eso se hace manual)
     * y enviamos el mensaje, inyectando el nombre de
     * la entidad
     * */
    public IdNotFoundException(String nameEntity){
        super(String.format(ERROR_MESSAGE, nameEntity));
    }
}
