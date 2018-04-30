package com.shutter.springserver.service;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.data.UserGameData;
import com.shutter.springserver.dto.GameDTO;

public interface ManageGameService {
    void startGame(UserData userData);
    void endGame(long userId);
    GameDTO getGameData(long userId, UserGameData userGameData);
}
