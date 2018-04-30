package com.shutter.springserver.service;

import com.shutter.springserver.data.UserGameData;
import com.shutter.springserver.dto.GameDTO;

public interface GameServer {
    void updateGame();
    void updateUser(UserGameData userGameData);
    GameDTO getUserData();
}
