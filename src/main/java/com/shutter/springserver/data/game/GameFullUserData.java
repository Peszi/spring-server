package com.shutter.springserver.data.game;

import com.shutter.springserver.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameFullUserData extends GameUserData {

    private double longitude;
    private double latitude;
    private int direction;

    public GameFullUserData(User user) {
        super(user);
    }
}
