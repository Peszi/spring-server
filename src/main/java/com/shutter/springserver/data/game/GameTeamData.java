package com.shutter.springserver.data.game;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class GameTeamData {

    private String alias;
    private List<GameUserData> users = new ArrayList<>();
    private ZoneData resp;

    public GameTeamData(String alias) {
        this.alias = alias;
        this.resp = new ZoneData();
    }

    public void addUser(GameUserData userData) {
        this.users.add(userData);
    }

    public boolean hasAllies() {
        return !this.users.isEmpty();
    }

    public GameUserData getById(long userId) {
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
}
