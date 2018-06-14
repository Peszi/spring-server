package com.shutter.springserver.data.game.dto;

import com.shutter.springserver.data.game.dto.utility.GameLimitsModel;
import com.shutter.springserver.data.game.dto.utility.UserDataModel;
import com.shutter.springserver.data.game.dto.utility.zone.CptZonePrefsModel;
import com.shutter.springserver.data.game.dto.utility.zone.ZoneModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GamePrefsModel { // CONST per game

    // per Game
    private ZoneModel location;
    private GameLimitsModel limits;
    private CptZonePrefsModel zones;
    private List<UserDataModel> users;

    // per User
    private ZoneModel resp;

}
