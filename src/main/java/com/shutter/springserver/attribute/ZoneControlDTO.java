package com.shutter.springserver.attribute;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Data
public class ZoneControlDTO {

    @Min(50)
    private int pointsLimit;

    @Min(60)
    private int timeLimit;

    @Min(5)
    private int zoneCapacity;
}
