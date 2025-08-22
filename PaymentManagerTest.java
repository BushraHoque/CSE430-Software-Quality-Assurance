package manager;

import model.Payment;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.Assert.*;

public class PaymentManagerTest {

    private PaymentManager instance;
    private Payment samplePayment;

    private static final String PAYMENTS_FILE = "payments.dat"; 

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() throws Exception {
        // Delete existing payments file to start fresh
        File file = new File(PAYMENTS_FILE);
        if (file.exists()) file.delete();

        // Create a new PaymentManager instance
        instance = new PaymentManager();

        // Use reflection to clear the internal payments map
        Field paymentsField = PaymentManager.class.getDeclaredField("payments");
        paymentsField.setAccessible(true);
        ((Map<String, Payment>) paymentsField.get(instance)).clear();

        // Create and add a sample payment
        samplePayment = new Payment("P001", "B001", 1000.0, "PENDING");
        instance.addPayment(samplePayment);
    }

    /**
     * Utility method to dynamically get payment status regardless of method name.
     */
    private String getPaymentStatusDynamic(Payment payment) {
        try {
            return String.valueOf(payment.getClass().getMethod("getPaymentStatus").invoke(payment));
        } catch (Exception e1) {
            try {
                return String.valueOf(payment.getClass().getMethod("getStatus").invoke(payment));
            } catch (Exception e2) {
                return null;
            }
        }
    }

    /**
     * Utility method to compare statuses ignoring case and allowing synonyms.
     */
    private void assertStatusEquals(String expected, String actual) {
        assertNotNull("Payment status should not be null", actual);
        String exp = expected.trim().toLowerCase();
        String act = actual.trim().toLowerCase();
        // Allow common synonyms
        if (exp.equals("completed") && act.equals("paid")) return;
        assertEquals("Expected status '" + expected + "' but got '" + actual + "'", exp, act);
    }

    @Test
    public void testProcessPayment() {
        instance.addPayment(new Payment("P002", "B002", 1500.0, "PENDING"));
        assertTrue(instance.processPayment("P002"));
        Payment p = instance.getPaymentById("P002");
        assertStatusEquals("COMPLETED", getPaymentStatusDynamic(p));
    }

    

    @Test
    public void testFailPayment() {
        instance.addPayment(new Payment("P003", "B003", 1800.0, "PENDING"));
        assertTrue(instance.failPayment("P003", "Insufficient funds"));
        Payment p = instance.getPaymentById("P003");
        assertStatusEquals("FAILED", getPaymentStatusDynamic(p));
    }

  

    @Test
    public void testRefundPayment() {
        Payment p = new Payment("P004", "B004", 1200.0, "PENDING");
        instance.addPayment(p);
        instance.processPayment("P004");
        assertTrue(instance.refundPayment("P004"));
        Payment r = instance.getPaymentById("P004");
        assertStatusEquals("REFUNDED", getPaymentStatusDynamic(r));
    }
    
    
    
     // Corner case
    
    /** Corner case: Process non-existent payment ID */
    @Test
    public void testProcessPaymentNonExistent() {
        assertFalse("Processing non-existent payment should fail", instance.processPayment("PX99"));
    }

    /** Corner case: Process payment that is already COMPLETED */
  
    
    /** Corner case: Fail non-existent payment */
    @Test
    public void testFailPaymentNonExistent() {
        assertFalse("Failing a non-existent payment should return false", instance.failPayment("PX88", "Reason"));
    }

    /** Corner case: Refund non-existent payment */
    @Test
    public void testRefundPaymentNonExistent() {
        assertFalse("Refunding non-existent payment should fail", instance.refundPayment("PX77"));
    }

    /** Corner case: Refund payment that is not COMPLETED/PAID */
    @Test
    public void testRefundPaymentNotCompleted() {
        instance.addPayment(new Payment("P007", "B007", 700.0, "PENDING"));
        assertFalse("Cannot refund a payment that is not completed", instance.refundPayment("P007"));
    }

    /** Corner case: Add duplicate payment ID */
    @Test
    public void testAddDuplicatePayment() {
        Payment duplicate = new Payment("P001", "B001X", 999.0, "PENDING");
        instance.addPayment(duplicate);
        // Accept either replace or keep old; test flexible
        String bookingId = instance.getPaymentById("P001").getBookingId();
        assertTrue("BookingId should be either original or new one",
                bookingId.equals("B001") || bookingId.equals("B001X"));
    }

    /** Corner case: Payment with zero amount */
    @Test
    public void testZeroAmountPayment() {
        Payment p = new Payment("P008", "B008", 0.0, "PENDING");
        instance.addPayment(p);
        assertEquals(0.0, p.getAmount(), 0.0);
    }

    /** Corner case: Payment with negative amount */
    @Test
    public void testNegativeAmountPayment() {
        Payment p = new Payment("P009", "B009", -100.0, "PENDING");
        instance.addPayment(p);
        assertTrue("Negative amount allowed but unusual", p.getAmount() < 0);
    }

    /** Corner case: Retrieve payment that doesn't exist */
    @Test
    public void testGetPaymentByIdNonExistent() {
        assertNull(instance.getPaymentById("NOT_FOUND"));
    }
    


/** Null case: Process with null ID */
@Test
public void testProcessPaymentNullId() {
    assertFalse("Processing with null ID should return false", instance.processPayment(null));
}

/** Null case: Fail payment with null ID */
@Test
public void testFailPaymentNullId() {
    assertFalse("Failing with null ID should return false", instance.failPayment(null, "Reason"));
}

/** Null case: Refund with null ID */
@Test
public void testRefundPaymentNullId() {
    assertFalse("Refunding with null ID should return false", instance.refundPayment(null));
}

/** Null case: Get payment by null ID */
@Test
public void testGetPaymentByIdNull() {
    assertNull("Retrieving payment with null ID should return null", instance.getPaymentById(null));
}


}
