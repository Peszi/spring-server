package com.shutter.springserver.game.util;

import com.shutter.springserver.game.dto.utility.GameUserModel;
import com.shutter.springserver.model.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Deprecated
public class GameAllyModel extends GameUserModel {

    private long userLongitude;
    private long userLatitude;

    public GameAllyModel(User user, long userLongitude, long userLatitude) {
        super(user);
        this.userLongitude = userLongitude;
        this.userLatitude = userLatitude;
    }
}
