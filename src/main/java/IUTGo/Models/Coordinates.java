package IUTGo.Models;

import java.io.Serializable;

public class Coordinates implements Serializable {

    private float latitude;
    private float longitude;
    private String town;

    public Coordinates(float latitude, float longitude, String town) {
        setLatitude(latitude);
        setLongitude(longitude);
        setTown(town);
    }

    //region Getters and Setters
    public float getLatitude() {
        return latitude;
    }

    private void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    private void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getTown() {
        return town;
    }

    private void setTown(String town) {
        this.town = town;
    }
    //endregion

    @Override
    public String toString() {
        return "Coordinates{" + "latitude=" + latitude + ", longitude=" + longitude + ", town='" + town + '\'' + '}';
    }
}