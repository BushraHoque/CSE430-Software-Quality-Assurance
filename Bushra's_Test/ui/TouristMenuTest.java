package ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import manager.UserManager;

/**
 * Complete JUnit Test for TouristMenu class
 * Tests all methods using reflection and simple approach
 * @author Test Developer
 */
public class TouristMenuTest {
    
    private TouristMenu touristMenu;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    
    public TouristMenuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("=== Starting TouristMenuTest Suite ===");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("=== Completed TouristMenuTest Suite ===");
    }
    
    @Before
    public void setUp() {
        // Setup output stream capture
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // We'll create TouristMenu in individual tests as needed
        touristMenu = null;
    }
    
    @After
    public void tearDown() {
        // Restore original System.out
        System.setOut(originalOut);
        
        // Clear output stream
        if (outputStream != null) {
            outputStream.reset();
        }
    }

    /**
     * Test of TouristMenu constructor existence and basic functionality
     */
    @Test
    public void testTouristMenuConstructorExists() {
        System.out.println("Testing TouristMenu constructor existence");
        
        try {
            // Check if constructor exists
            Constructor<?>[] constructors = TouristMenu.class.getConstructors();
            assertTrue("TouristMenu should have at least one public constructor", 
                      constructors.length > 0);
            
            // Check for expected constructor parameters
            boolean hasCorrectConstructor = false;
            for (Constructor<?> constructor : constructors) {
                Class<?>[] paramTypes = constructor.getParameterTypes();
                if (paramTypes.length == 2) {
                    hasCorrectConstructor = true;
                    break;
                }
            }
            assertTrue("TouristMenu should have constructor with 2 parameters", 
                      hasCorrectConstructor);
            
        } catch (Exception e) {
            fail("Constructor test should not throw exception: " + e.getMessage());
        }
    }

    /**
     * Test of getLoyaltyTier method with Bronze tier values
     */
    @Test
    public void testGetLoyaltyTierBronze() {
        System.out.println("Testing getLoyaltyTier for Bronze tier");
        
        try {
            // Create a test instance using reflection if needed
            TouristMenu testInstance = createTestInstance();
            
            Method method = TouristMenu.class.getDeclaredMethod("getLoyaltyTier", int.class);
            method.setAccessible(true);
            
            // Test Bronze tier (0-499 points)
            String result1 = (String) method.invoke(testInstance, 0);
            assertEquals("Should return BRONZE for 0 points", "BRONZE", result1);
            
            String result2 = (String) method.invoke(testInstance, 100);
            assertEquals("Should return BRONZE for 100 points", "BRONZE", result2);
            
            String result3 = (String) method.invoke(testInstance, 499);
            assertEquals("Should return BRONZE for 499 points", "BRONZE", result3);
            
        } catch (Exception e) {
            fail("getLoyaltyTier test for Bronze should not fail: " + e.getMessage());
        }
    }

    /**
     * Test of getLoyaltyTier method with Silver tier values
     */
    @Test
    public void testGetLoyaltyTierSilver() {
        System.out.println("Testing getLoyaltyTier for Silver tier");
        
        try {
            TouristMenu testInstance = createTestInstance();
            
            Method method = TouristMenu.class.getDeclaredMethod("getLoyaltyTier", int.class);
            method.setAccessible(true);
            
            // Test Silver tier (500-999 points)
            String result1 = (String) method.invoke(testInstance, 500);
            assertEquals("Should return SILVER for 500 points", "SILVER", result1);
            
            String result2 = (String) method.invoke(testInstance, 750);
            assertEquals("Should return SILVER for 750 points", "SILVER", result2);
            
            String result3 = (String) method.invoke(testInstance, 999);
            assertEquals("Should return SILVER for 999 points", "SILVER", result3);
            
        } catch (Exception e) {
            fail("getLoyaltyTier test for Silver should not fail: " + e.getMessage());
        }
    }

    /**
     * Test of getLoyaltyTier method with Gold tier values
     */
    @Test
    public void testGetLoyaltyTierGold() {
        System.out.println("Testing getLoyaltyTier for Gold tier");
        
        try {
            TouristMenu testInstance = createTestInstance();
            
            Method method = TouristMenu.class.getDeclaredMethod("getLoyaltyTier", int.class);
            method.setAccessible(true);
            
            // Test Gold tier (1000-1999 points)
            String result1 = (String) method.invoke(testInstance, 1000);
            assertEquals("Should return GOLD for 1000 points", "GOLD", result1);
            
            String result2 = (String) method.invoke(testInstance, 1500);
            assertEquals("Should return GOLD for 1500 points", "GOLD", result2);
            
            String result3 = (String) method.invoke(testInstance, 1999);
            assertEquals("Should return GOLD for 1999 points", "GOLD", result3);
            
        } catch (Exception e) {
            fail("getLoyaltyTier test for Gold should not fail: " + e.getMessage());
        }
    }

    /**
     * Test of getLoyaltyTier method with Platinum tier values
     */
    @Test
    public void testGetLoyaltyTierPlatinum() {
        System.out.println("Testing getLoyaltyTier for Platinum tier");
        
        try {
            TouristMenu testInstance = createTestInstance();
            
            Method method = TouristMenu.class.getDeclaredMethod("getLoyaltyTier", int.class);
            method.setAccessible(true);
            
            // Test Platinum tier (2000+ points)
            String result1 = (String) method.invoke(testInstance, 2000);
            assertEquals("Should return PLATINUM for 2000 points", "PLATINUM", result1);
            
            String result2 = (String) method.invoke(testInstance, 5000);
            assertEquals("Should return PLATINUM for 5000 points", "PLATINUM", result2);
            
            String result3 = (String) method.invoke(testInstance, 10000);
            assertEquals("Should return PLATINUM for 10000 points", "PLATINUM", result3);
            
        } catch (Exception e) {
            fail("getLoyaltyTier test for Platinum should not fail: " + e.getMessage());
        }
    }

    /**
     * Test of getNextTierPoints method with Bronze to Silver transition
     */
    @Test
    public void testGetNextTierPointsBronzeToSilver() {
        System.out.println("Testing getNextTierPoints from Bronze to Silver");
        
        try {
            TouristMenu testInstance = createTestInstance();
            
            Method method = TouristMenu.class.getDeclaredMethod("getNextTierPoints", int.class);
            method.setAccessible(true);
            
            // Test Bronze to Silver (need to reach 500)
            int result1 = (Integer) method.invoke(testInstance, 100);
            assertEquals("Should need 400 points to reach Silver from 100", 400, result1);
            
            int result2 = (Integer) method.invoke(testInstance, 250);
            assertEquals("Should need 250 points to reach Silver from 250", 250, result2);
            
            int result3 = (Integer) method.invoke(testInstance, 450);
            assertEquals("Should need 50 points to reach Silver from 450", 50, result3);
            
        } catch (Exception e) {
            fail("getNextTierPoints test for Bronze to Silver should not fail: " + e.getMessage());
        }
    }

    /**
     * Test of getNextTierPoints method with Silver to Gold transition
     */
    @Test
    public void testGetNextTierPointsSilverToGold() {
        System.out.println("Testing getNextTierPoints from Silver to Gold");
        
        try {
            TouristMenu testInstance = createTestInstance();
            
            Method method = TouristMenu.class.getDeclaredMethod("getNextTierPoints", int.class);
            method.setAccessible(true);
            
            // Test Silver to Gold (need to reach 1000)
            int result1 = (Integer) method.invoke(testInstance, 600);
            assertEquals("Should need 400 points to reach Gold from 600", 400, result1);
            
            int result2 = (Integer) method.invoke(testInstance, 800);
            assertEquals("Should need 200 points to reach Gold from 800", 200, result2);
            
        } catch (Exception e) {
            fail("getNextTierPoints test for Silver to Gold should not fail: " + e.getMessage());
        }
    }

    /**
     * Test of getNextTierPoints method with Gold to Platinum transition
     */
    @Test
    public void testGetNextTierPointsGoldToPlatinum() {
        System.out.println("Testing getNextTierPoints from Gold to Platinum");
        
        try {
            TouristMenu testInstance = createTestInstance();
            
            Method method = TouristMenu.class.getDeclaredMethod("getNextTierPoints", int.class);
            method.setAccessible(true);
            
            // Test Gold to Platinum (need to reach 2000)
            int result1 = (Integer) method.invoke(testInstance, 1200);
            assertEquals("Should need 800 points to reach Platinum from 1200", 800, result1);
            
            int result2 = (Integer) method.invoke(testInstance, 1700);
            assertEquals("Should need 300 points to reach Platinum from 1700", 300, result2);
            
        } catch (Exception e) {
            fail("getNextTierPoints test for Gold to Platinum should not fail: " + e.getMessage());
        }
    }

    /**
     * Test of getNextTierPoints method for Platinum tier (maximum tier)
     */
    @Test
    public void testGetNextTierPointsPlatinumMax() {
        System.out.println("Testing getNextTierPoints for Platinum tier");
        
        try {
            TouristMenu testInstance = createTestInstance();
            
            Method method = TouristMenu.class.getDeclaredMethod("getNextTierPoints", int.class);
            method.setAccessible(true);
            
            // Test Platinum tier (should return 0 as it's the maximum)
            int result1 = (Integer) method.invoke(testInstance, 2500);
            assertEquals("Should return 0 for Platinum tier (2500 points)", 0, result1);
            
            int result2 = (Integer) method.invoke(testInstance, 10000);
            assertEquals("Should return 0 for very high points (10000)", 0, result2);
            
        } catch (Exception e) {
            fail("getNextTierPoints test for Platinum should not fail: " + e.getMessage());
        }
    }

    

    /**
     * Test private method existence and accessibility
     */
    @Test
    public void testPrivateMethodsExist() {
        System.out.println("Testing private methods existence");
        
        try {
            // Test that private methods exist
            Method printTouristHeader = TouristMenu.class.getDeclaredMethod("printTouristHeader");
            assertNotNull("printTouristHeader method should exist", printTouristHeader);
            
            Method printTouristMenuOptions = TouristMenu.class.getDeclaredMethod("printTouristMenuOptions");
            assertNotNull("printTouristMenuOptions method should exist", printTouristMenuOptions);
            
            Method handleTouristMenuChoice = TouristMenu.class.getDeclaredMethod("handleTouristMenuChoice", int.class);
            assertNotNull("handleTouristMenuChoice method should exist", handleTouristMenuChoice);
            
            Method logout = TouristMenu.class.getDeclaredMethod("logout");
            assertNotNull("logout method should exist", logout);
            
        } catch (Exception e) {
            fail("Private methods should exist: " + e.getMessage());
        }
    }

    /**
     * Test field existence and types
     */
    @Test
    public void testFieldsExist() {
        System.out.println("Testing class fields existence");
        
        try {
            // Test that required fields exist
            Field touristField = TouristMenu.class.getDeclaredField("tourist");
            assertNotNull("tourist field should exist", touristField);
            
            Field userManagerField = TouristMenu.class.getDeclaredField("userManager");
            assertNotNull("userManager field should exist", userManagerField);
            
            Field isRunningField = TouristMenu.class.getDeclaredField("isRunning");
            assertNotNull("isRunning field should exist", isRunningField);
            assertEquals("isRunning should be boolean type", boolean.class, isRunningField.getType());
            
        } catch (Exception e) {
            fail("Required fields should exist: " + e.getMessage());
        }
    }

    /**
     * Test method parameter types
     */
    @Test
    public void testMethodParameterTypes() {
        System.out.println("Testing method parameter types");
        
        try {
            // Test getLoyaltyTier parameter type
            Method getLoyaltyTier = TouristMenu.class.getDeclaredMethod("getLoyaltyTier", int.class);
            Class<?>[] paramTypes = getLoyaltyTier.getParameterTypes();
            assertEquals("getLoyaltyTier should take int parameter", int.class, paramTypes[0]);
            assertEquals("getLoyaltyTier should return String", String.class, getLoyaltyTier.getReturnType());
            
            // Test getNextTierPoints parameter type
            Method getNextTierPoints = TouristMenu.class.getDeclaredMethod("getNextTierPoints", int.class);
            Class<?>[] paramTypes2 = getNextTierPoints.getParameterTypes();
            assertEquals("getNextTierPoints should take int parameter", int.class, paramTypes2[0]);
            assertEquals("getNextTierPoints should return int", int.class, getNextTierPoints.getReturnType());
            
        } catch (Exception e) {
            fail("Method parameter types should be correct: " + e.getMessage());
        }
    }

    /**
     * Test edge cases for loyalty tier calculation
     */
    @Test
    public void testLoyaltyTierEdgeCases() {
        System.out.println("Testing loyalty tier edge cases");
        
        try {
            TouristMenu testInstance = createTestInstance();
            Method method = TouristMenu.class.getDeclaredMethod("getLoyaltyTier", int.class);
            method.setAccessible(true);
            
            // Test boundary values
            assertEquals("499 points should be BRONZE", "BRONZE", method.invoke(testInstance, 499));
            assertEquals("500 points should be SILVER", "SILVER", method.invoke(testInstance, 500));
            assertEquals("999 points should be SILVER", "SILVER", method.invoke(testInstance, 999));
            assertEquals("1000 points should be GOLD", "GOLD", method.invoke(testInstance, 1000));
            assertEquals("1999 points should be GOLD", "GOLD", method.invoke(testInstance, 1999));
            assertEquals("2000 points should be PLATINUM", "PLATINUM", method.invoke(testInstance, 2000));
            
        } catch (Exception e) {
            fail("Loyalty tier edge cases should work: " + e.getMessage());
        }
    }

    /**
     * Test edge cases for next tier points calculation
     */
    @Test
    public void testNextTierPointsEdgeCases() {
        System.out.println("Testing next tier points edge cases");
        
        try {
            TouristMenu testInstance = createTestInstance();
            Method method = TouristMenu.class.getDeclaredMethod("getNextTierPoints", int.class);
            method.setAccessible(true);
            
            // Test boundary values
            assertEquals("0 points should need 500 to reach Silver", 500, method.invoke(testInstance, 0));
            assertEquals("499 points should need 1 to reach Silver", 1, method.invoke(testInstance, 499));
            assertEquals("500 points should need 500 to reach Gold", 500, method.invoke(testInstance, 500));
            assertEquals("999 points should need 1 to reach Gold", 1, method.invoke(testInstance, 999));
            assertEquals("1000 points should need 1000 to reach Platinum", 1000, method.invoke(testInstance, 1000));
            assertEquals("1999 points should need 1 to reach Platinum", 1, method.invoke(testInstance, 1999));
            assertEquals("2000+ points should need 0 (max tier)", 0, method.invoke(testInstance, 2000));
            
        } catch (Exception e) {
            fail("Next tier points edge cases should work: " + e.getMessage());
        }
    }

    private TouristMenu createTestInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    }
