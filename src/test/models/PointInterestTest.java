package models;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.Users.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;


/**
 Created by axelm on 15/11/2016.
 */
public class PointInterestTest
{
    HashMap<String, PointInterest> H = new HashMap<String, PointInterest>();
    private PointInterest PI;
    private Coordinates   coordinates;
    
    @Before
    public void setUp () throws Exception
    {
        coordinates = new Coordinates(3, 4, "Paris");
        PI = new PointInterest("Parc des Princes",
                               PointInterestType.MUSEUM,
                               100,
                               new Coordinates(1, 1, "Paris"),
                               new User("Axel", "Mouchiroud", "Axel", "@", "mdp", new Coordinates(1, 1, "Paris")));
        
        //Methode nécessaire lors de modification de classe
        //PointInterest.createSaveFile();
    }
    
    @After
    public void tearDown () throws Exception
    {
        
    }
    
    @Test
    public void save () throws Exception
    {
        PI.save();
        H = PointInterest.read();
        assertEquals(true, H.containsKey("Parc des Princes"));
    }
    
    @Test
    public void read () throws Exception
    {
        H = PointInterest.read();
        assertEquals(true, H.containsKey("Parc des Princes"));
    }
    
    @Test
    public void addCommentTest ()
    {
        assertEquals(true, PI.addComment("cool", 4));
        assertEquals("cool", PI.getComments().get(0).getMessage());
        assertEquals((Integer) 4, PI.getComments().get(0).getGrade());
        
    }
    
    @Test
    public void getGradeTest ()
    {
        assertEquals(true, PI.addComment("cool", 4));
        assertEquals(true, PI.addComment("frai", 3));
        assertEquals(3.5, PI.getGrade(), 0.1);
    }
    
    
}