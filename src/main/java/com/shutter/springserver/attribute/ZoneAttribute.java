package com.shutter.springserver.attribute;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ZoneAttribute {

    @NotNull
    private long zoneLat;

    @NotNull
    private long zoneLng;

    @Min(5)
    @Max(1000)
    private int zoneRadius;

}
