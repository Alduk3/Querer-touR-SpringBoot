package com.riwi.querertourapi.utils.exceptions;

/*
 * RuntimeException is the general class of errors in Java
 * we use this class to implement its constructor in this class and generate the personalized error
 * */
public class IdNotFoundException extends RuntimeException {

    //%s for insert the variable

    private static final String ERROR_MESSAGE = "There is no register in the entity %s with the suministred id";

    //Constructor
    public IdNotFoundException(String nameEntity){
        //We use the constructor of RuntimeException and we send the message
        //Inject the name of the entity
        super(String.format(ERROR_MESSAGE, nameEntity));
    }
}