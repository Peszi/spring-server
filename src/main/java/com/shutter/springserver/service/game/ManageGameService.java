package com.shutter.springserver.service.game;

import com.shutter.springserver.data.game.response.GamePacketModel;
import com.shutter.springserver.data.game.response.GamePrefsModel;
import com.shutter.springserver.data.game.response.ZonesLocationModel;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.key.UserGameData;

public interface ManageGameService {
    void startGame(UserData userData);
    void finishGame(UserData userData);

    GamePrefsModel getGamePrefs(long userId);
    ZonesLocationModel getZonesLocation(long userId);
    GamePacketModel getGamePacket(long userId, UserGameData userGameData);
}
