package com.shutter.springserver.service.room;

import com.shutter.springserver.key.GameType;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.attribute.ZoneControlAttribute;
import com.shutter.springserver.attribute.ZoneAttribute;

public interface HostRoomService {
    void kickUser(UserData userData, long userId);
    void addTeam(UserData userData, String alias);
    void removeTeam(UserData userData, long teamId);
    void changeGameMode(UserData userData, GameType gameType);
    void changeGameLocation(UserData userData, ZoneAttribute mainZone);
    void changeZoneControlData(UserData userData, ZoneControlAttribute zoneControlData);
}
