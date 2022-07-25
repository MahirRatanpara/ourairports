package com.mahir.ourairport.exception;

/**
 * @author Mahir Ratanpara
 */
public class InvalidInputException extends Exception {
    /**
     * Default Constructor
     */
    public InvalidInputException() {
    }

    /**
     * Overridden Message Constructor to pass message
     * @param message
     */
    public InvalidInputException(String message) {
        super(message);
    }

}
