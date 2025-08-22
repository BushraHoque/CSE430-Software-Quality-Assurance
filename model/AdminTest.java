package model;

import java.util.List;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class AdminTest {

    Admin testadmin;

    public AdminTest() {
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

    // Test admin role retrieval
    @Test
    public void testGetRole() {
        testadmin = new Admin("10", "ADMIN", "tanvir@gmail.com", "112233", "01767274222");
        String expResult = "ADMIN";
        String result = testadmin.getRole();
        assertEquals(expResult, result);
    }

    // Test default admin level
    @Test
    public void testGetAdminLevel() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        String expResult = "SUPER_ADMIN";
        String result = testadmin.getAdminLevel();
        assertEquals(expResult, result);
    }

    // Test setting admin level
    @Test
    public void testSetAdminLevel() {
        System.out.println("setAdminLevel");
        String adminLevel = "Tanvir";
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        testadmin.setAdminLevel(adminLevel);
        assertEquals(adminLevel, testadmin.getAdminLevel());
    }

    // Test getting permissions
    @Test
    public void testGetPermissions() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        List<String> expResult = Arrays.asList("tanvir@gmail.com", "112233");
        testadmin.setPermissions(expResult);
        List<String> result = testadmin.getPermissions();
        assertEquals(expResult, result);
    }

    // Test setting permissions
    @Test
    public void testSetPermissions() {
        System.out.println("setPermissions");
        List<String> permissions = Arrays.asList("10");
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        testadmin.setPermissions(permissions);
        assertEquals(permissions, testadmin.getPermissions());
    }

    // Test constructor with null values
    @Test
    public void testConstructorWithNullValues() {
        testadmin = new Admin(null, null, null, null, null);
        assertNotNull("Admin object should be created", testadmin);
        assertEquals("Role should still be ADMIN", "ADMIN", testadmin.getRole());
        assertEquals("Default admin level should be SUPER_ADMIN", "SUPER_ADMIN", testadmin.getAdminLevel());
    }

    // Test setting null admin level
    @Test
    public void testSetAdminLevelNull() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        testadmin.setAdminLevel(null);
        assertNull("Admin level should be null", testadmin.getAdminLevel());
    }

    // Test setting empty string admin level
    @Test
    public void testSetAdminLevelEmpty() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        testadmin.setAdminLevel("");
        assertEquals("Admin level should be empty", "", testadmin.getAdminLevel());
    }

    // Test setting null permissions
    @Test
    public void testSetPermissionsNull() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        testadmin.setPermissions(null);
        assertNull("Permissions should be null", testadmin.getPermissions());
    }

    // Test setting empty permissions list
    @Test
    public void testSetPermissionsEmpty() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        List<String> emptyList = new ArrayList<>();
        testadmin.setPermissions(emptyList);
        assertEquals("Empty permissions should be preserved", emptyList, testadmin.getPermissions());
        assertTrue("Permissions should be empty", testadmin.getPermissions().isEmpty());
    }

    // Test permissions list with null elements
    @Test
    public void testPermissionsWithNullElements() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        List<String> permissionsWithNull = Arrays.asList("READ", null, "WRITE");
        testadmin.setPermissions(permissionsWithNull);
        assertEquals("Permissions with null should be preserved", permissionsWithNull, testadmin.getPermissions());
        assertTrue("Should contain null element", testadmin.getPermissions().contains(null));
    }

    // Test role method consistency
    @Test
    public void testGetRoleConsistency() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        String first = testadmin.getRole();
        String second = testadmin.getRole();
        assertEquals("Role should be consistent", first, second);
    }

    // Test admin level changes multiple times
    @Test
    public void testAdminLevelAfterMultipleChanges() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        testadmin.setAdminLevel("BASIC");
        testadmin.setAdminLevel("MANAGER");
        testadmin.setAdminLevel("FINAL_LEVEL");
        assertEquals("Should have final level", "FINAL_LEVEL", testadmin.getAdminLevel());
    }

    // Test special characters in admin level
    @Test
    public void testSpecialCharactersInAdminLevel() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        String specialLevel = "ADMIN@#$%";
        testadmin.setAdminLevel(specialLevel);
        assertEquals("Special characters should be preserved", specialLevel, testadmin.getAdminLevel());
    }

    // Test unicode characters support
    @Test
    public void testUnicodeCharacters() {
        testadmin = new Admin("১০", "তানভীর", "tanvir@gmail.com", "112233", "01767274222");
        String banglaLevel = "সুপার_এডমিন";
        testadmin.setAdminLevel(banglaLevel);
        assertEquals("Unicode should work", banglaLevel, testadmin.getAdminLevel());
    }

    // Test exception throwing method
    @Test(expected = UnsupportedOperationException.class)
    public void testSetAdminLevelMethodException() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        testadmin.setAdminLevel(); // This should throw exception
    }

    // Test exception message verification
    @Test
    public void testExceptionMessage() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        try {
            testadmin.setAdminLevel();
            fail("Should have thrown exception");
        } catch (UnsupportedOperationException e) {
            assertEquals("Exception message should match", "Not supported yet.", e.getMessage());
        }
    }

    // Test duplicate permissions handling
    @Test
    public void testPermissionsDuplicates() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        List<String> duplicates = Arrays.asList("READ", "WRITE", "READ", "DELETE");
        testadmin.setPermissions(duplicates);
        assertEquals("Duplicates should be preserved", duplicates, testadmin.getPermissions());
        assertEquals("Size should include duplicates", 4, testadmin.getPermissions().size());
    }

    // Test large permissions list
    @Test
    public void testLargePermissionsList() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        List<String> largeList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            largeList.add("PERM_" + i);
        }
        testadmin.setPermissions(largeList);
        assertEquals("Large list should be preserved", 100, testadmin.getPermissions().size());
        assertEquals("First item should match", "PERM_0", testadmin.getPermissions().get(0));
        assertEquals("Last item should match", "PERM_99", testadmin.getPermissions().get(99));
    }

    // Test object state after exception
    @Test
    public void testObjectStateAfterException() {
        testadmin = new Admin("10", "Tanvir", "tanvir@gmail.com", "112233", "01767274222");
        String originalLevel = testadmin.getAdminLevel();
        
        try {
            testadmin.setAdminLevel(); // throws exception
        } catch (UnsupportedOperationException e) {
            // expected
        }
        
        assertEquals("State should be unchanged", originalLevel, testadmin.getAdminLevel());
        assertEquals("Role should be unchanged", "ADMIN", testadmin.getRole());
    }

    // Test multiple admin instances independence
    @Test
    public void testMultipleAdminInstances() {
        Admin admin1 = new Admin("1", "Admin1", "admin1@test.com", "pass1", "111");
        
        admin1.setAdminLevel("LEVEL1");
        
        assertEquals("Admin1 should have LEVEL1", "LEVEL1", admin1.getAdminLevel());
        assertNotEquals("Levels should be different", admin1.getAdminLevel());
    }
    
    // Test multiple admin instances independence
    @Test
    
    public void testMultipleAdminInstancess() {
        Admin admin2 = new Admin("2", "Admin2", "admin2@test.com", "pass2", "222");
        
        admin2.setAdminLevel("LEVEL2");
             
        assertEquals("Admin2 should have LEVEL2", "LEVEL2", admin2.getAdminLevel());
        assertNotEquals("Levels should be different",admin2.getAdminLevel());
    }
}