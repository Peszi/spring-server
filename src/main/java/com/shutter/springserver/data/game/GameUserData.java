package com.shutter.springserver.data.game;

import com.shutter.springserver.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameUserData {

    // data
    private long id;
    private String name;
    private boolean died;
    // location
    private double longitude;
    private double latitude;

    public GameUserData(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.died = false;
    }
}
