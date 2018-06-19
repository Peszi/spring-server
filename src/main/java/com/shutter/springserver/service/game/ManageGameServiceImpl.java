package com.shutter.springserver.service.game;

import com.shutter.springserver.game.GameEventListener;
import com.shutter.springserver.game.dto.GamePrefsModel;
import com.shutter.springserver.game.dto.GameUsersModel;
import com.shutter.springserver.game.dto.ZonesLocationModel;
import com.shutter.springserver.game.dto.utility.GameResultModel;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.key.UserGameAttributes;
import com.shutter.springserver.game.dto.GamePacketModel;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.User;
import com.shutter.springserver.service.room.RoomService;
import com.shutter.springserver.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ManageGameServiceImpl implements ManageGameService, GameEventListener {

    private UserService userService;
    private RoomService roomService;
    private GameService gameService;

    public ManageGameServiceImpl(UserService userService, RoomService roomService, GameService gameService) {
        this.userService = userService;
        this.roomService = roomService;
        this.gameService = gameService;
    }

    @Transactional
    @Override
    public void startGame(UserData userData) {
        this.startGame(this.userService.validateAndGetUser(userData));
    }

    @Transactional
    @Override
    public void finishGame(UserData userData) {
        Room room = this.roomService.validateAndGetByHost(this.userService.validateAndGetUser(userData));
        this.gameService.removeGame(room.getId());
        this.roomService.delete(room);
    }

    @Override
    public GamePrefsModel getGamePrefs(long userId) {
        final Long gameId = this.getUserGameId(userId);
        return this.gameService.getGamePrefs(userId, gameId);
    }

    @Override
    public GameUsersModel getGameUsers(long userId) {
        final Long gameId = this.getUserGameId(userId);
        return this.gameService.getGameUsers(userId, gameId);
    }

    @Override
    public ZonesLocationModel getZonesLocation(long userId) {
        final Long gameId = this.getUserGameId(userId);
        return this.gameService.getZonesLocation(userId, gameId);
    }

    @Override
    public void setUserReady(long userId) {
        final Long gameId = this.getUserGameId(userId);
        this.gameService.setUserReady(userId, gameId);
    }

    @Override
    public void setUserDied(long userId) {
        final Long gameId = this.getUserGameId(userId);
        this.gameService.setUserDied(userId, gameId);
    }

    @Override
    public GamePacketModel getGamePacket(long userId, UserGameAttributes userGameAttributes) {
        final Long gameId = this.getUserGameId(userId);
        return this.gameService.getGamePacket(userId, gameId, userGameAttributes);
    }

    @Override
    public GameResultModel getGameResult(long userId) {
        final Long gameId = this.getUserGameId(userId);
        return this.gameService.getGameResult(userId, gameId);
    }

    @Override
    public void onGameFinished(long roomId) {
        Room room = this.roomService.validateAndGetById(roomId);
        room.setIsStarted(false);
        this.roomService.save(room);
    }

    private void startGame(User user) {
        Room room = this.roomService.validateAndGetByHost(user);
        this.roomService.removeEmptyTeams(room);
        room.setIsStarted(true);
        this.roomService.save(room);
        this.gameService.createGame(room, this);
    }

    private Long getUserGameId(long userId) {
        Long roomId = this.gameService.getGameId(userId);
        if (roomId == null) {// if game crushed last time
//            this.restartGame(userId);
//            throw new BadRequestException("Game is restarted...");
            throw new BadRequestException("Game not exists!");
        }
        return roomId;
    }

    private void restartGame(Long userId) {
        this.startGame(this.userService.validateAndGetUserById(userId));
    }


//    @Override
//    public RoomService getHostRoom(UserDataModel userData) {
//        User user = this.userService.validateAndGetUser(userData);
//        if (!user.hasTeam() || !user.getTeam().hasRoom())
//            throw new NotFoundException("RoomService");
//        if (user.getTeam().validateAndGetByHost().getRoomId() != userData.getId())
//            throw new BadRequestException("User is not a host!");
//        return user.getTeam().validateAndGetByHost();
//    }
}
