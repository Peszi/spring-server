package com.shutter.springserver.service;

import com.shutter.springserver.dto.FullRoomDTO;
import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.exception.RoomNotFoundException;
import com.shutter.springserver.exception.UserRoomExistsException;
import com.shutter.springserver.exception.UserRoomNotFoundException;
import com.shutter.springserver.mapper.RoomMapper;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
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
        final Room room = this.roomService.getRoomById(roomId);
        User user = this.userService.getUser(userData);
        if (user.hasRoom()) {
            if (user.getRoom().getId() == roomId)
                throw new UserRoomExistsException();
            throw new UserRoomExistsException(roomId);
        } // Not we've got the user existing, without room, and requested room exists
        user.setRoom(room);
        this.userService.fetchUser(user);
        return this.roomMapper.roomToRoomDTO(room);
    }

    @Transactional
    @Override
    public void leaveRoom(UserData userData) {
        User user = this.userService.getUser(userData);
        if (!user.hasRoom())
            throw new UserRoomNotFoundException();
        user.setRoom(null);
        this.userService.fetchUser(user);
    }

    @Override
    public FullRoomDTO getRoom(UserData userData) {
        User user = this.userService.getUser(userData);
        if (!user.hasRoom())
            throw new RoomNotFoundException();
        return this.roomMapper.roomToFullRoomDTO(user.getRoom());
    }

    @Override
    public Room getHostRoom(UserData userData) {
        User user = this.userService.getUser(userData);
        if (!user.hasRoom())
            throw new RoomNotFoundException();
        if (user.getRoom().getHostId() != userData.getId())
            throw new UserRoomNotFoundException("User is not a host!");
        return user.getRoom();
    }
}
