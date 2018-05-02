package com.shutter.springserver.service.user;

import com.shutter.springserver.dto.BasicUserDTO;
import com.shutter.springserver.dto.UserDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.exception.NotFoundException;
import com.shutter.springserver.exception.ServerFailureException;
import com.shutter.springserver.mapper.UserMapper;
import com.shutter.springserver.model.Role;
import com.shutter.springserver.model.User;
import com.shutter.springserver.repository.RoleRepository;
import com.shutter.springserver.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManageUserServiceImpl implements ManageUserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;

    public ManageUserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public void registerUser(UserDTO userData) {
        if (this.userRepository.findByEmail(userData.getEmail()).isPresent())
            throw new BadRequestException(userData.getEmail() + " already registered!");
        if (this.userRepository.findByName(userData.getNickname()).isPresent())
            throw new BadRequestException(userData.getNickname()+ " already registered!");
        Optional<Role> defaultRole = this.roleRepository.findById(1L);
        if (!defaultRole.isPresent())
            throw new ServerFailureException("no default user role found!");
        User user = new User();
        user.setName(userData.getNickname());
        user.setEmail(userData.getEmail());
        user.setPassword(this.passwordEncoder.encode(userData.getPassword()));
        user.setRoles(Arrays.asList(defaultRole.get()));//
        user.setActive(true);
        this.userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(UserData userData) {
        Optional<User> user = this.userRepository.findById(userData.getId());
        if (!user.isPresent())
            throw new NotFoundException(userData.getUsername());
        this.userRepository.delete(user.get());
    }

    @Override
    public List<BasicUserDTO> getAllUsers() {
        return this.userRepository.findAll()
                .stream()
                .map(this.userMapper::userToBasicUserDTO)
                .collect(Collectors.toList());
    }
}
