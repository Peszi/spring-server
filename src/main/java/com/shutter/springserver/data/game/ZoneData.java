package com.shutter.springserver.data.game;

import com.shutter.springserver.model.Zone;
import com.shutter.springserver.util.location.LatLng;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZoneData {

    private double lat;
    private double lng;
    private int radius;

    public ZoneData(Zone zone) {
        this.setup(zone);
    }

    public void setup(Zone zone) {
        this.lat = zone.getZoneLatitude();
        this.lng = zone.getZoneLongitude();
        this.radius = zone.getZoneRadius();
    }

    public LatLng getLocation() {
        return new LatLng(this.lat, this.lng);
    }
}
