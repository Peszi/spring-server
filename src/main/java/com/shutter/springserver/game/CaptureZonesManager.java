package com.shutter.springserver.game;

import com.shutter.springserver.game.dto.GamePrefsModel;
import com.shutter.springserver.game.dto.ZonesLocationModel;
import com.shutter.springserver.game.dto.utility.zone.CptZoneDataModel;
import com.shutter.springserver.game.dto.utility.zone.ZoneModel;
import com.shutter.springserver.game.model.CaptureZone;
import com.shutter.springserver.util.location.LatLng;
import com.shutter.springserver.util.location.SphericalUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

import static com.shutter.springserver.game.util.ZoneControlConstants.*;

@Setter
@Slf4j
public class CaptureZonesManager {

    public static final int ANGLE_STEP = 360 / ZONES_SLOTS_COUNT;

    // Prefs
    private ZoneModel baseZone;
    private int zoneCapacity;
    private int zonesOffset;

    private int lastSlotId = -1;
    private int captureZoneIdx;
    private CaptureZone[] captureZones;

    private Random random;

    // dto
    private ZonesLocationModel zonesLocationModel;

    public CaptureZonesManager() {
        this.captureZones = new CaptureZone[ZONES_COUNT];
        this.random = new Random();
        this.zonesLocationModel = new ZonesLocationModel();
    }

    public void init(GamePrefsModel gamePrefsModel) {
        this.baseZone = gamePrefsModel.getLocation();
        this.zoneCapacity = gamePrefsModel.getZones().getCapacity();
        this.zonesOffset = new Random().nextInt(360);
        this.calcZones();
    }

    public void update(float delta) {
        this.removeEmptyZone();
    }

    private void removeEmptyZone() {
        int zoneToRemoveIdx = 0;
        for (int i = 0; i < ZONES_COUNT; i++) {
            if (captureZones[i] != null && captureZones[i].getPoints() <= 0) {
                log.warn("Removing Zone slot " + captureZones[i].getId() + " idx " + i);
                captureZones[i] = null;
                zoneToRemoveIdx++;
            }
        }
        if (zoneToRemoveIdx > 0)
            this.calcZones();
    }

    private void calcZones() {
        int slotId = 0;
        while(true) {
            if (this.isSlotEmpty(slotId) && this.lastSlotId != slotId && this.random.nextFloat() > CHANCE_FOR_ZONE_APPEAR) {
                log.warn("Adding new Zone slot " + slotId + " locked slot " + this.lastSlotId);
                this.addZone(slotId);
                if (this.getEmptyZoneIdx() < 0)
                    break;
            }
            slotId++;
            if (slotId >= ZONES_SLOTS_COUNT)
                slotId = 0;
        }
        this.zonesLocationModel.setup(this.captureZones);
    }

    private void addZone(int slotId) {
        final int emptyZoneIdx = this.getEmptyZoneIdx();
        final LatLng zoneLocation = SphericalUtil
                .computeOffset(this.baseZone.getLocation(), this.baseZone.getRadius() / 2,ANGLE_STEP * slotId + zonesOffset);
        this.captureZones[emptyZoneIdx] = new CaptureZone(slotId, this.captureZoneIdx++, zoneLocation.latitude, zoneLocation.longitude, this.zoneCapacity);
        this.lastSlotId = slotId;
    }

    private boolean isSlotEmpty(int id) {
        for (CaptureZone captureZone : this.captureZones)
            if (captureZone != null && captureZone.getId() == id)
                return false;
        return true;
    }

    private int getEmptyZoneIdx() {
        for (int i = 0; i < ZONES_COUNT; i++)
            if (this.captureZones[i] == null)
                return i;
        return -1;
    }

    public void updateZones(List<CptZoneDataModel> cptZoneDataModels) {
        cptZoneDataModels.clear();
        for (CaptureZone captureZone : this.captureZones)
            cptZoneDataModels.add(new CptZoneDataModel(captureZone));
    }

    public CaptureZone[] getCaptureZones() { // TODO jackson struggle with less than 3 zones
        return this.captureZones;
    }

    public ZonesLocationModel getZonesLocationModel() {
        return zonesLocationModel;
    }
}
