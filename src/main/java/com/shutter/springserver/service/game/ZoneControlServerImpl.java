package com.shutter.springserver.service.game;

import com.shutter.springserver.data.zonecontrol.ZoneControlGameStatus;
import com.shutter.springserver.key.UserGameData;
import com.shutter.springserver.data.game.GameData;
import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.GameUserData;
import com.shutter.springserver.data.status.GameStatus;
import com.shutter.springserver.attribute.ZoneControlAttribute;
import com.shutter.springserver.exception.ServerFailureException;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ZoneControlServerImpl implements GameServer {

    private GameStatus gameStatus;

    private Map<Long, Integer> usersMap;
    private List<GameTeamData> teamsData;

    private ZoneControlAttribute zoneControlData;

    public ZoneControlServerImpl() {
        this.gameStatus = new ZoneControlGameStatus();
        this.usersMap = new HashMap<>();
        this.teamsData = new ArrayList<>();
    }

    @Override
    public void setup(Room room) {
        this.gameStatus.setup(room);
        this.teamsData.clear();
        for (int i = 0; i < room.getTeams().size(); i++) {
            Team team = room.getTeams().get(i);
            GameTeamData teamData = new GameTeamData(team.getAlias());
            for (User user : team.getUsers()) {
                teamData.addUser(new GameUserData(user));
                this.usersMap.put(user.getId(), i);
            }
            this.teamsData.add(teamData);
        }
    }

    @Override
    public GameData updateUser(long userId, UserGameData userGameData) {
        // Get User Team
        Integer teamId = this.usersMap.get(userId);
        if (teamId == null)
            throw new ServerFailureException("User not in the game!");
        // Setup Feedback
        GameData gameData = new GameData();
        gameData.setGameStatus(this.gameStatus);
        gameData.setUserStatus(this.teamsData.get(teamId), userId);
        return gameData;
    }

    @Override
    public void updateGame(float deltaTime) {
        this.gameStatus.updateTime(deltaTime);
    }

}
