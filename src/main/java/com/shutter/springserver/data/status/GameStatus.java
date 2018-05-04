package com.shutter.springserver.data.status;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameStatus {

    private float gameTime;
    private boolean inQueue;

    public GameStatus() {
        this.inQueue = true;
    }

    public void updateTime(float deltaTime) {
        this.gameTime += deltaTime;
    }

    public int getGameTime() {
        return (int) gameTime;
    }
}
