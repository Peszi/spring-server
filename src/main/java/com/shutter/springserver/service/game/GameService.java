package com.shutter.springserver.service.game;

import com.shutter.springserver.game.GameEventListener;
import com.shutter.springserver.game.dto.GamePrefsModel;
import com.shutter.springserver.game.dto.GameUsersModel;
import com.shutter.springserver.game.dto.ZonesLocationModel;
import com.shutter.springserver.game.dto.utility.GameResultModel;
import com.shutter.springserver.key.UserGameAttributes;
import com.shutter.springserver.game.dto.GamePacketModel;
import com.shutter.springserver.model.Room;

public interface GameService {
    void createGame(Room room, GameEventListener eventListener);
    void removeGame(long roomId);

    GamePrefsModel getGamePrefs(long userId, long roomId);
    GameUsersModel getGameUsers(long userId, long roomId);
    ZonesLocationModel getZonesLocation(long userId, long roomId);
    void setUserReady(long userId, long roomId);
    GamePacketModel getGamePacket(long userId, long roomId, UserGameAttributes userData);
    GameResultModel getGameResult(long userId, long roomId);

    // utility
    Long getGameId(long userId);
    GameServer getGame(long gameId); // TODO depreciated
}
