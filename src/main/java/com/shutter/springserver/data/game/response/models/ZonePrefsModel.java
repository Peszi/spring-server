package com.shutter.springserver.data.game.response.models;

import lombok.Getter;

@Getter
public class ZonePrefsModel {

    private int capacity;
    private int radius;

    public ZonePrefsModel(int capacity, int radius) {
        this.setup(capacity, radius);
    }

    public void setup(int capacity, int radius) {
        this.capacity = capacity;
        this.radius = radius;
    }
}
