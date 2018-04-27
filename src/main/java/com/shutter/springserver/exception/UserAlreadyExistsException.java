package com.shutter.springserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException() {
        super("User already exists!");
    }

    public UserAlreadyExistsException(String credential) {
        super("User already exists with " + credential);
    }

}
