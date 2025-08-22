package report;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReportGeneratorTest {
    
    private ReportGenerator instance;
    
    public ReportGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
       
    }
    
    @Before
    public void setUp() {
        instance = new ReportGenerator();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testGenerateDaily() {
        System.out.println("generateDaily");
        String result = instance.generateDaily();
        assertNotNull("Daily report should not be null", result);
        assertTrue("Daily report should contain 'DAILY REPORT'", result.contains("DAILY REPORT"));
    }

    @Test
    public void testGenerateDailyReport() {
        System.out.println("generateDailyReport");
        String date = "2025-08-01";
        String result = instance.generateDailyReport(date);
        assertNotNull("Daily report for date should not be null", result);
        assertTrue("Report should contain the date", result.contains(date));
    }

    @Test
    public void testGenerateMonthly() {
        System.out.println("generateMonthly");
        String result = instance.generateMonthly();
        assertNotNull("Monthly report should not be null", result);
        assertTrue("Monthly report should contain 'MONTHLY REPORT'", result.contains("MONTHLY REPORT"));
    }

    @Test
    public void testGenerateMonthlyReport() {
        System.out.println("generateMonthlyReport");
        String month = "2025-08";
        String result = instance.generateMonthlyReport(month);
        assertNotNull("Monthly report for month should not be null", result);
        assertTrue("Report should contain the month", result.contains(month));
    }

    @Test
    public void testGenerateAnnual() {
        System.out.println("generateAnnual");
        String result = instance.generateAnnual();
        assertNotNull("Annual report should not be null", result);
        assertTrue("Annual report should contain 'ANNUAL REPORT'", result.contains("ANNUAL REPORT"));
    }

    @Test
    public void testGenerateAnnualReport() {
        System.out.println("generateAnnualReport");
        String year = "2025";
        String result = instance.generateAnnualReport(year);
        assertNotNull("Annual report for year should not be null", result);
        assertTrue("Report should contain the year", result.contains(year));
    }

    @Test
    public void testGenerateSystemReport() {
        System.out.println("generateSystemReport");
        String result = instance.generateSystemReport();
        assertNotNull("System report should not be null", result);
        assertTrue("System report should contain 'SYSTEM HEALTH'", result.contains("SYSTEM HEALTH"));
    }

    @Test
    public void testGenerateCustomReport() {
        System.out.println("generateCustomReport");
        String reportType = "REVENUE";
        String startDate = "2025-07-01";
        String endDate = "2025-07-31";
        String result = instance.generateCustomReport(reportType, startDate, endDate);
        assertNotNull("Custom report should not be null", result);
        assertTrue("Custom report should contain report type", result.contains(reportType));
        assertTrue("Custom report should contain start date", result.contains(startDate));
        assertTrue("Custom report should contain end date", result.contains(endDate));
    }
    
}
