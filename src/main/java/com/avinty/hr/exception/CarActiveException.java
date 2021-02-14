package com.avinty.hr.exception;

public class CarActiveException extends RuntimeException {

    public CarActiveException(String message) {
        super(message);
    }

    public CarActiveException(String message, Throwable cause) {
        super(message, cause);
    }
}
