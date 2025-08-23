/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumtype;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author we
 */
public class RoomTypeTest {
    
    public RoomTypeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class RoomType.
     */
    @Test
    public void testValues() {
        RoomType[] expected = {RoomType.STANDARD, RoomType.DELUXE, RoomType.SUITE};
        RoomType[] actual = RoomType.values();
        assertArrayEquals("RoomType.values() should return all enum constants", expected, actual);
    }

    /**
     * Test of valueOf method, of class RoomType.
     */
    @Test
    public void testValueOf() {
        assertEquals(RoomType.STANDARD, RoomType.valueOf("STANDARD"));
        assertEquals(RoomType.DELUXE, RoomType.valueOf("DELUXE"));
        assertEquals(RoomType.SUITE, RoomType.valueOf("SUITE"));
    }

    /**
     * Test of getDisplayName method, of class RoomType.
     */
    @Test
    public void testGetDisplayName() {
        assertEquals("Standard Room", RoomType.STANDARD.getDisplayName());
        assertEquals("Deluxe Room", RoomType.DELUXE.getDisplayName());
        assertEquals("Suite Room", RoomType.SUITE.getDisplayName());
    }

    /**
     * Test of getBasePrice method, of class RoomType.
     */
    @Test
    public void testGetBasePrice() {
        assertEquals(1500.0, RoomType.STANDARD.getBasePrice(), 0.001);
        assertEquals(2500.0, RoomType.DELUXE.getBasePrice(), 0.001);
        assertEquals(4000.0, RoomType.SUITE.getBasePrice(), 0.001);
    }
    
}
