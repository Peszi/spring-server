package com.shutter.springserver.attribute;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ZoneAttribute {

    @NotNull
    private double zoneLat;

    @NotNull
    private double zoneLng;

    @Min(5)
    @Max(2500)
    private int zoneRadius;

}
