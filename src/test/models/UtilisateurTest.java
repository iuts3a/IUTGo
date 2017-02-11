package models;

import IUTGo.Models.Coordinates;
import IUTGo.Models.Users.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 Created by Antoine on 07/02/2017.
 */
public class UtilisateurTest
{
    private User        userTest;
    private Coordinates coordTest;
    
    //            int xRand = ThreadLocalRandom.current().nextInt(0, 150);
    //            int yRand = ThreadLocalRandom.current().nextInt(0, 150);
    
    
    @Before
    public void setUp () throws Exception
    {
        coordTest = new Coordinates(1, 1, "Paris");
        userTest = new User("WAYNE", "Bruce", "Batman","bruce.wayne@live.fr", "motdepasse", coordTest);
    }
    
    @Test
    public void getNom () throws Exception
    {
        assertEquals("WAYNE", userTest.getLastName());
    }
    
    @Test
    public void setNom () throws Exception
    {
        userTest.setLastName("LEE");
        assertEquals("LEE", userTest.getLastName());
    }
    
}