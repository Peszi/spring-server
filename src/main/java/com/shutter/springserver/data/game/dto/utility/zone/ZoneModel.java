package com.shutter.springserver.data.game.dto.utility.zone;

import com.shutter.springserver.data.game.dto.utility.LocationModel;
import com.shutter.springserver.model.Zone;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ZoneModel extends LocationModel {

    private int radius;

    public ZoneModel(Zone zone) {
        super(zone.getZoneLatitude(), zone.getZoneLongitude());
        this.radius = zone.getZoneRadius();
    }

    public ZoneModel(double lat, double lng, int radius) {
        super(lat, lng);
        this.radius = radius;
    }
}
