package com.avinty.hr.exception;

public class LeaseClosedException extends RuntimeException{

    public LeaseClosedException(String message) {
        super(message);
    }

    public LeaseClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}
