package com.shutter.springserver.data.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shutter.springserver.data.shared.TeamsMap;
import com.shutter.springserver.data.status.GameData;
import com.shutter.springserver.data.status.GameStatus;
import com.shutter.springserver.data.status.UserStatus;
import com.shutter.springserver.exception.ServerFailureException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GamePacket {

    private GameStatus gameStatus;
    private UserStatus userStatus; // per user
    private GameData gameData; // per user

    public GamePacket() {
        this.gameStatus = new GameStatus();
        this.userStatus = new UserStatus();
        this.gameData = new GameData();
    }

    public void init() {

    }

    public void update(GameStatus gameStatus, GameTeamData gameTeamData, long userId) {
        this.gameStatus = gameStatus; // global value
        this.userStatus.update(gameTeamData, userId);
    }


}
