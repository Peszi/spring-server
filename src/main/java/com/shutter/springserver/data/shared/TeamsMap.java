package com.shutter.springserver.data.shared;

import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.GameUserData;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class TeamsMap {

    private Map<Long, Integer> usersMap; // Global User ID, Local Team ID
    private List<GameTeamData> teamsData; // Game Team Data (local team ID)

    public TeamsMap() {
        this.usersMap = new HashMap<>();
        this.teamsData = new ArrayList<>();
    }

    public void clear() {
        this.usersMap.clear();
        this.teamsData.clear();
    }
}
