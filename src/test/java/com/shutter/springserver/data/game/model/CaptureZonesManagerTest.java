package com.shutter.springserver.data.game.model;

import com.shutter.springserver.data.game.dto.GamePrefsModel;
import com.shutter.springserver.data.game.dto.utility.zone.CptZonePrefsModel;
import com.shutter.springserver.data.game.dto.utility.zone.ZoneModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaptureZonesManagerTest {

    private GamePrefsModel gamePrefsModel;

    private CaptureZonesManager zonesFactory;

    @Before
    public void setUp() throws Exception {
        this.gamePrefsModel = new GamePrefsModel();
        this.gamePrefsModel.setZones(new CptZonePrefsModel(16, 50));
        this.gamePrefsModel.setLocation(new ZoneModel(1, 1, 16));
        this.zonesFactory = new CaptureZonesManager();
    }

    @Test
    public void init() {
        this.zonesFactory.init(gamePrefsModel);
        this.printZones();
        assertEquals(3, this.zonesFactory.getCaptureZones().size());
    }

    @Test
    public void removeAndAddNew() {
        this.zonesFactory.init(gamePrefsModel);
        this.zonesFactory.getCaptureZones().get(0).setOwner("A");
        this.printZones();
//        while (true) {
//            this.zonesFactory.update(1f);
//            if (this.zonesFactory.getCaptureZones().get(0).getOrder() != 0) {
//                break;
//            }
//        }
//        this.printZones();
        assertEquals(3, this.zonesFactory.getCaptureZones().size());
    }

    private void printZones() {
        for (CaptureZone captureZone : this.zonesFactory.getCaptureZones())
            System.out.println("ORDER " + captureZone.getOrder() + " ID " + captureZone.getId());
    }
}