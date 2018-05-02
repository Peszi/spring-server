package com.shutter.springserver.service.room;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.exception.AlreadyExistsException;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.exception.NotFoundException;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import com.shutter.springserver.repository.TeamRepository;
import com.shutter.springserver.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class HostRoomServiceImpl implements HostRoomService {

    private UserService userService;
    private RoomService roomService;
    private TeamRepository teamRepository;

    public HostRoomServiceImpl(UserService userService, RoomService roomService, TeamRepository teamRepository) {
        this.userService = userService;
        this.roomService = roomService;
        this.teamRepository = teamRepository;
    }

    @Override
    public void kickUser(UserData userData, long userId) {

    }

    // Team

    @Transactional
    @Override
    public void addTeam(UserData userData, String alias) {
        final User user = this.userService.getUser(userData);
        final Room room = this.roomService.validateAndGetByHost(user);
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
        Room room = this.roomService.validateAndGetByHost(this.userService.getUser(userData));
        final Optional<Team> optTeam = this.teamRepository.findById(teamId);
        if (!optTeam.isPresent() || !optTeam.get().hasRoom() || (room.getId() != optTeam.get().getRoom().getId()))
            throw new NotFoundException("Team");
        if (room.getTeamsCount() <= 1)
            throw new BadRequestException("There need to be at least one team!");
        if (optTeam.get().getUsers().size() > 0)
            throw new BadRequestException("This team is not empty!");
//        this.teamRepository.delete(optTeam.get());
        room.removeTeam(optTeam.get());
        this.roomService.save(room);
    }

    @Override
    public void startGame(UserData userData) {
        // TODO implement
    }

    @Transactional
    @Override
    public void finishGame(UserData userData) {
        final Room room = this.roomService.validateAndGetByHost(this.userService.getUser(userData));
        this.roomService.delete(room);
    }

}
