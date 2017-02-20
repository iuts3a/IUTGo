package models;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.Users.Admin;
import org.junit.Test;

import static IUTGo.Models.PointInterestType.CHURCH;
import static junit.framework.Assert.assertEquals;

public class AdminTest
{
    @Test
    public void changePricePointInterest () throws Exception
    {
        Coordinates coordinates = new Coordinates(42, 22, "Lille");
        Admin admin = new Admin("Michel", "Jacques", "MJ", "mj@mj.fr", "mjpasse", coordinates);
        PointInterest pointInterest = new PointInterest("p1", CHURCH, 100, coordinates, admin);
        pointInterest.save();
        assertEquals(true, admin.changePricePointInterest("p1", 22));
    }
    
    @Test
    public void deletePointInterest () throws Exception
    {
        Coordinates coordinates = new Coordinates(42, 22, "Lille");
        Admin admin = new Admin("Michel", "Jacques", "MJ", "mj@mj.fr", "mjpasse", coordinates);
        PointInterest pointInterest = new PointInterest("p1", CHURCH, 100, coordinates, admin);
        pointInterest.save();
        assertEquals(true, admin.deletePointInterest("p1"));
        
    }
    
    @Test
    public void validatePointInterest () throws Exception
    {
        Coordinates coordinates = new Coordinates(42, 22, "Lille");
        Admin admin = new Admin("Michel", "Jacques", "MJ", "mj@mj.fr", "mjpasse", coordinates);
        PointInterest pointInterest = new PointInterest("p1", CHURCH, 100, coordinates, admin);
        pointInterest.save();
        assertEquals(true, admin.validatePointInterest("p1"));
    }
}