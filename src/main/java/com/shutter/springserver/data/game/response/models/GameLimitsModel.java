package com.shutter.springserver.data.game.response.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameLimitsModel {

    private int points;
    private int time;

    public GameLimitsModel(int points, int time) {
        this.setup(points, time);
    }

    public void setup(int points, int time) {
        this.points = points;
        this.time = time;
    }
}
