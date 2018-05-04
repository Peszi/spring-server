package com.shutter.springserver.service.game;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.data.UserGameData;
import com.shutter.springserver.data.game.GameData;

public interface ManageGameService {
    void startGame(UserData userData);
    void finishGame(UserData userData);
    GameData getGameData(long userId, UserGameData userGameData);
}
