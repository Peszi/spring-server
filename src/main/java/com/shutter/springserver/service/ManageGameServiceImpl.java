package com.shutter.springserver.service;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.data.UserGameData;
import com.shutter.springserver.dto.GameDTO;
import com.shutter.springserver.model.Room;
import org.springframework.stereotype.Service;

@Service
public class ManageGameServiceImpl implements ManageGameService {

    private UserRoomService userRoomService;
    private GameService gameService;

    public ManageGameServiceImpl(UserRoomService userRoomService, GameService gameService) {
        this.userRoomService = userRoomService;
        this.gameService = gameService;
    }

    @Override
    public void startGame(UserData userData) {
        final Room room = this.userRoomService.getHostRoom(userData);
        this.gameService.addGame(room);
    }

    @Override
    public void endGame(long userId) {

    }

    @Override
    public GameDTO getGameData(long userId, UserGameData userGameData) {
        return this.gameService.getGameData(userId, userGameData);
    }

}
