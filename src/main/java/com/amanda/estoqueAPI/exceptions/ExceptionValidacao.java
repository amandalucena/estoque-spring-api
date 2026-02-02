package com.amanda.estoqueAPI.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class ExceptionValidacao extends RuntimeException{
    public ExceptionValidacao (String message){
        super (message);
    }
}