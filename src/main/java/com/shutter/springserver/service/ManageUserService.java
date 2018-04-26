package com.shutter.springserver.service;

import com.shutter.springserver.mapper.UserDTO;

public interface ManageUserService {
    String registerUser(UserDTO userDTO);
    String deleteUser();
}
