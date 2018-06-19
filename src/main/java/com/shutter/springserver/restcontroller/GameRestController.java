package com.shutter.springserver.restcontroller;

import com.shutter.springserver.game.dto.GamePrefsModel;
import com.shutter.springserver.game.dto.GameUsersModel;
import com.shutter.springserver.game.dto.ZonesLocationModel;
import com.shutter.springserver.game.dto.utility.GameResultModel;
import com.shutter.springserver.game.dto.utility.ResultModel;
import com.shutter.springserver.key.UserGameAttributes;
import com.shutter.springserver.game.dto.GamePacketModel;
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
    public ResponseEntity<GamePrefsModel> getGamePrefs(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.gameService.getGamePrefs(userData.getId()));
    }

    @GetMapping("/users")
    public ResponseEntity<GameUsersModel> getGameUsers(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.gameService.getGameUsers(userData.getId()));
    }

    @GetMapping("/zones")
    public ResponseEntity<ZonesLocationModel> getZonesLocation(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.gameService.getZonesLocation(userData.getId()));
    }

    @PostMapping("/ready")
    public ResponseEntity<String> setUserReady(@AuthenticationPrincipal UserData userData) {
        this.gameService.setUserReady(userData.getId());
        return ResponseEntity.ok("User is ready!");
    }

    @PostMapping("/dead")
    public ResponseEntity<?> setUserDied(@AuthenticationPrincipal UserData userData) {
        this.gameService.setUserDied(userData.getId());
        return ResponseEntity.ok("User is dead!");
    }

    @PostMapping("/update")
    public ResponseEntity<GamePacketModel> getGameData(@AuthenticationPrincipal UserData userData, @RequestBody(required = false) UserGameAttributes userGameAttributes) {
        return ResponseEntity.ok(this.gameService.getGamePacket(userData.getId(), userGameAttributes));
    }

    @GetMapping("/results")
    public ResponseEntity<GameResultModel> getGameResult(@AuthenticationPrincipal UserData userData) {
        return ResponseEntity.ok(this.gameService.getGameResult(userData.getId()));
    }
}
