package com.shutter.springserver.service.user;

import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;

public interface TeamService {
    void save(Team team);
    void delete(Team team);
    void validateHasRoom(Team team);
    Team validateAndGetTeamById(long id);
}
