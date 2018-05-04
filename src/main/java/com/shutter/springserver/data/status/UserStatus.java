package com.shutter.springserver.data.status;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shutter.springserver.data.game.GameUserData;
import com.shutter.springserver.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserStatus {

    private GameUserData userData;

    private List<GameUserData> alliesList;

    public UserStatus(GameUserData userData) {
        this.userData = userData;
    }
}
