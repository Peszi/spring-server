package com.shutter.springserver.service.user;

import com.shutter.springserver.key.UserData;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.exception.NotFoundException;
import com.shutter.springserver.exception.ServerFailureException;
import com.shutter.springserver.model.User;
import com.shutter.springserver.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void validateInTeam(User user) {
        if (!user.hasTeam())
            throw new BadRequestException("Room not exists!");
        if (!user.getTeam().hasRoom())
            throw new ServerFailureException("Incorrect team, need to be attached to the room!");
    }

    @Override
    public User validateAndGetUser(UserData userData) {
        return this.validateAndGetUserById(userData.getId());
    }

    @Override
    public User validateAndGetUserById(long userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User " + userId));
    }
}
