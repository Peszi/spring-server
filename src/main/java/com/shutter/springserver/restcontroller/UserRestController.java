package com.shutter.springserver.restcontroller;

import com.shutter.springserver.attribute.UserAttribute;
import com.shutter.springserver.dto.UserDTO;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.mapper.UserMapper;
import com.shutter.springserver.service.user.ManageUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserMapper userMapper;
    private ManageUserService manageUserService;

    public UserRestController(UserMapper userMapper, ManageUserService manageUserService) {
        this.userMapper = userMapper;
        this.manageUserService = manageUserService;
    }

    @GetMapping("/register/check/email/{email}")
    public ResponseEntity<String> checkEmailAvailability(@PathVariable String email) {
        if (!this.manageUserService.isEmailInUse(email))
            return ResponseEntity.ok("Email available!");
        return new ResponseEntity<>("Email in use!", HttpStatus.CONFLICT);
    }

    @GetMapping("/register/check/name/{name}")
    public ResponseEntity<String> checkNameAvailability(@PathVariable String name) {
        if (!this.manageUserService.isNickInUse(name))
            return ResponseEntity.ok("Nick available!");
        return new ResponseEntity<>("Nick in use!", HttpStatus.CONFLICT);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @ModelAttribute UserAttribute user, BindingResult result) {
        if (result.hasErrors())
            return ResponseEntity.badRequest().body(result.getFieldError().getField() + " " + result.getFieldError().getDefaultMessage());
        this.manageUserService.registerUser(user);
        return ResponseEntity.ok("User account successfully created!");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@AuthenticationPrincipal UserData userData) {
        this.manageUserService.deleteUser(userData);
        return ResponseEntity.ok("User successfuly deleted!");
    }

    @GetMapping("/user")
    public ResponseEntity<UserDTO> getUserData(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.userMapper.userToUserDTO(userData));
    }

//    @GetMapping
//    @RequestMapping("/admin/info")
//    public ResponseEntity<String> getHelloAdmin(@AuthenticationPrincipal UserDataModel currentUser) {
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
//    public ResponseEntity<String> getUsers(@AuthenticationPrincipal UserDataModel currentUser) {
//        return ResponseEntity.ok("Works with Auth! " + currentUser.getUsername() + ":" + currentUser.getId() + " Role " + currentUser.getAuthorities().iterator().next().getAuthority());
//    }
}
