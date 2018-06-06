package com.shutter.springserver.data.zonecontrol;

import com.shutter.springserver.data.game.CaptureZoneData;
import com.shutter.springserver.data.game.ZoneData;
import com.shutter.springserver.data.status.GameStatus;
import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.Zone;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ZoneControlGameStatus extends GameStatus {

    private static final String[] ZONES = {"green", "cyan", "yellow"};

    private List<CaptureZoneData> captureZones;

    public ZoneControlGameStatus() {
        super();
        this.captureZones = new ArrayList<>();
    }

    @Override
    public void setup(Room room) {
        super.setup(room);
        CaptureZoneData captureZoneData;
        for (int i = 0; i < 3; i++) {
            captureZoneData = new CaptureZoneData(
                    room.getMainZone().getZoneLatitude() + i * 0.0006d - 0.0006d,
                    room.getMainZone().getZoneLongitude() + i * 0.0006d - 0.0006d, 15, ZONES[i]);
            this.captureZones.add(captureZoneData);
            System.out.println(captureZoneData.toString());
        }
    }
}
