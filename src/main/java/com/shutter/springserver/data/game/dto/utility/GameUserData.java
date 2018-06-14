package com.shutter.springserver.data.game.dto.utility;

import com.shutter.springserver.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GameUserData extends LocationModel {

    private long id;
    private boolean alive;

    public GameUserData(User user) {
        this.id = user.getId();
        this.alive = true;
    }
}
