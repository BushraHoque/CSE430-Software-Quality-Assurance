package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorTest {
    
    public ValidatorTest() {
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

    // Test email validation with valid and invalid emails
    @Test
    public void testValidateEmail() {
        // Valid emails
        assertTrue(Validator.validateEmail("test@example.com"));
        assertTrue(Validator.validateEmail("user123@gmail.com"));
        assertTrue(Validator.validateEmail("a@b.co"));
        assertTrue(Validator.validateEmail("test.email@domain.org"));
        assertTrue(Validator.validateEmail("user+tag@example.net"));
        assertTrue(Validator.validateEmail("user_name@example-domain.com"));
        
        // Invalid emails
        assertFalse(Validator.validateEmail(null));
        assertFalse(Validator.validateEmail(""));
        assertFalse(Validator.validateEmail("plainaddress"));
        assertFalse(Validator.validateEmail("@example.com"));
        assertFalse(Validator.validateEmail("user@"));
        assertFalse(Validator.validateEmail("user@@domain.com"));
    }

    // Test phone validation for Bangladesh phone numbers
    @Test
    public void testValidatePhone() {
        // Valid Bangladesh phone numbers
        assertTrue(Validator.validatePhone("01712345678"));
        assertTrue(Validator.validatePhone("01812345678"));
        assertTrue(Validator.validatePhone("01912345678"));
        assertTrue(Validator.validatePhone("01312345678"));
        assertTrue(Validator.validatePhone("01412345678"));
        assertTrue(Validator.validatePhone("01512345678"));
        assertTrue(Validator.validatePhone("01612345678"));
        assertTrue(Validator.validatePhone("+8801712345678"));
        assertTrue(Validator.validatePhone("+8801812345678"));
        
        // Invalid phone numbers
        assertFalse(Validator.validatePhone(null));
        assertFalse(Validator.validatePhone(""));
        assertFalse(Validator.validatePhone("0171234567"));  // Too short
        assertFalse(Validator.validatePhone("017123456789")); // Too long
        assertFalse(Validator.validatePhone("01012345678"));  // Invalid operator
        assertFalse(Validator.validatePhone("01212345678"));  // Invalid operator
        assertFalse(Validator.validatePhone("02712345678"));  // Invalid start
        assertFalse(Validator.validatePhone("1712345678"));   // Missing 0
    }

    // Test password validation (minimum 6 characters)
    @Test
    public void testValidatePassword() {
        // Valid passwords (6+ characters)
        assertTrue(Validator.validatePassword("123456"));
        assertTrue(Validator.validatePassword("password"));
        assertTrue(Validator.validatePassword("abcdef"));
        assertTrue(Validator.validatePassword("      ")); // 6 spaces
        assertTrue(Validator.validatePassword("P@ssw0rd123"));
        
        // Invalid passwords (less than 6 characters or null)
        assertFalse(Validator.validatePassword(null));
        assertFalse(Validator.validatePassword(""));
        assertFalse(Validator.validatePassword("12345"));
        assertFalse(Validator.validatePassword("abc"));
        assertFalse(Validator.validatePassword("     ")); // 5 spaces
    }

    // Test empty string validation
    @Test
    public void testIsNotEmpty() {
        // Valid non-empty strings (after trim)
        assertTrue(Validator.isNotEmpty("hello"));
        assertTrue(Validator.isNotEmpty("test"));
        assertTrue(Validator.isNotEmpty("a"));
        assertTrue(Validator.isNotEmpty(" hello ")); // Has content after trim
        assertTrue(Validator.isNotEmpty("  test  "));
        
        // Invalid empty/null strings (null or empty after trim)
        assertFalse(Validator.isNotEmpty(null));
        assertFalse(Validator.isNotEmpty(""));
        assertFalse(Validator.isNotEmpty(" "));
        assertFalse(Validator.isNotEmpty("  "));
        assertFalse(Validator.isNotEmpty("   "));
        assertFalse(Validator.isNotEmpty("\t"));
        assertFalse(Validator.isNotEmpty("\n"));
    }

    // Test positive number validation
    @Test
    public void testIsPositiveNumber() {
        // Valid positive numbers (greater than 0)
        assertTrue(Validator.isPositiveNumber(0.1));
        assertTrue(Validator.isPositiveNumber(1.0));
        assertTrue(Validator.isPositiveNumber(100.0));
        assertTrue(Validator.isPositiveNumber(0.000001));
        assertTrue(Validator.isPositiveNumber(999999.999999));
        
        // Invalid non-positive numbers (0 or negative)
        assertFalse(Validator.isPositiveNumber(0.0));
        assertFalse(Validator.isPositiveNumber(-0.1));
        assertFalse(Validator.isPositiveNumber(-1.0));
        assertFalse(Validator.isPositiveNumber(-100.0));
    }

    // Test number range validation
    @Test
    public void testIsValidRange() {
        // Valid ranges (value >= min && value <= max)
        assertTrue(Validator.isValidRange(5.0, 1.0, 10.0));
        assertTrue(Validator.isValidRange(1.0, 1.0, 10.0));  // At minimum
        assertTrue(Validator.isValidRange(10.0, 1.0, 10.0)); // At maximum
        assertTrue(Validator.isValidRange(5.5, 1.0, 10.0));
        assertTrue(Validator.isValidRange(0.0, -1.0, 1.0));
        assertTrue(Validator.isValidRange(100.0, 100.0, 100.0)); // Same min/max
        
        // Invalid ranges (value < min || value > max)
        assertFalse(Validator.isValidRange(0.0, 1.0, 10.0));    // Below minimum
        assertFalse(Validator.isValidRange(11.0, 1.0, 10.0));   // Above maximum
        assertFalse(Validator.isValidRange(-2.0, -1.0, 1.0));   // Below minimum
        assertFalse(Validator.isValidRange(2.0, -1.0, 1.0));    // Above maximum
    }

    // Test name validation (only letters and spaces, minimum 2 characters after trim)
    @Test
    public void testIsValidName() {
        // Valid names (2+ chars after trim, only letters and spaces)
        assertTrue(Validator.isValidName("John Doe"));
        assertTrue(Validator.isValidName("Alice"));
        assertTrue(Validator.isValidName("AB"));
        assertTrue(Validator.isValidName("Mary Jane Watson"));
        assertTrue(Validator.isValidName("  John  ")); // Trimmed to valid
        assertTrue(Validator.isValidName("A B"));
        assertTrue(Validator.isValidName("aa"));
        
        // Invalid names (null, <2 chars after trim, or contains non-letters/spaces)
        assertFalse(Validator.isValidName(null));
        assertFalse(Validator.isValidName(""));
        assertFalse(Validator.isValidName(" "));
        assertFalse(Validator.isValidName("A"));     // Single character after trim
        assertFalse(Validator.isValidName(" A "));   // Single character after trim
        assertFalse(Validator.isValidName("John123"));
        assertFalse(Validator.isValidName("123John"));
        assertFalse(Validator.isValidName("John@Doe"));
        assertFalse(Validator.isValidName("John-Doe"));
        assertFalse(Validator.isValidName("John_Doe"));
        assertFalse(Validator.isValidName("John.Doe"));
    }
}
