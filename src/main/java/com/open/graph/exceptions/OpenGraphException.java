package com.open.graph.exceptions;

/**
 * @author Pratyay Ganguli
 */

public class OpenGraphException extends RuntimeException{
    public OpenGraphException(String message){
        super(message);
    }

    public OpenGraphException(String message, Throwable cause){
        super(message, cause);
    }
}
