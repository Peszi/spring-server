package com.shutter.springserver.service;

import com.shutter.springserver.mapper.UserRowMapper;
import com.shutter.springserver.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = this.getUserByEmail(username);
        if (userDTO == null)
            throw new NoSuchElementException();
        final List<GrantedAuthority> grantedAuthorities = Arrays.asList(new SimpleGrantedAuthority("USER"));
        return new User(userDTO.getEmail(), userDTO.getPasswordHash(), userDTO.isActive(), true, true, true, grantedAuthorities);
    }

    private UserDTO getUserByEmail(String email) {
        return this.jdbcTemplate.queryForObject("SELECT `email`,`passwordHash`,`active` FROM `users` WHERE `email`=?", new Object[]{email}, new UserRowMapper());
    }
}
