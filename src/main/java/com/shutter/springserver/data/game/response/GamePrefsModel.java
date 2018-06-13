package com.shutter.springserver.data.game.response;

import com.shutter.springserver.data.game.response.models.GameLimitsModel;
import com.shutter.springserver.data.game.response.models.UserDataModel;
import com.shutter.springserver.data.game.response.models.ZonePrefsModel;
import com.shutter.springserver.data.game.response.models.ZoneModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GamePrefsModel { // CONST per game

    // per Game
    private ZoneModel location;
    private GameLimitsModel limits;
    private ZonePrefsModel zones;
    private List<UserDataModel> users;

    // per User
    private ZoneModel resp;

}
