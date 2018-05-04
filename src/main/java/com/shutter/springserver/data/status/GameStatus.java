package com.shutter.springserver.data.status;

import com.shutter.springserver.data.game.ZoneData;
import com.shutter.springserver.model.Room;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameStatus {

    private float gameTime;
    private boolean inGame;

    private ZoneData gameZone;

    public GameStatus() {
        this.gameZone = new ZoneData();
    }

    public void setup(Room room) {
        this.gameZone.setup(room.getMainZone());
    }

    public void updateTime(float deltaTime) {
        this.gameTime += deltaTime;
    }

    public int getGameTime() {
        return (int) gameTime;
    }
}
