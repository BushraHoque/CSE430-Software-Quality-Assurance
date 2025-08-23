package model;

import enumtype.TransportType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TransportTest {

    private Transport instance;

    @Before
    public void setUp() {

        instance = new Transport("T123", TransportType.BUS, "Dhaka", "Chittagong");
    }


    @Test
    public void testCancelSeat() {

        instance.bookSeat();
        int afterBooking = instance.getAvailableSeats();


        instance.cancelSeat();
        assertEquals(afterBooking + 1, instance.getAvailableSeats());


        int totalSeats = instance.getTotalSeats();
        instance.setAvailableSeats(totalSeats);
        instance.cancelSeat();
        assertEquals(totalSeats, instance.getAvailableSeats());
    }

    @Test
    public void testGetAndSetTransportId() {
        instance.setTransportId("NEWID123");
        assertEquals("NEWID123", instance.getTransportId());
    }

    @Test
    public void testGetAndSetType() {
        instance.setType(TransportType.FLIGHT);
        assertEquals(TransportType.FLIGHT, instance.getType());
    }

    @Test
    public void testGetAndSetDeparture() {
        instance.setDeparture("Sylhet");
        assertEquals("Sylhet", instance.getDeparture());
    }

    @Test
    public void testGetAndSetArrival() {
        instance.setArrival("Khulna");
        assertEquals("Khulna", instance.getArrival());
    }

    @Test
    public void testGetAndSetDepartureTime() {
        instance.setDepartureTime("10:00 AM");
        assertEquals("10:00 AM", instance.getDepartureTime());
    }

    @Test
    public void testGetAndSetArrivalTime() {
        instance.setArrivalTime("2:00 PM");
        assertEquals("2:00 PM", instance.getArrivalTime());
    }

    @Test
    public void testGetAndSetFare() {
        instance.setFare(1500.0);
        assertEquals(1500.0, instance.getFare(), 0.001);
    }

    @Test
    public void testGetAndSetTotalSeats() {
        instance.setTotalSeats(50);
        assertEquals(50, instance.getTotalSeats());
    }

    @Test
    public void testGetAndSetAvailableSeats() {
        instance.setAvailableSeats(20);
        assertEquals(20, instance.getAvailableSeats());
    }

    @Test
    public void testGetAndSetOperatorName() {
        instance.setOperatorName("Best Transport");
        assertEquals("Best Transport", instance.getOperatorName());
    }

    @Test
    public void testIsActiveAndSetActive() {
        assertTrue(instance.isActive());
        instance.setActive(false);
        assertFalse(instance.isActive());
    }

    @Test
    public void testToString() {
        String str = instance.toString();
        assertTrue(str.contains("Transport{"));
        assertTrue(str.contains("type="));
        assertTrue(str.contains("departure="));
        assertTrue(str.contains("arrival="));
        assertTrue(str.contains("fare="));
        assertTrue(str.contains("availableSeats="));
    }
}
