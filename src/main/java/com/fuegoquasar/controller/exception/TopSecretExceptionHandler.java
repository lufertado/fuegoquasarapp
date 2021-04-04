package com.fuegoquasar.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TopSecretExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<TopSecretError> handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        return new ResponseEntity<>(new TopSecretError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}

class TopSecretError {
    String message;

    public TopSecretError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}