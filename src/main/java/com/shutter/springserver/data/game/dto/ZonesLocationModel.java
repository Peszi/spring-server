package com.shutter.springserver.data.game.dto;

import com.shutter.springserver.data.game.model.CaptureZone;
import com.shutter.springserver.data.game.dto.utility.zone.CptZoneModel;
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

    public void setup(List<CaptureZone> captureZonesList) {
        this.zones.clear();
        for (CaptureZone zoneModel : captureZonesList)
            this.zones.add(new CptZoneModel(zoneModel));
    }

}
