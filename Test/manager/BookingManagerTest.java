package manager;

import enumtype.BookingStatus;
import java.util.List;
import java.util.Map;
import model.Booking;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookingManagerTest {

    public BookingManagerTest() {
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

    @Test
    public void testAddBooking() {
        System.out.println("addBooking");
        Booking booking = null;
        BookingManager instance = new BookingManager();
        instance.addBooking(booking);
    }

    @Test
    public void testRemoveBooking() {
        System.out.println("removeBooking");
        String bookingId = "";
        BookingManager instance = new BookingManager();
        instance.removeBooking(bookingId);
    }

    @Test
    public void testGetBookingById() {
        System.out.println("getBookingById");
        String bookingId = "";
        BookingManager instance = new BookingManager();
        Booking expResult = null;
        Booking result = instance.getBookingById(bookingId);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateBooking() {
        System.out.println("updateBooking");
        Booking booking = null;
        BookingManager instance = new BookingManager();
        instance.updateBooking(booking);
    }

    @Test
    public void testGetAllBookings() {
        System.out.println("getAllBookings");
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getAllBookings();
    }

    @Test
    public void testGetBookingsByUser() {
        System.out.println("getBookingsByUser");
        String userId = "";
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getBookingsByUser(userId);
    }

    @Test
    public void testGetBookingsByPackage() {
        System.out.println("getBookingsByPackage");
        String packageId = "";
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getBookingsByPackage(packageId);
    }

    @Test
    public void testGetBookingsByStatus() {
        System.out.println("getBookingsByStatus");
        BookingStatus status = null;
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getBookingsByStatus(status);
    }

    @Test
    public void testGetBookingsByDate() {
        System.out.println("getBookingsByDate");
        String date = "";
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getBookingsByDate(date);
    }

    @Test
    public void testGetBookingsByTravelDate() {
        System.out.println("getBookingsByTravelDate");
        String travelDate = "";
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getBookingsByTravelDate(travelDate);
    }

    @Test
    public void testGetBookingsInDateRange() {
        System.out.println("getBookingsInDateRange");
        String startDate = "";
        String endDate = "";
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getBookingsInDateRange(startDate, endDate);
    }

    @Test
    public void testGetPendingBookings() {
        System.out.println("getPendingBookings");
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getPendingBookings();
    }

    @Test
    public void testGetConfirmedBookings() {
        System.out.println("getConfirmedBookings");
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getConfirmedBookings();
    }

    @Test
    public void testGetCancelledBookings() {
        System.out.println("getCancelledBookings");
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getCancelledBookings();
    }

    @Test
    public void testCancelBooking() {
        System.out.println("cancelBooking");
        String bookingId = "";
        String reason = "";
        BookingManager instance = new BookingManager();
        boolean expResult = false;
        boolean result = instance.cancelBooking(bookingId, reason);
        assertEquals(expResult, result);
    }

    @Test
    public void testConfirmBooking() {
        System.out.println("confirmBooking");
        String bookingId = "";
        BookingManager instance = new BookingManager();
        boolean expResult = false;
        boolean result = instance.confirmBooking(bookingId);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompleteBooking() {
        System.out.println("completeBooking");
        String bookingId = "";
        BookingManager instance = new BookingManager();
        boolean expResult = false;
        boolean result = instance.completeBooking(bookingId);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalRevenue() {
        System.out.println("getTotalRevenue");
        BookingManager instance = new BookingManager();
        double expResult = 14000.0;
        double result = instance.getTotalRevenue();
        assertEquals(expResult, result, 14000.0);
    }

    @Test
    public void testGetRevenueByPackage() {
        System.out.println("getRevenueByPackage");
        String packageId = "";
        BookingManager instance = new BookingManager();
        double expResult = 0.0;
        double result = instance.getRevenueByPackage(packageId);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTotalBookings() {
        System.out.println("getTotalBookings");
        BookingManager instance = new BookingManager();
        int expResult = 1;
        int result = instance.getTotalBookings();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBookingsCountByStatus() {
        System.out.println("getBookingsCountByStatus");
        BookingStatus status = null;
        BookingManager instance = new BookingManager();
        int expResult = 0;
        int result = instance.getBookingsCountByStatus(status);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUpcomingBookings() {
        System.out.println("getUpcomingBookings");
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getUpcomingBookings();
    }

    @Test
    public void testGetTodaysBookings() {
        System.out.println("getTodaysBookings");
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.getTodaysBookings();
    }

    @Test
    public void testGetBookingCountsByMonth() {
        System.out.println("getBookingCountsByMonth");
        BookingManager instance = new BookingManager();
        Map<String, Integer> result = instance.getBookingCountsByMonth();
    }

    @Test
    public void testSearchBookings() {
        System.out.println("searchBookings");
        String keyword = "";
        BookingManager instance = new BookingManager();
        List<Booking> result = instance.searchBookings(keyword);
    }
        // ---------------- CORNER CASE TESTS ----------------

    @Test
    public void testAddNullBooking() {
        BookingManager manager = new BookingManager();
        manager.addBooking(null); // should not throw exception
        assertEquals(1, manager.getTotalBookings());
    }

    @Test
    public void testRemoveNonExistentBooking() {
        BookingManager manager = new BookingManager();
        manager.removeBooking("NON_EXISTENT"); // should not throw exception
        assertNull(manager.getBookingById("NON_EXISTENT"));
    }

    @Test
    public void testGetBookingByIdInvalid() {
        BookingManager manager = new BookingManager();
        assertNull(manager.getBookingById("INVALID_ID"));
    }

    @Test
    public void testGetBookingsByUserInvalid() {
        BookingManager manager = new BookingManager();
        assertTrue(manager.getBookingsByUser("INVALID_USER").isEmpty());
    }

    @Test
    public void testGetBookingsByPackageInvalid() {
        BookingManager manager = new BookingManager();
        assertTrue(manager.getBookingsByPackage("INVALID_PACKAGE").isEmpty());
    }

    @Test
    public void testGetBookingsByStatusNull() {
        BookingManager manager = new BookingManager();
        assertTrue(manager.getBookingsByStatus(null).isEmpty());
    }

    @Test
    public void testGetBookingsByInvalidDate() {
        BookingManager manager = new BookingManager();
        assertTrue(manager.getBookingsByDate("2099-99-99").isEmpty()); // invalid future-like date
    }

    @Test
    public void testGetBookingsInDateRangeInvalid() {
        BookingManager manager = new BookingManager();
        assertTrue(manager.getBookingsInDateRange("2030-12-31", "2020-01-01").isEmpty()); // reversed dates
    }

    @Test
    public void testCancelBookingInvalidId() {
        BookingManager manager = new BookingManager();
        assertFalse(manager.cancelBooking("INVALID_ID", "Reason"));
    }

    @Test
    public void testConfirmBookingInvalidId() {
        BookingManager manager = new BookingManager();
        assertFalse(manager.confirmBooking("INVALID_ID"));
    }

    @Test
    public void testCompleteBookingInvalidId() {
        BookingManager manager = new BookingManager();
        assertFalse(manager.completeBooking("INVALID_ID"));
    }

    @Test
    public void testGetRevenueByPackageInvalid() {
        BookingManager manager = new BookingManager();
        assertEquals(0.0, manager.getRevenueByPackage("INVALID_PACKAGE"), 0.0);
    }

    @Test
    public void testGetBookingsCountByStatusNull() {
        BookingManager manager = new BookingManager();
        assertEquals(0, manager.getBookingsCountByStatus(null));
    }

    @Test
    public void testSearchBookingsNoResult() {
        BookingManager manager = new BookingManager();
        assertTrue(manager.searchBookings("NonMatchingKeyword").isEmpty());
    }

}
