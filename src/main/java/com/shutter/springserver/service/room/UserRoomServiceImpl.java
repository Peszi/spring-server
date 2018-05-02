package com.shutter.springserver.service.room;

import com.shutter.springserver.dto.FullRoomDTO;
import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.dto.RoomsListDTO;
import com.shutter.springserver.exception.AlreadyExistsException;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.exception.NotFoundException;
import com.shutter.springserver.mapper.RoomMapper;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import com.shutter.springserver.repository.TeamRepository;
import com.shutter.springserver.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRoomServiceImpl implements UserRoomService {

    private UserService userService;
    private RoomService roomService;
    private TeamRepository teamRepository;
    private RoomMapper roomMapper;

    public UserRoomServiceImpl(UserService userService, RoomService roomService, TeamRepository teamRepository, RoomMapper roomMapper) {
        this.userService = userService;
        this.roomService = roomService;
        this.teamRepository = teamRepository;
        this.roomMapper = roomMapper;
    }

    @Transactional
    @Override
    public RoomDTO createRoom(UserData userData) {
        final User user = this.userService.getUser(userData);
        if (this.roomService.getRoom(user).isPresent())
            throw new AlreadyExistsException("Room");
        Room room = new Room();
        room.setHost(user);
        room.setIsStarted(false);
        this.roomService.save(room);
        Team team = new Team();
        team.setAlias("Alpha");
        team.setRoom(room);
        team.addUser(user);
        this.teamRepository.save(team);
        return this.roomMapper.roomToRoomDTO(room);
    }

    @Override
    public void changeTeam(UserData userData, long teamId) {
        final User user = this.userService.getUser(userData);
        final long currentRoomId = user.getTeam().getRoom().getId();
        final Optional<Team> optTeam = this.teamRepository.findById(teamId);
        if (!optTeam.isPresent() || !optTeam.get().hasRoom() || (currentRoomId != optTeam.get().getRoom().getId()))
            throw new NotFoundException("Team");
        if (user.getTeam().getId() == optTeam.get().getId())
            throw new BadRequestException("You are already in this room!");
        user.setTeam(optTeam.get());
        this.userService.fetchUser(user);
    }

    // Rooms

    @Transactional
    @Override
    public RoomDTO joinRoom(UserData userData, long roomId) {
        final User user = this.userService.getUser(userData);
        if (user.hasTeam()) {
            if (user.getTeam().getRoom().getId() == roomId)
                throw new BadRequestException("User already in this room!");
            throw new BadRequestException("User is in another room!");
        }
        final Room room = this.roomService.validateAndGetById(roomId);
        Team team = room.getTeams().iterator().next();
        team.addUser(user);
        this.teamRepository.save(team);
        return this.roomMapper.roomToRoomDTO(room);
    }

    @Transactional
    @Override
    public void leaveRoom(UserData userData) {
        final User user = this.userService.getUser(userData);
        if (!user.hasTeam() || !user.getTeam().hasRoom())
            throw new NotFoundException("RoomService");
        Team team = user.getTeam();
        team.removeUser(user);
        this.teamRepository.save(team);
    }

    // Getters

    @Transactional
    @Override
    public FullRoomDTO getRoom(UserData userData) {
        final User user = this.userService.getUser(userData);
        final Team team = user.getTeam();
        if (!user.hasTeam() || !team.hasRoom())
            throw new NotFoundException("Room");
        return this.roomMapper.roomToFullRoomDTO(team.getRoom());
    }

    @Transactional
    @Override
    public RoomsListDTO getAllRooms(UserData userData) {
        boolean hasRoom = this.userService.getUser(userData).hasTeam();
        return new RoomsListDTO(hasRoom, this.roomService.getAllRooms()
                .stream()
                .map(this.roomMapper::roomToRoomDTO)
                .collect(Collectors.toList()));
    }
}
