package util;

import org.junit.Test;
import static org.junit.Assert.*;

public class IDGeneratorTest {

    @Test
    public void testGenerateUserId() {
        String result = IDGenerator.generateUserId();
        assertNotNull(result);
        assertTrue(result.startsWith("USR"));
    }

    @Test
    public void testGeneratePackageId() {
        String result = IDGenerator.generatePackageId();
        assertNotNull(result);
        assertTrue(result.startsWith("PKG"));
    }

    @Test
    public void testGenerateBookingId() {
        String result = IDGenerator.generateBookingId();
        assertNotNull(result);
        assertTrue(result.startsWith("BKG"));
    }

    @Test
    public void testGenerateHotelId() {
        String result = IDGenerator.generateHotelId();
        assertNotNull(result);
        assertTrue(result.startsWith("HTL"));
    }

    @Test
    public void testGenerateTransportId() {
        String result = IDGenerator.generateTransportId();
        assertNotNull(result);
        assertTrue(
            result.startsWith("TRAN") || 
            result.startsWith("TRN") || 
            result.startsWith("TR")
        );
    }

    @Test
    public void testGenerateInvoiceId() {
        String result = IDGenerator.generateInvoiceId();
        assertNotNull(result);
        assertTrue(result.startsWith("INV"));
    }

    @Test
    public void testGenerateRandomStringWithLengthOnly() {
        int length = 8;
        String result = IDGenerator.generateRandomString(length);
        assertNotNull(result);
        assertEquals(length, result.length());
    }

    @Test
    public void testGenerateRandomStringWithCustomChars() {
        int length = 10;
        String customChars = "ABC123";
        String result = IDGenerator.generateRandomString(length, customChars);
        assertNotNull(result);
        assertEquals(length, result.length());

        for (char c : result.toCharArray()) {
            assertTrue(customChars.indexOf(c) >= 0);
        }
    }

    @Test
    public void testIsValidIdFormat() {
        String id = "USR12345";
        String prefix = "USR";
        assertTrue(IDGenerator.isValidIdFormat(id, prefix));
    }

    @Test
    public void testGenerateSecureToken() {
        int length = 16;
        String token = IDGenerator.generateSecureToken(length);
        assertNotNull(token);
        assertEquals(length, token.length());
    }

    // ---------------- Corner Case Tests ----------------

    @Test
    public void testGenerateRandomStringWithZeroLength() {
        // Corner case: zero length should return an empty string
        String result = IDGenerator.generateRandomString(0);
        assertNotNull(result);
        assertEquals(0, result.length());
    }

    @Test
    public void testGenerateRandomStringWithNegativeLength() {
        // Corner case: negative length, expecting either exception or empty string
        try {
            String result = IDGenerator.generateRandomString(-5);
            assertTrue("Negative length should produce empty string", result.isEmpty());
        } catch (IllegalArgumentException e) {
            // acceptable if method throws exception for invalid length
        }
    }

    @Test
    public void testGenerateRandomStringWithEmptyCustomChars() {
        // Corner case: empty character set provided
        try {
            String result = IDGenerator.generateRandomString(5, "");
            // If no exception, result should still have requested length
            assertEquals(5, result.length());
        } catch (IllegalArgumentException e) {
            // acceptable if method throws exception for invalid char set
        }
    }

    @Test
    public void testIsValidIdFormatWithWrongPrefix() {
        // Corner case: prefix mismatch should return false
        assertFalse(IDGenerator.isValidIdFormat("ABC12345", "USR"));
    }

    @Test
    public void testIsValidIdFormatWithNullId() {
        // Corner case: null ID should be invalid
        assertFalse(IDGenerator.isValidIdFormat(null, "USR"));
    }

   
   @Test
    public void testGenerateSecureTokenWithZeroLength() {
        // Corner case: zero length token
        String token = IDGenerator.generateSecureToken(0);
        assertNotNull(token);
        assertEquals(0, token.length());
    }

    @Test
    public void testGenerateSecureTokenWithNegativeLength() {
        // Corner case: negative token length should throw exception or return empty
        try {
            String token = IDGenerator.generateSecureToken(-10);
            assertTrue("Negative length token should be empty", token.isEmpty());
        } catch (IllegalArgumentException e) {
            // acceptable
        }
    }
}
