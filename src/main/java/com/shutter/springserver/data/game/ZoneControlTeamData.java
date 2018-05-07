package com.shutter.springserver.data.game;

import com.shutter.springserver.constants.ZoneControlConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZoneControlTeamData extends GameTeamData {

    private double respLongitude;
    private double respLatitude;
    private int respRadius;

    public ZoneControlTeamData(String alias) {
        super(alias);
        this.respRadius = ZoneControlConstants.DEFAULT_RESP_RADIUS;
    }
}
