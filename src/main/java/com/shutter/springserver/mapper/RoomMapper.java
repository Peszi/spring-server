package com.shutter.springserver.mapper;

import com.shutter.springserver.data.RoomDTO;
import com.shutter.springserver.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomDTO roomToRoomDTO(Room room);

//    @Mapping(source = "users", target = "usersList")
//    FullRoomDTO roomToFullRoomDTO(Room room);
}
