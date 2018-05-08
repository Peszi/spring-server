package com.shutter.springserver.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class RoomDTO {

    private long id;
    private long hostId;
    private String hostName;
    private boolean isStarted;
    private int teamsCount;

}
