package com.shutter.springserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shutter.springserver.game.util.ZoneControlConstants;
import com.shutter.springserver.attribute.ZoneControlAttributes;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "zc_mode")
public class ModeZoneControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    private int pointsLimit;
    private int timeLimit;
    private int zoneCapacity;

    @PrePersist
    public void init() {
        this.pointsLimit = ZoneControlConstants.DEFAULT_POINTS_LIMIT;
        this.timeLimit = ZoneControlConstants.DEFAULT_TIME_LIMIT;
        this.zoneCapacity = ZoneControlConstants.DEFAULT_ZONE_CAPACITY;
    }

    public void setData(ZoneControlAttributes zoneControlData) {
        this.pointsLimit = zoneControlData.getPointsLimit();
        this.timeLimit = zoneControlData.getTimeLimit();
        this.zoneCapacity = zoneControlData.getZoneCapacity();
    }
}
