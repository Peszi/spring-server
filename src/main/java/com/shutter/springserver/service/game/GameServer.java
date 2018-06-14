package com.shutter.springserver.service.game;

import com.shutter.springserver.data.game.dto.GamePrefsModel;
import com.shutter.springserver.data.game.dto.ZonesLocationModel;
import com.shutter.springserver.key.UserGameAttributes;
import com.shutter.springserver.data.game.dto.GamePacketModel;
import com.shutter.springserver.model.Room;

public interface GameServer {
    void setup(Room room);
    void updateGame(float deltaTime);
    GamePrefsModel getGamePrefs(long userId);
    ZonesLocationModel getZonesLocation(long userId);
    GamePacketModel getGamePacket(long userId, UserGameAttributes userGameAttributes);
}
