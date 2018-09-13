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
    void removeGame(int roomId);

    GamePrefsModel getGamePrefs(int userId, int roomId);
    GameUsersModel getGameUsers(int userId, int roomId);
    ZonesLocationModel getZonesLocation(int userId, int roomId);
    void setUserReady(int userId, int roomId);
    void setUserDied(int userId, int roomId);
    GamePacketModel getGamePacket(int userId, int roomId, UserGameAttributes userData);
    GameResultModel getGameResult(int userId, int roomId);

    // utility
    Integer getGameId(int userId);
    GameServer getGame(int gameId); // TODO depreciated
}
