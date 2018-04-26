package com.shutter.springserver.restcontroller;

import com.shutter.springserver.data.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/admin/info")
    public ResponseEntity<String> getHelloAdmin(@AuthenticationPrincipal UserData currentUser) {
        return ResponseEntity.ok("Hello admin!");
    }

    @GetMapping
    @RequestMapping("/")
    public ResponseEntity<String> getHello() {

        return ResponseEntity.ok("Hello from outside of Auth!");
    }

    @GetMapping
    @RequestMapping("/api/user")
    public ResponseEntity<String> getUsers(@AuthenticationPrincipal UserData currentUser) {
        return ResponseEntity.ok("Works with Auth! " + currentUser.getUsername() + ":" + currentUser.getId() + " Role " + currentUser.getAuthorities().iterator().next().getAuthority());
    }
}
