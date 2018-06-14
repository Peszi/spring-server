package com.shutter.springserver.data.game.model;

import com.shutter.springserver.data.game.dto.GamePacketModel;
import com.shutter.springserver.data.game.dto.GamePrefsModel;
import com.shutter.springserver.data.game.dto.utility.GameUserData;
import com.shutter.springserver.exception.ServerFailureException;
import com.shutter.springserver.util.location.SphericalUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class GameEngine { // Dynamic game data

    private GamePrefsModel gamePrefsModel; // const game utility

    private Map<Long, Integer> usersMap; // Global User ID, Local Team ID
    private List<GameTeamData> teamsDataList; // Game Team Data (local team ID)

    private CaptureZonesManager zonesManager;

    private GamePacketModel gamePacketModel;

    public GameEngine() {
        this.usersMap = new HashMap<>();
        this.teamsDataList = new ArrayList<>();
        this.zonesManager = new CaptureZonesManager();
        this.gamePacketModel = new GamePacketModel();
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

    // Game

    public void startGame() {
        this.zonesManager.init(this.gamePrefsModel);
    }

    public void update(float delta) {
        this.gamePacketModel.updateTime(delta);
        this.calcCapturePoints(delta);
        this.zonesManager.update(delta);
        this.zonesManager.updateZones(this.gamePacketModel.getZones());
    }

    // Zones Logic

    private void calcCapturePoints(float deltaTime) {
        Map<GameTeamData, Integer> inZoneTeams = new HashMap<>();
        for (CaptureZone captureZone : this.zonesManager.getCaptureZones()) { // per zone
            inZoneTeams.clear();
            for (GameTeamData gameTeamData : this.teamsDataList) {
                for (GameUserData userData : gameTeamData.getUsers()) { // per user
                    final float distanceTo = (float) SphericalUtil.computeDistanceBetween(captureZone.getLocation(), userData.getLocation());
                    if (distanceTo < this.gamePrefsModel.getZones().getRadius()) {
                        if (inZoneTeams.containsKey(gameTeamData)) {
                            inZoneTeams.put(gameTeamData, inZoneTeams.get(gameTeamData) + 1);
                        } else {
                            inZoneTeams.put(gameTeamData, 1);
                        }
                    }
                }
            }
            if (inZoneTeams.size() > 0) { // TODO full logic
//                for (Map.Entry<GameTeamData, Integer> zoneTeam : inZoneTeams.entrySet()) {
//
//                }
                this.setCaptTeam(captureZone, inZoneTeams.entrySet().iterator().next().getKey(), deltaTime);
            } else {
                this.setCaptTeam(captureZone, null, deltaTime);
            }
        }
    }

    private void setCaptTeam(CaptureZone captureZoneData, GameTeamData gameTeamData, float delta) {
        if (gameTeamData != null) {
            final float cpt_value = delta * 50f;
            captureZoneData.setOwner(gameTeamData.getAlias());
            captureZoneData.decreasePoints(cpt_value);
            gameTeamData.decreasePoints(cpt_value);
        } else {
            captureZoneData.setOwner(null);
        }
    }

}
