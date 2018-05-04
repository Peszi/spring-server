package com.shutter.springserver.model;

import com.shutter.springserver.constants.ZoneControlConstants;
import com.shutter.springserver.dto.ZoneControlDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "modes_zone_control")
public class ModeZoneControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pointsLimit;
    private int timeLimit;
    private int zoneCapacity;

    @PrePersist
    public void init() {
        this.pointsLimit = ZoneControlConstants.DEFAULT_POINTS_LIMIT;
        this.timeLimit = ZoneControlConstants.DEFAULT_TIME_LIMIT;
        this.zoneCapacity = ZoneControlConstants.DEFAULT_ZONE_CAPACITY;
    }

    public void setData(ZoneControlDTO zoneControlData) {
        this.pointsLimit = zoneControlData.getPointsLimit();
        this.timeLimit = zoneControlData.getTimeLimit();
        this.zoneCapacity = zoneControlData.getZoneCapacity();
    }
}
