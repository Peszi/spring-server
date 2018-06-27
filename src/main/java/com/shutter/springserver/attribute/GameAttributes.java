package com.shutter.springserver.attribute;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class GameAttributes extends ZoneAttribute {

    @NotNull
    private int gameMode;
}
