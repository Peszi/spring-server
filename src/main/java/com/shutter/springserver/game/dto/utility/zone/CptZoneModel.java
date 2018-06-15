package com.shutter.springserver.game.dto.utility.zone;

import com.shutter.springserver.game.dto.utility.LocationModel;
import com.shutter.springserver.game.model.CaptureZone;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CptZoneModel extends LocationModel {

    private int order;

    public CptZoneModel(CaptureZone captureZone) {
        super(captureZone.getLat(), captureZone.getLng());
        this.order = captureZone.getOrder();
    }
}
