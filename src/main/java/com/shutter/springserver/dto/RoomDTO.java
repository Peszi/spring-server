package com.shutter.springserver.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class RoomDTO {

    private long id;
    private long hostId;
    private String hostName;
    private boolean isStarted;
    private int teamsCount;
    private String createdAt;

    private double zoneLat;
    private double zoneLng;
    private int zoneRadius;

}
