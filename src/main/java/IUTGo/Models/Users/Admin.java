package IUTGo.Models.Users;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.RoadTrip;

import java.io.IOException;

public class Admin extends User
{
    public Admin (String firstName, String lastName, String userName, String email, String password, Coordinates coordinates)
    {
        super(firstName, lastName, userName, email, password, coordinates);
    }
    
    public boolean changePricePointInterest (String name, float price)
    {
        try
        {
            PointInterest p = PointInterest.read().get(name);
            
            p.setPrice(price);
            PointInterest.read().remove(name);
            p.save();
            
            for (RoadTrip r : RoadTrip.read().values())
            {
                if(r.getPointInterests().containsKey(p.getName()))
                {
                    r.getPointInterests().remove(p.getName());
                    r.getPointInterests().put(p.getName(), p);
                    
                    RoadTrip.read().remove(r.getName());
                    r.save();
                }
            }
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deletePointInterest (String name)
    {
        try
        {
            PointInterest.read().remove(name);
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean validatePointInterest (String name)
    {
        try
        {
            PointInterest.read().get(name).setValidated(true);
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
