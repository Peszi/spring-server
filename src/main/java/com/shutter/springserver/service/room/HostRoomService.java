package com.shutter.springserver.service.room;

import com.shutter.springserver.attribute.GameAttributes;
import com.shutter.springserver.key.GameType;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.attribute.ZoneControlAttributes;
import com.shutter.springserver.attribute.ZoneAttribute;

public interface HostRoomService {
    void deleteRoom(UserData userData);
    void kickUser(UserData userData, long userId);
    void addTeam(UserData userData, String alias);
    void removeTeam(UserData userData, long teamId);
    void changeGameSettings(UserData userData, GameAttributes gameAttributes);
    void changeGameMode(UserData userData, GameType gameType);
    void changeGameLocation(UserData userData, ZoneAttribute mainZone);
    void changeZoneControlData(UserData userData, ZoneControlAttributes zoneControlData);
}
