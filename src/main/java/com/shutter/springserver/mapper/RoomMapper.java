package com.shutter.springserver.mapper;

import com.shutter.springserver.dto.FullRoomDTO;
import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.dto.TeamDTO;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mappings({
            @Mapping(source = "host.name", target = "hostName"),
            @Mapping(source = "isStarted", target = "started")
    })
    RoomDTO roomToRoomDTO(Room room);

    @Mapping(source = "users", target = "usersList")
    TeamDTO teamToTeamDTO(Team team);

    @Mappings({
            @Mapping(source = "host.name", target = "hostName"),
            @Mapping(source = "teams", target = "teamsList"),
            @Mapping(source = "isStarted", target = "started")
    })
    FullRoomDTO roomToFullRoomDTO(Room room);
}
