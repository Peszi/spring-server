package com.shutter.springserver.game.dto;

import com.shutter.springserver.game.dto.utility.GameTeamModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class GameUsersModel {

    private List<GameTeamModel> teams;

    public GameUsersModel() {
        this.teams = new ArrayList<>();
    }
}
