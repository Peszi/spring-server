package com.shutter.springserver.service;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.mapper.UserRowMapper;
import com.shutter.springserver.model.User;
import com.shutter.springserver.model.UserDTO;
import com.shutter.springserver.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.BadClientCredentialsException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByEmail(username);
        if (!user.isPresent())
            throw new BadClientCredentialsException();
        final List<GrantedAuthority> grantedAuthorities = Arrays.asList(new SimpleGrantedAuthority("USER"));
        return new UserData(user.get().getId(), user.get().getEmail(), user.get().getPassword(), user.get().isActive(), grantedAuthorities);
    }

}
