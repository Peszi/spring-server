package com.shutter.springserver.restcontroller;

import com.shutter.springserver.data.UserData;
import com.shutter.springserver.service.room.HostRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room/host/")
public class HostRestController {

    private HostRoomService hostService;

    public HostRestController(HostRoomService hostService) {
        this.hostService = hostService;
    }

    @DeleteMapping("/kick/{userId}")
    public ResponseEntity<String> kickUser(@AuthenticationPrincipal UserData userData, @PathVariable long userId) {
        this.hostService.kickUser(userData, userId);
        return ResponseEntity.ok("User successfully kicked!");
    }

    @PostMapping("/team/{alias}")
    public ResponseEntity<String> addTeam(@AuthenticationPrincipal UserData userData, @PathVariable String alias) {
        this.hostService.addTeam(userData, alias);
        return ResponseEntity.ok("Team successfully created!");
    }

    @DeleteMapping("/team/{teamId}")
    public ResponseEntity<String> removeTeam(@AuthenticationPrincipal UserData userData, @PathVariable long teamId) {
        this.hostService.removeTeam(userData, teamId);
        return ResponseEntity.ok("Team successfully removed!");
    }

    @PostMapping("/game")
    public ResponseEntity<String> startGame(@AuthenticationPrincipal UserData userData) {
        this.hostService.startGame(userData);
        return ResponseEntity.ok("Team successfully created!");
    }

    @DeleteMapping("/game")
    public ResponseEntity<String> finishGame(@AuthenticationPrincipal UserData userData) { // TODO
        this.hostService.finishGame(userData);
        return ResponseEntity.ok("Team successfully removed!");
    }
}
