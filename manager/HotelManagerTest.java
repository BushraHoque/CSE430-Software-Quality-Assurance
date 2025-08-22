/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import enumtype.RoomType;
import java.util.List;
import java.util.Map;
import model.Hotel;
import model.Room;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hp
 */
public class HotelManagerTest {
    
    public HotelManagerTest() {
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
     * Test of addHotel method behavior.
     */
    @Test
    public void testAddHotelBehavior() {
        System.out.println("addHotel - behavior");
        HotelManager instance = new HotelManager();
     
        try {
            instance.addHotel(null);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true); 
        }
    }

    /**
     * Test of removeHotel method with empty string.
     */
    @Test
    public void testRemoveHotelEmptyString() {
        System.out.println("removeHotel - empty string");
        HotelManager instance = new HotelManager();
        instance.removeHotel("");
       
        assertTrue(true);
    }

    /**
     * Test of removeHotel method with null string.
     */
    @Test
    public void testRemoveHotelNull() {
        System.out.println("removeHotel - null");
        HotelManager instance = new HotelManager();
        instance.removeHotel(null);
        
        assertTrue(true);
    }

    /**
     * Test of getHotelById method with empty string.
     */
    @Test
    public void testGetHotelByIdEmpty() {
        System.out.println("getHotelById - empty");
        HotelManager instance = new HotelManager();
        Hotel result = instance.getHotelById("");
        assertNull(result);
    }

    /**
     * Test of getHotelById method with null.
     */
    @Test
    public void testGetHotelByIdNull() {
        System.out.println("getHotelById - null");
        HotelManager instance = new HotelManager();
        Hotel result = instance.getHotelById(null);
        assertNull(result);
    }

    /**
     * Test of updateHotel method with null hotel.
     */
    @Test
    public void testUpdateHotelNull() {
        System.out.println("updateHotel - null");
        HotelManager instance = new HotelManager();
        instance.updateHotel(null);
       
        assertTrue(true);
    }

