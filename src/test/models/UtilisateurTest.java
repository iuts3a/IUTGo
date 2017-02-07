package models;

import IUTGo.Models.Coordonee;
import IUTGo.Models.Users.Utilisateur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Antoine on 07/02/2017.
 */
public class UtilisateurTest {
    private Utilisateur userTest;
    private Coordonee coordTest;

    @Before
    public void setUp() throws Exception {
        coordTest = new Coordonee(1,1,"Paris");
        userTest = new Utilisateur("WAYNE","Bruce","bruce.wayne@live.fr","motdepasse",coordTest);
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