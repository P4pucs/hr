package com.avinty.hr.exception;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.util.Date;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException
            (ResourceNotFoundException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Timestamp(new Date().getTime()),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CarActiveException.class)
    public ResponseEntity<?> handleResourceNotFoundException
            (CarActiveException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Timestamp(new Date().getTime()),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(LeaseClosedException.class)
    public ResponseEntity<?> handleResourceNotFoundException
            (LeaseClosedException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Timestamp(new Date().getTime()),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.I_AM_A_TEAPOT);
    }


}
