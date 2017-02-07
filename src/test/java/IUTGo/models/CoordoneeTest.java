package IUTGo.models;

import IUTGo.Models.Coordonee;
import org.junit.After;
import org.junit.Before;

/**
 * Created by axelm on 18/11/2016.
 */
public class CoordoneeTest {
    private Coordonee testCoor;

    @Before
    public void setUp() throws Exception {
        testCoor = new Coordonee(5,5,"Marseille");

    }

    @After
    public void tearDown() throws Exception {

    }

}