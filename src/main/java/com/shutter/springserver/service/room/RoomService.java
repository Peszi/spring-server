package com.shutter.springserver.service.room;

import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.User;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    void save(Room room);
    void delete(Room room);
    void validateNotInGame(Room room);
    Room validateAndGetByHost(User user);
    Room validateAndGetById(int roomId);
    void removeEmptyTeams(Room room);
    Optional<Room> getRoom(User user);
    List<Room> getAllRooms();
}
