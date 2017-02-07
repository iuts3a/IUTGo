package models;

import IUTGo.Models.Coordonee;
import IUTGo.Models.Passager;
import IUTGo.Models.Voyage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static java.lang.System.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Silas on 15/11/2016.
 */
public class VoyageTest {

    Passager bob = new Passager();
    Coordonee depart = new Coordonee(0,0,"Lyon");
    Coordonee arrive = new Coordonee(1,5,"Nice");
    int nombrePassager = 2;
    Date dateDepart = new Date(116,10,15);

    public VoyageTest() throws IOException {
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void creerVoyage() throws Exception {
        Voyage voyageTest = new Voyage(bob,depart,arrive,nombrePassager);
        assertEquals("Voyage{nomConducteur=Passager{nom='defaut', prenom='defaut', mail='defaut@hotmail.fr', numTel='0700000000', conducteur=false}, depart=Coordonee{latitude=0.0, longitude=0.0, ville='Lyon'}, arrive=Coordonee{latitude=1.0, longitude=5.0, ville='Nice'}, nbPassager=2}",voyageTest.toString());

    }

}