package models;

import IUTGo.Models.Coordonee;
import IUTGo.Models.PointInteret;
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
        PI = new PointInteret("Parc des Princes","Stade de foot","Stade",20,50,coordonee);


        //Methode nécessaire lors de modification de classe
       //PI.creerFichier();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void like() throws Exception {
        PI.like();
        assertEquals(1,PI.getCoefficient());
    }

    @Test
    public void dislike() throws Exception {
        PI.dislike();
        assertEquals(-1, PI.getCoefficient());

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


    @Test
    public void getNom() throws Exception {
        assertEquals("Parc des Princes",PI.getNom());
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals("Stade de foot",PI.getDescription());
    }

    @Test
    public void getCoordonee() throws Exception {
        assertEquals(coordonee, PI.getCoordonee());
    }

    @Test
    public void getPrixMin() throws Exception {
       assertEquals(20, PI.getPrixMin(),0.0001);
    }

    @Test
    public void setPrixMin() throws Exception {
        PI.setPrixMin(40);
        assertEquals(40,PI.getPrixMin(),0.0001);
    }

    @Test
    public void getPrixMax() throws Exception {

    }

    @Test
    public void setPrixMax() throws Exception {

    }

    @Test
    public void getCoefficient() throws Exception {

    }

    @Test
    public void setCoefficient() throws Exception {

    }

}