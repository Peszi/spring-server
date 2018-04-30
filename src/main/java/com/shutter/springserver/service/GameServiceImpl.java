package com.shutter.springserver.service;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.data.UserGameData;
import com.shutter.springserver.dto.GameDTO;
import com.shutter.springserver.exception.ServerFailureException;
import com.shutter.springserver.exception.UserGameNotFoundException;
import com.shutter.springserver.model.Room;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {

    private Map<Long, Long> usersList;
    private Map<Long, GameServer> gamesList;

    public GameServiceImpl() {
        this.usersList = new HashMap<>();
        this.gamesList = new HashMap<>();
    }

    @Override
    public void addGame(Room room) {

        // TODO game setup
        this.gamesList.put(room.getId(), new GameServerImpl());
        room.getUsers().stream().forEach(user -> this.usersList.put(user.getId(), room.getId()));
    }

    @Override
    public void removeGame() {
    }

    @Override
    public GameDTO getGameData(long userId, UserGameData userData) {
        Long gameId = this.usersList.get(userId);
        if (gameId == null)
            throw new UserGameNotFoundException();
        GameServer gameServer = this.gamesList.get(gameId);
        if (gameServer == null)
            throw new ServerFailureException("user game is null :(");
        gameServer.updateUser(userData);
        return gameServer.getUserData();
    }

    @Scheduled(fixedRate = 100)
    public void updateGames() {
        for (GameServer gameServer : this.gamesList.values())
            gameServer.updateGame();
    }
}
