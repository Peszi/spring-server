package com.shutter.springserver.mapper;

import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.dto.TeamDTO;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(source = "users", target = "usersList")
    TeamDTO teamToTeamDTO(Team team);

}
