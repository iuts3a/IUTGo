package IUTGo.Models.Users;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;

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
            PointInterest.read().get(name).setPrice(price);
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
