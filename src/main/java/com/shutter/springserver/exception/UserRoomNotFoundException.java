package com.shutter.springserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserRoomNotFoundException extends RuntimeException {

    public UserRoomNotFoundException() {
        super("User isn't in any room!");
    }

    public UserRoomNotFoundException(String message) {
        super(message);
    }
}
