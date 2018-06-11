package com.shutter.springserver.service.game;

import com.shutter.springserver.key.UserGameData;
import com.shutter.springserver.data.game.GamePacket;
import com.shutter.springserver.model.Room;

public interface GameServer {
    void setup(Room room);
    void updateGame(float deltaTime);
    GamePacket updateUser(long userId, UserGameData userGameData);
}
