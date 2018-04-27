package com.shutter.springserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerFailureException extends RuntimeException {

    public ServerFailureException() {
        super();
    }

    public ServerFailureException(String message) {
        super("Server fatal error: " + message);
    }

}
