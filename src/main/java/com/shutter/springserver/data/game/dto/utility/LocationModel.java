package com.shutter.springserver.data.game.dto.utility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shutter.springserver.util.location.LatLng;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocationModel {

    private double lat;
    private double lng;

    public void updateLocation(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @JsonIgnore
    public LatLng getLocation() {
        return new LatLng(this.lat, this.lng);
    }

}
