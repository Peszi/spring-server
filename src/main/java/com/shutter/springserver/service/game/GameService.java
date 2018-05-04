package com.shutter.springserver.service.game;

import com.shutter.springserver.data.UserGameData;
import com.shutter.springserver.data.game.GameData;
import com.shutter.springserver.model.Room;

public interface GameService {
    void createGame(Room room);
    void removeGame(long roomId);
    GameData getGameData(long userId, long roomId, UserGameData userData);
    Long getGameId(long userId);
    GameServer getGame(long gameId);
}
