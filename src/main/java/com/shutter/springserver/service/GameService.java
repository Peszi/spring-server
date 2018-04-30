package com.shutter.springserver.service;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.data.UserGameData;
import com.shutter.springserver.dto.GameDTO;
import com.shutter.springserver.model.Room;

public interface GameService {
    void addGame(Room room);
    void removeGame();
    GameDTO getGameData(long userId, UserGameData userData);
}
