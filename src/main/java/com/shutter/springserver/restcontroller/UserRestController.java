package com.shutter.springserver.restcontroller;

import com.shutter.springserver.data.UserDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.service.ManageUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private ManageUserService manageUserService;

    public UserRestController(ManageUserService manageUserService) {
        this.manageUserService = manageUserService;
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<String> getUser(@Valid @ModelAttribute UserDTO user, BindingResult result) {
        if (result.hasErrors())
            return ResponseEntity.badRequest().body(result.getFieldError().getField() + " " + result.getFieldError().getDefaultMessage());
        this.manageUserService.registerUser(user);
        return ResponseEntity.ok("User account successfully created!");
    }

    @DeleteMapping
    @RequestMapping("/delete")
    public ResponseEntity<String> getUser(@AuthenticationPrincipal UserData userData) {
        this.manageUserService.deleteUser(userData);
        return ResponseEntity.ok("User successfuly deleted!");
    }

//    @GetMapping
//    @RequestMapping("/admin/info")
//    public ResponseEntity<String> getHelloAdmin(@AuthenticationPrincipal UserData currentUser) {
//        return ResponseEntity.ok("Hello admin!");
//    }
//
//    @GetMapping
//    @RequestMapping("/hello")
//    public ResponseEntity<String> getHello() {
//        return ResponseEntity.ok("Hello from outside of Auth!");
//    }
//
//    @GetMapping
//    @RequestMapping("/api/user")
//    public ResponseEntity<String> getUsers(@AuthenticationPrincipal UserData currentUser) {
//        return ResponseEntity.ok("Works with Auth! " + currentUser.getUsername() + ":" + currentUser.getId() + " Role " + currentUser.getAuthorities().iterator().next().getAuthority());
//    }
}
