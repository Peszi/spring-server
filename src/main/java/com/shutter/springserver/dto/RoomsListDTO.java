package com.shutter.springserver.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomsListDTO {
    private boolean hasRoom;
    private List<RoomDTO> roomsList;
}
