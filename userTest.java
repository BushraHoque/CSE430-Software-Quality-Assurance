package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class userTest {

    private user instance;

    @BeforeClass
    public static void setUpClass() {}

    @AfterClass
    public static void tearDownClass() {}

    @Before
    public void setUp() {
        // Use the concrete subclass instead of abstract user
        instance = new userImpl();
        instance.setActive(true);
    }

    @After
    public void tearDown() {
        instance = null;
    }

  

    @Test
    public void testSetId() {
        instance.setId("U456");
        assertEquals("U456", instance.getId());
    }


    @Test
    public void testSetName() {
        instance.setName("Nody");
        assertEquals("Nody", instance.getName());
    }


    @Test
    public void testSetEmail() {
        instance.setEmail("Nody145@gmail.com");
        assertEquals("Nody145@gmail.com", instance.getEmail());
    }


    @Test
    public void testSetPassword() {
        instance.setPassword("newPass");
        assertEquals("newPass", instance.getPassword());
    }

    @Test
    public void testSetPhone() {
        instance.setPhone("01987654321");
        assertEquals("01987654321", instance.getPhone());
    }

    @Test
    public void testGetCreatedDate() {
        assertNotNull("Created date should not be null", instance.getCreatedDate());
    }
    
     // Concrete implementation for testing
    public class userImpl extends user {
        public userImpl() {
            super("U999", "Nirzona", "nir@gmail.com", "pass", "019112222");
        }
        @Override
        public String getRole() {
            return "Tester";
        }
    }
    
    
     @Test
    public void testGetName() {
        assertEquals("Nirzona", instance.getName());

        // Corner case: Empty Name
        instance.setName("");
        assertEquals("Empty name should be allowed", "", instance.getName());

        // Corner case: Null Name
        instance.setName(null);
        assertNull("Null name should be allowed", instance.getName());
    }
    
     @Test
    public void testGetEmail() {
        assertEquals("nir@gmail.com", instance.getEmail());

        // Corner case: Invalid email format
        instance.setEmail("notAnEmail");
        assertEquals("Invalid email format still stored", "notAnEmail", instance.getEmail());

        // Corner case: Null email
        instance.setEmail(null);
        assertNull("Null email should be allowed", instance.getEmail());
    }
    
     @Test
    public void testGetPassword() {
        assertEquals("pass", instance.getPassword());

        // Corner case: Empty password
        instance.setPassword("");
        assertEquals("Empty password should be allowed", "", instance.getPassword());

        // Corner case: Null password
        instance.setPassword(null);
        assertNull("Null password should be allowed", instance.getPassword());
    }
    
     @Test
    public void testGetPhone() {
        assertEquals("019112222", instance.getPhone());

        // Corner case: Invalid phone number (non-digit)
        instance.setPhone("abc123");
        assertEquals("Non-digit phone should still be stored", "abc123", instance.getPhone());

        // Corner case: Null phone
        instance.setPhone(null);
        assertNull("Null phone should be allowed", instance.getPhone());
    }

    @Test
    public void testIsActive() {
        assertTrue(instance.isActive());

        // Corner case: Active status false
        instance.setActive(false);
        assertFalse("Should be false when set", instance.isActive());
    }

    @Test
    public void testSetActive() {
        instance.setActive(false);
        assertFalse(instance.isActive());

        // Corner case: Setting active back to true
        instance.setActive(true);
        assertTrue("Should be true when set", instance.isActive());
    }

    @Test
    public void testGetRole() {
        assertEquals("Tester", instance.getRole());

        // Corner case: Ensure role string is case-insensitive match
        assertTrue("Role should match ignoring case", instance.getRole().equalsIgnoreCase("tester"));
    }

    @Test
    public void testToString() {
        String result = instance.toString();
        assertNotNull(result);
        assertTrue(result.contains("Nirzona")); // sanity check

        // Corner case: Empty fields in toString
        instance.setName("");
        instance.setEmail("");
        assertTrue("toString should still work even if fields are empty", instance.toString().contains(""));
    }
    
      @Test
    public void testGetId() {
        assertEquals("U999", instance.getId());

        // Corner case: Empty ID
        instance.setId("");
        assertEquals("Empty ID should be allowed", "", instance.getId());

        // Corner case: Null ID
        instance.setId(null);
        assertNull("Null ID should be allowed", instance.getId());
    }
  
}
