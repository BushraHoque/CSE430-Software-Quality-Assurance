/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
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
public class HotelTest {
    
    public HotelTest() {
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
     * Test of addRoom method, of class Hotel.
     */
    @Test
    public void testAddRoom() {
        System.out.println("addRoom");
        Room room = null;
        Hotel instance = null;
        instance.addRoom(room);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeRoom method, of class Hotel.
     */
    @Test
    public void testRemoveRoom() {
        System.out.println("removeRoom");
        String roomId = "";
        Hotel instance = null;
        instance.removeRoom(roomId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomById method, of class Hotel.
     */
    @Test
    public void testGetRoomById() {
        System.out.println("getRoomById");
        String roomId = "";
        Hotel instance = null;
        Room expResult = null;
        Room result = instance.getRoomById(roomId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableRooms method, of class Hotel.
     */
    @Test
    public void testGetAvailableRooms() {
        System.out.println("getAvailableRooms");
        Hotel instance = null;
        List<Room> expResult = null;
        List<Room> result = instance.getAvailableRooms();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHotelId method, of class Hotel.
     */
    @Test
    public void testGetHotelId() {
        System.out.println("getHotelId");
        Hotel instance = null;
        String expResult = "";
        String result = instance.getHotelId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHotelId method, of class Hotel.
     */
    @Test
    public void testSetHotelId() {
        System.out.println("setHotelId");
        String hotelId = "";
        Hotel instance = null;
        instance.setHotelId(hotelId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Hotel.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Hotel instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Hotel.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Hotel instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Hotel.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Hotel instance = null;
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Hotel.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "";
        Hotel instance = null;
        instance.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRating method, of class Hotel.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        Hotel instance = null;
        double expResult = 0.0;
        double result = instance.getRating();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRating method, of class Hotel.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        double rating = 0.0;
        Hotel instance = null;
        instance.setRating(rating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomList method, of class Hotel.
     */
    @Test
    public void testGetRoomList() {
        System.out.println("getRoomList");
        Hotel instance = null;
        List<Room> expResult = null;
        List<Room> result = instance.getRoomList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoomList method, of class Hotel.
     */
    @Test
    public void testSetRoomList() {
        System.out.println("setRoomList");
        List<Room> roomList = null;
        Hotel instance = null;
        instance.setRoomList(roomList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Hotel.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Hotel instance = null;
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Hotel.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Hotel instance = null;
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class Hotel.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Hotel instance = null;
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class Hotel.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Hotel instance = null;
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Hotel.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Hotel instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Hotel.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Hotel instance = null;
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmenities method, of class Hotel.
     */
    @Test
    public void testGetAmenities() {
        System.out.println("getAmenities");
        Hotel instance = null;
        List<String> expResult = null;
        List<String> result = instance.getAmenities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmenities method, of class Hotel.
     */
    @Test
    public void testSetAmenities() {
        System.out.println("setAmenities");
        List<String> amenities = null;
        Hotel instance = null;
        instance.setAmenities(amenities);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Hotel.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Hotel instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Hotel.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Hotel instance = null;
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActive method, of class Hotel.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        Hotel instance = null;
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActive method, of class Hotel.
     */
    @Test
    public void testSetActive() {
        System.out.println("setActive");
        boolean active = false;
        Hotel instance = null;
        instance.setActive(active);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Hotel.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Hotel instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
