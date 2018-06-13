package com.shutter.springserver.data.game.response.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shutter.springserver.util.location.LatLng;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LocationModel {

    private double lat;
    private double lng;

    @JsonIgnore
    public LatLng getLocation() {
        return new LatLng(this.lat, this.lng);
    }

}
