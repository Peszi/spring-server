package com.shutter.springserver.service.game;

import com.shutter.springserver.game.dto.GamePrefsModel;
import com.shutter.springserver.game.dto.ZonesLocationModel;
import com.shutter.springserver.game.GameEngine;
import com.shutter.springserver.game.dto.utility.GameResultModel;
import com.shutter.springserver.game.util.ZoneControlUtility;
import com.shutter.springserver.key.UserGameAttributes;
import com.shutter.springserver.game.dto.GamePacketModel;
import com.shutter.springserver.model.Room;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZoneControlServerImpl extends GameServer {

    private GameEngine gameEngine; // game data

    @Override
    public void setup(Room room) {
        this.gameEngine = ZoneControlUtility.initGame(room);
        this.gameEngine.setGamePrefsModel(ZoneControlUtility.initPrefs(room));
        this.gameEngine.setGameListener(this.gameListener);
        // After game start
        this.gameEngine.startGame();
    }

    @Override
    public GamePrefsModel getGamePrefs(long userId) {
        return ZoneControlUtility.getUserPrefs(this.gameEngine.getGamePrefsModel(), this.gameEngine.getUserTeam(userId));
    }

    @Override
    public ZonesLocationModel getZonesLocation(long userId) {
        return this.gameEngine.getZonesManager().getZonesLocationModel();
    }

    @Override
    public String setUserReady(long userId) {
        this.gameEngine.setUserReady(userId);
        return null; // TODO hardcoded
    }

    @Override
    public GamePacketModel getGamePacket(long userId, UserGameAttributes userAttributes) {
        return ZoneControlUtility.getUserPacket(this.gameEngine, userId, userAttributes);
    }

    @Override
    public GameResultModel getGameResult(long userId) {
        return this.gameEngine.getGameResultModel();
    }

    @Override
    public void updateGame(float deltaTime) {
        this.gameEngine.update(deltaTime);
    }

    @Override
    public GameEngine getGameEngine() { return this.gameEngine; }
}
