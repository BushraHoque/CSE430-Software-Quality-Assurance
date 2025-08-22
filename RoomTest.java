package model;

import enumtype.RoomType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Extended test for Room including edge/corner cases.
 */
public class RoomTest {

    private Room instance;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Normal setup
        instance = new Room("R1001", "H178", "1001", RoomType.DELUXE, 2500.0);
        instance.setAvailability(true);
        instance.setCapacity(2);
        instance.setDescription("A deluxe double room");
        instance.setHasAC(true);
        instance.setHasWiFi(true);
        instance.setHasTV(true);
        instance.setBedType("King");
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testIsAvailable() {
        assertTrue(instance.isAvailable());
    }

    @Test
    public void testBookRoom() {
        instance.bookRoom();
        assertFalse(instance.isAvailable());
    }

   

    @Test
    public void testCheckOut() {
        instance.bookRoom();
        instance.checkOut();
        assertTrue(instance.isAvailable());
    }

   
    @Test
    public void testGetRoomId() {
        assertEquals("R1001", instance.getRoomId());
    }

   

    @Test
    public void testGetHotelId() {
        assertEquals("H178", instance.getHotelId());
    }

    @Test
    public void testSetHotelId_SpecialCharacters() {
        // Corner case: unusual hotel ID
        instance.setHotelId("@@@");
        assertEquals("@@@", instance.getHotelId());
    }

    @Test
    public void testGetRoomNumber() {
        assertEquals("1001", instance.getRoomNumber());
    }

    @Test
    public void testSetRoomNumber_Empty() {
        instance.setRoomNumber("");
        assertEquals("", instance.getRoomNumber());
    }

    @Test
    public void testGetRoomType() {
        assertEquals(RoomType.DELUXE, instance.getRoomType());
    }
    
    

    @Test
    public void testIsAvailability() {
        assertTrue(instance.isAvailability());
    }

    @Test
    public void testSetAvailability_False() {
        instance.setAvailability(false);
        assertFalse(instance.isAvailability());
    }

    @Test
    public void testGetPrice() {
        assertEquals(2500.0, instance.getPrice(), 0.0);
    }

   

    @Test
    public void testGetCapacity() {
        assertEquals(2, instance.getCapacity());
    }

   

    @Test
    public void testGetDescription() {
        assertEquals("A deluxe double room", instance.getDescription());
    }

    @Test
    public void testSetDescription_Empty() {
        instance.setDescription("");
        assertEquals("", instance.getDescription());
    }

    @Test
    public void testIsHasAC() {
        assertTrue(instance.isHasAC());
    }

    @Test
    public void testSetHasAC_False() {
        instance.setHasAC(false);
        assertFalse(instance.isHasAC());
    }

    @Test
    public void testIsHasWiFi() {
        assertTrue(instance.isHasWiFi());
    }

    @Test
    public void testSetHasWiFi_False() {
        instance.setHasWiFi(false);
        assertFalse(instance.isHasWiFi());
    }

    @Test
    public void testIsHasTV() {
        assertTrue(instance.isHasTV());
    }

    @Test
    public void testSetHasTV_False() {
        instance.setHasTV(false);
        assertFalse(instance.isHasTV());
    }

    @Test
    public void testGetBedType() {
        assertEquals("King", instance.getBedType());
    }

    

    @Test
    public void testSetBedType_Empty() {
        instance.setBedType("");
        assertEquals("", instance.getBedType());
    }

    @Test
    public void testToString() {
        String result = instance.toString();
        assertNotNull(result);
        assertTrue(result.contains("R1001") || result.contains("1001"));
    }
    
     @Test
    public void testSetPrice_Negative() {
        // Corner case: negative price
        instance.setPrice(-500.0);
        assertEquals(-500.0, instance.getPrice(), 0.0);
    }

    @Test
    public void testSetPrice_Zero() {
        // Corner case: zero price
        instance.setPrice(0.0);
        assertEquals(0.0, instance.getPrice(), 0.0);
    }
    
     @Test
    public void testSetRoomId_Null() {
        // Corner case: null room ID
        instance.setRoomId(null);
        assertNull(instance.getRoomId());
    }

    @Test
    public void testSetRoomId_Empty() {
        // Corner case: empty string as ID
        instance.setRoomId("");
        assertEquals("", instance.getRoomId());
    }

    @Test
    public void testSetRoomType_Null() {
        // Corner case: null type
        instance.setRoomType(null);
        assertNull(instance.getRoomType());
    }
    
     @Test
    public void testCheckOut_WhenAlreadyAvailable() {
        // Corner case: checking out when already available
        instance.checkOut();
        assertTrue(instance.isAvailable());
    }
    
     @Test
    public void testSetCapacity_Zero() {
        // Corner case: zero capacity
        instance.setCapacity(0);
        assertEquals(0, instance.getCapacity());
    }

    @Test
    public void testSetCapacity_Negative() {
        // Corner case: negative capacity
        instance.setCapacity(-5);
        assertEquals(-5, instance.getCapacity());
    }
    
    @Test
    public void testSetBedType_Null() {
        // Corner case: null bed type
        instance.setBedType(null);
        assertNull(instance.getBedType());
    }
    
     @Test
    public void testBookRoom_WhenAlreadyBooked() {
        // Corner case: booking an already booked room
        instance.bookRoom();
        instance.bookRoom(); // no exception expected
        assertFalse(instance.isAvailable());
    }


    @Test
    public void testToString_AllFieldsNull() {
        // Corner case: toString() with null/empty fields
        Room emptyRoom = new Room(null, null, null, null, 0.0);
        emptyRoom.setDescription(null);
        String result = emptyRoom.toString();
        assertNotNull(result); // should still return a string
    }
}
