package com.shutter.springserver.data.shared;

import com.shutter.springserver.data.game.response.models.CaptureZone;
import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.GameUserData;
import com.shutter.springserver.data.status.GameStatus;
import com.shutter.springserver.util.location.SphericalUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
public class TeamsMap {

    private final float CPT_SPEED = 0.1f;

    private Map<Long, Integer> usersMap; // Global User ID, Local Team ID
    private List<GameTeamData> teamsData; // Game Team Data (local team ID)

    public TeamsMap() {
        this.usersMap = new HashMap<>();
        this.teamsData = new ArrayList<>();
    }

    public void update(GameStatus gameStatus, float deltaTime) {
        this.calcCapturePoints(gameStatus, deltaTime);
        this.calcPlaces(gameStatus, deltaTime);
    }

    private void calcCapturePoints(GameStatus gameStatus, float deltaTime) {
        Map<GameTeamData, Integer> inZoneTeams = new HashMap<>();
        for (CaptureZone captureZone : gameStatus.getCaptureZones()) { // per zone
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
//                for (Map.Entry<GameTeamData, Integer> zoneTeam : inZoneTeams.entrySet()) {
//
//                }
                this.setCaptTeam(captureZone, inZoneTeams.entrySet().iterator().next().getKey(), deltaTime);
            } else {
                this.setCaptTeam(captureZone, null, deltaTime);
            }
        }
    }

    private void calcPlaces(GameStatus gameStatus, float deltaTime) { }

    private void setCaptTeam(CaptureZone captureZoneData, GameTeamData gameTeamData, float delta) {
        if (gameTeamData != null) {
            captureZoneData.setCapt(true);
            captureZoneData.setOwner(gameTeamData.getAlias());
            final float cpt_value = delta * CPT_SPEED;
            captureZoneData.decreasePoints(cpt_value);
            gameTeamData.decreasePoints(cpt_value);
        } else {
            captureZoneData.setCapt(false);
            captureZoneData.setOwner(null);
        }
    }

    void clear() {
        this.usersMap.clear();
        this.teamsData.clear();
    }
}
