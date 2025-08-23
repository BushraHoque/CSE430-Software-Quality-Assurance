package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicketTest {

    @Test
    public void testUseTicket() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        assertFalse(instance.isUsed());
        instance.useTicket();
        assertTrue(instance.isUsed());
    }

    @Test
    public void testGenerateTicketText() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        String text = instance.generateTicketText();
        assertNotNull(text);
        assertTrue(text.contains("Ticket ID: T001"));
        assertTrue(text.contains("Booking ID: B001"));
        assertTrue(text.contains("Passenger: John Doe"));
        assertTrue(text.contains("Package: Holiday Package"));
        assertTrue(text.contains("Status: VALID"));
    }

    @Test
    public void testGetAndSetTicketId() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        assertEquals("T001", instance.getTicketId());
        instance.setTicketId("T002");
        assertEquals("T002", instance.getTicketId());
    }

    @Test
    public void testGetAndSetBookingId() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        assertEquals("B001", instance.getBookingId());
        instance.setBookingId("B002");
        assertEquals("B002", instance.getBookingId());
    }

    @Test
    public void testGetAndSetQRcode() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        String originalQR = instance.getQRcode();
        assertNotNull(originalQR);
        instance.setQRcode("NEWQR123456");
        assertEquals("NEWQR123456", instance.getQRcode());
    }

    @Test
    public void testGetAndSetIssueDate() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        String originalDate = instance.getIssueDate();
        assertNotNull(originalDate);
        instance.setIssueDate("2025-08-07");
        assertEquals("2025-08-07", instance.getIssueDate());
    }

    @Test
    public void testGetAndSetValidFrom() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        assertNull(instance.getValidFrom()); 
        instance.setValidFrom("2025-08-10");
        assertEquals("2025-08-10", instance.getValidFrom());
    }

    @Test
    public void testGetAndSetValidUntil() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        assertNull(instance.getValidUntil());  
        instance.setValidUntil("2025-08-20");
        assertEquals("2025-08-20", instance.getValidUntil());
    }

    @Test
    public void testGetAndSetPassengerName() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        assertEquals("John Doe", instance.getPassengerName());
        instance.setPassengerName("Jane Doe");
        assertEquals("Jane Doe", instance.getPassengerName());
    }

    @Test
    public void testGetAndSetPassengerPhone() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        assertNull(instance.getPassengerPhone());  
        instance.setPassengerPhone("0123456789");
        assertEquals("0123456789", instance.getPassengerPhone());
    }

    @Test
    public void testGetAndSetPackageName() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        assertEquals("Holiday Package", instance.getPackageName());
        instance.setPackageName("Business Package");
        assertEquals("Business Package", instance.getPackageName());
    }

    @Test
    public void testGetAndSetSeatNumber() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        assertNull(instance.getSeatNumber());  
        instance.setSeatNumber("A1");
        assertEquals("A1", instance.getSeatNumber());
    }

    @Test
    public void testIsUsedAndSetUsed() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        assertFalse(instance.isUsed());
        instance.setUsed(true);
        assertTrue(instance.isUsed());
        instance.setUsed(false);
        assertFalse(instance.isUsed());
    }

    @Test
    public void testToString() {
        Ticket instance = new Ticket("T001", "B001", "John Doe", "Holiday Package");
        String str = instance.toString();
        assertTrue(str.contains("ticketId='T001'"));
        assertTrue(str.contains("passenger='John Doe'"));
        assertTrue(str.contains("package='Holiday Package'"));
        assertTrue(str.contains("used=false"));
    }
}
