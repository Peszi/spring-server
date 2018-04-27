package com.shutter.springserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException() {
        super("User room not found!");
    }

    public RoomNotFoundException(long roomId) {
        super("Room not found! (" + roomId + ")");
    }

}