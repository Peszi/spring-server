package com.shutter.springserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserRoomExistsException extends RuntimeException {

    public UserRoomExistsException() {
        super("User already in this roomId!");
    }

    public UserRoomExistsException(long roomId) {
        super("User already in another roomId! (" + roomId + ")");
    }

}
