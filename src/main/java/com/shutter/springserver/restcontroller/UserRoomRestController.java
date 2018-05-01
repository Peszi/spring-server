package com.shutter.springserver.restcontroller;

import com.shutter.springserver.dto.FullRoomDTO;
import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.service.UserRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user/room")
public class UserRoomRestController {

    private UserRoomService userRoomService;

    public UserRoomRestController(UserRoomService userRoomService) {
        this.userRoomService = userRoomService;
    }

    @PostMapping("/{roomId}")
    public ResponseEntity<RoomDTO> joinRoom(@PathVariable("roomId") long roomId, @AuthenticationPrincipal UserData userData) { // TODO check game status
        return ResponseEntity.ok(this.userRoomService.joinRoom(userData, roomId));
    }

    @DeleteMapping
    public ResponseEntity<String> leaveRoom(@AuthenticationPrincipal UserData userData) { // TODO check game status
        this.userRoomService.leaveRoom(userData);
        return ResponseEntity.ok("User left the roomId!");
    }

    @GetMapping
    public ResponseEntity<FullRoomDTO> getUserRoom(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.userRoomService.getRoom(userData));
    }

    private String getClientIp(HttpServletRequest request) {
        final String requestHeader = request.getHeader("X-FORWARDED-FOR");
        if (requestHeader != null && !requestHeader.isEmpty())
            return requestHeader;
        return request.getRemoteAddr();
    }

}
