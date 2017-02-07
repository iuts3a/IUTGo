package models;

import IUTGo.Models.Position;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author vnahi
 * @package IUTGo.Models
 */
public class PositionTest {
    @Test
    public void distance() {
        Assert.assertEquals(400.98773719220475, new Position(0., 0.).distance(new Position(2.5, 2.6)), 0.001);
    }
}