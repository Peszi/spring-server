package com.shutter.springserver.data.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shutter.springserver.model.User;
import com.shutter.springserver.util.location.LatLng;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameUserData {

    // data
    private long id;
    private String name;
    private boolean died;
    // location
    private double lat;
    private double lng;

    public GameUserData(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.died = false;
    }

    @JsonIgnore
    public LatLng getLocation() {
        return new LatLng(this.lat, this.lng);
    }
}
