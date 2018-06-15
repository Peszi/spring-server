package com.shutter.springserver.game.model;

import com.shutter.springserver.game.CaptureZonesManager;
import com.shutter.springserver.game.dto.GamePrefsModel;
import com.shutter.springserver.game.dto.utility.zone.CptZonePrefsModel;
import com.shutter.springserver.game.dto.utility.zone.ZoneModel;
import org.junit.Before;
import org.junit.Test;

import static com.shutter.springserver.game.util.ZoneControlConstants.ZONES_COUNT;
import static org.junit.Assert.assertEquals;

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
        assertEquals(3, ZONES_COUNT);
    }

    @Test
    public void removeAndAddNew() {
        this.zonesFactory.init(gamePrefsModel);
        this.zonesFactory.getCaptureZones()[0].setOwner("A");
        this.printZones();
//        while (true) {
//            this.zonesFactory.update(1f);
//            if (this.zonesFactory.getCaptureZones().get(0).getOrder() != 0) {
//                break;
//            }
//        }
//        this.printZones();
        assertEquals(3, ZONES_COUNT);
    }

    private void printZones() {
        for (CaptureZone captureZone : this.zonesFactory.getCaptureZones())
            System.out.println("ORDER " + captureZone.getOrder() + " ID " + captureZone.getId());
    }
}