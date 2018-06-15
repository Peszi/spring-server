package com.shutter.springserver.game.dto;

import com.shutter.springserver.game.dto.utility.zone.CptZoneModel;
import com.shutter.springserver.game.model.CaptureZone;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ZonesLocationModel {

    private List<CptZoneModel> zones;

    public ZonesLocationModel() {
        this.zones = new ArrayList<>();
    }

    public void setup(CaptureZone[] captureZonesList) {
        this.zones.clear();
        for (CaptureZone zoneModel : captureZonesList)
            this.zones.add(new CptZoneModel(zoneModel));
    }

}
