package com.shutter.springserver.service.game;

import com.shutter.springserver.data.game.response.GamePrefsModel;
import com.shutter.springserver.data.game.response.ZonesLocationModel;
import com.shutter.springserver.data.game.model.GameDataModel;
import com.shutter.springserver.data.game.util.ZoneControlInitializer;
import com.shutter.springserver.key.UserGameData;
import com.shutter.springserver.data.game.response.GamePacketModel;
import com.shutter.springserver.model.Room;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZoneControlServerImpl implements GameServer {

    private GamePrefsModel gamePrefsModel; // const game models
    private ZonesLocationModel zonesLocationModel;
//    private GamePacketModel gamePacketModel;

    private GameDataModel gameDataModel; // game data

    @Override
    public void setup(Room room) {
        this.gamePrefsModel = ZoneControlInitializer.initPrefs(room);
        this.gameDataModel = ZoneControlInitializer.initGame(room);

        // After game start
        this.gameDataModel.startGame(this.gamePrefsModel);
    }

    @Override
    public GamePrefsModel getGamePrefs(long userId) {
        return ZoneControlInitializer.getUserPrefs(this.gamePrefsModel, this.gameDataModel.getUserTeam(userId));
    }

    @Override
    public ZonesLocationModel getZonesLocation(long userId) {
        return ZoneControlInitializer.getCptZones(this.zonesLocationModel, this.gameDataModel.getZonesFactory().getCaptureZones());
    }

    @Override
    public GamePacketModel getGamePacket(long userId, UserGameData userGameData) {
        this.gamePacket.setGameStatus(this.gameStatus); // TODO tmp
        this.gamePacket.update(this.getCurrentUserTeam(userId), userId, userGameData);
        return this.gamePacket;
    }

    @Override
    public void updateGame(float deltaTime) {
        this.gameStatus.updateTime(deltaTime);
        this.teamsMap.update(this.gameStatus, deltaTime);
        // update game logic
        this.gameDataModel.update(deltaTime);
    }
}
