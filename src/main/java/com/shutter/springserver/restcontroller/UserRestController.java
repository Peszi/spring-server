package com.shutter.springserver.restcontroller;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.security.Principal;

@RestController
public class UserRestController {

//    private UserRepository userRepository;
//
//    public UserRestController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping
//    @RequestMapping("/{name}")
//    public ResponseEntity<UserDTO> getUser(@PathParam("name") String name) {
//        return ResponseEntity.ok(this.userRepository.findByName(name));
//    }

    @GetMapping
    @RequestMapping("/")
    public ResponseEntity<String> getHello() {

        return ResponseEntity.ok("Hello outside Auth!");
    }

    @GetMapping
    @RequestMapping("/user")
    public ResponseEntity<String> getUsers(@AuthenticationPrincipal UserData currentUser) {
        return ResponseEntity.ok("Works with Auth! " + currentUser.getUsername() + ":" + currentUser.getId());
    }
}
