package com.shutter.springserver.data.game;


import com.shutter.springserver.model.Zone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class CaptureZoneData extends ZoneData {
    private String color;

    public CaptureZoneData(double lat, double lng, int radius, String color) {
        super(lat, lng, radius);
        this.color = color;
    }

    public void setup(Zone zone, String color) {
        super.setup(zone);
        this.color = color;
    }

    @Override
    public String toString() {
        return "CaptureZoneData{" +
                "lat=" + this.getLat() +
                "lng=" + this.getLng() +
                "color='" + color + '\'' +
                '}';
    }
}
