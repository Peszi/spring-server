package com.shutter.springserver.mapper;

import com.shutter.springserver.dto.FullRoomDTO;
import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(source = "isStarted", target = "started")
    RoomDTO roomToRoomDTO(Room room);

    @Mapping(source = "isStarted", target = "started")
//    @Mapping(source = "users", target = "usersList") TODO
    FullRoomDTO roomToFullRoomDTO(Room room);
}
