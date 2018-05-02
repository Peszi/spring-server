package com.shutter.springserver.service.room;

import com.shutter.springserver.data.UserData;

public interface HostRoomService {
    void kickUser(UserData userData, long userId);
    void addTeam(UserData userData, String alias);
    void removeTeam(UserData userData, long teamId);
    void startGame(UserData userData);
    void finishGame(UserData userData);
}
