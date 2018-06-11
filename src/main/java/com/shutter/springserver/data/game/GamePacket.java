package com.shutter.springserver.data.game;

import com.shutter.springserver.data.shared.GameUtility;
import com.shutter.springserver.data.shared.TeamsMap;
import com.shutter.springserver.data.status.GameData;
import com.shutter.springserver.data.status.GameStatus;
import com.shutter.springserver.data.status.UserStatus;
import com.shutter.springserver.model.Room;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GamePacket {

    private GameStatus gameStatus; // per game

    private UserStatus userStatus; // updated per user
    private GameData gameData; // updated per user

    public GamePacket() {
        this.gameStatus = new GameStatus();
        this.userStatus = new UserStatus();
        this.gameData = new GameData();
    }

    public void init(Room room, TeamsMap teamsMap) {
        GameUtility.setupUsers(room, teamsMap);
        this.gameStatus.init(room.getBaseZone());
        GameData.init(teamsMap.getTeamsData(), room.getMainZone());
    }

    public void update(GameTeamData gameTeamData, long userId) {
        this.userStatus.update(gameTeamData, userId); // updated per user
        this.gameData.setRespZone(gameTeamData.getResp()); // updated per user
    }

    public void updateTime(float deltaTime) {
        this.gameStatus.updateTime(deltaTime);
    }

}
