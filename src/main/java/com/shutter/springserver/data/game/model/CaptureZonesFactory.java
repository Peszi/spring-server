package com.shutter.springserver.data.game.model;

import com.shutter.springserver.data.game.response.models.CaptureZone;
import com.shutter.springserver.data.game.response.models.ZoneModel;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.util.location.LatLng;
import com.shutter.springserver.util.location.SphericalUtil;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Setter
public class CaptureZonesFactory {

    private static final int ZONES_SLOTS_COUNT = 5;
    private static final int ZONES_COUNT = 3;

    // Prefs
    private ZoneModel baseZone;
    private int zoneCapacity;
    private int zonesOffset;

    private int captureZoneIdx;
    private List<CaptureZone> captureZones;

    private Random random;

    public CaptureZonesFactory() {
        this.captureZones = new ArrayList<>();
        this.random = new Random();
    }

    public void init(int zoneCapacity) {
        this.zoneCapacity = zoneCapacity;
        this.zonesOffset = new Random().nextInt(360);
        this.captureZones.clear();
        this.calcZones();
    }

    public void update(float delta) {
        //
    }

    private void calcZones() {
        final int zoneAngleStep = 360 / ZONES_SLOTS_COUNT;
        while(true) {
            this.addNewZone(zoneAngleStep);
            if (this.captureZones.size() >= 3)
                break;
        }
    }

    private void addNewZone(int angleStep) {
        int id = 0;
        while(true) {
            id++;
            if (this.random.nextBoolean()) {
                if (this.isSlotEmpty(id)) {
//                    final LatLng zoneLocation = SphericalUtil
//                            .computeOffset(this.baseZone.getLocation(), this.baseZone.getRadius() / 2,zoneAngleStep * i + zonesOffset);
//                    this.captureZones.add(new CaptureZone(id, this.captureZoneIdx++, zoneLocation.latitude, zoneLocation.longitude, this.zoneCapacity));
                    break;
                }
            }
        }
    }

    private boolean isSlotEmpty(int id) {
        for (CaptureZone captureZone : this.captureZones)
            if (captureZone.getId() == id)
                return false;
        return true;
    }

    private void addCaptureZone(CaptureZone captureZone) {
        this.captureZones.add(this.captureZoneIdx++, captureZone);
    }

    public List<CaptureZone> getCaptureZones() {
        if (this.captureZones.size() > 0) { return this.captureZones; }
        throw new BadRequestException("There is no capture zone!");
    }
}
