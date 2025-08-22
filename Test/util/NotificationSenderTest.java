package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotificationSenderTest {

    public NotificationSenderTest() {
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
    public void testSendWelcomeEmail() {
        String email = "test@example.com";
        String name = "Test User";
        try {
            NotificationSender.sendWelcomeEmail(email, name);
        } catch (Exception e) {
            fail("sendWelcomeEmail threw exception: " + e.getMessage());
        }
    }

    @Test
    public void testSendBookingConfirmation() {
        String email = "booking@example.com";
        String name = "Booking User";
        String bookingId = "BK001";
        try {
            NotificationSender.sendBookingConfirmation(email, name, bookingId);
        } catch (Exception e) {
            fail("sendBookingConfirmation threw exception: " + e.getMessage());
        }
    }

    @Test
    public void testSendPaymentConfirmation() {
        String email = "payment@example.com";
        String name = "Payment User";
        String paymentId = "PMT123";
        double amount = 500.00;
        try {
            NotificationSender.sendPaymentConfirmation(email, name, paymentId, amount);
        } catch (Exception e) {
            fail("sendPaymentConfirmation threw exception: " + e.getMessage());
        }
    }

    @Test
    public void testSendSMS() {
        String phone = "01700000000";
        String message = "Your ticket has been confirmed.";
        try {
            NotificationSender.sendSMS(phone, message);
        } catch (Exception e) {
            fail("sendSMS threw exception: " + e.getMessage());
        }
    }
    // -------------------- NOTIFICATION SENDER CORNER CASE TESTS --------------------

@Test
public void testSendWelcomeEmail_NullOrEmpty() {
    try {
        NotificationSender.sendWelcomeEmail(null, null);
        NotificationSender.sendWelcomeEmail("", "");
        NotificationSender.sendWelcomeEmail("user@example.com", null);
        NotificationSender.sendWelcomeEmail(null, "User");
    } catch (Exception e) {
        fail("sendWelcomeEmail corner cases threw exception: " + e.getMessage());
    }
}

@Test
public void testSendBookingConfirmation_NullOrEmpty() {
    try {
        NotificationSender.sendBookingConfirmation(null, null, null);
        NotificationSender.sendBookingConfirmation("", "", "");
        NotificationSender.sendBookingConfirmation("user@example.com", null, "BK001");
        NotificationSender.sendBookingConfirmation(null, "User", "BK002");
    } catch (Exception e) {
        fail("sendBookingConfirmation corner cases threw exception: " + e.getMessage());
    }
}

@Test
public void testSendPaymentConfirmation_NullOrEmpty() {
    try {
        NotificationSender.sendPaymentConfirmation(null, null, null, 0.0);
        NotificationSender.sendPaymentConfirmation("", "", "", 0.0);
        NotificationSender.sendPaymentConfirmation("user@example.com", null, "PMT001", 100.0);
        NotificationSender.sendPaymentConfirmation(null, "User", "PMT002", 200.0);
    } catch (Exception e) {
        fail("sendPaymentConfirmation corner cases threw exception: " + e.getMessage());
    }
}

@Test
public void testSendSMS_NullOrEmpty() {
    try {
        NotificationSender.sendSMS(null, null);
        NotificationSender.sendSMS("", "");
        NotificationSender.sendSMS("01700000000", "");
        NotificationSender.sendSMS("", "Hello");
    } catch (Exception e) {
        fail("sendSMS corner cases threw exception: " + e.getMessage());
    }
}

@Test
public void testSendMultipleRapidly() {
    try {
        for (int i = 0; i < 10; i++) {
            NotificationSender.sendWelcomeEmail("rapid@example.com", "Rapid User");
            NotificationSender.sendBookingConfirmation("rapid@example.com", "Rapid User", "BK" + i);
            NotificationSender.sendPaymentConfirmation("rapid@example.com", "Rapid User", "PMT" + i, i * 100.0);
            NotificationSender.sendSMS("0170000000" + i, "Message " + i);
        }
    } catch (Exception e) {
        fail("Rapid sending corner case threw exception: " + e.getMessage());
    }
}

}
