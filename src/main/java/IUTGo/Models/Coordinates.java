package IUTGo.Models;

import java.io.IOException;
import java.io.Serializable;

public class Coordinates implements Serializable
{
    
    private float  latitude;
    private float  longitude;
    private String city;
    
    public Coordinates (float latitude, float longitude, String city) throws IOException
    {
        setLatitude(latitude);
        setLongitude(longitude);
        setCity(city);
    }
    
    //region Getters and Setters
    public float getLatitude ()
    {
        return latitude;
    }
    
    private void setLatitude (float latitude)
    {
        this.latitude = latitude;
    }
    
    public float getLongitude ()
    {
        return longitude;
    }
    
    private void setLongitude (float longitude)
    {
        this.longitude = longitude;
    }
    
    public String getCity ()
    {
        return city;
    }
    
    private void setCity (String city)
    {
        this.city = city;
    }
    //endregion
    
    @Override
    public String toString ()
    {
        return "Coordinates{" + "latitude=" + latitude + ", longitude=" + longitude + ", city='" + city + '\'' + '}';
    }
}