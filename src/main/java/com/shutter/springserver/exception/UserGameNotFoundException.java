package com.shutter.springserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserGameNotFoundException extends RuntimeException {

    public UserGameNotFoundException() {
        super("User isn't attached to any game!");
    }
}
