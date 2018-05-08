package com.shutter.springserver.key;

public enum GameType {

    BATTLE_ROYAL,
    ZONE_CONTROL;

    public static GameType fromInteger(int gameType) {
        switch(gameType) {
            case 0: return BATTLE_ROYAL;
            case 1: return ZONE_CONTROL;
        }
        return BATTLE_ROYAL;
    }
}

// capture point center, radius,
