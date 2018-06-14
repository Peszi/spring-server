package com.shutter.springserver.data.game.model;

import com.shutter.springserver.data.game.dto.utility.LocationModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CaptureZone extends LocationModel {

    private int id;

    private int order;
    private String owner;
    private float points;
    private float cptProgress;
    private boolean cptStatus;

    public CaptureZone(int id, int order, double lat, double lng, int points) {
        super(lat, lng);
        this.id = id;
        this.order = order;
        this.points = points;
    }

    public void decreasePoints(float value) {
        if (this.points > 0)
            this.points -= value;
        else
            this.points = 0;
    }

    public int getPoints() {
        return (int) this.points;
    }
}
