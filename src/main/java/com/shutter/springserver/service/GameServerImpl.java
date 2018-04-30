package com.shutter.springserver.service;

import com.shutter.springserver.data.UserGameData;
import com.shutter.springserver.dto.GameDTO;
import com.shutter.springserver.service.GameServer;

public class GameServerImpl implements GameServer {

    @Override
    public void updateUser(UserGameData userGameData) {

    }

    @Override
    public void updateGame() {

    }

    @Override
    public GameDTO getUserData() {
        return new GameDTO();
    }
}
