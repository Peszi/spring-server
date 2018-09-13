package com.shutter.springserver.service.room;

import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.exception.NotFoundException;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import com.shutter.springserver.repository.RoomRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void save(Room room) {
        this.roomRepository.save(room);
    }

    @Override
    public void delete(Room room) {
        this.roomRepository.delete(room);
    }

    @Override
    public void validateNotInGame(Room room) {
        if (room.getStarted())
            throw new BadRequestException("Game is started!");
    }

    @Override
    public Room validateAndGetByHost(User user) {
        Optional<Room> room = this.roomRepository.findRoomByHost(user);
        if (!room.isPresent())
            throw new NotFoundException("Room");
        return room.get();
    }

    @Override
    public Room validateAndGetById(int roomId) {
        Optional<Room> room = this.roomRepository.findById(roomId);
        if (!room.isPresent())
            throw new NotFoundException("Room");
        return room.get();
    }

    @Override
    public void removeEmptyTeams(Room room) {
        Set<Team> teamsToRemove = new HashSet<>();
        for (Team team : room.getTeams())
            if (!team.hasUsers())
                teamsToRemove.add(team);
        for (Team team : teamsToRemove)
            room.removeTeam(team);
        this.save(room);
    }

    @Override
    public Optional<Room> getRoom(User user) {
        return this.roomRepository.findRoomByHost(user);
    }

    @Override
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }
}
