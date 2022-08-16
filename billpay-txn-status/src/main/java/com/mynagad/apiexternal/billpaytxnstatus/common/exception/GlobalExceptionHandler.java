package com.mynagad.apiexternal.billpaytxnstatus.common.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return generateErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info(ex.getClass().getName());

        final String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
        return generateErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info(ex.getClass().getName());
        return generateErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, ex.getMessage(), ex);

    }


    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info(ex.getClass().getName());
        return generateErrorResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE, ex.getMessage(), ex);

    }

    // 500 Error
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error("error", ex);
        return generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);

    }

    private ResponseEntity<Object> generateErrorResponse(HttpStatus status, String message,  Exception e) {
        String envType;
        label22: {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            String stackTrace = sw.toString();
            envType = System.getenv("ENV");

            if (envType != null) {
                String var7 = envType;
                switch(var7.hashCode()) {
                    case -2056856391:
                        if (var7.equals("PRODUCTION")) {
                            envType = null;
                            break label22;
                        }
                        break;
                    case -1179540453:
                        if (var7.equals("STAGING") || var7.equals("DEVELOPMENT") || var7.equals("LOCAL")) {
                            envType = stackTrace;
                            break label22;
                        }
                }
            }

            envType = stackTrace;
        }

        String stackTraceMessage = envType;
        final ExceptionResponse apiError = ExceptionResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND)
                .message(message)
                .timestamp(LocalDateTime.now())
                .devMessage(stackTraceMessage)
                .build();
        return new ResponseEntity<>(apiError, status);
    }
}
