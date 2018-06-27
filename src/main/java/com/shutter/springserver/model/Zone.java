package com.shutter.springserver.model;

import com.shutter.springserver.attribute.GameAttributes;
import com.shutter.springserver.constants.RoomConstants;
import com.shutter.springserver.attribute.ZoneAttribute;
import com.shutter.springserver.util.location.LatLng;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "zones")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double lng;
    private double lat;
    private int radius;

    @PrePersist
    public void init() {
        this.radius = RoomConstants.DEFAULT_ZONE_RADIUS;
        this.lat = 49.824814d;
        this.lng = 19.046022d;
    }

    public void setZoneData(ZoneAttribute zoneData) {
        this.lng = zoneData.getZoneLng();
        this.lat = zoneData.getZoneLat();
        this.radius = zoneData.getZoneRadius();
    }

    public void setZoneData(GameAttributes gameAttributes) {
        this.lng = gameAttributes.getZoneLng();
        this.lat = gameAttributes.getZoneLat();
        this.radius = gameAttributes.getZoneRadius();
    }

    public LatLng getLocation() {
        return new LatLng(this.lat, this.lng);
    }
}
