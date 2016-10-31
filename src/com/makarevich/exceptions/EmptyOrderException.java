package com.makarevich.exceptions;

/**
 * Created by j on 28.10.16.
 */
public class EmptyOrderException extends Exception{

    public EmptyOrderException(String message) {
        super(message);
    }

    public EmptyOrderException() {
        super();
    }
}
