package com.shutter.springserver.restcontroller;

import com.shutter.springserver.dto.FullRoomDTO;
import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.dto.RoomsListDTO;
import com.shutter.springserver.model.ModeZoneControl;
import com.shutter.springserver.service.room.UserRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoomRestController {

    private UserRoomService userRoomService;

    public RoomRestController(UserRoomService userRoomService) {
        this.userRoomService = userRoomService;
    }

    @PostMapping("/room")
    public ResponseEntity<RoomDTO> createRoom(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.userRoomService.createRoom(userData));
    }

    @PostMapping("/room/team/{teamId}")
    public ResponseEntity<String> changeTeam(@AuthenticationPrincipal UserData userData, @PathVariable int teamId) {
        this.userRoomService.changeTeam(userData, teamId);
        return ResponseEntity.ok("User succesfully changed the room!");
    }

    @GetMapping("/room")
    public ResponseEntity<FullRoomDTO> getUserRoom(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.userRoomService.getRoom(userData));
    }

    @GetMapping("/room/zoneControl")
    public ResponseEntity<ModeZoneControl> getZoneControl(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.userRoomService.getZoneControl(userData));
    }

    @GetMapping("/rooms")
    public ResponseEntity<RoomsListDTO> getAllRooms(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.userRoomService.getAllRooms(userData));
    }

    @PostMapping("/rooms/{roomId}")
    public ResponseEntity<RoomDTO> joinRoom(@PathVariable("roomId") int roomId, @AuthenticationPrincipal UserData userData) { // TODO check game alive
        return ResponseEntity.ok(this.userRoomService.joinRoom(userData, roomId));
    }

    @DeleteMapping("/rooms")
    public ResponseEntity<String> leaveRoom(@AuthenticationPrincipal UserData userData) { // TODO check game alive
        this.userRoomService.leaveRoom(userData);
        return ResponseEntity.ok("User left the roomId!");
    }
}
