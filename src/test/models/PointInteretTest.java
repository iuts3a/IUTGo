package models;

import IUTGo.Models.Coordonee;
import IUTGo.Models.PointInteret;
import IUTGo.Models.TypePointInteret;
import IUTGo.Models.Users.Utilisateur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;


/**
 * Created by axelm on 15/11/2016.
 */
public class PointInteretTest {

    private PointInteret PI;
    private Coordonee coordonee;
    HashMap<String,PointInteret> H = new HashMap<String, PointInteret>();


    @Before
    public void setUp() throws Exception {
        coordonee = new Coordonee(3,4,"Paris");
        PI = new PointInteret("Parc des Princes", TypePointInteret.MUSEE,100,new Coordonee(),new Utilisateur("Axel","Mouchiroud","@","mdp",new Coordonee()));


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