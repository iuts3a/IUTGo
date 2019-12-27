package models;


import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.Users.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by axelm on 15/11/2016.
 */
public class RoadTripTest {

    HashMap<String, RoadTrip> tabTest = new HashMap<String, RoadTrip>();
    private PointInterest PI;
    private RoadTrip itinineraire;
    private RoadTrip itinineraire2;
    private Coordinates coordinates;

    @Before
    public void setUp() throws Exception {
        coordinates = new Coordinates(3, 4, "Paris");
        PI = new PointInterest("Parc des Princes",
                PointInterestType.MUSEUM,
                100,
                new Coordinates(1, 1, "Paris"),
                new User("Axel", "Mouchiroud", "Axel", "@", "mdp", new Coordinates(1, 1, "Paris")));

        itinineraire = new RoadTrip("Test",
                new User("Axel", "Mouchiroud", "Axel", "@", "mdp", new Coordinates(1, 1, "Paris")));
        itinineraire2 = new RoadTrip("Test2",
                new User("Axel",
                        "Mouchiroud",
                        "Axel",
                        "@",
                        "mdp",
                        new Coordinates(1, 1, "Paris")));
        //RoadTrip.createSaveFile();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addPI() throws Exception {
        itinineraire.addPointInterest(PI);
        assertEquals(true, itinineraire.getPointInterests().containsKey("Parc des Princes"));
        assertEquals(1, itinineraire.getPointInterests().size());
    }

    @Test
    public void deletePI() throws Exception {
        itinineraire.addPointInterest(PI);
        assertEquals(true, itinineraire.getPointInterests().containsKey("Parc des Princes"));
        assertEquals(1, itinineraire.getPointInterests().size());
        itinineraire.deletePointInterest("Parc des Princes");
        assertEquals(false, itinineraire.getPointInterests().containsKey("Parc des Princes"));
        assertEquals(0, itinineraire.getPointInterests().size());
    }

    @Test
    public void testSave() throws IOException, ClassNotFoundException {
        itinineraire.save();
        tabTest = RoadTrip.read();
        assertEquals(true, tabTest.containsKey("Test"));
    }

    @Test
    public void testRead() throws IOException, ClassNotFoundException {
        tabTest = RoadTrip.read();
        assertEquals(true, tabTest.containsKey("Test"));
    }

    @Test
    public void getGrade() {
        PI.addComment("Note", 4);
        itinineraire.addPointInterest(PI);
        assertEquals(4, itinineraire.getGrade(), 0.1);

    }

    @Test
    public void addParticipants() throws IOException {
        itinineraire.addParticipants(new User("Axel",
                "Mouchiroud",
                "Axel",
                "@",
                "mdp",
                new Coordinates(1, 1, "Paris")));
        assertEquals(true, itinineraire.getParticipants().containsKey("@"));
        assertEquals(1, itinineraire.getParticipants().size());
        itinineraire.addParticipants(new User("Axel",
                "Mouchiroud",
                "Axel",
                "55",
                "mdp",
                new Coordinates(1, 1, "Paris")));
        assertEquals(false, itinineraire.getParticipants().containsKey("aaa"));
        assertEquals(true, itinineraire.getParticipants().containsKey("55"));
        assertEquals(2, itinineraire.getParticipants().size());

    }

    @Test
    public void deletePartipants() throws IOException {
        itinineraire.addParticipants(new User("Axel",
                "Mouchiroud",
                "Axel",
                "@",
                "mdp",
                new Coordinates(1, 1, "Paris")));
        assertEquals(true, itinineraire.getParticipants().containsKey("@"));
        assertEquals(1, itinineraire.getParticipants().size());
        itinineraire.deleteParticipants("@");
        assertEquals(false, itinineraire.getParticipants().containsKey("@"));
        assertEquals(0, itinineraire.getParticipants().size());
    }

    @Test
    public void deleteTest() throws IOException, ClassNotFoundException {
        itinineraire2.save();
        assertEquals(true, RoadTrip.read().containsKey(itinineraire2.getName()));
        itinineraire2.delete();
        assertEquals(false, RoadTrip.read().containsKey(itinineraire2.getName()));
    }


}