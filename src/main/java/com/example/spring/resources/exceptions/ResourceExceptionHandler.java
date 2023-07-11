package com.example.spring.resources.exceptions;

import com.example.spring.services.exceptions.ResourceNotFoundExecption;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundExecption.class)
    public ResponseEntity<StandarError> resourceNotFoundHandler(ResourceNotFoundExecption e, HttpServletRequest request) {
        String error = "Resource not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandarError> MethodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e,
                                                                                   HttpServletRequest request) {
        String error = "Illegal argument";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
