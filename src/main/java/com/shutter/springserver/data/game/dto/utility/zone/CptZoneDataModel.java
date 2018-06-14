package com.shutter.springserver.data.game.dto.utility.zone;

import com.shutter.springserver.data.game.model.CaptureZone;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CptZoneDataModel {

    private int order;

    private String owner;
    private float points;
    private float cptProgress;
    private boolean cptStatus;

    public CptZoneDataModel(CaptureZone captureZone) {
        this.order = captureZone.getOrder();
        this.owner = captureZone.getOwner();
        this.points = captureZone.getPoints();
        this.cptProgress = captureZone.getCptProgress();
        this.cptStatus = captureZone.isCptStatus();
    }
}
