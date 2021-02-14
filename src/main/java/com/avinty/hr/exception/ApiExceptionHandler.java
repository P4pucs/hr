package com.avinty.hr.exception;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
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
    public ResponseEntity<?> handleCarActiveException
            (CarActiveException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Timestamp(new Date().getTime()),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LeaseClosedException.class)
    public ResponseEntity<?> handleLeaseClosedException
            (LeaseClosedException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Timestamp(new Date().getTime()),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(BadValueException.class)
    public ResponseEntity<?> handleBadValueException
            (BadValueException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Timestamp(new Date().getTime()),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException
            (NullPointerException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Timestamp(new Date().getTime()),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException
            (HttpMessageNotReadableException exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Timestamp(new Date().getTime()),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
