package com.shutter.springserver.game.dto.utility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shutter.springserver.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GameUserModel extends LocationModel {

    private long id;
    private boolean alive;

    @JsonIgnore
    private boolean ready;

    public GameUserModel(User user) {
        this.id = user.getId();
        this.alive = true;
    }
}
