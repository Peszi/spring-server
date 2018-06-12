package com.shutter.springserver.key;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserGameData {
    private double lat;
    private double lng;
    private boolean ready;
}
