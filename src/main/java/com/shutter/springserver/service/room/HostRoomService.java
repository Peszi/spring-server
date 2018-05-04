package com.shutter.springserver.service.room;

import com.shutter.springserver.data.GameType;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.dto.ZoneControlDTO;
import com.shutter.springserver.dto.ZoneDTO;

public interface HostRoomService {
    void kickUser(UserData userData, long userId);
    void addTeam(UserData userData, String alias);
    void removeTeam(UserData userData, long teamId);
    void changeGameMode(UserData userData, GameType gameType);
    void changeGameLocation(UserData userData, ZoneDTO mainZone);
    void changeZoneControlData(UserData userData, ZoneControlDTO zoneControlData);
}
