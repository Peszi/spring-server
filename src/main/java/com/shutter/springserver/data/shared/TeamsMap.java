package com.shutter.springserver.data.shared;

import com.shutter.springserver.data.game.CaptureZoneData;
import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.GameUserData;
import com.shutter.springserver.data.status.GameStatus;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import com.shutter.springserver.util.location.SphericalUtil;
import lombok.Getter;
import lombok.Setter;

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

    public void update(GameStatus gameStatus, float deltaTime) {
        Map<GameTeamData, Integer> inZoneTeams = new HashMap<>();
        for (CaptureZoneData captureZone : gameStatus.getCaptureZones()) { // per zone
            inZoneTeams.clear();
            for (GameTeamData gameTeamData : this.teamsData) {
                for (GameUserData userData : gameTeamData.getUsers()) { // per user
                    final float distanceTo = (float) SphericalUtil.computeDistanceBetween(captureZone.getLocation(), userData.getLocation());
                    if (distanceTo < captureZone.getRadius()) {
                        if (inZoneTeams.containsKey(gameTeamData)) {
                            inZoneTeams.put(gameTeamData, inZoneTeams.get(gameTeamData) + 1);
                        } else {
                            inZoneTeams.put(gameTeamData, 1);
                        }
                    }
                }
            }
            if (inZoneTeams.size() > 0) {
                for (Map.Entry<GameTeamData, Integer> zoneTeam : inZoneTeams.entrySet()) {
                    this.setCaptTeam(captureZone, zoneTeam.getKey(), deltaTime);
                }
            } else {
                this.setCaptTeam(captureZone, null, deltaTime);
            }
        }
    }

    private void setCaptTeam(CaptureZoneData captureZoneData, GameTeamData gameTeamData, float delta) {
        if (gameTeamData != null) {
            captureZoneData.setCapt(true);
            captureZoneData.setPoints(captureZoneData.getPoints() - (delta * 0.05f));
            captureZoneData.setOwner(gameTeamData.getAlias());
        } else {
            captureZoneData.setCapt(false);
            captureZoneData.setOwner(null);
        }
    }

    void clear() {
        this.usersMap.clear();
        this.teamsData.clear();
    }

    @Setter
    @Getter
    class InZoneTeam {
        private GameTeamData gameTeamData;
        private int capturingUsers;
    }
}
