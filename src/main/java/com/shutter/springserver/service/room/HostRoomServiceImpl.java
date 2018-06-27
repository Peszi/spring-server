package com.shutter.springserver.service.room;

import com.shutter.springserver.attribute.GameAttributes;
import com.shutter.springserver.key.GameType;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.attribute.ZoneControlAttributes;
import com.shutter.springserver.attribute.ZoneAttribute;
import com.shutter.springserver.exception.AlreadyExistsException;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import com.shutter.springserver.service.user.TeamService;
import com.shutter.springserver.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class HostRoomServiceImpl implements HostRoomService {

    private UserService userService;
    private TeamService teamService;
    private RoomService roomService;

    public HostRoomServiceImpl(UserService userService, TeamService teamService, RoomService roomService) {
        this.userService = userService;
        this.teamService = teamService;
        this.roomService = roomService;
    }

    @Transactional
    @Override
    public void deleteRoom(UserData userData) {
        Room room = this.roomService.validateAndGetByHost(this.userService.validateAndGetUser(userData));
        this.roomService.delete(room);
    }

    @Override
    public void kickUser(UserData userData, long userId) {

    }

    // Team

    @Transactional
    @Override
    public void addTeam(UserData userData, String alias) {
        final User user = this.userService.validateAndGetUser(userData);
        final Room room = this.roomService.validateAndGetByHost(user);
        this.roomService.validateNotInGame(room);
        if (room.getTeams().stream().anyMatch(team -> team.getAlias().equalsIgnoreCase(alias)))
            throw new AlreadyExistsException("Team '" + alias + "'");
        Team team = new Team();
        team.setAlias(alias);
        room.addTeam(team);
        this.roomService.save(room);
    }

    @Transactional
    @Override
    public void removeTeam(UserData userData, long teamId) {
        Room room = this.roomService.validateAndGetByHost(this.userService.validateAndGetUser(userData));
        Team team = this.teamService.validateAndGetTeamById(teamId);
        this.roomService.validateNotInGame(room);
        if (room.getId() != team.getRoom().getId())
            throw new BadRequestException("Incorrect team id!");
        if (room.getTeamsCount() <= 1)
            throw new BadRequestException("There need to be at least one team!");
        if (team.getUsers().size() > 0)
            throw new BadRequestException("This team is not empty!");
//        this.teamRepository.delete(team);
        room.removeTeam(team);
        this.roomService.save(room);
    }

    // Room

    @Override
    public void changeGameSettings(UserData userData, GameAttributes gameAttributes) {
        Room room = this.roomService.validateAndGetByHost(this.userService.validateAndGetUser(userData));
        this.roomService.validateNotInGame(room);
        room.getMainZone().setZoneData(gameAttributes);
        room.setGameMode(GameType.fromInteger(gameAttributes.getGameMode()));
        this.roomService.save(room);
    }

    @Override
    public void changeGameMode(UserData userData, GameType gameType) {
        Room room = this.roomService.validateAndGetByHost(this.userService.validateAndGetUser(userData));
        this.roomService.validateNotInGame(room);
        room.setGameMode(gameType);
        this.roomService.save(room);
    }

    @Override
    public void changeGameLocation(UserData userData, ZoneAttribute mainZone) {
        Room room = this.roomService.validateAndGetByHost(this.userService.validateAndGetUser(userData));
        this.roomService.validateNotInGame(room);
        room.getMainZone().setZoneData(mainZone);
        this.roomService.save(room);
    }

    // Battle Royal

    // Zone Control

    @Override
    public void changeZoneControlData(UserData userData, ZoneControlAttributes zoneControlData) {
        Room room = this.roomService.validateAndGetByHost(this.userService.validateAndGetUser(userData));
        this.roomService.validateNotInGame(room);
        if (room.getGameMode() != GameType.ZONE_CONTROL.ordinal())
            throw new BadRequestException("Wrong game mode " + room.getGameMode() + "!");
        room.getZoneControl().setData(zoneControlData);
        this.roomService.save(room);
    }
}
