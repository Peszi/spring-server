package com.shutter.springserver.service.game;

import com.shutter.springserver.key.UserGameData;
import com.shutter.springserver.data.game.GameData;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.exception.NotFoundException;
import com.shutter.springserver.exception.ServerFailureException;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    private Map<Long, Long> usersList;
    private Map<Long, GameServer> gamesList;

    private long lastTime;

    public GameServiceImpl() {
        this.usersList = new HashMap<>();
        this.gamesList = new HashMap<>();
        this.lastTime = System.currentTimeMillis();
    }

    @Override
    public void createGame(Room room) {
        if (this.gamesList.containsKey(room.getId()))
            throw new BadRequestException("Game already started!");
        this.setupGame(room);
        this.setupUsers(room.getTeams(), room.getId());
    }

    @Override
    public void removeGame(long roomId) {
        if (!this.gamesList.containsKey(roomId))
            throw new NotFoundException("Game");
        this.gamesList.remove(roomId);
        for (Map.Entry<Long, Long> user : this.usersList.entrySet())
            this.usersList.remove(user);
    }

    @Override
    public GameData getGameData(long userId, long roomId, UserGameData userData) {
        GameServer gameServer = this.getGameServer(roomId);
        return gameServer.updateUser(userId, userData);
    }

    @Override
    public Long getGameId(long userId) {
        return this.usersList.get(userId);
    }

    @Override
    public GameServer getGame(long gameId) {
        return this.gamesList.get(gameId);
    }

    @Scheduled(fixedRate = 200)
    public void updateGames() {
        final float deltaTime = this.getDeltaTime();
        for (GameServer gameServer : this.gamesList.values())
            gameServer.updateGame(deltaTime);
    }

    private void setupGame(Room room) {
        GameServer gameServer = null;
        switch (room.getGameType()) {
            case BATTLE_ROYAL:
                gameServer = new ZoneControlServerImpl(); break;
            case ZONE_CONTROL:
                gameServer = new ZoneControlServerImpl(); break;
        }
        if (gameServer == null)
            throw new ServerFailureException("Cannot start game (incorrect game mode)!");
        gameServer.setup(room);
        this.gamesList.put(room.getId(), gameServer);
    }

    private void setupUsers(List<Team> roomTeams, long roomId) {
        for (Team team : roomTeams)
            for (User user : team.getUsers())
                this.usersList.put(user.getId(), roomId);
    }

    private GameServer getGameServer(Long gameId) {
        GameServer gameServer = this.gamesList.get(gameId);
        if (gameServer == null)
            throw new NotFoundException("Game");
        return gameServer;
    }

    private float getDeltaTime() {
        final long currentTime = System.currentTimeMillis();
        float deltaTime = (currentTime - this.lastTime) / 1000f;
        this.lastTime = currentTime;
        return deltaTime;
    }
}
