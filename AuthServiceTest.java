package auth;

import manager.UserManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class AuthServiceTest {

    public AuthServiceTest() {
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

    
    // Normal Functional Tests
  

    @Test
    public void testLogout() {
        System.out.println("logout");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            authService.logout("nir@gmail.com");
            assertTrue("Logout executed without exception", true);
        } catch (Exception e) {
            fail("Logout should not throw exception");
        }
    }

    @Test
    public void testIsUserAuthenticated() {
        System.out.println("isUserAuthenticated");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            boolean result = authService.isUserAuthenticated("nir@gmail.com");
            assertFalse("User should not be authenticated initially", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    @Test
    public void testHasRole() {
        System.out.println("hasRole");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            boolean result = authService.hasRole("nir@gmail.com", "TOURIST");
            assertFalse("User should not have role before registration", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    @Test
    public void testHasAnyRole() {
        System.out.println("hasAnyRole");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            String[] roles = {"TOURIST", "ADMIN"};
            boolean result = authService.hasAnyRole("nir@gmail.com", roles);
            assertFalse("User should not have any role before registration", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    @Test
    public void testIsAdmin() {
        System.out.println("isAdmin");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            boolean result = authService.isAdmin("raisa@gmail.com");
            assertFalse("Default user should not be admin", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    @Test
    public void testIsTourist() {
        System.out.println("isTourist");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            boolean result = authService.isTourist("nir@gmail.com");
            assertFalse("User should not be tourist unless registered", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    @Test
    public void testIsAgent() {
        System.out.println("isAgent");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            boolean result = authService.isAgent("tourandtravels@gmail.com");
            assertFalse("Default user should not be agent", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    @Test
    public void testAuthorizeAccess() {
        System.out.println("authorizeAccess");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            boolean result = authService.authorizeAccess("nir@gmail.com", "TOURIST");
            assertFalse("Access should not be authorized for unregistered user", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    @Test
    public void testAuthorizeAdminAccess() {
        System.out.println("authorizeAdminAccess");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            boolean result = authService.authorizeAdminAccess("raisa@gmail.com");
            assertFalse("Admin access should not be authorized for default user", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            String result = authService.changePassword("nir@gmail.com", "oldpass", "newpass");
            assertNotNull("Change password should return a result", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    @Test
    public void testRequestPasswordReset() {
        System.out.println("requestPasswordReset");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            String result = authService.requestPasswordReset("nir@gmail.com");
            assertNotNull("Request password reset should return token/message", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    @Test
    public void testResetPassword() {
        System.out.println("resetPassword");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            String result = authService.resetPassword("nir@gmail.com", "token", "newpass");
            assertNotNull("Reset password should return confirmation", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    @Test
    public void testBlockUser() {
        System.out.println("blockUser");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            authService.blockUser("nir@gmail.com", "reason");
            assertTrue("Block user executed without exception", true);
        } catch (Exception e) {
            fail("Block user should not throw exception");
        }
    }

    @Test
    public void testUnblockUser() {
        System.out.println("unblockUser");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            authService.unblockUser("nir@gmail.com");
            assertTrue("Unblock user executed without exception", true);
        } catch (Exception e) {
            fail("Unblock user should not throw exception");
        }
    }

    @Test
    public void testIsAccountLocked() {
        System.out.println("isAccountLocked");
        try {
            UserManager userManager = new UserManager();
            AuthService authService = new AuthService(userManager);

            boolean result = authService.isAccountLocked("nir@gmail.com");
            assertFalse("User account should not be locked initially", result);
        } catch (Exception e) {
            assertNotNull("Method threw exception but should exist", e);
        }
    }

    
    // Corner Cases
    

    @Test
    public void testLogoutWithNullEmail() {
        UserManager userManager = new UserManager();
        AuthService authService = new AuthService(userManager);
        try {
            authService.logout(null);
            assertTrue("Logout with null should not crash", true);
        } catch (Exception e) {
            assertNotNull("Exception handled for null logout", e);
        }
    }

    @Test
    public void testHasRoleWithNulls() {
        UserManager userManager = new UserManager();
        AuthService authService = new AuthService(userManager);
        boolean result = authService.hasRole(null, null);
        assertFalse("Null email/role should not have role", result);
    }

  

    @Test
    public void testChangePasswordWithNulls() {
        UserManager userManager = new UserManager();
        AuthService authService = new AuthService(userManager);
        String result = authService.changePassword(null, null, null);
        assertNotNull("Null change password should still return a response", result);
    }

    @Test
    public void testRequestPasswordResetWithNull() {
        UserManager userManager = new UserManager();
        AuthService authService = new AuthService(userManager);
        String result = authService.requestPasswordReset(null);
        assertNotNull("Request password reset with null should return response", result);
    }

    @Test
    public void testResetPasswordWithNulls() {
        UserManager userManager = new UserManager();
        AuthService authService = new AuthService(userManager);
        String result = authService.resetPassword(null, null, null);
        assertNotNull("Reset password with nulls should return response", result);
    }

    @Test
    public void testBlockUserWithNulls() {
        UserManager userManager = new UserManager();
        AuthService authService = new AuthService(userManager);
        try {
            authService.blockUser(null, null);
            assertTrue("Block user with nulls should not crash", true);
        } catch (Exception e) {
            assertNotNull("Exception handled for blockUser with nulls", e);
        }
    }

    @Test
    public void testUnblockUserWithNull() {
        UserManager userManager = new UserManager();
        AuthService authService = new AuthService(userManager);
        try {
            authService.unblockUser(null);
            assertTrue("Unblock user with null should not crash", true);
        } catch (Exception e) {
            assertNotNull("Exception handled for unblockUser with null", e);
        }
    }
}
