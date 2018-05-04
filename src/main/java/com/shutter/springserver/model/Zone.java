package com.shutter.springserver.model;

import com.shutter.springserver.constants.RoomConstants;
import com.shutter.springserver.dto.ZoneDTO;

import javax.persistence.*;

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
    }

    public void setZoneData(ZoneDTO zoneData) {
        this.zoneLongitude = zoneData.getZoneLongitude();
        this.zoneLatitude = zoneData.getZoneLatitude();
        this.zoneRadius = zoneData.getZoneRadius();
    }

}
