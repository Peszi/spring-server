package com.shutter.springserver.data.game.model;

import com.shutter.springserver.data.game.dto.GamePrefsModel;
import com.shutter.springserver.data.game.dto.ZonesLocationModel;
import com.shutter.springserver.data.game.dto.utility.zone.CptZoneDataModel;
import com.shutter.springserver.data.game.dto.utility.zone.ZoneModel;
import com.shutter.springserver.exception.BadRequestException;
import com.shutter.springserver.util.location.LatLng;
import com.shutter.springserver.util.location.SphericalUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Setter
@Slf4j
public class CaptureZonesManager {

    private static final int ZONES_SLOTS_COUNT = 5;
    private static final int ZONES_COUNT = 3;
    private static final int ANGLE_STEP = 360 / ZONES_SLOTS_COUNT;
    private static final float CHANGE_FOR_ZONE = 0.75f;

    // Prefs
    private ZoneModel baseZone;
    private int zoneCapacity;
    private int zonesOffset;

    private int lastZoneId = -1;
    private int captureZoneIdx;
    private List<CaptureZone> captureZones;

    private Random random;

    // dto
    private ZonesLocationModel zonesLocationModel;

    public CaptureZonesManager() {
        this.captureZones = new ArrayList<>();
        this.random = new Random();
        this.zonesLocationModel = new ZonesLocationModel();
    }

    public void init(GamePrefsModel gamePrefsModel) {
        this.baseZone = gamePrefsModel.getLocation();
        this.zoneCapacity = gamePrefsModel.getZones().getCapacity();
        this.zonesOffset = new Random().nextInt(360);
        this.captureZones.clear();
        this.calcZones();
    }

    public void update(float delta) {
        this.removeEmptyZone();
    }

    private void removeEmptyZone() {
        int zoneToRemoveIdx = -1;
        for (int i = 0; i < this.captureZones.size(); i++) {
            if (captureZones.get(i).getPoints() <= 0) {
                zoneToRemoveIdx = i;
            }
        }
        if (zoneToRemoveIdx >= 0) {
            log.warn("Removing Zone id " + zoneToRemoveIdx);
            this.captureZones.remove(zoneToRemoveIdx);
            this.calcZones();
        }
    }

    private void calcZones() {
        int id = 0;
        while(true) {
            if (this.isSlotEmpty(id) && this.lastZoneId != id && this.random.nextFloat() > CHANGE_FOR_ZONE) {
                this.lastZoneId = id;
                final LatLng zoneLocation = SphericalUtil
                        .computeOffset(this.baseZone.getLocation(), this.baseZone.getRadius() / 2,ANGLE_STEP * id + zonesOffset);
                this.captureZones.add(new CaptureZone(id, this.captureZoneIdx++, zoneLocation.latitude, zoneLocation.longitude, this.zoneCapacity));
                log.warn("Adding new Zone id " + id + " order " + (this.captureZoneIdx-1));
                if (this.captureZones.size() >= ZONES_COUNT)
                    break;
            }
            id++;
            if (id >= ZONES_SLOTS_COUNT)
                id = 0;
        }
        this.zonesLocationModel.setup(this.captureZones);
    }

    private boolean isSlotEmpty(int id) {
        for (CaptureZone captureZone : this.captureZones)
            if (captureZone.getId() == id)
                return false;
        return true;
    }

    public void updateZones(List<CptZoneDataModel> cptZoneDataModels) {
        cptZoneDataModels.clear();
        for (CaptureZone captureZone : this.captureZones)
            cptZoneDataModels.add(new CptZoneDataModel(captureZone));
    }

    public List<CaptureZone> getCaptureZones() {
        if (this.captureZones.size() > 0) { return this.captureZones; }
        throw new BadRequestException("There is no capture zone!");
    }

    public ZonesLocationModel getZonesLocationModel() {
        return zonesLocationModel;
    }
}
