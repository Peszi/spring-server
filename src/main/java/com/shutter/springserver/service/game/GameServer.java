package com.shutter.springserver.service.game;

import com.shutter.springserver.data.game.response.GamePrefsModel;
import com.shutter.springserver.data.game.response.ZonesLocationModel;
import com.shutter.springserver.key.UserGameData;
import com.shutter.springserver.data.game.response.GamePacketModel;
import com.shutter.springserver.model.Room;

public interface GameServer {
    void setup(Room room);
    void updateGame(float deltaTime);
    GamePrefsModel getGamePrefs(long userId);
    ZonesLocationModel getZonesLocation(long userId);
    GamePacketModel getGamePacket(long userId, UserGameData userGameData);
}
