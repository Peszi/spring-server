package com.shutter.springserver.restcontroller;

import com.shutter.springserver.dto.BasicUserDTO;
import com.shutter.springserver.service.ManageUserService;
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

    @GetMapping
    @RequestMapping("/users")
    public ResponseEntity<List<BasicUserDTO>> getHello() {
        return ResponseEntity.ok(this.manageUserService.getAllUsers());
    }
}
