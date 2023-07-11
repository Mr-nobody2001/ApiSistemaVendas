package com.example.spring.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExecption extends RuntimeException {
    public ResourceNotFoundExecption(Object id) {
        super("Resource not found. Id " + id);
    }
}
