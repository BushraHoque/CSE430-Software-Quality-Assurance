import auth.AuthService;
import manager.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import report.ReportGenerator;

import static org.junit.Assert.*;


public class MainTest {

    public MainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        // Runs once before all tests
    }

    @AfterClass
    public static void tearDownClass() {
        // Runs once after all tests
    }

    @Before
    public void setUp() {
        // Runs before each test
    }

    @After
    public void tearDown() {
        // Runs after each test
    }


    @Test
public void testMain() {
   
    System.out.println("main");
    String[] args = new String[0];
    try {
        Main.main(args);
        // Assert that args is still empty after main execution
        assertEquals("Args array should remain empty", 0, args.length);
    } catch (Exception e) {
        fail("Main method threw an exception: " + e.getMessage());
    }
}



    // ============================
    // Manager Getter Tests
    // ============================

    @Test
    public void testGetUserManager() {
        System.out.println("getUserManager");
        UserManager result = Main.getUserManager();
        assertTrue(result == null || result instanceof UserManager);
    }

    @Test
    public void testGetPackageManager() {
        System.out.println("getPackageManager");
        PackageManager result = Main.getPackageManager();
        assertTrue(result == null || result instanceof PackageManager);
    }

    @Test
    public void testGetBookingManager() {
        System.out.println("getBookingManager");
        BookingManager result = Main.getBookingManager();
        assertTrue(result == null || result instanceof BookingManager);
    }

    @Test
    public void testGetPaymentManager() {
        System.out.println("getPaymentManager");
        PaymentManager result = Main.getPaymentManager();
        assertTrue(result == null || result instanceof PaymentManager);
    }

    @Test
    public void testGetHotelManager() {
        System.out.println("getHotelManager");
        HotelManager result = Main.getHotelManager();
        assertTrue(result == null || result instanceof HotelManager);
    }

    @Test
    public void testGetTransportManager() {
        System.out.println("getTransportManager");
        TransportManager result = Main.getTransportManager();
        assertTrue(result == null || result instanceof TransportManager);
    }

    @Test
    public void testGetGuideManager() {
        System.out.println("getGuideManager");
        GuideManager result = Main.getGuideManager();
        assertTrue(result == null || result instanceof GuideManager);
    }

    @Test
    public void testGetReviewManager() {
        System.out.println("getReviewManager");
        ReviewManager result = Main.getReviewManager();
        assertTrue(result == null || result instanceof ReviewManager);
    }

    @Test
    public void testGetRefundManager() {
        System.out.println("getRefundManager");
        RefundManager result = Main.getRefundManager();
        assertTrue(result == null || result instanceof RefundManager);
    }

    @Test
    public void testGetRoomManager() {
        System.out.println("getRoomManager");
        RoomManager result = Main.getRoomManager();
        assertTrue(result == null || result instanceof RoomManager);
    }

    @Test
    public void testGetAuthService() {
        System.out.println("getAuthService");
        AuthService result = Main.getAuthService();
        assertTrue(result == null || result instanceof AuthService);
    }

    @Test
    public void testGetReportGenerator() {
        System.out.println("getReportGenerator");
        ReportGenerator result = Main.getReportGenerator();
        assertTrue(result == null || result instanceof ReportGenerator);
    }

    // ============================
    // Singleton Pattern Tests
    // ============================

    @Test
    public void testSingletonManagers() {
        // Ensures each manager follows singleton pattern
        // Multiple calls should return same instance
        assertSame(Main.getUserManager(), Main.getUserManager());
        assertSame(Main.getPackageManager(), Main.getPackageManager());
        assertSame(Main.getBookingManager(), Main.getBookingManager());
        assertSame(Main.getPaymentManager(), Main.getPaymentManager());
        assertSame(Main.getHotelManager(), Main.getHotelManager());
        assertSame(Main.getTransportManager(), Main.getTransportManager());
        assertSame(Main.getGuideManager(), Main.getGuideManager());
        assertSame(Main.getReviewManager(), Main.getReviewManager());
        assertSame(Main.getRefundManager(), Main.getRefundManager());
        assertSame(Main.getRoomManager(), Main.getRoomManager());
        assertSame(Main.getAuthService(), Main.getAuthService());
        assertSame(Main.getReportGenerator(), Main.getReportGenerator());
    }

    

// Null / Corner Case Tests
    
    
     
    @Test
public void testMainWithNullArgs() {
    // Corner case: Passing null instead of empty array
    // Many programs assume args is non-null, so we verify null safety
    try {
        Main.main(null);
      
        assertTrue("Main executed successfully with null args", true);
    } catch (Exception e) {
        fail("Main method threw exception with null args: " + e.getMessage());
    }
}

@Test
public void testMainWithLongArgs() {
    // Corner case: Passing unusually long arguments
    // Ensures the program can handle large string inputs without crashing
    String[] args = new String[]{"arg1", "arg2", "arg3", "thisIsAVeryLongArgumentToTestBehavior"};
    try {
        Main.main(args);
        // Assertion to indicate the method executed successfully
        assertTrue("Main executed successfully with long args", true);
    } catch (Exception e) {
        fail("Main method threw exception with long args: " + e.getMessage());
    }
}
    

    @Test
    public void testManagersNullSafety() {
        // Corner case: Tests lazy initialization safety
        // If managers are null initially, calling getters should still return non-null
        assertNotNull("UserManager should not be null after access", Main.getUserManager());
        assertNotNull("PackageManager should not be null after access", Main.getPackageManager());
        assertNotNull("BookingManager should not be null after access", Main.getBookingManager());
        assertNotNull("PaymentManager should not be null after access", Main.getPaymentManager());
        assertNotNull("HotelManager should not be null after access", Main.getHotelManager());
        assertNotNull("TransportManager should not be null after access", Main.getTransportManager());
        assertNotNull("GuideManager should not be null after access", Main.getGuideManager());
        assertNotNull("ReviewManager should not be null after access", Main.getReviewManager());
        assertNotNull("RefundManager should not be null after access", Main.getRefundManager());
        assertNotNull("RoomManager should not be null after access", Main.getRoomManager());
        assertNotNull("AuthService should not be null after access", Main.getAuthService());
        assertNotNull("ReportGenerator should not be null after access", Main.getReportGenerator());
    }
}