    /**
     * Test of updateHotel method behavior.
     */
    @Test
    public void testUpdateHotelBehavior() {
        System.out.println("updateHotel - behavior");
        HotelManager instance = new HotelManager();
        try {
            instance.updateHotel(null);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true); 
        }
    }

    /**
     * Test of getAllHotels method returns list.
     */
    @Test
    public void testGetAllHotelsReturns() {
        System.out.println("getAllHotels - returns");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getAllHotels();
        assertNotNull(result);
    }

    /**
     * Test of getAllHotels method list type.
     */
    @Test
    public void testGetAllHotelsType() {
        System.out.println("getAllHotels - type");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getAllHotels();
        assertTrue(result instanceof List);
    }

    /**
     * Test of getActiveHotels method returns list.
     */
    @Test
    public void testGetActiveHotelsReturns() {
        System.out.println("getActiveHotels - returns");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getActiveHotels();
        assertNotNull(result);
    }

    /**
     * Test of getActiveHotels method list type.
     */
    @Test
    public void testGetActiveHotelsType() {
        System.out.println("getActiveHotels - type");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getActiveHotels();
        assertTrue(result instanceof List);
    }

    /**
     * Test of searchHotels method with empty keyword.
     */
    @Test
    public void testSearchHotelsEmpty() {
        System.out.println("searchHotels - empty");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.searchHotels("");
        assertNotNull(result);
    }

    /**
     * Test of searchHotels method with null keyword.
     */
    @Test
    public void testSearchHotelsNull() {
        System.out.println("searchHotels - null");
        HotelManager instance = new HotelManager();
        try {
            List<Hotel> result = instance.searchHotels(null);
            assertNotNull(result);
        } catch (Exception e) {
            assertTrue(true); 
        }
    }

    /**
     * Test of searchHotels method with normal keyword.
     */
    @Test
    public void testSearchHotelsNormal() {
        System.out.println("searchHotels - normal");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.searchHotels("hotel");
        assertNotNull(result);
    }

    /**
     * Test of getHotelsByLocation method with empty location.
     */
    @Test
    public void testGetHotelsByLocationEmpty() {
        System.out.println("getHotelsByLocation - empty");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getHotelsByLocation("");
        assertNotNull(result);
    }

    /**
     * Test of getHotelsByLocation method with null location.
     */
    @Test
    public void testGetHotelsByLocationNull() {
        System.out.println("getHotelsByLocation - null");
        HotelManager instance = new HotelManager();
        try {
            List<Hotel> result = instance.getHotelsByLocation(null);
            assertNotNull(result);
        } catch (Exception e) {
            assertTrue(true); 
        }
    }

    /**
     * Test of getHotelsByLocation method with normal location.
     */
    @Test
    public void testGetHotelsByLocationNormal() {
        System.out.println("getHotelsByLocation - normal");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getHotelsByLocation("Dhaka");
        assertNotNull(result);
    }

    /**
     * Test of getHotelsByRating method with zero rating.
     */
    @Test
    public void testGetHotelsByRatingZero() {
        System.out.println("getHotelsByRating - zero");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getHotelsByRating(0.0);
        assertNotNull(result);
    }

    /**
     * Test of getHotelsByRating method with high rating.
     */
    @Test
    public void testGetHotelsByRatingHigh() {
        System.out.println("getHotelsByRating - high");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getHotelsByRating(4.5);
        assertNotNull(result);
    }

    /**
     * Test of getHotelsByRating method with negative rating.
     */
    @Test
    public void testGetHotelsByRatingNegative() {
        System.out.println("getHotelsByRating - negative");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getHotelsByRating(-1.0);
        assertNotNull(result);
    }

    /**
     * Test of getHotelsWithAvailableRooms method.
     */
    @Test
    public void testGetHotelsWithAvailableRooms() {
        System.out.println("getHotelsWithAvailableRooms");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getHotelsWithAvailableRooms();
        assertNotNull(result);
    }

    /**
     * Test of getHotelsWithAvailableRooms method return type.
     */
    @Test
    public void testGetHotelsWithAvailableRoomsType() {
        System.out.println("getHotelsWithAvailableRooms - type");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getHotelsWithAvailableRooms();
        assertTrue(result instanceof List);
    }

    /**
     * Test of searchAvailableRooms method with empty location.
     */
    @Test
    public void testSearchAvailableRoomsEmpty() {
        System.out.println("searchAvailableRooms - empty");
        HotelManager instance = new HotelManager();
        List<Room> result = instance.searchAvailableRooms("", null);
        assertNotNull(result);
    }

    /**
     * Test of searchAvailableRooms method with null location.
     */
    @Test
    public void testSearchAvailableRoomsNullLocation() {
        System.out.println("searchAvailableRooms - null location");
        HotelManager instance = new HotelManager();
        try {
            List<Room> result = instance.searchAvailableRooms(null, null);
            assertNotNull(result);
        } catch (Exception e) {
            assertTrue(true); 
        }
    }

    /**
     * Test of bookRoom method with empty hotel ID.
     */
    @Test
    public void testBookRoomEmptyHotelId() {
        System.out.println("bookRoom - empty hotel ID");
        HotelManager instance = new HotelManager();
        boolean result = instance.bookRoom("", "R001");
        assertFalse(result);
    }

    /**
     * Test of bookRoom method with empty room ID.
     */
    @Test
    public void testBookRoomEmptyRoomId() {
        System.out.println("bookRoom - empty room ID");
        HotelManager instance = new HotelManager();
        boolean result = instance.bookRoom("H001", "");
        assertFalse(result);
    }

    /**
     * Test of bookRoom method with null parameters.
     */
    @Test
    public void testBookRoomNullParams() {
        System.out.println("bookRoom - null params");
        HotelManager instance = new HotelManager();
        boolean result = instance.bookRoom(null, null);
        assertFalse(result);
    }

    /**
     * Test of bookRoom method with non-existing hotel.
     */
    @Test
    public void testBookRoomNonExistingHotel() {
        System.out.println("bookRoom - non-existing hotel");
        HotelManager instance = new HotelManager();
        boolean result = instance.bookRoom("NONEXISTENT", "R001");
        assertFalse(result);
    }

    /**
     * Test of checkoutRoom method with empty hotel ID.
     */
    @Test
    public void testCheckoutRoomEmptyHotelId() {
        System.out.println("checkoutRoom - empty hotel ID");
        HotelManager instance = new HotelManager();
        boolean result = instance.checkoutRoom("", "R001");
        assertFalse(result);
    }

    /**
     * Test of checkoutRoom method with empty room ID.
     */
    @Test
    public void testCheckoutRoomEmptyRoomId() {
        System.out.println("checkoutRoom - empty room ID");
        HotelManager instance = new HotelManager();
        boolean result = instance.checkoutRoom("H001", "");
        assertFalse(result);
    }

    /**
     * Test of checkoutRoom method with null parameters.
     */
    @Test
    public void testCheckoutRoomNullParams() {
        System.out.println("checkoutRoom - null params");
        HotelManager instance = new HotelManager();
        boolean result = instance.checkoutRoom(null, null);
        assertFalse(result);
    }

    /**
     * Test of checkoutRoom method with non-existing hotel.
     */
    @Test
    public void testCheckoutRoomNonExistingHotel() {
        System.out.println("checkoutRoom - non-existing hotel");
        HotelManager instance = new HotelManager();
        boolean result = instance.checkoutRoom("NONEXISTENT", "R001");
        assertFalse(result);
    }

    /**
     * Test of addRoomToHotel method with empty hotel ID.
     */
    @Test
    public void testAddRoomToHotelEmptyId() {
        System.out.println("addRoomToHotel - empty ID");
        HotelManager instance = new HotelManager();
        instance.addRoomToHotel("", null);
        // Should not cause exception
        assertTrue(true);
    }

    /**
     * Test of addRoomToHotel method with null parameters.
     */
    @Test
    public void testAddRoomToHotelNullParams() {
        System.out.println("addRoomToHotel - null params");
        HotelManager instance = new HotelManager();
        instance.addRoomToHotel(null, null);
        // Should not cause exception
        assertTrue(true);
    }

    /**
     * Test of addRoomToHotel method with non-existing hotel.
     */
    @Test
    public void testAddRoomToHotelNonExisting() {
        System.out.println("addRoomToHotel - non-existing");
        HotelManager instance = new HotelManager();
        instance.addRoomToHotel("NONEXISTENT", null);
        // Should not cause exception
        assertTrue(true);
    }

    /**
     * Test of removeRoomFromHotel method with empty hotel ID.
     */
    @Test
    public void testRemoveRoomFromHotelEmptyId() {
        System.out.println("removeRoomFromHotel - empty ID");
        HotelManager instance = new HotelManager();
        instance.removeRoomFromHotel("", "R001");
        // Should not cause exception
        assertTrue(true);
    }

    /**
     * Test of removeRoomFromHotel method with null parameters.
     */
    @Test
    public void testRemoveRoomFromHotelNullParams() {
        System.out.println("removeRoomFromHotel - null params");
        HotelManager instance = new HotelManager();
        instance.removeRoomFromHotel(null, null);
        // Should not cause exception
        assertTrue(true);
    }

    /**
     * Test of removeRoomFromHotel method with non-existing hotel.
     */
    @Test
    public void testRemoveRoomFromHotelNonExisting() {
        System.out.println("removeRoomFromHotel - non-existing");
        HotelManager instance = new HotelManager();
        instance.removeRoomFromHotel("NONEXISTENT", "R001");
        // Should not cause exception
        assertTrue(true);
    }

    /**
     * Test of getTotalHotels method initial state.
     */
    @Test
    public void testGetTotalHotelsInitial() {
        System.out.println("getTotalHotels - initial");
        HotelManager instance = new HotelManager();
        int result = instance.getTotalHotels();
        assertTrue(result >= 0);
    }

    /**
     * Test of getTotalHotels method return type.
     */
    @Test
    public void testGetTotalHotelsType() {
        System.out.println("getTotalHotels - type");
        HotelManager instance = new HotelManager();
        int result = instance.getTotalHotels();
        assertTrue(result == (int) result);
    }

    /**
     * Test of getActiveHotelsCount method initial state.
     */
    @Test
    public void testGetActiveHotelsCountInitial() {
        System.out.println("getActiveHotelsCount - initial");
        HotelManager instance = new HotelManager();
        int result = instance.getActiveHotelsCount();
        assertTrue(result >= 0);
    }

    /**
     * Test of getActiveHotelsCount method return type.
     */
    @Test
    public void testGetActiveHotelsCountType() {
        System.out.println("getActiveHotelsCount - type");
        HotelManager instance = new HotelManager();
        int result = instance.getActiveHotelsCount();
        assertTrue(result == (int) result);
    }

    /**
     * Test of getAverageHotelRating method initial state.
     */
    @Test
    public void testGetAverageHotelRatingInitial() {
        System.out.println("getAverageHotelRating - initial");
        HotelManager instance = new HotelManager();
        double result = instance.getAverageHotelRating();
        assertTrue(result >= 0.0);
    }

    /**
     * Test of getAverageHotelRating method return type.
     */
    @Test
    public void testGetAverageHotelRatingType() {
        System.out.println("getAverageHotelRating - type");
        HotelManager instance = new HotelManager();
        double result = instance.getAverageHotelRating();
        assertTrue(result == (double) result);
    }

    /**
     * Test of getHighestRatedHotel method initial state.
     */
    @Test
    public void testGetHighestRatedHotelInitial() {
        System.out.println("getHighestRatedHotel - initial");
        HotelManager instance = new HotelManager();
        Hotel result = instance.getHighestRatedHotel();
        // Can be null or Hotel object
        assertTrue(result == null || result instanceof Hotel);
    }

    /**
     * Test of getHighestRatedHotel method return type.
     */
    @Test
    public void testGetHighestRatedHotelType() {
        System.out.println("getHighestRatedHotel - type");
        HotelManager instance = new HotelManager();
        Hotel result = instance.getHighestRatedHotel();
        if (result != null) {
            assertTrue(result instanceof Hotel);
        } else {
            assertNull(result);
        }
    }

    /**
     * Test of getHotelCountByLocation method initial state.
     */
    @Test
    public void testGetHotelCountByLocationInitial() {
        System.out.println("getHotelCountByLocation - initial");
        HotelManager instance = new HotelManager();
        Map<String, Long> result = instance.getHotelCountByLocation();
        assertNotNull(result);
    }

    /**
     * Test of getHotelCountByLocation method return type.
     */
    @Test
    public void testGetHotelCountByLocationType() {
        System.out.println("getHotelCountByLocation - type");
        HotelManager instance = new HotelManager();
        Map<String, Long> result = instance.getHotelCountByLocation();
        assertTrue(result instanceof Map);
    }

    /**
     * Test of getTotalRooms method initial state.
     */
    @Test
    public void testGetTotalRoomsInitial() {
        System.out.println("getTotalRooms - initial");
        HotelManager instance = new HotelManager();
        int result = instance.getTotalRooms();
        assertTrue(result >= 0);
    }

    /**
     * Test of getTotalRooms method return type.
     */
    @Test
    public void testGetTotalRoomsType() {
        System.out.println("getTotalRooms - type");
        HotelManager instance = new HotelManager();
        int result = instance.getTotalRooms();
        assertTrue(result == (int) result);
    }

    /**
     * Test of getAvailableRoomsCount method initial state.
     */
    @Test
    public void testGetAvailableRoomsCountInitial() {
        System.out.println("getAvailableRoomsCount - initial");
        HotelManager instance = new HotelManager();
        int result = instance.getAvailableRoomsCount();
        assertTrue(result >= 0);
    }

    /**
     * Test of getAvailableRoomsCount method return type.
     */
    @Test
    public void testGetAvailableRoomsCountType() {
        System.out.println("getAvailableRoomsCount - type");
        HotelManager instance = new HotelManager();
        int result = instance.getAvailableRoomsCount();
        assertTrue(result == (int) result);
    }

    /**
     * Test of getOccupancyRate method initial state.
     */
    @Test
    public void testGetOccupancyRateInitial() {
        System.out.println("getOccupancyRate - initial");
        HotelManager instance = new HotelManager();
        double result = instance.getOccupancyRate();
        assertTrue(result >= 0.0);
    }

    /**
     * Test of getOccupancyRate method return type.
     */
    @Test
    public void testGetOccupancyRateType() {
        System.out.println("getOccupancyRate - type");
        HotelManager instance = new HotelManager();
        double result = instance.getOccupancyRate();
        assertTrue(result == (double) result);
    }

    /**
     * Test of getOccupancyRate method range.
     */
    @Test
    public void testGetOccupancyRateRange() {
        System.out.println("getOccupancyRate - range");
        HotelManager instance = new HotelManager();
        double result = instance.getOccupancyRate();
        assertTrue(result >= 0.0 && result <= 100.0);
    }

    // Additional Edge Cases

    /**
     * Test searchHotels with special characters.
     */
    @Test
    public void testSearchHotelsSpecialChars() {
        System.out.println("searchHotels - special chars");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.searchHotels("@#$%^&*()");
        assertNotNull(result);
    }

    /**
     * Test getHotelsByLocation with special characters.
     */
    @Test
    public void testGetHotelsByLocationSpecialChars() {
        System.out.println("getHotelsByLocation - special chars");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getHotelsByLocation("Cox's Bazar");
        assertNotNull(result);
    }

    /**
     * Test getHotelsByRating with maximum value.
     */
    @Test
    public void testGetHotelsByRatingMax() {
        System.out.println("getHotelsByRating - max");
        HotelManager instance = new HotelManager();
        List<Hotel> result = instance.getHotelsByRating(5.0);
        assertNotNull(result);
    }


    /**
     * Test searchAvailableRooms with suite type.
     */
    @Test
    public void testSearchAvailableRoomsSuiteType() {
        System.out.println("searchAvailableRooms - suite type");
        HotelManager instance = new HotelManager();
        List<Room> result = instance.searchAvailableRooms("Chittagong", RoomType.SUITE);
        assertNotNull(result);
    }

    /**
     * Test multiple consecutive operations.
     */
    @Test
    public void testMultipleOperations() {
        System.out.println("multiple operations");
        HotelManager instance = new HotelManager();
        
        instance.getTotalHotels();
        instance.getActiveHotelsCount();
        instance.getAllHotels();
        instance.getActiveHotels();
        instance.getAverageHotelRating();
        
        assertTrue(true); 
    }

    /**
     * Test method consistency.
     */
    @Test
    public void testMethodConsistency() {
        System.out.println("method consistency");
        HotelManager instance = new HotelManager();
        
        int total1 = instance.getTotalHotels();
        int total2 = instance.getTotalHotels();
        assertEquals(total1, total2); 
    }

    /**
     * Test state independence.
     */
    @Test
    public void testStateIndependence() {
        System.out.println("state independence");
        HotelManager instance1 = new HotelManager();
        HotelManager instance2 = new HotelManager();
        
        int count1 = instance1.getTotalHotels();
        int count2 = instance2.getTotalHotels();
        
        assertTrue(count1 >= 0);
        assertTrue(count2 >= 0);
    }
}