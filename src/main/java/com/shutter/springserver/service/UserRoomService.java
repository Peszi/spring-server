package com.shutter.springserver.service;

import com.shutter.springserver.data.RoomDTO;
import com.shutter.springserver.data.UserData;

public interface UserRoomService {
    RoomDTO joinRoom(UserData userData, long roomId);
    void leaveRoom(UserData userData);
    RoomDTO getRoom(UserData userData);
}
