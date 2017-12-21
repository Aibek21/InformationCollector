package kz.kbtu.informationcollector.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aibekkuralbaev on 21.12.2017.
 */

public class LocationInfo {

    @SerializedName("lat")
    private double lat;

    @SerializedName("lon")
    private double lon;


    protected LocationInfo() {}

    private LocationInfo(double lat, double lon) {
       this.lat = lat;
       this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public static LocationInfoBuilder builder(){
        return new LocationInfoBuilder();
    }


    public static class LocationInfoBuilder{


        private double lat;
        private double lon;


        public LocationInfoBuilder setLat(double lat) {
            this.lat = lat;
            return this;
        }

        public LocationInfoBuilder setLon(double lon) {
            this.lon = lon;
            return this;
        }

        public LocationInfo build(){
            return new LocationInfo(lat, lon);
        }
    }

}
