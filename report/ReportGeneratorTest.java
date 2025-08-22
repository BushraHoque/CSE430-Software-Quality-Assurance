/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hp
 */
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

    /**
     * Test of generateDaily method, of class ReportGenerator.
     */
    @Test
    public void testGenerateDaily() {
        System.out.println("generateDaily");
        String result = instance.generateDaily();
        assertNotNull("Daily report should not be null", result);
        assertTrue("Daily report should contain DAILY REPORT header", 
        result.contains("DAILY REPORT"));
    }

    /**
     * Test of generateDaily method with content validation.
     */
    @Test
    public void testGenerateDailyContentValidation() {
        System.out.println("generateDaily - Content Validation");
        String result = instance.generateDaily();
        assertTrue("Daily report should contain Date field", 
                   result.contains("Date:"));
        assertTrue("Daily report should have substantial content", 
                   result.length() > 100);
    }

    /**
     * Test of generateDaily method multiple times.
     */
    @Test
    public void testGenerateDailyMultipleTimes() {
        System.out.println("generateDaily - Multiple Times");
        String result1 = instance.generateDaily();
        String result2 = instance.generateDaily();
        assertNotNull("First daily report should not be null", result1);
        assertNotNull("Second daily report should not be null", result2);
        
       // ekdine multiple report generate korte parse kina
    }

    /**
     * Test of generateDaily method performance.
     */
    @Test
    public void testGenerateDailyPerformance() {
        System.out.println("generateDaily - Performance");
        long startTime = System.currentTimeMillis();
        String result = instance.generateDaily();
        long endTime = System.currentTimeMillis();
        assertNotNull("Daily report should be generated", result);
        assertTrue("Report generation should complete within reasonable time", 
                   (endTime - startTime) < 5000);
        
        // report generate kotu time ar modde sesh hoitese 
        //benchmark maintain
    }

    /**
     * Test of generateDailyReport method, of class ReportGenerator.
     */
    @Test
    public void testGenerateDailyReport() {
        System.out.println("generateDailyReport");
        String date = "2024-01-15";
        String result = instance.generateDailyReport(date);
        assertNotNull("Daily report with date should not be null", result);
        assertTrue("Report should contain the specified date", 
                   result.contains(date));
        
        // specific date diye report generate kora jacce kina
    }

    /**
     * Test of generateDailyReport method with different date.
     */
    @Test
    public void testGenerateDailyReportDifferentDate() {
        System.out.println("generateDailyReport - Different Date");
        String date = "2024-06-15";
        String result = instance.generateDailyReport(date);
        assertTrue("Report should contain DAILY BOOKINGS section", 
                   result.contains("DAILY BOOKINGS"));
        assertTrue("Report should contain DAILY PAYMENTS section", 
                   result.contains("DAILY PAYMENTS"));
    }

    /**
     * Test of generateDailyReport method with leap year date.
     */
    @Test
    public void testGenerateDailyReportLeapYear() {
        System.out.println("generateDailyReport - Leap Year");
        String date = "2024-02-29";
        String result = instance.generateDailyReport(date);
        assertTrue("Report should contain the leap year date", 
                   result.contains(date));
        assertTrue("Report should contain NEW REGISTRATIONS section", 
                   result.contains("NEW REGISTRATIONS"));
    }

    /**
     * Test of generateDailyReport method with year end date.
     */
    @Test
    public void testGenerateDailyReportYearEnd() {
        System.out.println("generateDailyReport - Year End");
        String date = "2024-12-31";
        String result = instance.generateDailyReport(date);
        assertNotNull("Year end report should not be null", result);
        assertTrue("Report should contain year end date", 
                   result.contains(date));
    }

    /**
     * Test of generateDailyReport method with null date.
     */
    @Test
    public void testGenerateDailyReportNullDate() {
        System.out.println("generateDailyReport - Null Date");
        String result = instance.generateDailyReport(null);
        assertNotNull("Daily report should handle null date gracefully", result);
        assertTrue("Report should still contain basic structure", 
                   result.contains("DAILY REPORT"));
    }

    /**
     * Test of generateDailyReport method with empty date.
     */
    @Test
    public void testGenerateDailyReportEmptyDate() {
        System.out.println("generateDailyReport - Empty Date");
        String result = instance.generateDailyReport("");
        assertNotNull("Daily report should handle empty date gracefully", result);
        assertTrue("Report should contain basic structure", 
                   result.contains("DAILY REPORT"));
    }

    /**
     * Test of generateMonthly method, of class ReportGenerator.
     */
    @Test
    public void testGenerateMonthly() {
        System.out.println("generateMonthly");
        String result = instance.generateMonthly();
        assertNotNull("Monthly report should not be null", result);
        assertTrue("Monthly report should contain MONTHLY REPORT header", 
                   result.contains("MONTHLY REPORT"));
        
        // manual calculation theke update hote monthly performance report feature ache naki check
    }

    /**
     * Test of generateMonthly method content validation.
     */
    @Test
    public void testGenerateMonthlyContentValidation() {
        System.out.println("generateMonthly - Content Validation");
        String result = instance.generateMonthly();
        assertTrue("Monthly report should contain Month field", 
                   result.contains("Month:"));
        assertTrue("Monthly report should contain MONTHLY OVERVIEW", 
                   result.contains("MONTHLY OVERVIEW"));
    }

    /**
     * Test of generateMonthly method length validation.
     */
    @Test
    public void testGenerateMonthlyLengthValidation() {
        System.out.println("generateMonthly - Length Validation");
        String result = instance.generateMonthly();
        assertTrue("Monthly report should have substantial content", 
                   result.length() > 200);
        assertTrue("Monthly report should contain Generated field", 
                   result.contains("Generated:"));
    }

    /**
     * Test of generateMonthly method consistency.
     */
    @Test
    public void testGenerateMonthlyConsistency() {
        System.out.println("generateMonthly - Consistency");
        String result1 = instance.generateMonthly();
        String result2 = instance.generateMonthly();
        assertTrue("Both monthly reports should contain MONTHLY", 
                   result1.contains("MONTHLY") && result2.contains("MONTHLY"));
        assertNotNull("Both monthly reports should not be null", result1);
        assertNotNull("Second monthly report should not be null", result2);
    }

    /**
     * Test of generateMonthlyReport method, of class ReportGenerator.
     */
    @Test
    public void testGenerateMonthlyReport() {
        System.out.println("generateMonthlyReport");
        String month = "2024-01";
        String result = instance.generateMonthlyReport(month);
        assertNotNull("Monthly report with month should not be null", result);
        assertTrue("Report should contain the specified month", 
                   result.contains(month));
    }

    /**
     * Test of generateMonthlyReport method with different month.
     */
    @Test
    public void testGenerateMonthlyReportDifferentMonth() {
        System.out.println("generateMonthlyReport - Different Month");
        String month = "2024-06";
        String result = instance.generateMonthlyReport(month);
        assertTrue("Report should contain BOOKING STATUS BREAKDOWN", 
                   result.contains("BOOKING STATUS BREAKDOWN"));
        assertTrue("Report should contain POPULAR PACKAGES", 
                   result.contains("POPULAR PACKAGES"));
    }

    /**
     * Test of generateMonthlyReport method with December.
     */
    @Test
    public void testGenerateMonthlyReportDecember() {
        System.out.println("generateMonthlyReport - December");
        String month = "2024-12";
        String result = instance.generateMonthlyReport(month);
        assertTrue("Report should contain CUSTOMER ANALYSIS", 
                   result.contains("CUSTOMER ANALYSIS"));
        assertTrue("Report should contain PAYMENT METHODS", 
                   result.contains("PAYMENT METHODS"));
    }

    /**
     * Test of generateMonthlyReport method with previous year.
     */
    @Test
    public void testGenerateMonthlyReportPreviousYear() {
        System.out.println("generateMonthlyReport - Previous Year");
        String month = "2023-03";
        String result = instance.generateMonthlyReport(month);
        assertNotNull("Previous year monthly report should not be null", result);
        assertTrue("Report should contain the previous year month", 
                   result.contains(month));
    }

    /**
     * Test of generateMonthlyReport method with null month.
     */
    @Test
    public void testGenerateMonthlyReportNullMonth() {
        System.out.println("generateMonthlyReport - Null Month");
        String result = instance.generateMonthlyReport(null);
        assertNotNull("Monthly report should handle null month gracefully", result);
        assertTrue("Report should still contain basic structure", 
                   result.contains("MONTHLY REPORT"));
    }

    /**
     * Test of generateMonthlyReport method with empty month.
     */
    @Test
    public void testGenerateMonthlyReportEmptyMonth() {
        System.out.println("generateMonthlyReport - Empty Month");
        String result = instance.generateMonthlyReport("");
        assertNotNull("Monthly report should handle empty month gracefully", result);
        assertTrue("Report should contain basic structure", 
                   result.contains("MONTHLY REPORT"));
    }

    /**
     * Test of generateAnnual method, of class ReportGenerator.
     */
    @Test
    public void testGenerateAnnual() {
        System.out.println("generateAnnual");
        String result = instance.generateAnnual();
        assertNotNull("Annual report should not be null", result);
        assertTrue("Annual report should contain ANNUAL REPORT header", 
                   result.contains("ANNUAL REPORT"));
    }

    /**
     * Test of generateAnnual method content validation.
     */
    @Test
    public void testGenerateAnnualContentValidation() {
        System.out.println("generateAnnual - Content Validation");
        String result = instance.generateAnnual();
        assertTrue("Annual report should contain Year field", 
                   result.contains("Year:"));
        assertTrue("Annual report should contain ANNUAL OVERVIEW", 
                   result.contains("ANNUAL OVERVIEW"));
    }

    /**
     * Test of generateAnnual method sections validation.
     */
    @Test
    public void testGenerateAnnualSectionsValidation() {
        System.out.println("generateAnnual - Sections Validation");
        String result = instance.generateAnnual();
        assertTrue("Annual report should contain FINANCIAL SUMMARY", 
                   result.contains("FINANCIAL SUMMARY"));
        assertTrue("Annual report should have substantial content", 
                   result.length() > 300);
    }

    /**
     * Test of generateAnnual method comprehensive validation.
     */
    @Test
    public void testGenerateAnnualComprehensiveValidation() {
        System.out.println("generateAnnual - Comprehensive Validation");
        String result = instance.generateAnnual();
        assertTrue("Annual report should contain GROWTH ANALYSIS", 
                   result.contains("GROWTH ANALYSIS"));
        assertTrue("Annual report should contain Generated field", 
                   result.contains("Generated:"));
    }

    /**
     * Test of generateAnnualReport method, of class ReportGenerator.
     */
    @Test
    public void testGenerateAnnualReport() {
        System.out.println("generateAnnualReport");
        String year = "2024";
        String result = instance.generateAnnualReport(year);
        assertNotNull("Annual report with year should not be null", result);
        assertTrue("Report should contain the specified year", 
                   result.contains(year));
    }

    /**
     * Test of generateAnnualReport method with different year.
     */
    @Test
    public void testGenerateAnnualReportDifferentYear() {
        System.out.println("generateAnnualReport - Different Year");
        String year = "2023";
        String result = instance.generateAnnualReport(year);
        assertTrue("Report should contain TOP PERFORMING PACKAGES", 
                   result.contains("TOP PERFORMING PACKAGES"));
        assertTrue("Report should contain CUSTOMER INSIGHTS", 
                   result.contains("CUSTOMER INSIGHTS"));
    }

    /**
     * Test of generateAnnualReport method with future year.
     */
    @Test
    public void testGenerateAnnualReportFutureYear() {
        System.out.println("generateAnnualReport - Future Year");
        String year = "2025";
        String result = instance.generateAnnualReport(year);
        assertTrue("Report should contain SEASONAL ANALYSIS", 
                   result.contains("SEASONAL ANALYSIS"));
        assertTrue("Report should contain SYSTEM STATISTICS", 
                   result.contains("SYSTEM STATISTICS"));
    }

    /**
     * Test of generateAnnualReport method with past year.
     */
    @Test
    public void testGenerateAnnualReportPastYear() {
        System.out.println("generateAnnualReport - Past Year");
        String year = "2022";
        String result = instance.generateAnnualReport(year);
        assertNotNull("Past year annual report should not be null", result);
        assertTrue("Report should contain the past year", 
                   result.contains(year));
    }

    /**
     * Test of generateAnnualReport method with null year.
     */
    @Test
    public void testGenerateAnnualReportNullYear() {
        System.out.println("generateAnnualReport - Null Year");
        String result = instance.generateAnnualReport(null);
        assertNotNull("Annual report should handle null year gracefully", result);
        assertTrue("Report should still contain basic structure", 
                   result.contains("ANNUAL REPORT"));
    }

    /**
     * Test of generateAnnualReport method with empty year.
     */
    @Test
    public void testGenerateAnnualReportEmptyYear() {
        System.out.println("generateAnnualReport - Empty Year");
        String result = instance.generateAnnualReport("");
        assertNotNull("Annual report should handle empty year gracefully", result);
        assertTrue("Report should contain basic structure", 
                   result.contains("ANNUAL REPORT"));
    }

    /**
     * Test of generateSystemReport method, of class ReportGenerator.
     */
    @Test
    public void testGenerateSystemReport() {
        System.out.println("generateSystemReport");
        String result = instance.generateSystemReport();
        assertNotNull("System report should not be null", result);
        assertTrue("System report should contain SYSTEM REPORT header", 
                   result.contains("SYSTEM REPORT"));
    }

    /**
     * Test of generateSystemReport method content validation.
     */
    @Test
    public void testGenerateSystemReportContentValidation() {
        System.out.println("generateSystemReport - Content Validation");
        String result = instance.generateSystemReport();
        assertTrue("System report should contain SYSTEM OVERVIEW", 
                   result.contains("SYSTEM OVERVIEW"));
        assertTrue("System report should contain USER DISTRIBUTION", 
                   result.contains("USER DISTRIBUTION"));
    }

    /**
     * Test of generateSystemReport method sections validation.
     */
    @Test
    public void testGenerateSystemReportSectionsValidation() {
        System.out.println("generateSystemReport - Sections Validation");
        String result = instance.generateSystemReport();
        assertTrue("System report should contain PACKAGE DISTRIBUTION", 
                   result.contains("PACKAGE DISTRIBUTION"));
        assertTrue("System report should contain SYSTEM HEALTH", 
                   result.contains("SYSTEM HEALTH"));
    }

    /**
     * Test of generateSystemReport method length validation.
     */
    @Test
    public void testGenerateSystemReportLengthValidation() {
        System.out.println("generateSystemReport - Length Validation");
        String result = instance.generateSystemReport();
        assertTrue("System report should contain Generated field", 
                   result.contains("Generated:"));
        assertTrue("System report should have substantial content", 
                   result.length() > 200);
    }

    /**
     * Test of generateSystemReport method consistency.
     */
    @Test
    public void testGenerateSystemReportConsistency() {
        System.out.println("generateSystemReport - Consistency");
        String result1 = instance.generateSystemReport();
        String result2 = instance.generateSystemReport();
        assertNotNull("First system report should not be null", result1);
        assertNotNull("Second system report should not be null", result2);
    }

    /**
     * Test of generateCustomReport method, of class ReportGenerator.
     */
    @Test
    public void testGenerateCustomReport() {
        System.out.println("generateCustomReport");
        String reportType = "REVENUE";
        String startDate = "2024-01-01";
        String endDate = "2024-01-31";
        String result = instance.generateCustomReport(reportType, startDate, endDate);
        assertNotNull("Custom report should not be null", result);
        assertTrue("Custom report should contain CUSTOM REPORT header", 
                   result.contains("CUSTOM REPORT"));
    }

    /**
     * Test of generateCustomReport method with REVENUE type.
     */
    @Test
    public void testGenerateCustomReportRevenue() {
        System.out.println("generateCustomReport - REVENUE");
        String reportType = "REVENUE";
        String startDate = "2024-01-01";
        String endDate = "2024-01-31";
        String result = instance.generateCustomReport(reportType, startDate, endDate);
        assertTrue("Report should contain the report type", 
                   result.contains(reportType));
        assertTrue("Report should contain the start date", 
                   result.contains(startDate));
    }

    /**
     * Test of generateCustomReport method with BOOKINGS type.
     */
    @Test
    public void testGenerateCustomReportBookings() {
        System.out.println("generateCustomReport - BOOKINGS");
        String reportType = "BOOKINGS";
        String startDate = "2024-02-01";
        String endDate = "2024-02-28";
        String result = instance.generateCustomReport(reportType, startDate, endDate);
        assertTrue("Report should contain BOOKINGS type", 
                   result.contains("BOOKINGS"));
        assertTrue("Report should contain the end date", 
                   result.contains(endDate));
    }

    /**
     * Test of generateCustomReport method with CUSTOMERS type.
     */
    @Test
    public void testGenerateCustomReportCustomers() {
        System.out.println("generateCustomReport - CUSTOMERS");
        String reportType = "CUSTOMERS";
        String startDate = "2024-03-01";
        String endDate = "2024-03-31";
        String result = instance.generateCustomReport(reportType, startDate, endDate);
        assertTrue("Report should contain CUSTOMERS type", 
                   result.contains("CUSTOMERS"));
        assertTrue("Report should contain Period field", 
                   result.contains("Period:"));
    }

    /**
     * Test of generateCustomReport method with PACKAGES type.
     */
    @Test
    public void testGenerateCustomReportPackages() {
        System.out.println("generateCustomReport - PACKAGES");
        String reportType = "PACKAGES";
        String startDate = "2024-04-01";
        String endDate = "2024-04-30";
        String result = instance.generateCustomReport(reportType, startDate, endDate);
        assertNotNull("Packages report should not be null", result);
        assertTrue("Report should contain PACKAGES type", 
                   result.contains("PACKAGES"));
    }

    /**
     * Test of generateCustomReport method with unknown type.
     */
    @Test
    public void testGenerateCustomReportUnknownType() {
        System.out.println("generateCustomReport - Unknown Type");
        String reportType = "UNKNOWN";
        String startDate = "2024-01-01";
        String endDate = "2024-01-31";
        String result = instance.generateCustomReport(reportType, startDate, endDate);
        assertNotNull("Unknown type report should not be null", result);
        assertTrue("Report should contain unknown report type message", 
                   result.contains("Unknown report type"));
    }

    /**
     * Test of generateCustomReport method with different date range.
     */
    @Test
    public void testGenerateCustomReportDifferentDateRange() {
        System.out.println("generateCustomReport - Different Date Range");
        String reportType = "BOOKINGS";
        String startDate = "2024-06-01";
        String endDate = "2024-06-30";
        String result = instance.generateCustomReport(reportType, startDate, endDate);
        assertTrue("Report should contain June start date", 
                   result.contains(startDate));
        assertTrue("Report should contain June end date", 
                   result.contains(endDate));
    }

    /**
     * Test of generateCustomReport method with long date range.
     */
    @Test
    public void testGenerateCustomReportLongDateRange() {
        System.out.println("generateCustomReport - Long Date Range");
        String reportType = "REVENUE";
        String startDate = "2024-01-01";
        String endDate = "2024-12-31";
        String result = instance.generateCustomReport(reportType, startDate, endDate);
        assertNotNull("Long date range report should not be null", result);
        assertTrue("Report should handle long date range", 
                   result.contains("2024-01-01"));
    }

    /**
     * Test of generateCustomReport method with null parameters.
     */
    @Test
    public void testGenerateCustomReportNullParameters() {
        System.out.println("generateCustomReport - Null Parameters");
        String result = instance.generateCustomReport(null, null, null);
        assertNotNull("Custom report should handle null parameters gracefully", result);
        assertTrue("Report should still contain basic structure", 
                   result.contains("CUSTOM REPORT"));
    }

    /**
     * Test of generateCustomReport method with empty parameters.
     */
    @Test
    public void testGenerateCustomReportEmptyParameters() {
        System.out.println("generateCustomReport - Empty Parameters");
        String result = instance.generateCustomReport("", "", "");
        assertNotNull("Custom report should handle empty parameters gracefully", result);
        assertTrue("Report should contain basic structure", 
                   result.contains("CUSTOM REPORT"));
    }

    /**
     * Test constructor functionality.
     */
    @Test
    public void testConstructor() {
        System.out.println("Testing Constructor");
        ReportGenerator rg = new ReportGenerator();
        assertNotNull("ReportGenerator instance should not be null", rg);
        String report = rg.generateDaily();
        assertNotNull("Report should be generated after construction", report);
    }

    /**
     * Test constructor with immediate report generation.
     */
    @Test
    public void testConstructorImmediateGeneration() {
        System.out.println("Constructor - Immediate Generation");
        ReportGenerator rg = new ReportGenerator();
        String report = rg.generateSystemReport();
        assertTrue("Report should have proper content after construction", 
                   report.contains("SYSTEM REPORT"));
        assertTrue("Report should be substantial", report.length() > 100);
    }

    /**
     * Test all report types consistency.
     */
    @Test
    public void testAllReportTypesConsistency() {
        System.out.println("All Report Types - Consistency");
        String daily = instance.generateDaily();
        String monthly = instance.generateMonthly();
        assertNotNull("Daily report should not be null", daily);
        assertNotNull("Monthly report should not be null", monthly);
    }

    /**
     * Test all report types content validation.
     */
    @Test
    public void testAllReportTypesContentValidation() {
        System.out.println("All Report Types - Content Validation");
        String annual = instance.generateAnnual();
        String system = instance.generateSystemReport();
        assertTrue("Annual report should contain ANNUAL", annual.contains("ANNUAL"));
        assertTrue("System report should contain SYSTEM", system.contains("SYSTEM"));
    }

    /**
     * Test performance of report generation.
     */
    @Test
    public void testReportGenerationPerformance() {
        System.out.println("Report Generation - Performance");
        long startTime = System.currentTimeMillis();
        String result = instance.generateMonthly();
        long endTime = System.currentTimeMillis();
        assertNotNull("Report should be generated", result);
        assertTrue("Report generation should complete within reasonable time", 
                   (endTime - startTime) < 5000);
    }

    /**
     * Test multiple report generations consistency.
     */
    @Test
    public void testMultipleReportGenerationsConsistency() {
        System.out.println("Multiple Report Generations - Consistency");
        String report1 = instance.generateSystemReport();
        String report2 = instance.generateSystemReport();
        assertTrue("Both reports should contain SYSTEM REPORT", 
                   report1.contains("SYSTEM REPORT") && report2.contains("SYSTEM REPORT"));
        assertTrue("Both reports should have substantial content", 
                   report1.length() > 100 && report2.length() > 100);
    }

    /**
     * Test boundary date values handling.
     */
    @Test
    public void testBoundaryDateValues() {
        System.out.println("Boundary Date Values");
        String leapYearResult = instance.generateDailyReport("2024-02-29");
        String yearEndResult = instance.generateDailyReport("2024-12-31");
        assertNotNull("Leap year date should work", leapYearResult);
        assertNotNull("Year end date should work", yearEndResult);
    }

    /**
     * Test edge case date handling.
     */
    @Test
    public void testEdgeCaseDateHandling() {
        System.out.println("Edge Case Date Handling");
        String yearStartResult = instance.generateDailyReport("2024-01-01");
        String customResult = instance.generateCustomReport("REVENUE", "2024-01-01", "2024-01-01");
        assertTrue("Year start date should work", yearStartResult.contains("2024-01-01"));
        assertTrue("Same start and end date should work", customResult.contains("2024-01-01"));
    }

    /**
     * Final integration test to ensure all methods work together.
     */
    @Test
    public void testCompleteIntegration() {
        System.out.println("Complete Integration Test");
        String daily = instance.generateDaily();
        String monthly = instance.generateMonthly();
        assertNotNull("Daily report should be generated", daily);
        assertNotNull("Monthly report should be generated", monthly);
    }

    /**
     * Final comprehensive validation test.
     */
    @Test
    public void testFinalComprehensiveValidation() {
        System.out.println("Final Comprehensive Validation");
        String annual = instance.generateAnnual();
        String system = instance.generateSystemReport();
        assertTrue("Annual report should have content", annual.length() > 200);
        assertTrue("System report should have content", system.length() > 150);
    }
}