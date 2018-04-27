package com.shutter.springserver.service;

import com.shutter.springserver.data.RoomDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.exception.RoomNotFoundException;
import com.shutter.springserver.exception.UserRoomExistsException;
import com.shutter.springserver.mapper.RoomMapper;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.User;
import com.shutter.springserver.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserRoomServiceImpl implements UserRoomService {

    private UserService userService;
    private RoomService roomService;

    private RoomMapper roomMapper;

    public UserRoomServiceImpl(UserService userService, RoomService roomService, RoomMapper roomMapper) {
        this.userService = userService;
        this.roomService = roomService;
        this.roomMapper = roomMapper;
    }

    @Transactional
    @Override
    public RoomDTO joinRoom(UserData userData, long roomId) {
        User user = this.userService.getUser(userData);
        if (user.hasRoom()) {
            if (user.getRoom().getId() == roomId)
                throw new UserRoomExistsException();
            throw new UserRoomExistsException(roomId);
        }
        Room room = this.roomService.getRoomById(roomId);
        // Not we've got the user existing, without room, and requested room exists
        user.setRoom(room);
        this.userService.fetchUser(user);// TODO room need user fetched!
        return this.roomMapper.roomToRoomDTO(room);
    }

    @Override
    public void leaveRoom(UserData userData) {
        // TODO
    }

    @Override
    public RoomDTO getRoom(UserData userData) {
        User user = this.userService.getUser(userData);
        if (!user.hasRoom())
            throw new RoomNotFoundException();
        return this.roomMapper.roomToRoomDTO(user.getRoom());
    }
}
