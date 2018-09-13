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

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mappings({
            @Mapping(source = "host.name", target = "hostName"),
            @Mapping(source = "started", target = "started"),
            @Mapping(source = "createdDate", target = "createdAt"),
            @Mapping(source = "zone.lat", target = "zoneLat"),
            @Mapping(source = "zone.lng", target = "zoneLng"),
            @Mapping(source = "zone.radius", target = "zoneRadius")
    })
    RoomDTO roomToRoomDTO(Room room);

    @Mapping(source = "users", target = "usersList")
    TeamDTO teamToTeamDTO(Team team);

    @Mappings({
            @Mapping(source = "host.name", target = "hostName"),
            @Mapping(source = "started", target = "started"),
            @Mapping(source = "createdDate", target = "createdAt"),
            @Mapping(source = "zone.lat", target = "zoneLat"),
            @Mapping(source = "zone.lng", target = "zoneLng"),
            @Mapping(source = "zone.radius", target = "zoneRadius"),
            @Mapping(source = "teams", target = "teamsList")
    })
    FullRoomDTO roomToFullRoomDTO(Room room);
}
