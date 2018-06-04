package com.shutter.springserver.service.room;

import com.shutter.springserver.dto.FullRoomDTO;
import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.dto.ZoneControlDTO;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.dto.RoomsListDTO;
import com.shutter.springserver.model.ModeZoneControl;

public interface UserRoomService {
    RoomDTO createRoom(UserData userData);
    void changeTeam(UserData userData, long teamId);
    RoomDTO joinRoom(UserData userData, long roomId);
    void leaveRoom(UserData userData);
    FullRoomDTO getRoom(UserData userData);
    ModeZoneControl getZoneControl(UserData userData);
    RoomsListDTO getAllRooms(UserData userData);
}
