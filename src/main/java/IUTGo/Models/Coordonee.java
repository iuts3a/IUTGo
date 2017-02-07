package IUTGo.Models;

import java.io.IOException;
import java.io.Serializable;

public class Coordonee implements Serializable {

    private float latitude;
    private float longitude;
    private String ville;

    public Coordonee(float latitude, float longitude, String ville) throws IOException {
        this.latitude = latitude;
        this.longitude = longitude;
        this.ville = ville;
    }

    public Coordonee() {
        this.latitude = 1;
        this.longitude = 1;
        this.ville = "Paris";
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Coordonee{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", ville='" + ville + '\'' +
                '}';
    }
}