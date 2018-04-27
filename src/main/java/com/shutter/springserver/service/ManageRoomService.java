package com.shutter.springserver.service;

import com.shutter.springserver.data.RoomDTO;
import com.shutter.springserver.data.RoomsListDTO;
import com.shutter.springserver.data.UserData;

public interface ManageRoomService {
    RoomDTO createRoom(UserData userData);
    void deleteRoom(UserData userData);
    RoomsListDTO getAllRooms(UserData userData);
}
