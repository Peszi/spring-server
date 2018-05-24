package com.shutter.springserver.mapper;

import com.shutter.springserver.dto.BasicUserDTO;
import com.shutter.springserver.dto.UserDTO;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    BasicUserDTO userToBasicUserDTO(User user);

    @Mapping(source = "username", target = "email")
    UserDTO userToUserDTO(UserData userData);

}
