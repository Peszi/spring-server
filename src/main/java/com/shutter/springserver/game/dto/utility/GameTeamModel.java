package com.shutter.springserver.game.dto.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class GameTeamModel {

    private String alias;
    private List<UserPrefsModel> users;

}
