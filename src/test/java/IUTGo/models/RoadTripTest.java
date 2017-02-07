package java.IUTGo.models;


import IUTGo.Models.Coordonee;
import IUTGo.Models.PointInteret;
import IUTGo.Models.RoadTrip;
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

    private PointInteret PI;
    private RoadTrip itinineraire;
    private Coordonee coordonee;
    HashMap<String,RoadTrip> tabTest = new HashMap<String, RoadTrip>();


    @Before
    public void setUp() throws Exception {
        coordonee = new Coordonee(3, 4, "Paris");
        PI = new PointInteret("Parc des Princes", "Stade de foot","Stade", 20, 50, coordonee);
        itinineraire = new RoadTrip("Test");

      itinineraire.creerFichier();
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