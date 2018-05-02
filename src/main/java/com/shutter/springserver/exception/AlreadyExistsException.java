package com.shutter.springserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException() {
        super("Object already exists!");
    }

    public AlreadyExistsException(String name) {
        super(name + " already exists!");
    }

    public AlreadyExistsException(String message, boolean none) {
        super(message);
    }
}
