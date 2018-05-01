package com.shutter.springserver.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class FullRoomDTO {

    private long id;
    private long hostId;
    private boolean isStarted;
    private int usersCount;

//    private Set<BasicUserDTO> usersList;

}
