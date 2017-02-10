package models;

import IUTGo.Models.Coordinates;
import IUTGo.Models.PointInterest;
import IUTGo.Models.PointInterestType;
import IUTGo.Models.Users.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;


/**
 * Created by axelm on 15/11/2016.
 */
public class PointInterestTest
{

    private PointInterest PI;
    private Coordinates   coordinates;
    HashMap<String,PointInterest> H = new HashMap<String, PointInterest>();


    @Before
    public void setUp() throws Exception {
        coordinates = new Coordinates(3,4,"Paris");
        PI = new PointInterest("Parc des Princes", PointInterestType.MUSEE, 100, new Coordinates(), new User("Axel", "Mouchiroud", "@", "mdp", new Coordinates()));


        //Methode nécessaire lors de modification de classe
      // PI.creerFichier();
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void save() throws Exception {
        PI.save();
        H = PI.read();
        assertEquals(true,H.containsKey("Parc des Princes"));
    }

    @Test
    public void read() throws Exception {
       H = PI.read();
       assertEquals(true,H.containsKey("Parc des Princes"));
    }


}