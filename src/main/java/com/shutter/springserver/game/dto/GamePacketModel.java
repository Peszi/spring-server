package com.shutter.springserver.game.dto;

import com.shutter.springserver.game.dto.utility.GameUserModel;
import com.shutter.springserver.game.dto.utility.ResultModel;
import com.shutter.springserver.game.dto.utility.zone.CptZoneDataModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.shutter.springserver.game.util.ZoneControlConstants.TIME_SPEED_GAIN;

@Setter
@Getter
public class GamePacketModel {

    // per update
    private float time;
    private boolean started;
    private boolean finished;
    private List<CptZoneDataModel> zones;
    private List<ResultModel> results;

    // per user
    private int points;
    private String alias;
    private GameUserModel user;
    private List<GameUserModel> allies;

    public GamePacketModel() {
        this.user = new GameUserModel();
        this.zones = new ArrayList<>();
        this.allies = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public void init(GamePrefsModel gamePrefs) {
        this.time = gamePrefs.getLimits().getTime();
        this.started = false;
        this.finished = false;
    }

    public void updateTime(float delta) {
        if (this.time > 0) { this.time -= delta * TIME_SPEED_GAIN; } else { this.time = 0; }
    }

    public int getTime() {
        return (int) this.time;
    }
}
