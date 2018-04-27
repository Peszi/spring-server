package com.shutter.springserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RoomAlreadyExistsException extends RuntimeException {

    public RoomAlreadyExistsException() {
        super("Room already exists!");
    }

    public RoomAlreadyExistsException(long roomId) {
        super("Room already exists! id(" + roomId + ")");
    }

}
