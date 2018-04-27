package com.shutter.springserver.service;

import com.shutter.springserver.data.BasicUserDTO;
import com.shutter.springserver.data.UserDTO;
import com.shutter.springserver.data.UserData;

import java.util.List;

public interface ManageUserService {
    void registerUser(UserDTO userData);
    void deleteUser(UserData userData);
    List<BasicUserDTO> getAllUsers();
}
