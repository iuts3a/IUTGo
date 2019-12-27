package models;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

/**
 * Created by Antoine on 07/02/2017.
 */
public class UserTest {
    int xRand = ThreadLocalRandom.current().nextInt(0, 150);
    int yRand = ThreadLocalRandom.current().nextInt(0, 150);
    private User userTest;
    private Coordinates coordTest;
    private PointInterest PiTest, PiTest2;

    @Before
    public void setUp() throws Exception {
        //User.createSaveFile();
        coordTest = new Coordinates(xRand, yRand, "Paris");
        userTest = new User("WAYNE", "Bruce", "Batman", "bruce.wayne@live.fr", "motdepasse", coordTest);
        PiTest = new PointInterest("Buffalo", PointInterestType.RESTAURANT, 10, coordTest, userTest);
        PiTest.save();
        PiTest2 = new PointInterest("Buffalo", PointInterestType.RESTAURANT, 10, coordTest, userTest);
        PiTest2.save();
    }

    @Test
    public void commentPointInteretTest() throws Exception {
        assertEquals(true, userTest.commentPointInteret("Buffalo", "Génial", 4));
        assertEquals((Integer) 4, PointInterest.read().get("Buffalo").getComments().get(0).getGrade());
    }

    @Test
    public void createRoadtripTest() throws Exception {
        assertEquals(true, userTest.createRoadTrip("England roadtrip"));
        assertEquals(true, RoadTrip.read().containsKey("England roadtrip"));
    }

    @Test
    public void deleteRoadTripTest() throws IOException, ClassNotFoundException {
        assertEquals(true, userTest.createRoadTrip("TESTTTT"));
        assertEquals(true, RoadTrip.read().containsKey("TESTTTT"));
        assertEquals(true, userTest.deleteRoadTrip("TESTTTT"));
        assertEquals(false, RoadTrip.read().containsKey("TESTTTT"));
    }

    @Test
    public void suggestPointInteretTest() throws IOException, ClassNotFoundException {
        assertEquals(true, userTest.suggestPointInteret("Stade", PointInterestType.CHURCH, 5, coordTest));
        assertEquals(true, PointInterest.read().containsKey("Stade"));
    }

    @Test
    public void addPointInteretToRoadTripTest() throws Exception {
       /* //Deja contenue
        assertEquals(false,
                     userTest.addPointInteretToRoadTrip("England roadtrip",
                                                        "Buffalo",
                                                        "Voyage pour faire le tour des coins touristique de l'Angleterre",
                                                        PointInterestType.RESTAURANT,
                                                        10,
                                                        coordTest));
        //Bien contenue dans le road
        assertEquals(true, RoadTrip.read().get("England roadtrip").getPointInterests().containsKey("Buffalo"));
        */
    }

    @Test
    public void deletePointInteretFromRoadTripTest() throws Exception {
        assertEquals(true, userTest.deletePointInteretFromRoadTrip("England roadtrip", "Buffalo"));
        assertEquals(false, RoadTrip.read().get("England roadtrip").getPointInterests().containsKey(PiTest.getName()));
    }

    @Test
    public void signInTest() throws IOException, ClassNotFoundException {
        userTest.signIn("England roadtrip");
        assertEquals(true, RoadTrip.read().get("England roadtrip").getParticipants().containsKey(userTest.getEmail()));
    }

    @Test
    public void signOutTest() throws IOException, ClassNotFoundException {
        userTest.signOut("England roadtrip");
        assertEquals(false, RoadTrip.read().get("England roadtrip").getParticipants().containsKey(userTest.getEmail()));
    }


    @Test
    public void addRoadTripToFavoriteTest() throws Exception {
        assertEquals(true, userTest.addRoadTripToFavorite("England roadtrip"));
        userTest.save();
        assertEquals("England roadtrip", User.read().get(userTest.getEmail()).getFavoriteRoadTrips().get(0).getName());

    }


    @Test
    public void getRoadTripPriceTest() throws Exception {
      /*  userTest.addPointInteretToRoadTrip("England roadtrip",
                                           "Buffalo",
                                           "Voyage pour faire le tour des coins touristique de l'Angleterre",
                                           PointInterestType.RESTAURANT,
                                           10,
                                           coordTest);
        
        assertEquals(10, userTest.getRoadTripPrice("England roadtrip"), 0.0001);
   */
    }


    @Test
    public void getRoadTripByScore() {
        //System.out.print(userTest.getRoadTripByScore(4));


    }

    @Test
    public void saveTest() throws IOException, ClassNotFoundException {
        userTest.save();
        assertEquals(true, User.read().containsKey(userTest.getEmail()));
    }

    @Test
    public void readTest() throws IOException, ClassNotFoundException {
        assertEquals(true, User.read().containsKey(userTest.getEmail()));
    }
}