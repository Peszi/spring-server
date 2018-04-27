package com.shutter.springserver.restcontroller;

import com.shutter.springserver.data.RoomDTO;
import com.shutter.springserver.data.RoomsListDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.service.ManageRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {

    private ManageRoomService manageRoomService;

    public RoomRestController(ManageRoomService manageRoomService) {
        this.manageRoomService = manageRoomService;
    }

    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.manageRoomService.createRoom(userData));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteRoom(@AuthenticationPrincipal UserData userData) {
        this.manageRoomService.deleteRoom(userData);
        return ResponseEntity.ok("Room successfully deleted!");
    }

    @GetMapping
    public ResponseEntity<RoomsListDTO> getAllRooms(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.manageRoomService.getAllRooms(userData));
    }
}
