package com.shutter.springserver.service.user;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.model.User;

public interface UserService {
    void save(User user);
    void validateInTeam(User user);
    User validateAndGetUser(UserData userData);
    User validateAndGetUserById(long userId);
}
