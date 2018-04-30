package com.shutter.springserver.service;

import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.dto.RoomsListDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.mapper.RoomMapper;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class ManageRoomServiceImpl implements ManageRoomService {

    private UserService userService;
    private RoomService roomService;

    private RoomMapper roomMapper;

    public ManageRoomServiceImpl(UserService userService, RoomService roomService, RoomMapper roomMapper) {
        this.userService = userService;
        this.roomService = roomService;
        this.roomMapper = roomMapper;
    }

    @Transactional
    @Override
    public RoomDTO createRoom(UserData userData) {
        User user = this.userService.getUser(userData);
        final Room room = this.roomService.createRoom(user);
        return this.roomMapper.roomToRoomDTO(room);
    }

    @Override
    public void deleteRoom(UserData userData) {
        User user = this.userService.getUser(userData);
        this.roomService.deleteRoom(user);
    }

    @Override
    public RoomsListDTO getAllRooms(UserData userData) {
        boolean hasRoom = this.userService.getUser(userData).hasRoom();
        return new RoomsListDTO(hasRoom, this.roomService.getAllRooms()
                .stream()
                .map(this.roomMapper::roomToRoomDTO)
                .collect(Collectors.toList()));
    }
}
