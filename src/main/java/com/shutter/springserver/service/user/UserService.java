package com.shutter.springserver.service.user;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.model.User;

public interface UserService {
    void fetchUser(User user);
    User getUser(UserData userData);
}
