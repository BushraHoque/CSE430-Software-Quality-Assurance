package enumtype;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BUSHRA HOQUE
 */
public class BookingStatusTest {
    
    public BookingStatusTest() {
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
        System.out.println("values");
        BookingStatus[] expResult = {
            BookingStatus.PENDING,
            BookingStatus.CONFIRMED,
            BookingStatus.CANCELED,
            BookingStatus.COMPLETED
        };
        BookingStatus[] result = BookingStatus.values();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "CONFIRMED";
        BookingStatus expResult = BookingStatus.CONFIRMED;
        BookingStatus result = BookingStatus.valueOf(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDisplayName() {
        System.out.println("getDisplayName");
        BookingStatus instance = BookingStatus.CANCELED;
        String expResult = "Canceled";
        String result = instance.getDisplayName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        BookingStatus instance = BookingStatus.COMPLETED;
        String expResult = "Tour has been completed";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    // ---------------- CORNER CASE TESTS ----------------

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfInvalidEnumName() {
        System.out.println("valueOf - invalid name");
        BookingStatus.valueOf("INVALID_STATUS"); // should throw IllegalArgumentException
    }

    @Test(expected = NullPointerException.class)
    public void testValueOfNull() {
        System.out.println("valueOf - null");
        BookingStatus.valueOf(null); // should throw NullPointerException
    }

    @Test
    public void testGetDisplayNameNotNull() {
        System.out.println("getDisplayName - not null check");
        for (BookingStatus status : BookingStatus.values()) {
            assertNotNull("Display name should not be null", status.getDisplayName());
        }
    }

    @Test
    public void testGetDescriptionNotNull() {
        System.out.println("getDescription - not null check");
        for (BookingStatus status : BookingStatus.values()) {
            assertNotNull("Description should not be null", status.getDescription());
        }
    }
}
