package com.shutter.springserver.data.game;

import com.shutter.springserver.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameAllyData extends GameUserData {

    private long userLongitude;
    private long userLatitude;

    public GameAllyData(User user, long userLongitude, long userLatitude) {
        super(user);
        this.userLongitude = userLongitude;
        this.userLatitude = userLatitude;
    }
}
