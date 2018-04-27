package com.shutter.springserver.mapper;

import com.shutter.springserver.data.BasicUserDTO;
import com.shutter.springserver.data.RoomDTO;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    BasicUserDTO userToBasicUserDTO(User user);

}
