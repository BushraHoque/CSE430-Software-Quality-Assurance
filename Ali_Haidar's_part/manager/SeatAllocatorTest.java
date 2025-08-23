package manager;

import model.Seat;
import model.Transport;
import enumtype.TransportType;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class SeatAllocatorTest {

    @Test
    public void testAutoAssignSeats_returnsEmptyList() {
        System.out.println("autoAssignSeats - returns empty list (placeholder)");

        Transport transport = new Transport("T001", TransportType.BUS, "Dhaka", "Chittagong");
        SeatAllocator allocator = new SeatAllocator();

        List<Seat> result = allocator.autoAssignSeats(transport, 2);

        assertNotNull(result);
        assertTrue(result.isEmpty()); 
    }

    @Test
    public void testFindBestAvailableSeat_withPreferredType() {
        System.out.println("findBestAvailableSeat - preferred type exists");

        List<Seat> availableSeats = new ArrayList<>();

        Seat seat1 = new Seat("S001", "T001", "1A");
        seat1.setSeatType("Window");

        Seat seat2 = new Seat("S002", "T001", "1B");
        seat2.setSeatType("Aisle");

        availableSeats.add(seat1);
        availableSeats.add(seat2);

        String preferredType = "Window";
        SeatAllocator allocator = new SeatAllocator();

        Seat result = allocator.findBestAvailableSeat(availableSeats, preferredType);

        assertNotNull(result);
        assertEquals("Window", result.getSeatType());
    }

    @Test
    public void testFindBestAvailableSeat_withoutPreferredType() {
        System.out.println("findBestAvailableSeat - preferred type NOT exists");

        List<Seat> availableSeats = new ArrayList<>();

        Seat seat1 = new Seat("S001", "T001", "1A");
        seat1.setSeatType("Middle");

        Seat seat2 = new Seat("S002", "T001", "1B");
        seat2.setSeatType("Middle");

        availableSeats.add(seat1);
        availableSeats.add(seat2);

        String preferredType = "Window";
        SeatAllocator allocator = new SeatAllocator();

        Seat result = allocator.findBestAvailableSeat(availableSeats, preferredType);

        assertNotNull(result);
        assertEquals("Middle", result.getSeatType());
    }

    @Test
    public void testFindBestAvailableSeat_withEmptyList() {
        System.out.println("findBestAvailableSeat - empty list");

        List<Seat> availableSeats = new ArrayList<>();
        String preferredType = "Window";

        SeatAllocator allocator = new SeatAllocator();
        Seat result = allocator.findBestAvailableSeat(availableSeats, preferredType);

        assertNull(result);
    }

}
