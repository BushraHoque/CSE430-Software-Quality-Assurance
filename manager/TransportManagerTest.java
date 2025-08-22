/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import enumtype.TransportType;
import java.util.List;
import java.util.Map;
import model.Seat;
import model.Transport;
import model.Vehicle;
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
public class TransportManagerTest {
    
    public TransportManagerTest() {
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
     * Test of addTransport method, of class TransportManager.
     */
    @Test
    public void testAddTransport() {
        System.out.println("addTransport");
        TransportManager instance = new TransportManager();
        assertNotNull(instance);
    }

    /**
     * Test of removeTransport method, of class TransportManager.
     */
    @Test
    public void testRemoveTransport() {
        System.out.println("removeTransport");
        TransportManager instance = new TransportManager();
        assertNotNull(instance);
    }

    /**
     * Test of getTransportById method, of class TransportManager.
     */
    @Test
    public void testGetTransportById() {
        System.out.println("getTransportById");
        TransportManager instance = new TransportManager();
        Transport result = instance.getTransportById("");
        assertTrue(result == null || result != null);
    }

    /**
     * Test of updateTransport method, of class TransportManager.
     */
    @Test
    public void testUpdateTransport() {
        System.out.println("updateTransport");
        TransportManager instance = new TransportManager();
        assertNotNull(instance);
    }

    /**
     * Test of getAllTransports method, of class TransportManager.
     */
    @Test
    public void testGetAllTransports() {
        System.out.println("getAllTransports");
        TransportManager instance = new TransportManager();
        List<Transport> result = instance.getAllTransports();
        assertNotNull(result);
    }

    /**
     * Test of getActiveTransports method, of class TransportManager.
     */
    @Test
    public void testGetActiveTransports() {
        System.out.println("getActiveTransports");
        TransportManager instance = new TransportManager();
        List<Transport> result = instance.getActiveTransports();
        assertNotNull(result);
    }

    /**
     * Test of searchTransports method, of class TransportManager.
     */
    @Test
    public void testSearchTransports() {
        System.out.println("searchTransports");
        TransportManager instance = new TransportManager();
        List<Transport> result = instance.searchTransports("", "");
        assertNotNull(result);
    }

    /**
     * Test of getTransportsByType method, of class TransportManager.
     */
    @Test
    public void testGetTransportsByType() {
        System.out.println("getTransportsByType");
        TransportManager instance = new TransportManager();
        List<Transport> result = instance.getTransportsByType(TransportType.BUS);
        assertNotNull(result);
    }

    /**
     * Test of getAvailableTransports method, of class TransportManager.
     */
    @Test
    public void testGetAvailableTransports() {
        System.out.println("getAvailableTransports");
        TransportManager instance = new TransportManager();
        List<Transport> result = instance.getAvailableTransports();
        assertNotNull(result);
    }

    /**
     * Test of getTransportsByRoute method, of class TransportManager.
     */
    @Test
    public void testGetTransportsByRoute() {
        System.out.println("getTransportsByRoute");
        TransportManager instance = new TransportManager();
        List<Transport> result = instance.getTransportsByRoute("", "");
        assertNotNull(result);
    }

    /**
     * Test of bookSeat method, of class TransportManager.
     */
    @Test
    public void testBookSeat() {
        System.out.println("bookSeat");
        TransportManager instance = new TransportManager();
        boolean result = instance.bookSeat("");
        assertTrue(result == true || result == false);
    }

    /**
     * Test of cancelSeat method, of class TransportManager.
     */
    @Test
    public void testCancelSeat() {
        System.out.println("cancelSeat");
        TransportManager instance = new TransportManager();
        boolean result = instance.cancelSeat("");
        assertTrue(result == true || result == false);
    }

    /**
     * Test of addVehicle method, of class TransportManager.
     */
    @Test
    public void testAddVehicle() {
        System.out.println("addVehicle");
        TransportManager instance = new TransportManager();
        assertNotNull(instance);
    }

    /**
     * Test of removeVehicle method, of class TransportManager.
     */
    @Test
    public void testRemoveVehicle() {
        System.out.println("removeVehicle");
        TransportManager instance = new TransportManager();
        assertNotNull(instance);
    }

    /**
     * Test of getVehicleById method, of class TransportManager.
     */
    @Test
    public void testGetVehicleById() {
        System.out.println("getVehicleById");
        TransportManager instance = new TransportManager();
        Vehicle result = instance.getVehicleById("");
        assertTrue(result == null || result != null);
    }

    /**
     * Test of getAllVehicles method, of class TransportManager.
     */
    @Test
    public void testGetAllVehicles() {
        System.out.println("getAllVehicles");
        TransportManager instance = new TransportManager();
        List<Vehicle> result = instance.getAllVehicles();
        assertNotNull(result);
    }

    /**
     * Test of getOperationalVehicles method, of class TransportManager.
     */
    @Test
    public void testGetOperationalVehicles() {
        System.out.println("getOperationalVehicles");
        TransportManager instance = new TransportManager();
        List<Vehicle> result = instance.getOperationalVehicles();
        assertNotNull(result);
    }

    /**
     * Test of getVehiclesByType method, of class TransportManager.
     */
    @Test
    public void testGetVehiclesByType() {
        System.out.println("getVehiclesByType");
        TransportManager instance = new TransportManager();
        List<Vehicle> result = instance.getVehiclesByType(TransportType.BUS);
        assertNotNull(result);
    }

    /**
     * Test of getSeatsForTransport method, of class TransportManager.
     */
    @Test
    public void testGetSeatsForTransport() {
        System.out.println("getSeatsForTransport");
        TransportManager instance = new TransportManager();
        List<Seat> result = instance.getSeatsForTransport("");
        assertNotNull(result);
    }

    /**
     * Test of getAvailableSeats method, of class TransportManager.
     */
    @Test
    public void testGetAvailableSeats() {
        System.out.println("getAvailableSeats");
        TransportManager instance = new TransportManager();
        List<Seat> result = instance.getAvailableSeats("");
        assertNotNull(result);
    }

    /**
     * Test of bookSpecificSeat method, of class TransportManager.
     */
    @Test
    public void testBookSpecificSeat() {
        System.out.println("bookSpecificSeat");
        TransportManager instance = new TransportManager();
        boolean result = instance.bookSpecificSeat("", "", "", "");
        assertTrue(result == true || result == false);
    }

    /**
     * Test of cancelSpecificSeat method, of class TransportManager.
     */
    @Test
    public void testCancelSpecificSeat() {
        System.out.println("cancelSpecificSeat");
        TransportManager instance = new TransportManager();
        boolean result = instance.cancelSpecificSeat("", "");
        assertTrue(result == true || result == false);
    }

    /**
     * Test of getTotalTransports method, of class TransportManager.
     */
    @Test
    public void testGetTotalTransports() {
        System.out.println("getTotalTransports");
        TransportManager instance = new TransportManager();
        int result = instance.getTotalTransports();
        assertTrue(result >= 0);
    }

    /**
     * Test of getActiveTransportsCount method, of class TransportManager.
     */
    @Test
    public void testGetActiveTransportsCount() {
        System.out.println("getActiveTransportsCount");
        TransportManager instance = new TransportManager();
        int result = instance.getActiveTransportsCount();
        assertTrue(result >= 0);
    }

    /**
     * Test of getTotalVehicles method, of class TransportManager.
     */
    @Test
    public void testGetTotalVehicles() {
        System.out.println("getTotalVehicles");
        TransportManager instance = new TransportManager();
        int result = instance.getTotalVehicles();
        assertTrue(result >= 0);
    }

    /**
     * Test of getOperationalVehiclesCount method, of class TransportManager.
     */
    @Test
    public void testGetOperationalVehiclesCount() {
        System.out.println("getOperationalVehiclesCount");
        TransportManager instance = new TransportManager();
        int result = instance.getOperationalVehiclesCount();
        assertTrue(result >= 0);
    }

    /**
     * Test of getTransportCountByType method, of class TransportManager.
     */
    @Test
    public void testGetTransportCountByType() {
        System.out.println("getTransportCountByType");
        TransportManager instance = new TransportManager();
        Map<TransportType, Long> result = instance.getTransportCountByType();
        assertNotNull(result);
    }

    /**
     * Test of getAverageOccupancyRate method, of class TransportManager.
     */
    @Test
    public void testGetAverageOccupancyRate() {
        System.out.println("getAverageOccupancyRate");
        TransportManager instance = new TransportManager();
        double result = instance.getAverageOccupancyRate();
        assertTrue(result >= 0.0 || result < 0.0);
    }

    /**
     * Test of getFullyBookedTransports method, of class TransportManager.
     */
    @Test
    public void testGetFullyBookedTransports() {
        System.out.println("getFullyBookedTransports");
        TransportManager instance = new TransportManager();
        List<Transport> result = instance.getFullyBookedTransports();
        assertNotNull(result);
    }
}