package com.shutter.springserver.data.game.response.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ZoneLocationModel extends LocationModel {

    private int idx;

    public ZoneLocationModel(CaptureZone captureZone) {
        super(captureZone.getLat(), captureZone.getLng());
        this.idx = captureZone.getIdx();
    }
}
