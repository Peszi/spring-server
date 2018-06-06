package com.shutter.springserver.data.status;

import com.shutter.springserver.data.game.ZoneData;
import com.shutter.springserver.model.Room;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameStatus {

    private float gameTime;
    private boolean inGame;

    private ZoneData baseZone;

    public GameStatus() {
        this.baseZone = new ZoneData();
    }

    public void setup(Room room) { // init mode data
        this.baseZone.setup(room.getMainZone());
    }

    public void updateTime(float deltaTime) {
        this.gameTime += deltaTime;
    }

    public int getGameTime() {
        return (int) gameTime;
    }
}
