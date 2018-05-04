package com.shutter.springserver.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ZoneDTO {

    @NotNull
    private long zoneLongitude;

    @NotNull
    private long zoneLatitude;

    @Min(5)
    @Max(1000)
    private int zoneRadius;

}
