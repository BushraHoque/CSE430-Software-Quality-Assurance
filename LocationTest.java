package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Extended test class for Location with added corner and boundary cases.
 */
public class LocationTest {

    private Location instance;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Location("LOC001", "Cox's Bazar", "Bangladesh");
        instance.setState("Chattogram");
        instance.setLatitude(21.4272);
        instance.setLongitude(92.0058);
        instance.setDescription("Longest sea beach in the world");
        instance.setClimate("Tropical");
        instance.setBestTimeToVisit("Winter");
        instance.setLandmarks(new ArrayList<>(Arrays.asList("Himchori", "Inani Beach")));
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testAddLandmark() {
        instance.addLandmark("Laboni Beach");
        assertTrue(instance.getLandmarks().contains("Laboni Beach"));
    }

 

    @Test
    public void testRemoveLandmark() {
        instance.removeLandmark("Inani Beach");
        assertFalse(instance.getLandmarks().contains("Inani Beach"));
    }
  
    @Test
    public void testGetLocationId() {
        assertEquals("LOC001", instance.getLocationId());
    }
    
    
  
    @Test
    public void testGetDescription() {
        assertEquals("Longest sea beach in the world", instance.getDescription());
    }

    @Test
    public void testSetDescription_Empty() {
        instance.setDescription("");
        assertEquals("", instance.getDescription());
    }

    @Test
    public void testGetClimate() {
        assertEquals("Tropical", instance.getClimate());
    }

    @Test
    public void testSetClimate_Null() {
        instance.setClimate(null);
        assertNull(instance.getClimate());
    }

    @Test
    public void testGetBestTimeToVisit() {
        assertEquals("Winter", instance.getBestTimeToVisit());
    }

    @Test
    public void testSetBestTimeToVisit_Empty() {
        instance.setBestTimeToVisit("");
        assertEquals("", instance.getBestTimeToVisit());
    }

    @Test
    public void testToString() {
        String result = instance.toString();
        assertNotNull(result);
        assertTrue(result.contains("Cox's Bazar") || result.contains("Bangladesh"));
    }
    
  

    @Test
    public void testGetCity() {
        assertEquals("Cox's Bazar", instance.getCity());
    }
 

    @Test
    public void testGetCountry() {
        assertEquals("Bangladesh", instance.getCountry());
    }

    @Test
    public void testSetCountry_Null() {
        instance.setCountry(null);
        assertNull(instance.getCountry());
    }

    @Test
    public void testGetState() {
        assertEquals("Chattogram", instance.getState());
    }

    @Test
    public void testSetState_Empty() {
        instance.setState("");
        assertEquals("", instance.getState());
    }

    @Test
    public void testGetLandmarks() {
        assertNotNull(instance.getLandmarks());
        assertTrue(instance.getLandmarks().contains("Himchori"));
    }
    
    
    
    
     // Corner cases
    
    
     @Test
    public void testAddLandmark_NullValue() {
        // Corner case: Adding null should not break
        instance.addLandmark(null);
        assertTrue(instance.getLandmarks().contains(null));
    }

    @Test
    public void testAddLandmark_Duplicate() {
        // Corner case: Adding duplicate landmark
        instance.addLandmark("Himchori");
        long count = instance.getLandmarks().stream().filter(l -> "Himchori".equals(l)).count();
        assertTrue(count >= 2); // duplicate allowed unless handled in Location
    }
    
      @Test
    public void testRemoveLandmark_NotExists() {
        // Corner case: Removing landmark not in list
        instance.removeLandmark("NonExisting");
        assertEquals(2, instance.getLandmarks().size());
    }


    @Test
    public void testSetLocationId_EmptyString() {
        // Corner case: empty location ID
        instance.setLocationId("");
        assertEquals("", instance.getLocationId());
    }

    @Test
    public void testSetLocationId_Null() {
        // Corner case: null location ID
        instance.setLocationId(null);
        assertNull(instance.getLocationId());
    }
    
    @Test
    public void testSetCity_SpecialCharacters() {
        // Corner case: special characters
        instance.setCity("@@@###");
        assertEquals("@@@###", instance.getCity());
    }

    @Test
    public void testSetLandmarks_EmptyList() {
        // Corner case: setting empty landmarks
        instance.setLandmarks(Collections.emptyList());
        assertTrue(instance.getLandmarks().isEmpty());
    }

    @Test
    public void testSetLandmarks_NullList() {
        // Corner case: setting null landmarks
        instance.setLandmarks(null);
        assertNull(instance.getLandmarks());
    }

    @Test
    public void testGetLatitude() {
        assertEquals(21.4272, instance.getLatitude(), 0.0001);
    }

    @Test
    public void testSetLatitude_OutOfRange() {
        // Corner case: Latitude out of valid range
        instance.setLatitude(200.0);
        assertEquals(200.0, instance.getLatitude(), 0.0001);
    }

    @Test
    public void testGetLongitude() {
        assertEquals(92.0058, instance.getLongitude(), 0.0001);
    }

    @Test
    public void testSetLongitude_OutOfRange() {
        // Corner case: Longitude out of valid range
        instance.setLongitude(-200.0);
        assertEquals(-200.0, instance.getLongitude(), 0.0001);
    }


   
}
