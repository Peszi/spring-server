package com.shutter.springserver.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class RoomsListDTO {
    private boolean hasRoom;
    private Iterable<RoomDTO> roomsList;
}
