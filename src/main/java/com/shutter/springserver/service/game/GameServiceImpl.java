package com.shutter.springserver.service.game;

import com.shutter.springserver.game.GameEventListener;
import com.shutter.springserver.game.dto.GamePrefsModel;
import com.shutter.springserver.game.dto.GameUsersModel;
import com.shutter.springserver.game.dto.ZonesLocationModel;
import com.shutter.springserver.game.dto.utility.GameResultModel;
import com.shutter.springserver.key.GameType;
import com.shutter.springserver.key.UserGameAttributes;
import com.shutter.springserver.game.dto.GamePacketModel;
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

    private Map<Integer, Integer> usersList;
    private Map<Integer, GameServer> gamesList;

    private long lastTime;

    public GameServiceImpl() {
        this.usersList = new HashMap<>();
        this.gamesList = new HashMap<>();
        this.lastTime = System.currentTimeMillis();
    }

    @Override
    public void createGame(Room room, GameEventListener gameListener) {
        if (this.gamesList.containsKey(room.getId()) && !this.isGameFinished(room.getId()))
            throw new BadRequestException("Game already started!");
        this.setupGame(room, gameListener);
        this.setupUsers(room.getTeams(), room.getId());
    }

    @Override
    public void removeGame(int roomId) {
        if (!this.gamesList.containsKey(roomId))
            throw new NotFoundException("Game");
        this.gamesList.remove(roomId);
        for (Integer user : this.usersList.keySet())
            this.usersList.remove(user);
    }

    @Override
    public GamePrefsModel getGamePrefs(int userId, int roomId) {
        GameServer gameServer = this.getGameServer(roomId);
        return gameServer.getGamePrefs(userId);
    }

    @Override
    public GameUsersModel getGameUsers(int userId, int roomId) {
        return this.getGameServer(roomId).getGameUsers();
    }

    @Override
    public ZonesLocationModel getZonesLocation(int userId, int roomId) {
        GameServer gameServer = this.getGameServer(roomId);
        return gameServer.getZonesLocation(userId);
    }

    @Override
    public void setUserReady(int userId, int roomId) {
        this.getGameServer(roomId).setUserReady(userId);
    }

    @Override
    public void setUserDied(int userId, int roomId) {
        this.getGameServer(roomId).setUserDied(userId);
    }

    @Override
    public GamePacketModel getGamePacket(int userId, int roomId, UserGameAttributes userData) {
        GameServer gameServer = this.getGameServer(roomId);
        return gameServer.getGamePacket(userId, userData);
    }

    @Override
    public GameResultModel getGameResult(int userId, int roomId) {
        GameServer gameServer = this.getGameServer(roomId);
        return gameServer.getGameResult(userId);
    }

    @Override
    public Integer getGameId(int userId) {
        return this.usersList.get(userId);
    }

    @Override
    public GameServer getGame(int gameId) {
        return this.gamesList.get(gameId);
    }

    @Scheduled(fixedRate = 200)
    public void updateGames() {
        final float deltaTime = this.getDeltaTime();
        for (GameServer gameServer : this.gamesList.values())
            gameServer.updateGame(deltaTime);
    }

    private void setupGame(Room room, GameEventListener gameListener) {
        GameServer gameServer = null;
        switch (room.getGameMode()) {
            case 0:
                gameServer = new ZoneControlServerImpl(); break;
            case 1:
                gameServer = new ZoneControlServerImpl(); break;
        }
        if (gameServer == null)
            throw new ServerFailureException("Cannot start game (incorrect game mode)!");
        gameServer.setGameListener(gameListener);
        gameServer.setup(room);
        this.gamesList.put(room.getId(), gameServer);
    }

    private void setupUsers(List<Team> roomTeams, int roomId) {
        for (Team team : roomTeams)
            for (User user : team.getUsers())
                this.usersList.put(user.getId(), roomId);
    }

    private GameServer getGameServer(int gameId) {
        GameServer gameServer = this.gamesList.get(gameId);
        if (gameServer == null)
            throw new NotFoundException("Game");
        return gameServer;
    }

    private boolean isGameFinished(int roomId) {
        final GameServer gameServer = this.gamesList.get(roomId);
        return (gameServer != null && gameServer.getGameEngine() != null && gameServer.getGameEngine().getGamePacketModel().isFinished());
    }

    private float getDeltaTime() {
        final long currentTime = System.currentTimeMillis();
        float deltaTime = (currentTime - this.lastTime) / 1000f;
        this.lastTime = currentTime;
        return deltaTime;
    }
}
