package com.shutter.springserver.data.game.response.models;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CaptureZone extends LocationModel {

    private int id;

    private int idx;
    private String owner;
    private float points;
    private float cptProgress;
    private boolean cptStatus;

    public CaptureZone(int id, int idx, double lat, double lng, int points) {
        super(lat, lng);
        this.id = id;
        this.idx = idx;
        this.points = points;
    }

    public void decreasePoints(float value) {
        this.points -= value;
    }

    public int getPoints() {
        return (int) this.points;
    }
}
