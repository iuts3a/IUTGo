package models;


import IUTGo.Models.Coordinates;
import IUTGo.Models.Users.User;
import IUTGo.Models.PointInterest;
import IUTGo.Models.RoadTrip;
import IUTGo.Models.PointInterestType;
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

    private PointInterest PI;
    private RoadTrip      itinineraire;
    private Coordinates   coordinates;
    HashMap<String,RoadTrip> tabTest = new HashMap<String, RoadTrip>();


    @Before
    public void setUp() throws Exception {
        coordinates = new Coordinates(3, 4, "Paris");
        PI = new PointInterest("Parc des Princes", PointInterestType.MUSEE, 100, new Coordinates(), new User("Axel", "Mouchiroud", "@", "mdp", new Coordinates()));

        itinineraire = new RoadTrip("Test",new User("Axel","Mouchiroud","@","mdp",new Coordinates()));

     //itinineraire.creerFichier();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addPI() throws Exception {
        itinineraire.addPI(PI);
        assertEquals(true, itinineraire.getListePI().containsKey("Parc des Princes"));
    }

    @Test
    public void deletePI() throws Exception {
        itinineraire.addPI(PI);
        itinineraire.deletePI("Parc des Princes");
        assertEquals(0, itinineraire.getListePI().size());
    }



    @Test
    public void testSave() throws IOException, ClassNotFoundException {
        itinineraire.save();
        tabTest = RoadTrip.read();
        assertEquals(true,tabTest.containsKey("Test"));
    }

    @Test
    public void testRead() throws IOException, ClassNotFoundException {
        tabTest = RoadTrip.read();
        assertEquals(true,tabTest.containsKey("Test"));
    }



    @Test
    public void toStringTest() throws Exception {
        itinineraire.addPI(PI);
    }
}