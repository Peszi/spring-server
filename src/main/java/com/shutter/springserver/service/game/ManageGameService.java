package com.shutter.springserver.service.game;

import com.shutter.springserver.game.dto.GamePacketModel;
import com.shutter.springserver.game.dto.GamePrefsModel;
import com.shutter.springserver.game.dto.GameUsersModel;
import com.shutter.springserver.game.dto.ZonesLocationModel;
import com.shutter.springserver.game.dto.utility.GameResultModel;
import com.shutter.springserver.key.UserData;
import com.shutter.springserver.key.UserGameAttributes;

public interface ManageGameService {
    void startGame(UserData userData);
    void finishGame(UserData userData);

    GamePrefsModel getGamePrefs(int userId);
    GameUsersModel getGameUsers(int userId);
    ZonesLocationModel getZonesLocation(int userId);
    void setUserReady(int userId);
    void setUserDied(int userId);
    GamePacketModel getGamePacket(int userId, UserGameAttributes userGameAttributes);
    GameResultModel getGameResult(int userId);
}
