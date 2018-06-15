package com.shutter.springserver.game.util;

import com.shutter.springserver.game.dto.GamePacketModel;
import com.shutter.springserver.game.dto.utility.GameUserModel;
import com.shutter.springserver.game.dto.GamePrefsModel;
import com.shutter.springserver.game.GameEngine;
import com.shutter.springserver.game.dto.utility.*;
import com.shutter.springserver.game.dto.utility.zone.ZoneModel;
import com.shutter.springserver.game.dto.utility.zone.CptZonePrefsModel;
import com.shutter.springserver.game.model.GameTeamData;
import com.shutter.springserver.key.UserGameAttributes;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import com.shutter.springserver.util.location.LatLng;
import com.shutter.springserver.util.location.SphericalUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZoneControlUtility {

    // PREFS

    public static GamePrefsModel initPrefs(Room room) {
        GamePrefsModel prefs = new GamePrefsModel();
        prefs.setLocation(new ZoneModel(room.getMainZone()));
        prefs.setLimits(new GameLimitsModel(room.getZoneControl().getPointsLimit(), room.getZoneControl().getTimeLimit()));
        prefs.setZones(new CptZonePrefsModel(room.getZoneControl().getZoneCapacity(), ZoneControlConstants.CAPTURE_ZONE_RADIUS));
        prefs.setUsers(ZoneControlUtility.initUsers(room));
        return prefs;
    }

    // mapping data
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

    public static GameEngine initGame(Room room) {
        GameEngine gameEngine = ZoneControlUtility.initTeams(room);
        gameEngine.setRoomId(room.getId());
        ZoneControlUtility.initResps(room, gameEngine);
        return gameEngine;
    }

    private static GameEngine initTeams(Room room) {
        GameEngine gameEngine = new GameEngine();
        for (int i = 0; i < room.getTeams().size(); i++) {
            Team team = room.getTeams().get(i);
            GameTeamData teamData = new GameTeamData(team.getAlias(), room.getZoneControl().getPointsLimit());
            for (User user : team.getUsers()) {
                teamData.addUser(user);
                gameEngine.addUser(user.getId(), i);
            }
            gameEngine.addTeam(teamData);
        }
        return gameEngine;
    }

    private static void initResps(Room room, GameEngine gameEngine) {
        final int teamsCount = gameEngine.getTeamsDataList().size();
        final int zonesOffset = new Random().nextInt(360);
        final int zoneAngleStep = 360 / teamsCount;
        for (int i = 0; i < teamsCount; i++) {
            final LatLng zoneLocation = SphericalUtil
                    .computeOffset(room.getMainZone().getLocation(), room.getMainZone().getZoneRadius(), zoneAngleStep * i + zonesOffset);
            gameEngine.getTeamsDataList().get(i)
                    .setResp(new ZoneModel(zoneLocation.latitude, zoneLocation.longitude, ZoneControlConstants.RESP_RADIUS));
        }
    }

    // GAME

    // mapping data
    public static GamePacketModel getUserPacket(GameEngine gameEngine, long userId, UserGameAttributes userAttributes) { // update user packet
        GamePacketModel packetModel = gameEngine.getGamePacketModel();
        GameTeamData teamData = gameEngine.getUserTeam(userId);
        GameUserModel userData = teamData.getUserById(userId);
        if (userAttributes != null)
            userData.updateLocation(userAttributes.getLat(), userAttributes.getLng()); // update user location
        packetModel.setPoints(teamData.getPoints());
        packetModel.setAlias(teamData.getAlias());
        packetModel.setUser(userData);
        if (packetModel.getUser() != null && teamData.hasAllies())
            packetModel.setAllies(teamData.getTeamAllies(userId));
        return packetModel;
    }
}
