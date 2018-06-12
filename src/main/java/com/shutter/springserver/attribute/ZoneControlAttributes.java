package com.shutter.springserver.attribute;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Data
public class ZoneControlAttributes {

    @Min(50)
    private int pointsLimit = 500;

    @Min(60)
    private int timeLimit = 1200;

    @Min(5)
    private int zoneCapacity = 50;
}
