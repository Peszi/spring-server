package com.shutter.springserver.game.dto.utility.zone;

import lombok.Getter;

@Getter
public class CptZonePrefsModel {

    private int capacity;
    private int radius;

    public CptZonePrefsModel(int capacity, int radius) {
        this.setup(capacity, radius);
    }

    public void setup(int capacity, int radius) {
        this.capacity = capacity;
        this.radius = radius;
    }
}
