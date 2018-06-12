package com.shutter.springserver.data.game;

import com.shutter.springserver.data.shared.GameUtility;
import com.shutter.springserver.data.shared.TeamsMap;
import com.shutter.springserver.data.status.GameData;
import com.shutter.springserver.data.status.GameStatus;
import com.shutter.springserver.data.status.UserStatus;
import com.shutter.springserver.key.UserGameData;
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
        this.userStatus = new UserStatus();
        this.gameData = new GameData();
    }

    public void init(Room room, TeamsMap teamsMap) {
        GameUtility.setupUsers(room, teamsMap);
        GameData.init(teamsMap.getTeamsData(), room.getMainZone());
    }

    public void update(GameTeamData gameTeamData, long userId, UserGameData userGameData) {
        this.userStatus.update(gameTeamData, userId); // updated per user
        this.userStatus.updatePosition(userGameData);
        this.gameData.setRespZone(gameTeamData.getResp()); // updated per user
    }

}
