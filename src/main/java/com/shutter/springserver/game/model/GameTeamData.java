package com.shutter.springserver.game.model;

import com.shutter.springserver.game.dto.utility.GameUserModel;
import com.shutter.springserver.game.dto.utility.zone.ZoneModel;
import com.shutter.springserver.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class GameTeamData {

    private String alias;
    private List<GameUserModel> users;

    private float points;
    private ZoneModel resp;

    public GameTeamData(String alias, int teamPointsCap) {
        this.alias = alias;
        this.users = new ArrayList<>();
        this.points = teamPointsCap;
    }

    public void addUser(User user) {
        this.users.add(new GameUserModel(user));
    }

    public boolean hasAllies() {
        return !this.users.isEmpty();
    }

    public GameUserModel getUserById(long userId) {
        for (GameUserModel userData : this.users)
            if (userData.getId() == userId)
                return userData;
        return null;
    }

    public List<GameUserModel> getTeamAllies(long userId) {
        List<GameUserModel> alliesList = new ArrayList<>();
        for (GameUserModel userData : this.users)
            if (userData.getId() != userId)
                alliesList.add(userData);
        return alliesList;
    }
    
    public boolean isTeamReady() {
        for (GameUserModel userData : this.users)
            if (!userData.isReady())
                return false;
        return true;
    }

    public void decreasePoints(float value) {
        if (this.points > 0) { this.points -= value; } else { this.points = 0; }
    }

    public int getPoints() {
        return (int) this.points;
    }
}
