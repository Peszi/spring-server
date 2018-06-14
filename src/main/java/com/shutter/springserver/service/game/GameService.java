package com.shutter.springserver.service.game;

import com.shutter.springserver.data.game.dto.GamePrefsModel;
import com.shutter.springserver.data.game.dto.ZonesLocationModel;
import com.shutter.springserver.key.UserGameAttributes;
import com.shutter.springserver.data.game.dto.GamePacketModel;
import com.shutter.springserver.model.Room;

public interface GameService {
    void createGame(Room room);
    void removeGame(long roomId);

    GamePrefsModel getGamePrefs(long userId, long roomId);
    ZonesLocationModel getZonesLocation(long userId, long roomId);
    GamePacketModel getGamePacket(long userId, long roomId, UserGameAttributes userData);

    // utility
    Long getGameId(long userId);
    GameServer getGame(long gameId); // TODO depreciated
}
