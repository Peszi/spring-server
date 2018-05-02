package com.shutter.springserver.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
public class FullRoomDTO {

    private long id;
    private long hostId;
    private boolean isStarted;
    private int teamsCount;

    private List<TeamDTO> teamsList;

}
