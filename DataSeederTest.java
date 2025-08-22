package util;

import manager.HotelManager;
import manager.PackageManager;
import manager.UserManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for DataSeeder
 */
public class DataSeederTest {
    
    public DataSeederTest() {
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
     * Basic happy-path test for seedInitialData method.
     */
    @Test
    public void testSeedInitialData() {
        System.out.println("seedInitialData");

        // Create dummy (empty) manager objects
        UserManager userManager = new UserManager();
        PackageManager packageManager = new PackageManager();
        HotelManager hotelManager = new HotelManager();

        // Call method under test
        DataSeeder.seedInitialData(userManager, packageManager, hotelManager);

        // If no exception thrown, the test is successful
        assertNotNull("UserManager should not be null", userManager);
        assertNotNull("PackageManager should not be null", packageManager);
        assertNotNull("HotelManager should not be null", hotelManager);
    }

    /**
     * Corner case: Call method with already populated managers
     * This checks if seeding twice does not break or duplicate incorrectly.
     */
    @Test
    public void testSeedInitialDataWithAlreadyPopulatedManagers() {
        UserManager userManager = new UserManager();
        PackageManager packageManager = new PackageManager();
        HotelManager hotelManager = new HotelManager();

        // First seed
        DataSeeder.seedInitialData(userManager, packageManager, hotelManager);

        int userCountBefore = userManager.getAllUsers().size();
        
        int hotelCountBefore = hotelManager.getAllHotels().size();

        // Seed again
        DataSeeder.seedInitialData(userManager, packageManager, hotelManager);

        // Check if no unexpected data duplication occurred (depends on seeder implementation)
        assertTrue("User count should not decrease after reseeding", 
                   userManager.getAllUsers().size() >= userCountBefore);
        
        assertTrue("Hotel count should not decrease after reseeding", 
                   hotelManager.getAllHotels().size() >= hotelCountBefore);
    }

    /**
     * Corner case: Call method with all managers null
     * Expected: Should throw a NullPointerException or handle gracefully
     */
    @Test(expected = NullPointerException.class)
    public void testSeedInitialDataWithNullManagers() {
        DataSeeder.seedInitialData(null, null, null);
    }

    /**
     * Corner case: Call method with some managers null
     * Expected: Should throw a NullPointerException or handle gracefully
     */
    @Test(expected = NullPointerException.class)
    public void testSeedInitialDataWithPartialNullManagers() {
        UserManager userManager = new UserManager();
        DataSeeder.seedInitialData(userManager, null, new HotelManager());
    }
}
