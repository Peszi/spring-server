package com.shutter.springserver.data.game;


import com.shutter.springserver.model.Zone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class CaptureZoneData extends ZoneData {

    private String color; // const
    private String owner;
    private float points;
    private boolean capt;

    public CaptureZoneData(double lat, double lng, int radius, String color, int points) {
        super(lat, lng, radius);
        this.color = color;
        this.points = points;
    }

    public int getPoints() {
        return (int) this.points;
    }
}
