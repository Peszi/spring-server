package com.shutter.springserver.service;

import com.shutter.springserver.dto.FullRoomDTO;
import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.model.Room;

public interface UserRoomService {
    RoomDTO joinRoom(UserData userData, long roomId);
    void leaveRoom(UserData userData);
    FullRoomDTO getRoom(UserData userData);
    Room getHostRoom(UserData userData);
}
