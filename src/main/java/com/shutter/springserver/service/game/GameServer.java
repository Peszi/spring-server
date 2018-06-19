package com.shutter.springserver.service.game;

import com.shutter.springserver.game.GameEngine;
import com.shutter.springserver.game.GameEventListener;
import com.shutter.springserver.game.dto.GamePrefsModel;
import com.shutter.springserver.game.dto.GameUsersModel;
import com.shutter.springserver.game.dto.ZonesLocationModel;
import com.shutter.springserver.game.dto.utility.GameResultModel;
import com.shutter.springserver.key.UserGameAttributes;
import com.shutter.springserver.game.dto.GamePacketModel;
import com.shutter.springserver.model.Room;

public abstract class GameServer {

    GameEventListener gameListener;

    void setGameListener(GameEventListener gameListener) { this.gameListener = gameListener; }

    public abstract void setup(Room room);
    public abstract void updateGame(float deltaTime);
    public abstract GamePrefsModel getGamePrefs(long userId);
    public abstract GameUsersModel getGameUsers();
    public abstract ZonesLocationModel getZonesLocation(long userId);
    public abstract void setUserReady(long userId);
    public abstract void setUserDied(long userId);
    public abstract GamePacketModel getGamePacket(long userId, UserGameAttributes userGameAttributes);
    public abstract GameResultModel getGameResult(long userId);
    public abstract GameEngine getGameEngine();
}
