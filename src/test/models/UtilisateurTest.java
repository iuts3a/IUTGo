package models;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.Users.User;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

/**
 Created by Antoine on 07/02/2017.
 */
public class UtilisateurTest
{
    private User        userTest;
    private Coordinates coordTest;
    private PointInterest PiTest,PiTest2;
    
    int xRand = ThreadLocalRandom.current().nextInt(0, 150);
    int yRand = ThreadLocalRandom.current().nextInt(0, 150);
    
    
    @Before
    public void setUp () throws Exception
    {

        coordTest = new Coordinates(xRand, yRand, "Paris");
        userTest = new User("WAYNE", "Bruce", "Batman","bruce.wayne@live.fr", "motdepasse", coordTest);
        PiTest = new PointInterest("Buffalo", PointInterestType.RESTAURANT,10,coordTest,userTest);
        PiTest.save();
        PiTest2 = new PointInterest("Buffalo", PointInterestType.RESTAURANT,10,coordTest,userTest);
        PiTest2.save();
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

    @Test
    public void commentPointInteret () throws Exception
    {
        assertEquals(true, userTest.commentPointInteret("Buffalo","Génial",4));
    }

    @Test
    public void createRoadtrip () throws Exception
    {
        assertEquals(true, userTest.createRoadTrip("England roadtrip"));
    }

    @Test
    public void addPointInteretToRoadTrip () throws Exception
    {
        assertEquals(true, userTest.addPointInteretToRoadTrip("England roadtrip","Buffalo","Voyage pour faire le tour des coins touristique de l'Angleterre",PointInterestType.RESTAURANT,10,coordTest));
    }

    @Test
    public void deletePointInteretFromRoadTrip () throws Exception
    {
        assertEquals(true, userTest.deletePointInteretFromRoadTrip("England roadtrip","Buffalo"));
    }

    @Test
    public void addRoadTripToFavorite () throws Exception
    {
        assertEquals(true, userTest.deletePointInteretFromRoadTrip("England roadtrip","Buffalo"));
    }

    
}