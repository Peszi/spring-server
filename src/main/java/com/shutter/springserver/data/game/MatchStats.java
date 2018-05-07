package com.shutter.springserver.data.game;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MatchStats {

    private String message;
    private List<UserStats> dyingOrder = new ArrayList<>();

    public void addUser(GameUserData userData, int elapsedTime) {
        UserStats userStats = new UserStats();
        userStats.setUserId(userData.getId());
        userStats.setName(userData.getName());
        userStats.setDieTime(elapsedTime);
        this.dyingOrder.add(userStats);
    }

}
