package com.shutter.springserver.service;

import com.shutter.springserver.attribute.UserAttribute;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.exception.AlreadyExistsException;
import com.shutter.springserver.exception.NotFoundException;
import com.shutter.springserver.exception.ServerFailureException;
import com.shutter.springserver.mapper.UserMapper;
import com.shutter.springserver.model.Role;
import com.shutter.springserver.model.User;
import com.shutter.springserver.repository.RoleRepository;
import com.shutter.springserver.repository.UserRepository;
import com.shutter.springserver.service.user.ManageUserService;
import com.shutter.springserver.service.user.ManageUserServiceImpl;
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

//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        this.manageUserService = new ManageUserServiceImpl(userRepository, roleRepository, passwordEncoder, userMapper);
//    }
//
//    @Test
//    public void registerUser() {
//        // Given
//        UserAttribute userAttribute = new UserAttribute("name", "name@email.com", "123456");
//        when(this.userRepository.findByEmail(userAttribute.getEmail())).thenReturn(Optional.empty());
//        when(this.userRepository.findByName(userAttribute.getNickname())).thenReturn(Optional.empty());
//        when(this.roleRepository.findById(1L)).thenReturn(Optional.of(new Role()));
//        // When
//        this.manageUserService.registerUser(userAttribute);
//        // Then
//        verify(userRepository, times(1)).save(any(User.class));
//    }
//
//    @Test(expected = AlreadyExistsException.class)
//    public void registerUserExceptionAEE() {
//        // Given
//        UserAttribute userAttribute = new UserAttribute("name", "name@email.com", "123456");
//        when(this.userRepository.findByEmail(userAttribute.getEmail())).thenReturn(Optional.of(new User()));
//        when(this.userRepository.findByName(userAttribute.getNickname())).thenReturn(Optional.empty());
//        when(this.roleRepository.findById(1L)).thenReturn(Optional.of(new Role()));
//        // When
//        this.manageUserService.registerUser(userAttribute);
//        // Then
//        verify(userRepository, never()).save(any(User.class));
//    }
//
//    @Test(expected = AlreadyExistsException.class)
//    public void registerUserExceptionAEU() {
//        // Given
//        UserAttribute userAttribute = new UserAttribute("name", "name@email.com", "123456");
//        when(this.userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
//        when(this.userRepository.findByName(userAttribute.getNickname())).thenReturn(Optional.of(new User()));
//        when(this.roleRepository.findById(anyLong())).thenReturn(Optional.of(new Role()));
//        // When
//        this.manageUserService.registerUser(userAttribute);
//        // Then
//        verify(userRepository, never()).save(any(User.class));
//    }
//
//    @Test(expected = ServerFailureException.class)
//    public void registerUserExceptionNoRole() {
//        // Given
//        UserAttribute userAttribute = new UserAttribute("name", "name@email.com", "123456");
//        when(this.userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
//        when(this.userRepository.findByName(userAttribute.getNickname())).thenReturn(Optional.empty());
//        when(this.roleRepository.findById(anyLong())).thenReturn(Optional.empty());
//        // When
//        this.manageUserService.registerUser(userAttribute);
//        // Then
//        verify(userRepository, never()).save(any(User.class));
//    }
//
//    @Test
//    public void deleteUser() {
//        // Given
//        UserDataModel userData = new UserDataModel(1L, "name","name@email.com", "", true, new ArrayList<>());
//        when(this.userRepository.findById(userData.getId())).thenReturn(Optional.of(new User()));
//        // When
//        this.manageUserService.deleteUser(userData);
//        // Then
//        verify(userRepository, times(1)).delete(any(User.class));
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void deleteUserExceptionNotExists() {
//        // Given
//        UserDataModel userData = new UserDataModel(1L, "name","name@email.com", "", true, new ArrayList<>());
//        when(this.userRepository.findById(userData.getId())).thenReturn(Optional.empty());
//        // When
//        this.manageUserService.deleteUser(userData);
//        // Then
//        verify(userRepository, never()).delete(any(User.class));
//    }
}