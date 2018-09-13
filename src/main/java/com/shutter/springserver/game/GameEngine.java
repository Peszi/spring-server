package com.shutter.springserver.game;

import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.game.dto.GamePacketModel;
import com.shutter.springserver.game.dto.GamePrefsModel;
import com.shutter.springserver.exception.ServerFailureException;
import com.shutter.springserver.game.dto.GameUsersModel;
import com.shutter.springserver.game.dto.utility.GameResultModel;
import com.shutter.springserver.game.model.GameTeamData;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
public class GameEngine { // Dynamic game data

    private GamePrefsModel gamePrefsModel; // const game utility

    private int roomId;
    private Map<Integer, Integer> usersMap; // Global User ID, Local Team ID
    private List<GameTeamData> teamsDataList; // Game Team Data (local team ID)

    private CaptureZonesManager zonesManager;

    private GameUsersModel gameUsersModel;
    private GamePacketModel gamePacketModel;
    private GameResultModel gameResultModel;

    private GameEventListener gameListener;

    public GameEngine() {
        this.usersMap = new HashMap<>();
        this.teamsDataList = new ArrayList<>();
        this.zonesManager = new CaptureZonesManager();
        this.gameUsersModel = new GameUsersModel();
        this.gamePacketModel = new GamePacketModel();
    }

    public void setGameListener(GameEventListener gameListener) {
        this.gameListener = gameListener;
    }

    // Users / Teams

    public void addUser(Integer userId, Integer teamId) {
        this.usersMap.put(userId, teamId);
    }

    public void addTeam(GameTeamData gameTeamData) {
        this.teamsDataList.add(gameTeamData);
    }

    public void setUserReady(Long userId) {
        this.getUserTeam(userId).getUserById(userId).setReady(true);
        GameLogic.updateGameStatus(this);
    }

    public void setUserDied(Long userId) {
        this.getUserTeam(userId).getUserById(userId).setAlive(false);
    }

    public GameTeamData getUserTeam(Long userId) {
        final Integer teamIdx = this.usersMap.get(userId);
        if (teamIdx != null) { return this.teamsDataList.get(teamIdx); }
        throw new ServerFailureException("User not in the game!");
    }

    public GameResultModel getGameResultModel() {
        if (this.gamePacketModel.isFinished() && this.gameResultModel != null)
            return this.gameResultModel;
        throw new BadRequestException("Game is not finished!");
    }

    // Game

    public void startGame() {
        this.zonesManager.init(this.gamePrefsModel);
        this.gamePacketModel.init(this.gamePrefsModel);
    }

    public void update(float delta) {
        GameLogic.setupUsers(this);
        this.zonesManager.updateZones(this.gamePacketModel.getZones());
        if (this.gamePacketModel.isStarted()) {
            this.gamePacketModel.updateTime(delta);
            this.zonesManager.update(delta);
            GameLogic.calcCapturePoints(delta, this);
            GameLogic.calcResultsList(this);
            GameLogic.checkGameResult(this);
        }
    }

    // Game Logic
}
