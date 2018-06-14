package com.shutter.springserver.data.game.dto.utility.zone;

import com.shutter.springserver.data.game.model.CaptureZone;
import com.shutter.springserver.data.game.dto.utility.LocationModel;
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
