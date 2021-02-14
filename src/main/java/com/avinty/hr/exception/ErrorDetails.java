package com.avinty.hr.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    private Timestamp timestamp;
    private String message;
    private String details;
}
