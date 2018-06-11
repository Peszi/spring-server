package com.shutter.springserver.data.status;

import com.shutter.springserver.data.game.CaptureZoneData;
import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.ZoneData;
import com.shutter.springserver.model.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class GameStatus {

    private float gameTime;
    private boolean inGame;

    public GameStatus() {}

    public void updateTime(float deltaTime) {
        this.gameTime += deltaTime;
    }

    public int getGameTime() {
        return (int) gameTime;
    }
}
