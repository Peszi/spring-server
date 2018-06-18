package com.shutter.springserver.game.dto.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserPrefsModel {

    private String name;
    private boolean ready;
    private boolean alive;

}
