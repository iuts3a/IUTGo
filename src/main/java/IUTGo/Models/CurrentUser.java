package IUTGo.Models;

import IUTGo.Models.Users.User;

import java.io.IOException;

public class CurrentUser
{
    private static CurrentUser uniqueInstance;
    private        User        currentUser;
    
    private CurrentUser (String email)
    {
        try
        {
            currentUser = User.read().get(email);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    
    public static synchronized CurrentUser getInstance () // Singleton Pattern
    {
        if(uniqueInstance != null)
        {
            return uniqueInstance;
        }
        return null;
    }
    
    public static void Init (String email)
    {
        uniqueInstance = new CurrentUser(email);
    }
    
    public User getUser ()
    {
        return currentUser;
    }
}
