package com.shutter.springserver.data.status;

import com.shutter.springserver.data.game.GameTeamData;
import com.shutter.springserver.data.game.ZoneData;
import com.shutter.springserver.model.Zone;
import com.shutter.springserver.util.location.LatLng;
import com.shutter.springserver.util.location.SphericalUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Setter
@Getter
public class GameData {

    private static final int RESP_ZONE_RADIUS = 16;

    private ZoneData respZone;

    public GameData() {
        this.respZone = new ZoneData();
    }

    public static void init(List<GameTeamData> teamsData, Zone zone) { // calc resp zone
        final int zonesOffset = new Random().nextInt(360);
        final int zoneAngleStep = 360 / teamsData.size();
        for (int i = 0; i < teamsData.size(); i++) {
            final LatLng zoneLocation = SphericalUtil.computeOffset(zone.getLocation(),
                    zone.getZoneRadius(), zoneAngleStep * i + zonesOffset);
            teamsData.get(i).setResp(new ZoneData(zoneLocation.latitude, zoneLocation.longitude, RESP_ZONE_RADIUS));
        }
    }
}
