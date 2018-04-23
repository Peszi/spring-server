package com.shutter.springserver.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

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
//    public ResponseEntity<User> getUser(@PathParam("name") String name) {
//        return ResponseEntity.ok(this.userRepository.findByName(name));
//    }

    @GetMapping
    @RequestMapping("/")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello outside Auth!");
    }

    @GetMapping
    @RequestMapping("/user")
    public ResponseEntity<String> getUsers() {
        return ResponseEntity.ok("Works with Auth!");
    }
}
