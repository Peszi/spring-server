package com.shutter.springserver.data.shared;

import com.shutter.springserver.data.game.CaptureZoneData;
import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.GameUserData;
import com.shutter.springserver.data.game.ZoneData;
import com.shutter.springserver.data.status.GameStatus;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import com.shutter.springserver.util.location.LatLng;
import com.shutter.springserver.util.location.SphericalUtil;

import java.util.List;
import java.util.Random;

public class ZoneControlInitializer {

    private static final String[] ZONES = {"green", "cyan", "yellow"};

    private final int RESP_ZONE_RADIUS = 15,
                        CAPTURE_ZONE_RADIUS = 15;

    public static void setupGame(Room room, TeamsMap teamsMap, GameStatus gameStatus) {
        setupUsers(room, teamsMap);
        gameStatus.setup(room);
        // Zones
        final LatLng center = room.getMainZone().getLocation();
        initRespZones(center, teamsMap.getTeamsData(), room.getMainZone().getZoneRadius());
        initCaptureZones(center, room.getMainZone().getZoneRadius()/2, gameStatus);
    }

    private static void setupUsers(Room room, TeamsMap teamsMap) {
        teamsMap.clear();
        for (int i = 0; i < room.getTeams().size(); i++) {
            Team team = room.getTeams().get(i);
            GameTeamData teamData = new GameTeamData(team.getAlias());
            for (User user : team.getUsers()) {
                teamData.addUser(new GameUserData(user));
                teamsMap.getUsersMap().put(user.getId(), i);
            }
            teamsMap.getTeamsData().add(teamData);
        }
    }

    private static void initRespZones(LatLng center, List<GameTeamData> teamsData, int offset) {
        final int zonesOffset = new Random().nextInt(360);
        final int zoneAngleStep = 360 / teamsData.size();
        for (int i = 0; i < teamsData.size(); i++) {
            final LatLng zoneLocation = SphericalUtil.computeOffset(center, offset, zoneAngleStep * i + zonesOffset);
            teamsData.get(i).setResp(new ZoneData(zoneLocation.latitude, zoneLocation.longitude, RESP_ZONE_RADIUS));
        }
    }

    private static void initCaptureZones(LatLng center, int offset, ZoneControlGameStatus gameStatus) {
        CaptureZoneData captureZoneData;
        final int captureZonesCount = 3;
        final int zonesOffset = new Random().nextInt(360);
        final int zoneAngleStep = 360 / captureZonesCount;
        for (int i = 0; i < captureZonesCount; i++) {
            final LatLng zoneLocation = SphericalUtil.computeOffset(center, offset,zoneAngleStep * i + zonesOffset);
            captureZoneData = new CaptureZoneData(zoneLocation.latitude, zoneLocation.longitude, CAPTURE_ZONE_RADIUS, ZONES[i]);
            gameStatus.getCaptureZones().add(captureZoneData);
            System.out.println(captureZoneData.toString());
        }
    }
}
