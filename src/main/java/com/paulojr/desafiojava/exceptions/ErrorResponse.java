package com.paulojr.desafiojava.exceptions;

import lombok.Data;

@Data
public class ErrorResponse extends Exception {

    private String message;
    private String details;

}
