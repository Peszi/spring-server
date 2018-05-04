package com.shutter.springserver.data.game;

import com.shutter.springserver.model.Zone;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ZoneData {

    private double zoneLongitude;
    private double zoneLatitude;
    private int zoneRadius;

    public void setup(Zone zone) {
        this.zoneLongitude = zone.getZoneLongitude();
        this.zoneLatitude = zone.getZoneLatitude();
        this.zoneRadius = zone.getZoneRadius();
    }
}
