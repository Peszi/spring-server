package com.shutter.springserver.service.game;

import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.shared.TeamsMap;
import com.shutter.springserver.key.UserGameData;
import com.shutter.springserver.data.game.GamePacket;
import com.shutter.springserver.attribute.ZoneControlAttributes;
import com.shutter.springserver.exception.ServerFailureException;
import com.shutter.springserver.model.Room;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZoneControlServerImpl implements GameServer {

    private TeamsMap teamsMap;

    private GamePacket gamePacket;

    // Game params
    private ZoneControlAttributes zoneControlData;

    public ZoneControlServerImpl() {
        this.teamsMap = new TeamsMap();
        this.gamePacket = new GamePacket();
    }

    @Override
    public void setup(Room room) {
        this.gamePacket.init(room, this.teamsMap);
    }

    @Override
    public GamePacket updateUser(long userId, UserGameData userGameData) {
        this.gamePacket.update(this.getCurrentUserTeam(userId), userId);
        return this.gamePacket;
    }

    @Override
    public void updateGame(float deltaTime) {
        this.gamePacket.updateTime(deltaTime);
    }

    private GameTeamData getCurrentUserTeam(long userId) {
        Integer teamId = this.teamsMap.getUsersMap().get(userId);
        if (teamId == null)
            throw new ServerFailureException("User not in the game!");
        return this.teamsMap.getTeamsData().get(teamId);
    }

}
