package com.shutter.springserver.service;

import com.shutter.springserver.data.UserDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.exception.UserAlreadyExistsException;
import com.shutter.springserver.exception.ServerFailureException;
import com.shutter.springserver.exception.UserNotFoundException;
import com.shutter.springserver.mapper.UserMapper;
import com.shutter.springserver.model.Role;
import com.shutter.springserver.model.User;
import com.shutter.springserver.repository.RoleRepository;
import com.shutter.springserver.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ManageUserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    RoleRepository roleRepository;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    ManageUserService manageUserService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.manageUserService = new ManageUserServiceImpl(userRepository, roleRepository, passwordEncoder, userMapper);
    }

    @Test
    public void registerUser() {
        // Given
        UserDTO userDTO = new UserDTO("name", "name@email.com", "123456");
        when(this.userRepository.findByEmail(userDTO.getEmail())).thenReturn(Optional.empty());
        when(this.userRepository.findByName(userDTO.getNickname())).thenReturn(Optional.empty());
        when(this.roleRepository.findById(1L)).thenReturn(Optional.of(new Role()));
        // When
        this.manageUserService.registerUser(userDTO);
        // Then
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void registerUserExceptionAEE() {
        // Given
        UserDTO userDTO = new UserDTO("name", "name@email.com", "123456");
        when(this.userRepository.findByEmail(userDTO.getEmail())).thenReturn(Optional.of(new User()));
        when(this.userRepository.findByName(userDTO.getNickname())).thenReturn(Optional.empty());
        when(this.roleRepository.findById(1L)).thenReturn(Optional.of(new Role()));
        // When
        this.manageUserService.registerUser(userDTO);
        // Then
        verify(userRepository, never()).save(any(User.class));
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void registerUserExceptionAEU() {
        // Given
        UserDTO userDTO = new UserDTO("name", "name@email.com", "123456");
        when(this.userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(this.userRepository.findByName(userDTO.getNickname())).thenReturn(Optional.of(new User()));
        when(this.roleRepository.findById(anyLong())).thenReturn(Optional.of(new Role()));
        // When
        this.manageUserService.registerUser(userDTO);
        // Then
        verify(userRepository, never()).save(any(User.class));
    }

    @Test(expected = ServerFailureException.class)
    public void registerUserExceptionNoRole() {
        // Given
        UserDTO userDTO = new UserDTO("name", "name@email.com", "123456");
        when(this.userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(this.userRepository.findByName(userDTO.getNickname())).thenReturn(Optional.empty());
        when(this.roleRepository.findById(anyLong())).thenReturn(Optional.empty());
        // When
        this.manageUserService.registerUser(userDTO);
        // Then
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void deleteUser() {
        // Given
        UserData userData = new UserData(1L, "name","name@email.com", "", true, new ArrayList<>());
        when(this.userRepository.findById(userData.getId())).thenReturn(Optional.of(new User()));
        // When
        this.manageUserService.deleteUser(userData);
        // Then
        verify(userRepository, times(1)).delete(any(User.class));
    }

    @Test(expected = UserNotFoundException.class)
    public void deleteUserExceptionNotExists() {
        // Given
        UserData userData = new UserData(1L, "name","name@email.com", "", true, new ArrayList<>());
        when(this.userRepository.findById(userData.getId())).thenReturn(Optional.empty());
        // When
        this.manageUserService.deleteUser(userData);
        // Then
        verify(userRepository, never()).delete(any(User.class));
    }
}