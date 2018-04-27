package com.shutter.springserver.service;

import com.shutter.springserver.exception.RoomAlreadyExistsException;
import com.shutter.springserver.exception.RoomNotFoundException;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.User;
import com.shutter.springserver.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room createRoom(User user) {
        Optional<Room> tmpRoom = this.roomRepository.findRoomByHost(user);
        if (tmpRoom.isPresent())
            throw new RoomAlreadyExistsException(tmpRoom.get().getId());
        Room room = new Room();
        room.setHost(user);
        room.setIsStarted(false);
        room.addUser(user);
        this.roomRepository.save(room);
        return room;
    }

    @Override
    public void deleteRoom(User user) {
        Optional<Room> room = this.roomRepository.findRoomByHost(user);
        if (!room.isPresent())
            throw new RoomNotFoundException();
        this.roomRepository.delete(room.get());
    }

    @Override
    public Room getRoomById(long roomId) {
        Optional<Room> room = this.roomRepository.findById(roomId);
        if (!room.isPresent())
            throw new RoomNotFoundException(roomId);
        return room.get();
    }

    @Override
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }
}
