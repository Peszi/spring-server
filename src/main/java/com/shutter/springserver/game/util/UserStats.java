package com.shutter.springserver.game.util;

import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.util.DateUtils;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
@Deprecated
public class UserStats {

    private long userId;
    private String name;
    private String dieTime;

    public void setDieTime(int elapsedSeconds) {
        int seconds = elapsedSeconds % 60;
        int minutes = (elapsedSeconds % 3600) / 60;
        this.dieTime = minutes + ":" + seconds;
    }
}
