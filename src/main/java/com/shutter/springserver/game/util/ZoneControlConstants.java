package com.shutter.springserver.game.util;

public class ZoneControlConstants {

    // DATABASE
    public static final int DEFAULT_POINTS_LIMIT = 1000;
    public static final int DEFAULT_TIME_LIMIT = 1800;
    public static final int DEFAULT_ZONE_CAPACITY = 200;

    // LIMITS
    public static final int CURRENT_RESULTS_LIMIT = 3;
    public static final int GAME_RESULTS_LIMIT = 10;

    // RADIUS
    public static final int RESP_RADIUS = 15;
    public static final int CAPTURE_ZONE_RADIUS = 15;

    // GAINS
    public static final float TIME_SPEED_GAIN = 2f;
    public static final float CAPTURING_SPEED_GAIN = 10f;

    // ZONES
    public static final int ZONES_SLOTS_COUNT = 5;
    public static final int ZONES_COUNT = 3;
    public static final float CHANCE_FOR_ZONE_APPEAR = 0.75f;
}
