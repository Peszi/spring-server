package com.shutter.springserver.service.user;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.exception.NotFoundException;
import com.shutter.springserver.model.User;
import com.shutter.springserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void fetchUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User getUser(UserData userData) {
        Optional<User> user = this.userRepository.findById(userData.getId());
        if (!user.isPresent())
            throw new NotFoundException("User " + userData.getUsername());
        return user.get();
    }
}
