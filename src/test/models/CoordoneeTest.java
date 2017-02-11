package models;

import IUTGo.Models.Coordinates;
import org.junit.After;
import org.junit.Before;

/**
 * Created by axelm on 18/11/2016.
 */
public class CoordoneeTest {
    private Coordinates testCoor;

    @Before
    public void setUp() throws Exception {
        testCoor = new Coordinates(5,5,"Marseille");

    }

    @After
    public void tearDown() throws Exception {

    }

}