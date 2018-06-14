package com.shutter.springserver.service.game;

import com.shutter.springserver.data.game.dto.GamePacketModel;
import com.shutter.springserver.data.game.dto.GamePrefsModel;
import com.shutter.springserver.data.game.dto.ZonesLocationModel;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.key.UserGameAttributes;

public interface ManageGameService {
    void startGame(UserData userData);
    void finishGame(UserData userData);

    GamePrefsModel getGamePrefs(long userId);
    ZonesLocationModel getZonesLocation(long userId);
    GamePacketModel getGamePacket(long userId, UserGameAttributes userGameAttributes);
}
