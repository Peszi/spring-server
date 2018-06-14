package com.shutter.springserver.data.game.dto;

import com.shutter.springserver.data.game.dto.utility.GameUserData;
import com.shutter.springserver.data.game.dto.utility.zone.CptZoneDataModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class GamePacketModel {

    // per updateLocation
    private float time;
    private boolean started;
    private List<CptZoneDataModel> zones;

    // per user
    private int points;
    private GameUserData user;
    private List<GameUserData> allies;

    public GamePacketModel() {
        this.user = new GameUserData();
        this.zones = new ArrayList<>();
        this.allies = new ArrayList<>();
    }

    public void updateTime(float delta) {
        if (this.isStarted())
            this.time += delta;
    }

    public int getTime() {
        return (int) this.time;
    }
}
