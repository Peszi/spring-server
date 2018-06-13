package com.shutter.springserver.service.game;

import com.shutter.springserver.data.game.response.GamePrefsModel;
import com.shutter.springserver.data.game.response.ZonesLocationModel;
import com.shutter.springserver.key.UserGameData;
import com.shutter.springserver.data.game.response.GamePacketModel;
import com.shutter.springserver.model.Room;

public interface GameService {
    void createGame(Room room);
    void removeGame(long roomId);

    GamePrefsModel getGamePrefs(long userId, long roomId);
    ZonesLocationModel getZonesLocation(long userId, long roomId);
    GamePacketModel getGamePacket(long userId, long roomId, UserGameData userData);

    // utility
    Long getGameId(long userId);
    GameServer getGame(long gameId); // TODO depreciated
}
