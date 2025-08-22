package enumtype;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TourTypeTest {

    public TourTypeTest() {
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

    @Test
    public void testValues() {
        System.out.println("testValues - Check all enum constants");
        TourType[] result = TourType.values();
        assertNotNull("Enum values should not be null", result);
        assertTrue("Enum should not be empty", result.length > 0);
        for (TourType t : result) {
            assertNotNull("Display name should not be null", t.getDisplayName());
            assertFalse("Display name should not be empty", t.getDisplayName().trim().isEmpty());

            assertNotNull("Description should not be null", t.getDescription());
            assertFalse("Description should not be empty", t.getDescription().trim().isEmpty());
        }
    }

    @Test
    public void testValueOf_Valid() {
        System.out.println("testValueOf_Valid - Using existing constant");
        TourType firstEnum = TourType.values()[0];
        String name = firstEnum.name();
        TourType result = TourType.valueOf(name);
        assertEquals(firstEnum, result);
    }

    @Test
    public void testGetDisplayName() {
        System.out.println("testGetDisplayName - Ensure valid display names");
        for (TourType type : TourType.values()) {
            String result = type.getDisplayName();
            assertNotNull("Display name should not be null", result);
            assertFalse("Display name should not be empty", result.trim().isEmpty());
        }
    }

    @Test
    public void testGetDescription() {
        System.out.println("testGetDescription - Ensure valid descriptions");
        for (TourType type : TourType.values()) {
            String result = type.getDescription();
            assertNotNull("Description should not be null", result);
            assertFalse("Description should not be empty", result.trim().isEmpty());
        }
    }
    
    
     @Test
    public void testOrdinalOrder() {
        System.out.println("testOrdinalOrder - Ensure ordinal values are sequential");
        //  Corner Case: Ensure ordinals increase correctly
        TourType[] values = TourType.values();
        for (int i = 1; i < values.length; i++) {
            assertEquals("Ordinal should match index position", i, values[i].ordinal());
        }
    }
    
    
    
     @Test(expected = IllegalArgumentException.class)
    public void testValueOf_Invalid() {
        System.out.println("testValueOf_Invalid - Using non-existing constant");
        //  Corner Case: valueOf() should throw exception for invalid name
        TourType.valueOf("INVALID_TOUR_TYPE");
    }

    @Test(expected = NullPointerException.class)
    public void testValueOf_Null() {
        System.out.println("testValueOf_Null - Passing null to valueOf()");
        //  Corner Case: Passing null should throw NullPointerException
        TourType.valueOf(null);
    }

    @Test
    public void testEnumConsistency() {
        System.out.println("testEnumConsistency - Ensure name() matches toString()");
        //  Corner Case: Ensure enum name and toString are consistent
        for (TourType type : TourType.values()) {
            assertEquals("Enum name and toString() should match by default", type.name(), type.toString());
        }
    }

   
}
