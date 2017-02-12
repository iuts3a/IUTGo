package models;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.Admin;
import IUTGo.Models.Users.User;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

/**
 Created by Antoine on 07/02/2017.
 */
public class MainScenario
{
    int xRand = ThreadLocalRandom.current().nextInt(0, 150);
    int yRand = ThreadLocalRandom.current().nextInt(0, 150);
    private Admin adminTest;
    private User  userTest, participanTest;
    private Coordinates coordTest;
    
    @Before
    public void setUp () throws Exception
    {
        adminTest = new Admin("WAYNE", "Bruce", "Batman", "bruce.wayne@mail.fr", "motdepasse", coordTest);
        coordTest = new Coordinates(xRand, yRand, "Paris");
        userTest = new User("WAYNE", "Bruce", "Batman", "bruce.wayne@mail.fr", "motdepasse", coordTest);
        participanTest = new User("kent", "Clark", "Superman", "clark.kent@mail.fr", "motdepasse", coordTest);
    }
    
    @Test
    public void Scenario () throws Exception
    {
        assertEquals(true, userTest.suggestPointInteret("Casino", PointInterestType.MUSEUM, 5, coordTest));
        assertEquals(true, adminTest.validatePointInterest("Casino"));
        assertEquals(true, userTest.createRoadTrip("EnglandRoadTrip"));
        RoadTrip roadTripTest = RoadTrip.read().get("EnglandRoadTrip");
        assertEquals(true, roadTripTest.addParticipants(participanTest));
        assertEquals(true,
                     userTest.addPointInteretToRoadTrip("England roadtrip",
                                                        "Buffalo",
                                                        "Voyage pour faire le tour des coins touristique de l'Angleterre",
                                                        PointInterestType.RESTAURANT,
                                                        10,
                                                        coordTest));
        assertEquals("RoadTrip name=Englant roadtrip, pointInterests=Buffalo, prix Itinéraire=10",
                     roadTripTest.toString());
        assertEquals(true, adminTest.changePricePointInterest("Buffalo", 15));
        assertEquals(15, PointInterest.read().get("Buffalo").getPrice(), 0.0001);
        
        
    }
    
}