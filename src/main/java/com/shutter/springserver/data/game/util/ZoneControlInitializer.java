package com.shutter.springserver.data.game.util;

import com.shutter.springserver.data.game.response.models.CaptureZone;
import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.GameUserData;
import com.shutter.springserver.data.game.response.GamePrefsModel;
import com.shutter.springserver.data.game.response.ZonesLocationModel;
import com.shutter.springserver.data.game.model.GameDataModel;
import com.shutter.springserver.data.game.response.models.*;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import com.shutter.springserver.util.location.LatLng;
import com.shutter.springserver.util.location.SphericalUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZoneControlInitializer {

    // PREFS

    public static GamePrefsModel initPrefs(Room room) {
        GamePrefsModel prefs = new GamePrefsModel();
        prefs.setLocation(new ZoneModel(room.getMainZone()));
        prefs.setLimits(new GameLimitsModel(room.getZoneControl().getPointsLimit(), room.getZoneControl().getTimeLimit()));
        prefs.setZones(new ZonePrefsModel(room.getZoneControl().getZoneCapacity(), ZoneControlConstants.DEFAULT_CPT_ZONE_RADIUS));
        prefs.setUsers(ZoneControlInitializer.initUsers(room));
        return prefs;
    }

    // "data mapping"
    public static GamePrefsModel getUserPrefs(GamePrefsModel gamePrefsModel, GameTeamData gameTeamData) {
        gamePrefsModel.setResp(gameTeamData.getResp()); // set user resp
        return gamePrefsModel;
    }

    private static List<UserDataModel> initUsers(Room room) {
        List<UserDataModel> usersList = new ArrayList<>();
        for (Team team : room.getTeams())
            for (User user : team.getUsers())
                usersList.add(new UserDataModel(user.getId(), user.getName()));
        return usersList;
    }

    // DATA

    public static GameDataModel initGame(Room room) {
        GameDataModel gameDataModel = ZoneControlInitializer.initTeams(room);
        ZoneControlInitializer.initResps(room, gameDataModel);
        return gameDataModel;
    }

    private static GameDataModel initTeams(Room room) {
        GameDataModel gameDataModel = new GameDataModel();
        for (int i = 0; i < room.getTeams().size(); i++) {
            Team team = room.getTeams().get(i);
            GameTeamData teamData = new GameTeamData(team.getAlias(), room.getZoneControl().getPointsLimit());
            for (User user : team.getUsers()) {
                teamData.addUser(new GameUserData(user));
                gameDataModel.addUser(user.getId(), i);
            }
            gameDataModel.addTeam(teamData);
        }
        return gameDataModel;
    }

    private static void initResps(Room room, GameDataModel gameDataModel) {
        final int teamsCount = gameDataModel.getTeamsDataList().size();
        final int zonesOffset = new Random().nextInt(360);
        final int zoneAngleStep = 360 / teamsCount;
        for (int i = 0; i < teamsCount; i++) {
            final LatLng zoneLocation = SphericalUtil
                    .computeOffset(room.getMainZone().getLocation(), room.getMainZone().getZoneRadius(), zoneAngleStep * i + zonesOffset);
            gameDataModel.getTeamsDataList().get(i)
                    .setResp(new ZoneModel(zoneLocation.latitude, zoneLocation.longitude, ZoneControlConstants.DEFAULT_RESP_RADIUS));
        }
    }

    // GAME

    // "data mapping"
    public static ZonesLocationModel getCptZones(ZonesLocationModel zonesLocationModel, List<CaptureZone> captureZonesList) { // TODO setup on zones add/change
        List<ZoneLocationModel> zoneLocationModels = new ArrayList<>();
        for (CaptureZone zoneModel : captureZonesList)
            zoneLocationModels.add(new ZoneLocationModel(zoneModel));
        zonesLocationModel.setZones(zoneLocationModels);
        return zonesLocationModel;
    }
}
