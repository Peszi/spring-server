package com.shutter.springserver.game.util;

import com.shutter.springserver.game.model.GameTeamData;

import java.util.Comparator;

public class CompareByPoints implements Comparator<GameTeamData> {

    @Override
    public int compare(GameTeamData teamA, GameTeamData teamB) {
        return teamA.getPoints() - teamB.getPoints();
    }
}