package com.shutter.springserver.data.game;

import com.shutter.springserver.data.game.response.models.ZoneModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class GameTeamData {

    private String alias;
    private List<GameUserData> users;

    private float points;
    private ZoneModel resp;

    public GameTeamData(String alias, int teamPointsCap) {
        this.alias = alias;
        this.users = new ArrayList<>();
        this.points = teamPointsCap;
    }

    public void addUser(GameUserData userData) {
        this.users.add(userData);
    }

    public boolean hasAllies() {
        return !this.users.isEmpty();
    }

    public GameUserData getUserById(long userId) {
        for (GameUserData userData : this.users)
            if (userData.getId() == userId)
                return userData;
        return null;
    }

    public List<GameUserData> getTeamAllies(long userId) {
        List<GameUserData> alliesList = new ArrayList<>();
        for (GameUserData userData : this.users)
            if (userData.getId() != userId)
                alliesList.add(userData);
        return alliesList;
    }

    public void decreasePoints(float value) {
        this.points -= value;
    }

    public int getPoints() {
        return (int) this.points;
    }
}
