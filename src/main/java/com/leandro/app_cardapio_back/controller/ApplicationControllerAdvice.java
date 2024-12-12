package com.leandro.app_cardapio_back.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.leandro.app_cardapio_back.exception.RecordNotFoundException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    
    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundExcetption(RecordNotFoundException ex){
        
        return  ex.getMessage();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        return ex.getBindingResult().getFieldErrors()
        .stream()
        .map(error -> error.getField() + " " + error.getDefaultMessage())
        .reduce("", (acc, error) -> acc + error + "\n");

    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleConstraintViolationException(ConstraintViolationException ex){
        return ex.getConstraintViolations()
        .stream()
        .map(error -> error.getPropertyPath() + " " + error.getMessage())
        .reduce("", (acc, error) -> acc + error + "\n");
   
    }
}


