package com.shutter.springserver.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FullRoomDTO extends RoomDTO {

    private List<TeamDTO> teamsList;

}
