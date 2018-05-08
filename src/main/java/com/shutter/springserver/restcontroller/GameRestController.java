package com.shutter.springserver.restcontroller;

import com.shutter.springserver.key.UserGameData;
import com.shutter.springserver.data.game.GameData;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.service.game.ManageGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room/game")
public class GameRestController {

    private ManageGameService gameService;

    public GameRestController(ManageGameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<String> startGame(@AuthenticationPrincipal UserData userData) { // Host only
        this.gameService.startGame(userData);
        return ResponseEntity.ok("Game is started!");
    }

    @DeleteMapping
    public ResponseEntity<String> finishGame(@AuthenticationPrincipal UserData userData) { // Host only
        this.gameService.finishGame(userData);
        return ResponseEntity.ok("Game is finished!");
    }

    @GetMapping
    public ResponseEntity<GameData> getGameData(@AuthenticationPrincipal UserData userData, UserGameData userGameData) {
        return ResponseEntity.ok(this.gameService.getGameData(userData.getId(), userGameData));
    }

}
