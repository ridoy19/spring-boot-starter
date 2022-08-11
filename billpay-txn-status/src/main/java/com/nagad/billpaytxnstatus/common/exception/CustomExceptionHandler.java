package com.nagad.billpaytxnstatus.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException exception, HttpStatus httpStatus, WebRequest webRequest) {
        return null;
    }
}
