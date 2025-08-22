/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Working JUnit test class for Invoice - All Methods
 * @author Hp
 */
public class InvoiceTest {
    
    private Invoice invoice;
    
    public InvoiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Create a test invoice instance
        invoice = new Invoice("INV001", "BK001", "U001");
    }
    
    @After
    public void tearDown() {
        invoice = null;
    }

    /**
     * Test of addItem method, of class Invoice.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        
        String description = "Hotel Booking";
        double amount = 1000.0;
        int quantity = 2;
        
        // Test adding item
        invoice.addItem(description, amount, quantity);
        
        // Verify item was added
        List<Invoice.InvoiceItem> items = invoice.getItems();
        assertEquals("Should have 1 item", 1, items.size());
        assertEquals("Description should match", description, items.get(0).description);
        assertEquals("Amount should match", amount, items.get(0).amount, 0.01);
        assertEquals("Quantity should match", quantity, items.get(0).quantity);
        
        // Test adding another item
        invoice.addItem("Transport", 500.0, 1);
        assertEquals("Should have 2 items", 2, invoice.getItems().size());
    }

    /**
     * Test of calculateTotal method, of class Invoice.
     */
    @Test
    public void testCalculateTotal() {
        System.out.println("calculateTotal");
        
        // Add some items
        invoice.addItem("Hotel", 1000.0, 2);  
        invoice.addItem("Food", 500.0, 3);   
        
        // Set tax and discount
        invoice.setTax(100.0);
        invoice.setDiscount(200.0);
        
        // Calculate total
        invoice.calculateTotal();
        
        // Verify calculations
        assertEquals("Subtotal should be 3500", 3500.0, invoice.getSubtotal(), 0.01);
        assertEquals("Total should be 3400 (3500 + 100 - 200)", 3400.0, invoice.getTotalAmount(), 0.01);
    }

    /**
     * Test of generateInvoiceText method, of class Invoice.
     */
    @Test
    public void testGenerateInvoiceText() {
        System.out.println("generateInvoiceText");
        
        // Add an item
        invoice.addItem("Test Item", 100.0, 1);
        
        String result = invoice.generateInvoiceText();
        
        assertNotNull("Invoice text should not be null", result);
        assertTrue("Should contain invoice header", result.contains("INVOICE"));
        assertTrue("Should contain invoice ID", result.contains("INV001"));
        assertTrue("Should contain booking ID", result.contains("BK001"));
        assertTrue("Should contain item description", result.contains("Test Item"));
    }

    /**
     * Test of getInvoiceId method, of class Invoice.
     */
    @Test
    public void testGetInvoiceId() {
        System.out.println("getInvoiceId");
        
        String result = invoice.getInvoiceId();
        assertEquals("Invoice ID should match", "INV001", result);
    }

    /**
     * Test of setInvoiceId method, of class Invoice.
     */
    @Test
    public void testSetInvoiceId() {
        System.out.println("setInvoiceId");
        
        String newInvoiceId = "INV002";
        invoice.setInvoiceId(newInvoiceId);
        
        assertEquals("Invoice ID should be updated", newInvoiceId, invoice.getInvoiceId());
    }

    /**
     * Test of getBookingId method, of class Invoice.
     */
    @Test
    public void testGetBookingId() {
        System.out.println("getBookingId");
        
        String result = invoice.getBookingId();
        assertEquals("Booking ID should match", "BK001", result);
    }

    /**
     * Test of setBookingId method, of class Invoice.
     */
    @Test
    public void testSetBookingId() {
        System.out.println("setBookingId");
        
        String newBookingId = "BK002";
        invoice.setBookingId(newBookingId);
        
        assertEquals("Booking ID should be updated", newBookingId, invoice.getBookingId());
    }

    /**
     * Test of getUserId method, of class Invoice.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        
        String result = invoice.getUserId();
        assertEquals("User ID should match", "U001", result);
    }

    /**
     * Test of setUserId method, of class Invoice.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        
        String newUserId = "U002";
        invoice.setUserId(newUserId);
        
        assertEquals("User ID should be updated", newUserId, invoice.getUserId());
    }

    /**
     * Test of getSubtotal method, of class Invoice.
     */
    @Test
    public void testGetSubtotal() {
        System.out.println("getSubtotal");
        
        // Initially should be 0
        assertEquals("Initial subtotal should be 0", 0.0, invoice.getSubtotal(), 0.01);
        
        // Add items and check subtotal
        invoice.addItem("Item1", 100.0, 2);
        invoice.addItem("Item2", 50.0, 3);
        
        assertEquals("Subtotal should be 350 (200 + 150)", 350.0, invoice.getSubtotal(), 0.01);
    }

    /**
     * Test of setSubtotal method, of class Invoice.
     */
    @Test
    public void testSetSubtotal() {
        System.out.println("setSubtotal");
        
        double newSubtotal = 500.0;
        invoice.setSubtotal(newSubtotal);
        
        assertEquals("Subtotal should be updated", newSubtotal, invoice.getSubtotal(), 0.01);
    }

    /**
     * Test of getTax method, of class Invoice.
     */
    @Test
    public void testGetTax() {
        System.out.println("getTax");
        
        // Initially should be 0
        assertEquals("Initial tax should be 0", 0.0, invoice.getTax(), 0.01);
    }

    /**
     * Test of setTax method, of class Invoice.
     */
    @Test
    public void testSetTax() {
        System.out.println("setTax");
        
        double newTax = 50.0;
        invoice.setTax(newTax);
        
        assertEquals("Tax should be updated", newTax, invoice.getTax(), 0.01);
    }

    /**
     * Test of getDiscount method, of class Invoice.
     */
    @Test
    public void testGetDiscount() {
        System.out.println("getDiscount");
        
        // Initially should be 0
        assertEquals("Initial discount should be 0", 0.0, invoice.getDiscount(), 0.01);
    }

    /**
     * Test of setDiscount method, of class Invoice.
     */
    @Test
    public void testSetDiscount() {
        System.out.println("setDiscount");
        
        double newDiscount = 25.0;
        invoice.setDiscount(newDiscount);
        
        assertEquals("Discount should be updated", newDiscount, invoice.getDiscount(), 0.01);
    }

    /**
     * Test of getTotalAmount method, of class Invoice.
     */
    @Test
    public void testGetTotalAmount() {
        System.out.println("getTotalAmount");
        
        // Add items
        invoice.addItem("Item", 100.0, 1);
        
        // Set tax and discount
        invoice.setTax(10.0);
        invoice.setDiscount(5.0);
        
        // Calculate total
        invoice.calculateTotal();
        
        assertEquals("Total should be 105 (100 + 10 - 5)", 105.0, invoice.getTotalAmount(), 0.01);
    }

    /**
     * Test of setTotalAmount method, of class Invoice.
     */
    @Test
    public void testSetTotalAmount() {
        System.out.println("setTotalAmount");
        
        double newTotal = 1000.0;
        invoice.setTotalAmount(newTotal);
        
        assertEquals("Total amount should be updated", newTotal, invoice.getTotalAmount(), 0.01);
    }

    /**
     * Test of getIssueDate method, of class Invoice.
     */
    @Test
    public void testGetIssueDate() {
        System.out.println("getIssueDate");
        
        String result = invoice.getIssueDate();
        assertNotNull("Issue date should not be null", result);
        assertTrue("Issue date should not be empty", result.length() > 0);
    }

    /**
     * Test of setIssueDate method, of class Invoice.
     */
    @Test
    public void testSetIssueDate() {
        System.out.println("setIssueDate");
        
        String newIssueDate = "2024-01-15";
        invoice.setIssueDate(newIssueDate);
        
        assertEquals("Issue date should be updated", newIssueDate, invoice.getIssueDate());
    }

    /**
     * Test of getDueDate method, of class Invoice.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        
        String result = invoice.getDueDate();
        // Initially should be null as not set in constructor
        assertNull("Due date should be null initially", result);
    }

    /**
     * Test of setDueDate method, of class Invoice.
     */
    @Test
    public void testSetDueDate() {
        System.out.println("setDueDate");
        
        String newDueDate = "2024-02-15";
        invoice.setDueDate(newDueDate);
        
        assertEquals("Due date should be updated", newDueDate, invoice.getDueDate());
    }

    /**
     * Test of getStatus method, of class Invoice.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        
        String result = invoice.getStatus();
        assertEquals("Status should be GENERATED initially", "GENERATED", result);
    }

    /**
     * Test of setStatus method, of class Invoice.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        
        String newStatus = "PAID";
        invoice.setStatus(newStatus);
        
        assertEquals("Status should be updated", newStatus, invoice.getStatus());
    }

    /**
     * Test of getItems method, of class Invoice.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        
        List<Invoice.InvoiceItem> result = invoice.getItems();
        
        assertNotNull("Items list should not be null", result);
        assertEquals("Items list should be empty initially", 0, result.size());
        
        // Add item and test
        invoice.addItem("Test Item", 100.0, 1);
        assertEquals("Items list should have 1 item", 1, invoice.getItems().size());
    }
    
    /**
     * Test Invoice constructor
     */
    @Test
    public void testInvoiceConstructor() {
        System.out.println("Invoice constructor");
        
        Invoice newInvoice = new Invoice("INV999", "BK999", "U999");
        
        assertEquals("Invoice ID should be set", "INV999", newInvoice.getInvoiceId());
        assertEquals("Booking ID should be set", "BK999", newInvoice.getBookingId());
        assertEquals("User ID should be set", "U999", newInvoice.getUserId());
        assertEquals("Status should be GENERATED", "GENERATED", newInvoice.getStatus());
        assertEquals("Tax should be 0", 0.0, newInvoice.getTax(), 0.01);
        assertEquals("Discount should be 0", 0.0, newInvoice.getDiscount(), 0.01);
        assertNotNull("Items list should be initialized", newInvoice.getItems());
        assertEquals("Items list should be empty", 0, newInvoice.getItems().size());
    }
    
    /**
     * Test InvoiceItem inner class
     */
    @Test
    public void testInvoiceItem() {
        System.out.println("InvoiceItem inner class");
        
        Invoice.InvoiceItem item = new Invoice.InvoiceItem("Test Description", 99.99, 3);
        
        assertEquals("Description should be set", "Test Description", item.description);
        assertEquals("Amount should be set", 99.99, item.amount, 0.01);
        assertEquals("Quantity should be set", 3, item.quantity);
    }
    
    /**
     * Test complex calculation scenario
     */
    @Test
    public void testComplexCalculation() {
        System.out.println("Complex calculation scenario");
        
        // Add multiple items
        invoice.addItem("Hotel Room", 2000.0, 3);     // 6000
        invoice.addItem("Meals", 500.0, 4);           // 2000  
        invoice.addItem("Transport", 300.0, 2);       // 600
        
        // Verify subtotal after adding items (addItem calls calculateTotal)
        assertEquals("Subtotal should be 8600", 8600.0, invoice.getSubtotal(), 0.01);
        
        // Set tax and discount
        invoice.setTax(860.0);
        invoice.setDiscount(100.0);
        
        // Need to call calculateTotal again after setting tax and discount
        invoice.calculateTotal();
        
        // Verify total (8600 + 860 - 100 = 9360)
        assertEquals("Total should be 9360", 9360.0, invoice.getTotalAmount(), 0.01);
    }
}