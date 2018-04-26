package com.shutter.springserver.service;

import com.shutter.springserver.mapper.UserDTO;
import com.shutter.springserver.model.User;
import com.shutter.springserver.repository.RoleRepository;
import com.shutter.springserver.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ManageUserServiceImpl implements ManageUserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public ManageUserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String registerUser(UserDTO userDTO) {
        if (this.userRepository.findByEmail(userDTO.getEmail()).isPresent())
            return "Email in use " + userDTO.getEmail() + "!";
        if (this.userRepository.findByName(userDTO.getNickname()).isPresent())
            return "Nickname already taken !";
        User user = new User();
        user.setName(userDTO.getNickname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(Arrays.asList(roleRepository.findById(1L).get()));
        user.setActive(true);
        this.userRepository.save(user);
        return "Successfully registered!";
    }

    @Override
    public String deleteUser() { // TODO removing account
        return "";
    }
}
