package com.shutter.springserver.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class RoomDTO {

    private long id;
    private long hostId;
    private boolean isStarted;
    private int usersCount;

}
