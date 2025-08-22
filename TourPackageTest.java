package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TourPackageTest {

    private TourPackage instance;

    @Before
    public void setUp() {
        instance = new TourPackage(
            "PKG001",
            "Test Package",
            "Cox's Bazar",
            10000.0,
            3,
            "Beautiful beach destination"
        );
    }

    @Test
    public void testCancelBooking() {
        instance.setCurrentBookings(3);
        instance.cancelBooking();
        assertEquals(2, instance.getCurrentBookings());
    }

    

    @Test
    public void testAddBooking() {
        instance.setCurrentBookings(3);
        instance.addBooking();
        assertEquals(4, instance.getCurrentBookings());
    }


    @Test
    public void testGetCurrentBookings() {
        instance.setCurrentBookings(7);
        int result = instance.getCurrentBookings();
        assertEquals(7, result);
    }

    

    @Test
    public void testSetCurrentBookings() {
        instance.setCurrentBookings(10);
        assertEquals(10, instance.getCurrentBookings());
    }

    @Test
    public void testGetMaxCapacity() {
        instance.setMaxCapacity(50);
        assertEquals(50, instance.getMaxCapacity());
    }

   
    @Test
    public void testSetMaxCapacity() {
        instance.setMaxCapacity(25);
        assertEquals(25, instance.getMaxCapacity());
    }

    @Test
    public void testGetRating() {
        instance.setRating(4.0);
        assertEquals(4.0, instance.getRating(), 0.001);
    }


    @Test
    public void testSetRating() {
        instance.setRating(4.5);
        assertEquals(4.5, instance.getRating(), 0.001);
    }

    @Test
    public void testGetTotalReviews() {
        instance.setTotalReviews(10);
        int result = instance.getTotalReviews();
        assertEquals(10, result);
    }

    @Test
    public void testSetTotalReviews_Negative() {
        // Corner case: Negative reviews
        instance.setTotalReviews(-3);
        assertEquals(-3, instance.getTotalReviews());
    }

    @Test
    public void testSetTotalReviews() {
        instance.setTotalReviews(15);
        assertEquals(15, instance.getTotalReviews());
    }

    @Test
    public void testGetDiscountPercentage() {
        instance.setDiscountPercentage(10.0);
        double result = instance.getDiscountPercentage();
        assertEquals(10.0, result, 0.001);
    }

    

    @Test
    public void testSetDiscountPercentage() {
        instance.setDiscountPercentage(15.5);
        assertEquals(15.5, instance.getDiscountPercentage(), 0.001);
    }

    @Test
    public void testGetCategory() {
        instance.setCategory(null); // we can’t use enum, but ensure no crash
        assertNull(instance.getCategory());
    }

    @Test
    public void testSetCategory() {
        instance.setCategory(null); // safely test setter
        assertNull(instance.getCategory());
    }

    @Test
    public void testGetTourType() {
        instance.setTourType(null);
        assertNull(instance.getTourType());
    }

    @Test
    public void testSetTourType() {
        instance.setTourType(null);
        assertNull(instance.getTourType());
    }

    @Test
    public void testIsActive() {
        instance.setActive(true);
        assertTrue(instance.isActive());
    }

    @Test
    public void testSetActive() {
        instance.setActive(false);
        assertFalse(instance.isActive());
    }

    @Test
    public void testIsFeatured() {
        instance.setFeatured(false);
        assertFalse(instance.isFeatured());
    }

    @Test
    public void testSetFeatured() {
        instance.setFeatured(true);
        assertTrue(instance.isFeatured());
    }

    @Test
    public void testGetCreatedBy() {
        instance.setCreatedBy("admin");
        assertEquals("admin", instance.getCreatedBy());
    }
    
    @Test
    public void testSetValidTo() {
        instance.setValidTo("2024-12-31");
        assertEquals("2024-12-31", instance.getValidTo());
    }
    
    
    
    @Test
    public void testSetCreatedBy() {
        instance.setCreatedBy("manager");
        assertEquals("manager", instance.getCreatedBy());
    }

    @Test
    public void testGetCreatedDate() {
        instance.setCreatedDate("2023-01-01");
        assertEquals("2023-01-01", instance.getCreatedDate());
    }
    
    

    @Test
    public void testSetCreatedDate() {
        instance.setCreatedDate("2024-01-01");
        assertEquals("2024-01-01", instance.getCreatedDate());
    }

    @Test
    public void testGetLastModified() {
        instance.setLastModified("2023-08-01");
        assertEquals("2023-08-01", instance.getLastModified());
    }


    @Test
    public void testSetLastModified() {
        instance.setLastModified("2024-08-01");
        assertEquals("2024-08-01", instance.getLastModified());
    }

    @Test
    public void testGetPackageId() {
        assertEquals("PKG001", instance.getPackageId());
    }

   

    @Test
    public void testSetPackageId() {
        instance.setPackageId("PKG999");
        assertEquals("PKG999", instance.getPackageId());
    }

    @Test
    public void testGetValidFrom() {
        instance.setValidFrom("2023-01-01");
        assertEquals("2023-01-01", instance.getValidFrom());
    }

    

    @Test
    public void testSetValidFrom() {
        instance.setValidFrom("2024-01-01");
        assertEquals("2024-01-01", instance.getValidFrom());
    }

    @Test
    public void testGetValidTo() {
        instance.setValidTo("2023-12-31");
        assertEquals("2023-12-31", instance.getValidTo());
    }
    
    
    
    // Corner case
    
    
    
     @Test
    public void testSetCurrentBookings_Negative() {
        // Corner case: Negative current bookings
        instance.setCurrentBookings(-2);
        assertEquals(-2, instance.getCurrentBookings());
    }
    
    @Test
    public void testSetMaxCapacity_Zero() {
        // Corner case: Zero capacity
        instance.setMaxCapacity(0);
        assertEquals(0, instance.getMaxCapacity());
    }

    @Test
    public void testSetMaxCapacity_Negative() {
        // Corner case: Negative capacity
        instance.setMaxCapacity(-5);
        assertEquals(-5, instance.getMaxCapacity());
    }


    @Test
    public void testSetCreatedDate_Null() {
        // Corner case: Null date
        instance.setCreatedDate(null);
        assertNull(instance.getCreatedDate());
    }
    
    
     @Test
    public void testSetRating_OutOfRangeHigh() {
        // Corner case: Rating > 5
        instance.setRating(6.0);
        assertEquals(6.0, instance.getRating(), 0.001);
    }

    @Test
    public void testSetRating_OutOfRangeLow() {
        // Corner case: Rating < 0
        instance.setRating(-1.0);
        assertEquals(-1.0, instance.getRating(), 0.001);
    }

    @Test
    public void testSetCreatedBy_Empty() {
        // Corner case: Empty string for createdBy
        instance.setCreatedBy("");
        assertEquals("", instance.getCreatedBy());
    }

    
     @Test
    public void testAddBooking_WhenAtMaxCapacity() {
        // Corner case: Adding booking when at maximum capacity
        instance.setMaxCapacity(5);
        instance.setCurrentBookings(5);
        instance.addBooking(); // Might exceed if not validated
        assertTrue(instance.getCurrentBookings() >= 5);
    }
    
      @Test
    public void testSetLastModified_Empty() {
        // Corner case: Empty lastModified
        instance.setLastModified("");
        assertEquals("", instance.getLastModified());
    }
    
     @Test
    public void testSetPackageId_Null() {
        // Corner case: Null ID
        instance.setPackageId(null);
        assertNull(instance.getPackageId());
    }

    @Test
    public void testSetDiscountPercentage_Negative() {
        // Corner case: Negative discount
        instance.setDiscountPercentage(-5.0);
        assertEquals(-5.0, instance.getDiscountPercentage(), 0.001);
    }

    @Test
    public void testSetDiscountPercentage_Above100() {
        // Corner case: Discount over 100%
        instance.setDiscountPercentage(150.0);
        assertEquals(150.0, instance.getDiscountPercentage(), 0.001);
    }
    
    @Test
    public void testSetValidTo_Null() {
        // Corner case: Null validTo
        instance.setValidTo(null);
        assertNull(instance.getValidTo());
    }
    
    @Test
    public void testSetValidFrom_Empty() {
        // Corner case: Empty validFrom
        instance.setValidFrom("");
        assertEquals("", instance.getValidFrom());
    }
    
@Test
    public void testCancelBooking_WhenZeroBookings() {
        // Corner case: Cancelling when there are zero bookings
        instance.setCurrentBookings(0);
        instance.cancelBooking(); // Should not go negative
        assertTrue(instance.getCurrentBookings() >= 0);
    }
    
}
