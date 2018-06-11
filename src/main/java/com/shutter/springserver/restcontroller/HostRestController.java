package com.shutter.springserver.restcontroller;

import com.shutter.springserver.attribute.GameAttributes;
import com.shutter.springserver.key.GameType;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.attribute.ZoneControlAttributes;
import com.shutter.springserver.attribute.ZoneAttribute;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.service.room.HostRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/room/host/")
public class HostRestController {

    private HostRoomService hostService;

    public HostRestController(HostRoomService hostService) {
        this.hostService = hostService;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> createRoom(@AuthenticationPrincipal UserData userData) {
        this.hostService.deleteRoom(userData);
        return ResponseEntity.ok("Room successfully deleted!");
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

    @PostMapping("/mode/{gameMode}")
    public ResponseEntity<String> changeMode(@AuthenticationPrincipal UserData userData, @PathVariable int gameMode) {
        GameType gameType = GameType.fromInteger(gameMode);
        this.hostService.changeGameMode(userData, gameType);
        return ResponseEntity.ok("Game mode changed to " + gameType.name() + "!");
    }

    @PostMapping("/game")
    public ResponseEntity<?> changeGameSettings(@AuthenticationPrincipal UserData userData, @Valid @ModelAttribute GameAttributes gameAttributes, BindingResult result) {
        if (result.hasErrors())
            throw new BadRequestException(result.getFieldError().getField() + " " + result.getFieldError().getDefaultMessage());
        this.hostService.changeGameSettings(userData, gameAttributes);
        return ResponseEntity.ok("Game settings changed!");
    }

    @PostMapping("/zone")
    public ResponseEntity<String> changeLocation(@AuthenticationPrincipal UserData userData, @Valid @ModelAttribute ZoneAttribute mainZone, BindingResult result) {
        if (result.hasErrors())
            throw new BadRequestException(result.getFieldError().getField() + " " + result.getFieldError().getDefaultMessage());
        this.hostService.changeGameLocation(userData, mainZone);
        return ResponseEntity.ok("Game location changed!");
    }

    @PostMapping("/zoneControl")
    public ResponseEntity<String> changeZoneControlPrefs(@AuthenticationPrincipal UserData userData, @Valid @ModelAttribute ZoneControlAttributes zoneControlData, BindingResult result) {
        if (result.hasErrors())
            throw new BadRequestException(result.getFieldError().getField() + " " + result.getFieldError().getDefaultMessage());
        this.hostService.changeZoneControlData(userData, zoneControlData);
        return ResponseEntity.ok("Game prefs changed!");
    }
}
