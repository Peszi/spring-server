package com.shutter.springserver.game.util;

import com.shutter.springserver.game.dto.utility.GameUserModel;
import com.shutter.springserver.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Deprecated
public class GameFullUserModel extends GameUserModel {

    private double longitude;
    private double latitude;
    private int direction;

    public GameFullUserModel(User user) {
        super(user);
    }
}
