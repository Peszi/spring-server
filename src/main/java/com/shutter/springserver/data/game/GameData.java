package com.shutter.springserver.data.game;

import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.GameUserData;
import com.shutter.springserver.data.status.GameStatus;
import com.shutter.springserver.data.status.UserStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GameData {

    private GameStatus gameStatus;
    private UserStatus userStatus;

    public void setUserStatus(GameTeamData teamData, long userId) {
        final GameUserData userData = teamData.getById(userId);
        if (userData != null) {
            this.userStatus = new UserStatus(userData);
            if (teamData.hasAllies())
                this.userStatus.setAlliesList(teamData.getTeamAllies(userId));
        }
    }

}
