package com.shutter.springserver.data.status;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shutter.springserver.attribute.ZoneAttribute;
import com.shutter.springserver.attribute.ZoneControlAttributes;
import com.shutter.springserver.constants.ZoneControlConstants;
import com.shutter.springserver.data.game.CaptureZoneData;
import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.ZoneData;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Zone;
import com.shutter.springserver.util.location.LatLng;
import com.shutter.springserver.util.location.SphericalUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Setter
@Getter
public class GameStatus {

    private static final String[] ZONES = {"green", "cyan", "yellow"};

    private static final int CAPTURE_ZONE_RADIUS = 15;

    private float gameTime;
    private boolean inGame;

    private ZoneData baseZone;
    private List<CaptureZoneData> captureZones;

    // Constant
    private ZoneControlAttributes attributes;

    public GameStatus() {
        this.captureZones = new ArrayList<>();
        this.attributes = new ZoneControlAttributes();
    }

    public void init(Zone zone, ZoneControlAttributes gameAttributes) {
        this.setBaseZone(new ZoneData(zone));
        this.initCaptureZones(zone.getLocation(), zone.getZoneRadius()/2, gameAttributes.getZoneCapacity());
    }

    public void updateTime(float deltaTime) {
        this.gameTime += deltaTime;
    }

    public int getGameTime() {
        return (int) gameTime;
    }

    private void initCaptureZones(LatLng center, int offset, int zoneCap) {
        CaptureZoneData captureZoneData;
        final int captureZonesCount = 3;
        final int zonesOffset = new Random().nextInt(360);
        final int zoneAngleStep = 360 / captureZonesCount;
        this.captureZones.clear();
        for (int i = 0; i < captureZonesCount; i++) {
            final LatLng zoneLocation = SphericalUtil.computeOffset(center, offset,zoneAngleStep * i + zonesOffset);
            captureZoneData = new CaptureZoneData(zoneLocation.latitude, zoneLocation.longitude, CAPTURE_ZONE_RADIUS, ZONES[i], zoneCap);
            this.captureZones.add(captureZoneData);
            System.out.println(captureZoneData.toString());
        }
    }
}
