package models;

import IUTGo.Models.Passager;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Silas on 18/10/2016.
 */

public class PassagerTest {

    Passager bob=new Passager();
    String nom="Bruce";
    String prenom="WAYNE";
    String mail="bruce.wayne@live.fr";
    String numTel="0695000000" ;
    boolean conduit=false;

    Passager bruce=new Passager(nom,prenom,mail,numTel,conduit);

    @Test
    public void constructPassagerD() throws Exception {

        assertEquals("Passager{nom='defaut', prenom='defaut', mail='defaut@hotmail.fr', " +
                "numTel='0700000000', conducteur=false}",bob.toString());
        assertEquals("bruce.wayne@live.fr",bruce.getMail());
        assertEquals("Bruce",bruce.getNom());
        assertEquals("WAYNE",bruce.getPrenom());
        assertEquals("0695000000",bruce.getNumTel());

    }
}