package com.shutter.springserver.service.room;

import com.shutter.springserver.key.GameType;
import com.shutter.springserver.dto.FullRoomDTO;
import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.dto.RoomsListDTO;
import com.shutter.springserver.exception.AlreadyExistsException;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.mapper.RoomMapper;
import com.shutter.springserver.model.ModeZoneControl;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import com.shutter.springserver.service.user.TeamService;
import com.shutter.springserver.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class UserRoomServiceImpl implements UserRoomService {

    private UserService userService;
    private TeamService teamService;
    private RoomService roomService;
    private RoomMapper roomMapper;

    public UserRoomServiceImpl(UserService userService, TeamService teamService, RoomService roomService, RoomMapper roomMapper) {
        this.userService = userService;
        this.teamService = teamService;
        this.roomService = roomService;
        this.roomMapper = roomMapper;
    }

    @Transactional
    @Override
    public RoomDTO createRoom(UserData userData) {
        final User user = this.userService.validateAndGetUser(userData);
        if (this.roomService.getRoom(user).isPresent())
            throw new AlreadyExistsException("Room");
        Room room = new Room();
        room.setHost(user);
        room.setStarted(false);
        room.getMainZone();
        room.setMode(GameType.ZONE_CONTROL); // TODO tmp
        room.setZcMode(new ModeZoneControl());
        Team team = new Team();
        team.setAlias("Alpha");
        team.addUser(user);
        room.addTeam(team);
        this.roomService.save(room);
//        this.teamService.save(team);
        return this.roomMapper.roomToRoomDTO(room);
    }

    @Transactional
    @Override
    public void changeTeam(UserData userData, int teamId) {
        final User user = this.userService.validateAndGetUser(userData);
        this.userService.validateInTeam(user);
        this.roomService.validateNotInGame(user.getTeam().getRoom());
        final Team team = this.teamService.validateAndGetTeamById(teamId);
        this.teamService.validateHasRoom(team);
        if (user.getTeam().getId() == team.getId())
            throw new BadRequestException("You are already in this room!");
        if (user.getTeam().getRoom().getId() != team.getRoom().getId())
            throw new BadRequestException("Incorrect team id!");
        user.setTeam(team);
        this.userService.save(user);
    }

    // Rooms

    @Transactional
    @Override
    public RoomDTO joinRoom(UserData userData, int roomId) {
        final User user = this.userService.validateAndGetUser(userData);
        if (user.hasTeam()) {
            if (user.getTeam().getRoom().getId() == roomId)
                throw new BadRequestException("User already in this room!");
            throw new BadRequestException("User is in another room!");
        }
        final Room room = this.roomService.validateAndGetById(roomId);
        this.roomService.validateNotInGame(room);
        Team team = room.getTeams().iterator().next();
        team.addUser(user);
        this.teamService.save(team);
        return this.roomMapper.roomToRoomDTO(room);
    }

    @Transactional
    @Override
    public void leaveRoom(UserData userData) { // TODO leave while in game consequences
        final User user = this.userService.validateAndGetUser(userData);
        this.userService.validateInTeam(user);
        Team team = user.getTeam();
        team.removeUser(user);
        this.teamService.save(team);
    }

    // Getters

    @Transactional
    @Override
    public FullRoomDTO getRoom(UserData userData) {
        final User user = this.userService.validateAndGetUser(userData);
        this.userService.validateInTeam(user);
        return this.roomMapper.roomToFullRoomDTO(user.getTeam().getRoom());
    }

    @Override
    public ModeZoneControl getZoneControl(UserData userData) {
        final User user = this.userService.validateAndGetUser(userData);
        this.userService.validateInTeam(user);
        return user.getTeam().getRoom().getZcMode();
    }

    @Transactional
    @Override
    public RoomsListDTO getAllRooms(UserData userData) {
        boolean hasRoom = this.userService.validateAndGetUser(userData).hasTeam();
        return new RoomsListDTO(hasRoom, this.roomService.getAllRooms()
                .stream()
                .map(this.roomMapper::roomToRoomDTO)
                .collect(Collectors.toList()));
    }
}
