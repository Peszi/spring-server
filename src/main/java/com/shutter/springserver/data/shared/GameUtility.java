package com.shutter.springserver.data.shared;

import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.GameUserData;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.model.User;

public class GameUtility {

    public static void setupUsers(Room room, TeamsMap teamsMap) {
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
}
