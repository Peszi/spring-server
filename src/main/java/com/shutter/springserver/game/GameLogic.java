package com.shutter.springserver.game;

import com.shutter.springserver.game.dto.GameUsersModel;
import com.shutter.springserver.game.dto.utility.*;
import com.shutter.springserver.game.model.CaptureZone;
import com.shutter.springserver.game.model.GameTeamData;
import com.shutter.springserver.game.util.CompareByPoints;
import com.shutter.springserver.util.location.SphericalUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import static com.shutter.springserver.game.util.ZoneControlConstants.CAPTURING_SPEED_GAIN;
import static com.shutter.springserver.game.util.ZoneControlConstants.CURRENT_RESULTS_LIMIT;
import static com.shutter.springserver.game.util.ZoneControlConstants.GAME_RESULTS_LIMIT;

@Slf4j
public class GameLogic {

    static void setupUsers(GameEngine gameEngine) {
        gameEngine.getGameUsersModel().getTeams().clear();
        for (GameTeamData gameTeamData : gameEngine.getTeamsDataList()) {
            List<UserPrefsModel> usersList = new ArrayList<>();
            for (GameUserModel user : gameTeamData.getUsers())
                usersList.add(new UserPrefsModel(user.getName(), user.isReady(), user.isAlive()));
            gameEngine.getGameUsersModel().getTeams().add(new GameTeamModel(gameTeamData.getAlias(), usersList));
        }
    }

    static void updateGameStatus(GameEngine gameEngine) {
        if (GameLogic.isGameReady(gameEngine.getTeamsDataList()))
            gameEngine.getGamePacketModel().setStarted(true);
    }

    private static boolean isGameReady(List<GameTeamData> teamsList) {
        for (GameTeamData teamData : teamsList)
            if (!teamData.isReady())
                return false;
        return true;
    }

    static void calcCapturePoints(float deltaTime, GameEngine gameEngine) {
        Map<GameTeamData, Integer> inZoneTeams = new HashMap<>();
        for (CaptureZone captureZone : gameEngine.getZonesManager().getCaptureZones()) { // per zone
            inZoneTeams.clear();
            for (GameTeamData gameTeamData : gameEngine.getTeamsDataList()) {
                for (GameUserModel userData : gameTeamData.getUsers()) { // per user
                    final float distanceTo = (float) SphericalUtil.computeDistanceBetween(captureZone.getLocation(), userData.getLocation());
                    if (distanceTo < gameEngine.getGamePrefsModel().getZones().getRadius()) {
                        if (inZoneTeams.containsKey(gameTeamData)) {
                            inZoneTeams.put(gameTeamData, inZoneTeams.get(gameTeamData) + 1);
                        } else {
                            inZoneTeams.put(gameTeamData, 1);
                        }
                    }
                }
            }
            if (inZoneTeams.size() > 0) { // TODO full logic
//                for (Map.Entry<GameTeamData, Integer> zoneTeam : inZoneTeams.entrySet()) {
//
//                }
                GameLogic.onZoneCapturing(captureZone, inZoneTeams.entrySet().iterator().next().getKey(), deltaTime);
            } else {
                GameLogic.onZoneCapturing(captureZone, null, deltaTime);
            }
        }
    }

    static void calcResultsList(GameEngine gameEngine) {
        List<ResultModel> results = new ArrayList<>();
        gameEngine.getTeamsDataList().stream().sorted(new CompareByPoints()).limit(CURRENT_RESULTS_LIMIT).forEachOrdered(teamData -> {
            results.add(new ResultModel(teamData.getAlias(), teamData.getPoints()));
        });
        gameEngine.getGamePacketModel().setResults(results);
    }

    static void checkGameResult(GameEngine gameEngine) {
        if (!gameEngine.getGamePacketModel().isFinished()) {
            final boolean isFinishedByTime = (gameEngine.getGamePacketModel().getTime() <= 0);
            if (isFinishedByTime) {
                gameEngine.getTeamsDataList().stream().min(new CompareByPoints())
                        .ifPresent(winnersTeam -> GameLogic.onGameEnd(gameEngine, true, winnersTeam));
            } else {
                gameEngine.getTeamsDataList().stream().filter(gameTeamData -> gameTeamData.getPoints() <= 0).findFirst()
                        .ifPresent(winnersTeam -> GameLogic.onGameEnd(gameEngine, false, winnersTeam));
            }
        }
    }

    // Events

    private static void onGameEnd(GameEngine gameEngine, boolean isFinishedByTime, GameTeamData winnersTeam) {
        if (isFinishedByTime)
            log.info("Game is finished by time");
        log.info("The winner is " + winnersTeam.getAlias());
        // setup game results
        GameResultModel gameResultModel = new GameResultModel();
        gameEngine.getTeamsDataList().stream().sorted(new CompareByPoints()).limit(GAME_RESULTS_LIMIT).forEachOrdered(teamData ->
            gameResultModel.getResults().add(new ResultModel(teamData.getAlias(), teamData.getPoints()))
        );
        gameEngine.setGameResultModel(gameResultModel);
        // setup status
        gameEngine.getGamePacketModel().setStarted(false);
        gameEngine.getGamePacketModel().setFinished(true);
        // stop in db
        gameEngine.getGameListener().onGameFinished(gameEngine.getRoomId());
    }

    private static void onZoneCapturing(CaptureZone captureZoneData, GameTeamData gameTeamData, float delta) {
        if (gameTeamData != null) {
            final float cpt_value = delta * CAPTURING_SPEED_GAIN;
            captureZoneData.setOwner(gameTeamData.getAlias());
            captureZoneData.decreasePoints(cpt_value);
            gameTeamData.decreasePoints(cpt_value);
        } else {
            captureZoneData.setOwner(null);
        }
    }
}
