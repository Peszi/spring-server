package com.shutter.springserver.restcontroller.util;

import com.shutter.springserver.dto.BasicUserDTO;
import com.shutter.springserver.service.user.ManageUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO class only for testing proposes
@RestController
public class InfoRestController {

    private ManageUserService manageUserService;

    public InfoRestController(ManageUserService manageUserService) {
        this.manageUserService = manageUserService;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> getPing() {
        return ResponseEntity.ok("pong");
    }

    @GetMapping
    @RequestMapping("/users")
    public ResponseEntity<List<BasicUserDTO>> getHello() {
        return ResponseEntity.ok(this.manageUserService.getAllUsers());
    }
}
