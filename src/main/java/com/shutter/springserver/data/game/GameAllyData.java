package com.shutter.springserver.data.game;

import com.shutter.springserver.data.game.dto.utility.GameUserData;
import com.shutter.springserver.model.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Deprecated
public class GameAllyData extends GameUserData {

    private long userLongitude;
    private long userLatitude;

    public GameAllyData(User user, long userLongitude, long userLatitude) {
        super(user);
        this.userLongitude = userLongitude;
        this.userLatitude = userLatitude;
    }
}
