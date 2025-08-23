package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeatTest {

    private Seat seat;

    @BeforeClass
    public static void setUpClass() {
      
    }

    @AfterClass
    public static void tearDownClass() {
      
    }

    @Before
    public void setUp() {
        
        seat = new Seat("S001", "T001", "12A");
        seat.setSeatType("Window");
    }

    @After
    public void tearDown() {
        seat = null;
    }

    @Test
    public void testBookSeat_success() {
        boolean result = seat.bookSeat("Jahid", "0123456789");
        assertTrue(result);
        assertFalse(seat.isAvailable());
        assertEquals("John Doe", seat.getPassengerName());
        assertEquals("0123456789", seat.getPassengerPhone());
    }

    @Test
    public void testBookSeat_fail_whenBlocked() {
        seat.setBlocked(true);
        boolean result = seat.bookSeat("Jahid", "0123456789");
        assertFalse(result);
        assertTrue(seat.isAvailable());
    }

    @Test
    public void testCancelSeat() {
        seat.bookSeat("Jahid", "0123456789");
        seat.cancelSeat();
        assertTrue(seat.isAvailable());
        assertNull(seat.getPassengerName());
        assertNull(seat.getPassengerPhone());
    }

    @Test
    public void testGettersAndSetters() {
        seat.setSeatId("S002");
        assertEquals("S002", seat.getSeatId());

        seat.setTransportId("T002");
        assertEquals("T002", seat.getTransportId());

        seat.setSeatNumber("14B");
        assertEquals("14B", seat.getSeatNumber());

        seat.setAvailable(false);
        assertFalse(seat.isAvailable());

        seat.setPassengerName("Alice");
        assertEquals("Alice", seat.getPassengerName());

        seat.setPassengerPhone("0987654321");
        assertEquals("0987654321", seat.getPassengerPhone());

        seat.setSeatType("Aisle");
        assertEquals("Aisle", seat.getSeatType());

        seat.setExtraCharge(15.5);
        assertEquals(15.5, seat.getExtraCharge(), 0.001);

        seat.setBlocked(true);
        assertTrue(seat.isBlocked());
    }

    @Test
    public void testToString_containsSeatNumberAndPassengerName() {
        seat.bookSeat("John Doe", "0123456789");
        String str = seat.toString();
        assertTrue(str.contains("12A"));
        assertTrue(str.contains("John Doe"));
    }
}
