package com.shutter.springserver.service.game;

import com.shutter.springserver.key.UserData;
import com.shutter.springserver.key.UserGameData;
import com.shutter.springserver.data.game.GameData;
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
public class ManageGameServiceImpl implements ManageGameService {

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
    public GameData getGameData(long userId, UserGameData userGameData) {
        Long roomId = this.gameService.getGameId(userId);
        if (roomId == null) {// if game crushed last time
            rerunGame(userId);
            throw new BadRequestException("Game is restarted...");
        }
        return this.gameService.getGameData(userId, roomId, userGameData);
    }

    private void rerunGame(Long userId) {
        this.startGame(this.userService.validateAndGetUserById(userId));
    }

    private void startGame(User user) {
        Room room = this.roomService.validateAndGetByHost(user);
        this.roomService.removeEmptyTeams(room);
        room.setIsStarted(true);
        this.roomService.save(room);
        this.gameService.createGame(room);
    }


//    @Override
//    public RoomService getHostRoom(UserData userData) {
//        User user = this.userService.validateAndGetUser(userData);
//        if (!user.hasTeam() || !user.getTeam().hasRoom())
//            throw new NotFoundException("RoomService");
//        if (user.getTeam().validateAndGetByHost().getHostId() != userData.getId())
//            throw new BadRequestException("User is not a host!");
//        return user.getTeam().validateAndGetByHost();
//    }
}
