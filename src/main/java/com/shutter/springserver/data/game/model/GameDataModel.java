package com.shutter.springserver.data.game.model;

import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.response.GamePrefsModel;
import com.shutter.springserver.data.game.response.models.CaptureZone;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.exception.ServerFailureException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class GameDataModel { // Dynamic game data

    private Map<Long, Integer> usersMap; // Global User ID, Local Team ID
    private List<GameTeamData> teamsDataList; // Game Team Data (local team ID)

    private CaptureZonesFactory zonesFactory;

    public GameDataModel() {
        this.usersMap = new HashMap<>();
        this.teamsDataList = new ArrayList<>();
        this.zonesFactory = new CaptureZonesFactory();
    }

    // Users / Teams

    public void addUser(Long userId, Integer teamId) {
        this.usersMap.put(userId, teamId);
    }

    public void addTeam(GameTeamData gameTeamData) {
        this.teamsDataList.add(gameTeamData);
    }

    public GameTeamData getUserTeam(Long userId) {
        final Integer teamIdx = this.usersMap.get(userId);
        if (teamIdx != null) { return this.teamsDataList.get(teamIdx); }
        throw new ServerFailureException("User not in the game!");
    }

    public void update(float delta) {
        this.zonesFactory.update(delta);
    }

    // Game

    public void startGame(GamePrefsModel gamePrefsModel) {
        this.zonesFactory.init(gamePrefsModel.getZones().getCapacity());
    }

    // TODO Game Logic

}
