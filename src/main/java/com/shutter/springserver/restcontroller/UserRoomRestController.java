package com.shutter.springserver.restcontroller;

import com.shutter.springserver.data.RoomDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.service.UserRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/user/room")
public class UserRoomRestController {

    private UserRoomService userRoomService;

    public UserRoomRestController(UserRoomService userRoomService) {
        this.userRoomService = userRoomService;
    }

    @PostMapping("/{roomId}")
    public ResponseEntity<RoomDTO> joinRoom(@PathParam("roomId") long roomId, @AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.userRoomService.joinRoom(userData, roomId));
    }

    @DeleteMapping
    public ResponseEntity<String> leaveRoom(@AuthenticationPrincipal UserData userData) {
        this.userRoomService.leaveRoom(userData);
        return ResponseEntity.ok("User left the room!");
    }

    @GetMapping
    public ResponseEntity<RoomDTO> getUserRoom(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.userRoomService.getRoom(userData));
    }

}
