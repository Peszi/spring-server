package com.shutter.springserver.restcontroller.util;

import com.shutter.springserver.data.UserGameData;
import com.shutter.springserver.dto.GameDTO;
import com.shutter.springserver.dto.RoomDTO;
import com.shutter.springserver.data.UserData;
import com.shutter.springserver.service.game.ManageGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/game")
public class GameRestController {

    private ManageGameService manageGameService;

    public GameRestController(ManageGameService manageGameService) {
        this.manageGameService = manageGameService;
    }

    @PostMapping
    public ResponseEntity<String> startGame(@AuthenticationPrincipal UserData userData) { // Host only
        this.manageGameService.startGame(userData);
        return ResponseEntity.ok("Ip ");
    }

    @DeleteMapping
    public ResponseEntity<RoomDTO> endGame(@AuthenticationPrincipal UserData userData) { // Host only
//        return ResponseEntity.ok(this.userRoomService.joinRoom(userData, roomId));
        return null;
    }

    @GetMapping
    public ResponseEntity<GameDTO> getGameData(@AuthenticationPrincipal UserData userData, UserGameData userGameData) {
        return ResponseEntity.ok(this.manageGameService.getGameData(userData.getId(), userGameData));
    }
}
