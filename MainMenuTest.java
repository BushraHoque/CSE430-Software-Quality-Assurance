package ui;

import auth.AuthService;
import manager.UserManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainMenuTest {

    private MainMenu instance;

    //  Dummy UserManager to avoid full implementation dependencies
    private static class DummyUserManager extends UserManager {
        @Override
        public int getTotalUsers() {
            return 0;
        }

        @Override
        public int getActiveUsersCount() {
            return 0;
        }
    }

    @Before
    public void setUp() {
        // Use dummy instead of real UserManager
        UserManager dummyUserManager = new DummyUserManager();
        instance = new MainMenu(dummyUserManager);
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testEmergencyShutdown() {
        assertTrue(instance.isSystemRunning());
        instance.emergencyShutdown();
        assertFalse(instance.isSystemRunning());
    }

    @Test
    public void testIsSystemRunning_DefaultTrue() {
        assertTrue(instance.isSystemRunning());
    }

    @Test
    public void testGetUserManager() {
        assertNotNull(instance.getUserManager());
    }

    @Test
    public void testGetAuthService() {
        AuthService auth = instance.getAuthService();
        assertNotNull(auth);
    }

    // ---------- CORNER CASE TESTS ----------

    @Test
    public void testEmergencyShutdownTwice() {
        //  Corner case: Calling shutdown twice should not crash or change behavior unexpectedly
        instance.emergencyShutdown();
        assertFalse(instance.isSystemRunning());
        instance.emergencyShutdown(); // Second call, should remain false
        assertFalse("System should remain shut down after second shutdown call", instance.isSystemRunning());
    }

    @Test
    public void testIsSystemRunningAfterMultipleOperations() {
        //  Corner case: System should still be running if we haven't called shutdown
        assertTrue(instance.isSystemRunning());
        assertNotNull(instance.getUserManager()); // Random safe operation
        assertTrue(instance.isSystemRunning()); // Still true
    }

    @Test
    public void testGetUserManagerNotNullEvenAfterShutdown() {
        //  Corner case: UserManager reference should still be available after shutdown
        instance.emergencyShutdown();
        assertNotNull("UserManager should not be null after shutdown", instance.getUserManager());
    }

    @Test
    public void testGetAuthServiceMultipleCallsReturnSameInstance() {
        // Corner case: AuthService should be consistent across multiple calls
        AuthService auth1 = instance.getAuthService();
        AuthService auth2 = instance.getAuthService();
        assertSame("AuthService should be same instance when fetched twice", auth1, auth2);
    }

    @Test
    public void testAuthServiceWorksAfterShutdown() {
        //  Corner case: Even if the system is shut down, auth service object should still be retrievable
        instance.emergencyShutdown();
        assertNotNull("AuthService should still be accessible after shutdown", instance.getAuthService());
    }

    @Test
    public void testSystemRunningStatePersistence() {
        //  Corner case: Make sure shutdown state persists until explicitly restarted (if restart exists)
        instance.emergencyShutdown();
        assertFalse(instance.isSystemRunning());
        
        assertFalse(instance.isSystemRunning());
    }
    
     @Test
    public void testGetUserManagerMayReturnNullIfNotInitialized() {
        // Null case: If MainMenu allowed null UserManager (depends on implementation)
        MainMenu menu = new MainMenu(null); 
        assertNull("UserManager should be null if constructed with null", menu.getUserManager());
    }
}
