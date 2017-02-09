package models;

import IUTGo.Models.Coordinates;
import IUTGo.Models.Users.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Antoine on 07/02/2017.
 */
public class UtilisateurTest {
    private User userTest;
    private Coordinates coordTest;

    @Before
    public void setUp() throws Exception {
        coordTest = new Coordinates(1,1,"Paris");
        userTest = new User("WAYNE","Bruce","bruce.wayne@live.fr","motdepasse",coordTest);
    }

    @Test
    public void getNom() throws Exception {
        assertEquals("WAYNE",userTest.getNom());
    }

    @Test
    public void setNom() throws Exception {
        userTest.setNom("LEE");
        assertEquals("LEE",userTest.getNom());
    }

}