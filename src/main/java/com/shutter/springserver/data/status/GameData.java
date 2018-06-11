package com.shutter.springserver.data.status;

import com.shutter.springserver.data.game.CaptureZoneData;
import com.shutter.springserver.data.game.ZoneData;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    private ZoneData baseZone;
    private List<CaptureZoneData> captureZones;
    private ZoneData respZone;

    public GameData() {
        this.baseZone = new ZoneData();
        this.captureZones = new ArrayList<>();
        this.respZone = new ZoneData();
    }

    public void setData() {

    }
}
