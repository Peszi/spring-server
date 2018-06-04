package com.shutter.springserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ZoneControlDTO {
    private int pointsLimit;
    private int timeLimit;
    private int zoneCapacity;
}
