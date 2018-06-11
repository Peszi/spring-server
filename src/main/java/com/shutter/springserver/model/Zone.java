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

    private double zoneLongitude;
    private double zoneLatitude;
    private int zoneRadius;

    @PrePersist
    public void init() {
        this.zoneRadius = RoomConstants.DEFAULT_ZONE_RADIUS;
        this.zoneLatitude = 49.824814d;
        this.zoneLongitude = 19.046022d;
    }

    public void setZoneData(ZoneAttribute zoneData) {
        this.zoneLongitude = zoneData.getZoneLng();
        this.zoneLatitude = zoneData.getZoneLat();
        this.zoneRadius = zoneData.getZoneRadius();
    }

    public void setZoneData(GameAttributes gameAttributes) {
        this.zoneLongitude = gameAttributes.getZoneLng();
        this.zoneLatitude = gameAttributes.getZoneLat();
        this.zoneRadius = gameAttributes.getZoneRadius();
    }

    public LatLng getLocation() {
        return new LatLng(this.zoneLatitude, this.zoneLongitude);
    }
}
