package com.shutter.springserver.service;

import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.User;

import java.util.List;

public interface RoomService {
    Room createRoom(User user);
    void deleteRoom(User user);
    Room getRoomById(long roomId);
    List<Room> getAllRooms();
}
