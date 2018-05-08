package com.shutter.springserver.service.game;

import com.shutter.springserver.key.UserData;
import com.shutter.springserver.key.UserGameData;
import com.shutter.springserver.data.game.GameData;

public interface ManageGameService {
    void startGame(UserData userData);
    void finishGame(UserData userData);
    GameData getGameData(long userId, UserGameData userGameData);
}
