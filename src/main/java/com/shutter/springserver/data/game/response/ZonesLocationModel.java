package com.shutter.springserver.data.game.response;

import com.shutter.springserver.data.game.response.models.ZoneLocationModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ZonesLocationModel {

    private List<ZoneLocationModel> zones;

}
