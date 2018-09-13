package com.shutter.springserver.repository;

import com.shutter.springserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
    Optional<User> findUserById(Integer id);
    Optional<User> findByEmail(String email);
}
