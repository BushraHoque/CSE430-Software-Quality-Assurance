package model;

import enumtype.BookingStatus;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookingTest {

    private Booking booking;

    @Before
    public void setUp() {
        booking = new Booking("B001", "U001", "P001", "2025-12-15", 2);
        booking.setTotalAmount(1500.0);
        booking.setSpecialRequests("Near window seat");
        booking.setHotelId("H001");
        booking.setTransportId("T001");
        booking.setGuideId("G001");
        booking.setPaid(true);
    }

    @Test
    public void testConfirmBooking() {
        booking.confirmBooking();
        assertEquals(BookingStatus.CONFIRMED, booking.getStatus());
    }

    @Test
    public void testCancelBooking() {
        booking.cancelBooking();
        assertEquals(BookingStatus.CANCELED, booking.getStatus());
    }

    @Test
    public void testCompleteBooking() {
        booking.completeBooking();
        assertEquals(BookingStatus.COMPLETED, booking.getStatus());
    }

    @Test
    public void testGetAndSetBookingId() {
        booking.setBookingId("B002");
        assertEquals("B002", booking.getBookingId());
    }

    @Test
    public void testGetAndSetUserId() {
        booking.setUserId("U002");
        assertEquals("U002", booking.getUserId());
    }

    @Test
    public void testGetAndSetPackageId() {
        booking.setPackageId("P002");
        assertEquals("P002", booking.getPackageId());
    }

    @Test
    public void testGetBookingDate() {
        assertNotNull(booking.getBookingDate());
    }

    @Test
    public void testGetAndSetTravelDate() {
        booking.setTravelDate("2025-12-20");
        assertEquals("2025-12-20", booking.getTravelDate());
    }

    @Test
    public void testGetAndSetStatus() {
        booking.setStatus(BookingStatus.CONFIRMED);
        assertEquals(BookingStatus.CONFIRMED, booking.getStatus());
    }

    @Test
    public void testGetAndSetNumberOfPeople() {
        booking.setNumberOfPeople(4);
        assertEquals(4, booking.getNumberOfPeople());
    }

    @Test
    public void testGetAndSetTotalAmount() {
        booking.setTotalAmount(2000.0);
        assertEquals(2000.0, booking.getTotalAmount(), 0.01);
    }

    @Test
    public void testGetAndSetSpecialRequests() {
        booking.setSpecialRequests("Veg meals only");
        assertEquals("Veg meals only", booking.getSpecialRequests());
    }

    @Test
    public void testGetAndSetHotelId() {
        booking.setHotelId("H002");
        assertEquals("H002", booking.getHotelId());
    }

    @Test
    public void testGetAndSetTransportId() {
        booking.setTransportId("T002");
        assertEquals("T002", booking.getTransportId());
    }

    @Test
    public void testGetAndSetGuideId() {
        booking.setGuideId("G002");
        assertEquals("G002", booking.getGuideId());
    }

    @Test
    public void testIsAndSetPaid() {
        booking.setPaid(false);
        assertFalse(booking.isPaid());
    }

    @Test
    public void testToStringNotNull() {
        assertNotNull(booking.toString());
        assertTrue(booking.toString().contains("bookingId='B001'"));
    }
        // -------------------- CORNER CASE TESTS (append below) --------------------

    @Test
    public void testConfirmBooking_Idempotent() {
        booking.confirmBooking();
        booking.confirmBooking(); // repeat
        assertEquals(BookingStatus.CONFIRMED, booking.getStatus());
    }

    @Test
    public void testCancelAfterConfirm_OverridesStatus() {
        booking.confirmBooking();
        booking.cancelBooking();
        assertEquals(BookingStatus.CANCELED, booking.getStatus());
    }

    @Test
    public void testSetNumberOfPeopleZero() {
        booking.setNumberOfPeople(0);
        assertEquals(0, booking.getNumberOfPeople());
    }

    @Test
    public void testSetNumberOfPeopleNegative() {
        booking.setNumberOfPeople(-3);
        assertEquals(-3, booking.getNumberOfPeople());
    }

    @Test
    public void testSetTotalAmountZero() {
        booking.setTotalAmount(0.0);
        assertEquals(0.0, booking.getTotalAmount(), 0.0001);
    }

    @Test
    public void testSetTotalAmountNegative() {
        booking.setTotalAmount(-500.0);
        assertEquals(-500.0, booking.getTotalAmount(), 0.0001);
    }

    @Test
    public void testSetTravelDateEmptyString() {
        booking.setTravelDate("");
        assertEquals("", booking.getTravelDate());
    }

    @Test
    public void testSetIdsEmptyString() {
        booking.setBookingId("");
        booking.setUserId("");
        booking.setPackageId("");
        booking.setHotelId("");
        booking.setTransportId("");
        booking.setGuideId("");

        assertEquals("", booking.getBookingId());
        assertEquals("", booking.getUserId());
        assertEquals("", booking.getPackageId());
        assertEquals("", booking.getHotelId());
        assertEquals("", booking.getTransportId());
        assertEquals("", booking.getGuideId());
    }

    @Test
    public void testSetStatusNullAllowed() {
        booking.setStatus(null);
        assertNull(booking.getStatus());
    }

    @Test
    public void testPaidToggleTwice() {
        booking.setPaid(false);
        assertFalse(booking.isPaid());
        booking.setPaid(true);
        assertTrue(booking.isPaid());
    }

    @Test
    public void testVeryLargeNumbers() {
        booking.setNumberOfPeople(1_000_000);
        booking.setTotalAmount(1_000_000_000.0);
        assertEquals(1_000_000, booking.getNumberOfPeople());
        assertEquals(1_000_000_000.0, booking.getTotalAmount(), 0.1);
    }

    @Test
    public void testBookingDateNotChangedByStatusChange() {
        Object initial = booking.getBookingDate(); // keep it generic to avoid type issues
        booking.confirmBooking();
        booking.cancelBooking();
        booking.completeBooking();
        assertEquals(initial, booking.getBookingDate());
    }

    @Test
    public void testToStringSafeWithEmptyFields() {
        booking.setSpecialRequests("");
        booking.setHotelId("");
        booking.setTransportId("");
        booking.setGuideId("");
        String s = booking.toString();
        assertNotNull(s);
        // still include original bookingId from setUp (B001) in this test class instance
        assertTrue(s.contains("B001"));
    }

}
