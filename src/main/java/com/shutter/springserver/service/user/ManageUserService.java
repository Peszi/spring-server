package com.shutter.springserver.service.user;

import com.shutter.springserver.dto.BasicUserDTO;
import com.shutter.springserver.attribute.UserDTO;
import com.shutter.springserver.key.UserData;

import java.util.List;

public interface ManageUserService {
    void registerUser(UserDTO userData);
    void deleteUser(UserData userData);
    List<BasicUserDTO> getAllUsers();
}
