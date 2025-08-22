package report;

import java.util.ArrayList;
import java.util.List;
import model.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PDFExporterTest {

    public PDFExporterTest() {
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

    @Test
    public void testExportDailyReport() {
        System.out.println("exportDailyReport");
        String content = "Sample daily report";
        String date = "2025-08-19";
        PDFExporter instance = new PDFExporter();
        boolean expResult = true;
        boolean result = instance.exportDailyReport(content, date);
        assertEquals(expResult, result);
    }

    @Test
    public void testExportMonthlyReport() {
        System.out.println("exportMonthlyReport");
        String content = "Sample monthly report";
        String month = "2025-08";
        PDFExporter instance = new PDFExporter();
        boolean expResult = true;
        boolean result = instance.exportMonthlyReport(content, month);
        assertEquals(expResult, result);
    }

    @Test
    public void testExportAnnualReport() {
        System.out.println("exportAnnualReport");
        String content = "Sample annual report";
        String year = "2025";
        PDFExporter instance = new PDFExporter();
        boolean expResult = true;
        boolean result = instance.exportAnnualReport(content, year);
        assertEquals(expResult, result);
    }

    @Test
    public void testExportReport() {
        System.out.println("exportReport");
        String content = "Generic report";
        String fileName = "report.pdf";
        PDFExporter instance = new PDFExporter();
        boolean expResult = true;
        boolean result = instance.exportReport(content, fileName);
        assertEquals(expResult, result);
    }

    @Test
    public void testExportUserList() {
        System.out.println("exportUserList");
        List<User> users = new ArrayList<>();
        users.add(new User("U001", "Alice", "alice@mail.com", "Admin", true));
        users.add(new User("U002", "Bob", "bob@mail.com", "User", false));

        PDFExporter instance = new PDFExporter();
        boolean expResult = true;
        boolean result = instance.exportUserList(users);
        assertEquals(expResult, result);
    }



    @Test
    public void testExportBookingList() {
        System.out.println("exportBookingList");
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("B001", "P001", "2025-09-01", 2, (int) 10000.0, enumtype.BookingStatus.CONFIRMED));

        PDFExporter instance = new PDFExporter();
        boolean expResult = true;
        boolean result = instance.exportBookingList(bookings);
        assertEquals(expResult, result);
    }

    @Test
    public void testExportPaymentList() {
        System.out.println("exportPaymentList");
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment("PAY001", "B001", 10000.0, "Card", "COMPLETED"));

        PDFExporter instance = new PDFExporter();
        boolean expResult = true;
        boolean result = instance.exportPaymentList(payments);
        assertEquals(expResult, result);
    }

   

    @Test
    public void testExportTicket() {
        System.out.println("exportTicket");
        Ticket ticket = new Ticket("T001", "B001", "2025-09-01", "Alice", "01712345678", "Beach Tour", "A1", "QR001", false);

        PDFExporter instance = new PDFExporter();
        boolean expResult = true;
        boolean result = instance.exportTicket(ticket);
        assertEquals(expResult, result);
    }

    @Test
    public void testExportCustomReport() {
        System.out.println("exportCustomReport");
        String title = "Custom Report";
        String content = "Custom content";
        String fileName = "custom_report.pdf";
        PDFExporter instance = new PDFExporter();
        boolean expResult = true;
        boolean result = instance.exportCustomReport(title, content, fileName);
        assertEquals(expResult, result);
    }

    @Test
    public void testExportBulkData() {
        System.out.println("exportBulkData");
        String dataType = "users";
        String start = "2025-08-01";
        String end = "2025-08-19";
        PDFExporter instance = new PDFExporter();
        boolean expResult = true;
        boolean result = instance.exportBulkData(dataType, start, end);
        assertEquals(expResult, result);
    }

}
