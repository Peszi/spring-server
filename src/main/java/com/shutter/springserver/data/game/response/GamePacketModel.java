package com.shutter.springserver.data.game.response;

import com.shutter.springserver.attribute.ZoneControlAttributes;
import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.shared.TeamsMap;
import com.shutter.springserver.data.status.GameStatus;
import com.shutter.springserver.data.status.UserStatus;
import com.shutter.springserver.key.UserGameData;
import com.shutter.springserver.model.Room;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GamePacketModel {

    private GameStatus gameStatus; // per game

    private UserStatus userStatus; // per user

    public GamePacketModel() {
        this.userStatus = new UserStatus();
    }

    public void init(Room room, TeamsMap teamsMap, ZoneControlAttributes attributes) {
    }

    public void update(GameTeamData gameTeamData, long userId, UserGameData userGameData) {
        this.userStatus.update(gameTeamData, userId); // updated per user
        this.userStatus.updatePosition(userGameData);
    }

}
