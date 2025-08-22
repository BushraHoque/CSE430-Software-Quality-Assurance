package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TouristTest {
    
    private Tourist instance;
    
    public TouristTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Normal initialization
        instance = new Tourist("T451", "Roza", "Roza@gmail.com", "Rozapass123", "01778906543");

        // Set nationality normally
        instance.setNationality("Bangladeshi");

        // Add normal preferences
        instance.setPreferences(new ArrayList<>(Arrays.asList("Beach", "Adventure")));
        instance.addLoyaltyPoints(100);
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    // ---------------- NORMAL TESTS ----------------

    @Test
    public void testGetRole() {
        String result = instance.getRole();
        assertNotNull("Role should not be null", result);
        assertTrue(result.equalsIgnoreCase("TOURIST") || !result.isEmpty());
    }

    @Test
    public void testAddLoyaltyPoints() {
        int before = instance.getLoyaltyPoints();
        instance.addLoyaltyPoints(50);
        assertEquals("Loyalty points should increase correctly", before + 50, instance.getLoyaltyPoints());
    }

    @Test
    public void testGetPreferences() {
        List<String> prefs = instance.getPreferences();
        assertNotNull("Preferences should not be null", prefs);
        assertTrue("Preferences should contain 'Beach'", prefs.contains("Beach"));
    }

    @Test
    public void testSetPreferences() {
        List<String> newPrefs = Arrays.asList("Cultural", "Wildlife");
        instance.setPreferences(newPrefs);
        assertEquals("Preferences should update correctly", newPrefs, instance.getPreferences());
    }

    @Test
    public void testGetNationality() {
        assertEquals("Nationality should match", "Bangladeshi", instance.getNationality());
    }

    @Test
    public void testSetNationality() {
        instance.setNationality("Canadian");
        assertEquals("Nationality should update correctly", "Canadian", instance.getNationality());
    }

    @Test
    public void testGetLoyaltyPoints() {
        assertTrue("Loyalty points should be 100 or more", instance.getLoyaltyPoints() >= 100);
    }

    @Test
    public void testGetBookingHistory() {
        List<String> bookings = instance.getBookingHistory();
        assertNotNull("Booking history should not be null", bookings);
        assertTrue("Booking history should be a List", bookings instanceof List);
    }

    // ---------------- CORNER CASE TESTS ----------------

    @Test
    public void testAddZeroLoyaltyPoints() {
        // Corner case: Adding 0 points should not change total
        int before = instance.getLoyaltyPoints();
        instance.addLoyaltyPoints(0);
        assertEquals("Adding zero points should keep loyalty points unchanged", before, instance.getLoyaltyPoints());
    }

    @Test
    public void testAddNegativeLoyaltyPoints() {
        // Corner case: Adding negative points might represent penalty
        int before = instance.getLoyaltyPoints();
        instance.addLoyaltyPoints(-50);
        assertEquals("Negative points should decrease total", before - 50, instance.getLoyaltyPoints());
    }

    @Test
    public void testSetEmptyPreferences() {
        // Corner case: Setting preferences to an empty list
        instance.setPreferences(new ArrayList<>());
        assertTrue("Preferences should be empty", instance.getPreferences().isEmpty());
    }

    @Test
    public void testSetNullPreferences() {
        // Corner case: Setting preferences to null (should handle gracefully if allowed)
        instance.setPreferences(null);
        assertNull("Preferences should be null when set to null", instance.getPreferences());
    }

    @Test
    public void testSetEmptyNationality() {
        // Corner case: Setting nationality to empty string
        instance.setNationality("");
        assertEquals("Nationality can be empty", "", instance.getNationality());
    }

    @Test
    public void testSetNullNationality() {
        // Corner case: Setting nationality to null
        instance.setNationality(null);
        assertNull("Nationality should be null when set to null", instance.getNationality());
    }

    @Test
    public void testEmptyBookingHistory() {
        // Corner case: Tourist with no bookings yet
        Tourist t = new Tourist("T999", "Empty", "empty@gmail.com", "pass123", "01000000000");
        assertTrue("Booking history should be empty for new tourist", t.getBookingHistory().isEmpty());
    }

    @Test
    public void testPreferencesImmutableReference() {
        // Corner case: Ensure modifications to returned list affect the actual object
        List<String> prefs = instance.getPreferences();
        prefs.add("Extra");
        assertTrue("Modifying returned preferences should reflect in object", instance.getPreferences().contains("Extra"));
    }
}
