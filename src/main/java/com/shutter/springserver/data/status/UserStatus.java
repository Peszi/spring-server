package com.shutter.springserver.data.status;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.GameUserData;
import com.shutter.springserver.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class UserStatus {

    private GameUserData userData;
    private List<GameUserData> alliesList = new ArrayList<>();

    public UserStatus() {}

    public void update(GameTeamData teamData, long userId) {
        final GameUserData userData = teamData.getById(userId);
        if (userData != null) {
            if (teamData.hasAllies())
                this.setAlliesList(teamData.getTeamAllies(userId));
        }
    }
}
