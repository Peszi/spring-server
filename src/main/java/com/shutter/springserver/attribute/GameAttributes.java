package com.shutter.springserver.attribute;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class GameAttributes {

    @NotNull
    private int gameMode;

    @NotNull
    private double zoneLat;

    @NotNull
    private double zoneLng;

    @Min(5) @Max(2500)
    private int zoneRadius;
}
