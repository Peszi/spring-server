package com.shutter.springserver.util.location;

public class LatLng {

    private final int kg;
    public final double latitude;
    public final double longitude;

    public LatLng(double paramDouble1, double paramDouble2) {
        this(1, paramDouble1, paramDouble2);
    }

    LatLng(int paramInt, double paramDouble1, double paramDouble2) {
        this.kg = paramInt;
        if ((-180.0D <= paramDouble2) && (paramDouble2 < 180.0D))
            this.longitude = paramDouble2;
        else
            this.longitude = ((360.0D + (paramDouble2 - 180.0D) % 360.0D) % 360.0D - 180.0D);
        this.latitude = Math.max(-90.0D, Math.min(90.0D, paramDouble1));
    }

    public final String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }
}
