/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Working JUnit test class for DateUtil - All Methods
 * @author Hp
 */
public class DateUtilTest {
    
    public DateUtilTest() {
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

    /**
     * Test of getCurrentDate method, of class DateUtil.
     */
    @Test
    public void testGetCurrentDate() {
        System.out.println("getCurrentDate");
        
        String result = DateUtil.getCurrentDate();
        
        assertNotNull("Current date should not be null", result);
        assertTrue("Current date should not be empty", result.length() > 0);
        assertTrue("Current date should contain year", result.contains("2"));
        assertTrue("Current date should contain dashes", result.contains("-"));
        assertEquals("Date format should be correct length", 10, result.length());
        
        // here 10 is date format length
    }

    /**
     * Test of getCurrentDateTime method, of class DateUtil.
     */
    @Test
    public void testGetCurrentDateTime() {
        System.out.println("getCurrentDateTime");
        
        String result = DateUtil.getCurrentDateTime();
        
        assertNotNull("Current datetime should not be null", result);
        assertTrue("Current datetime should not be empty", result.length() > 0);
        assertTrue("Current datetime should contain year", result.contains("20"));
        assertTrue("Current datetime should contain space", result.contains(" "));
        assertTrue("Current datetime should contain colon", result.contains(":"));
        assertEquals("DateTime format should be correct length", 19, result.length());
    }

    /**
     * Test of formatDate method, of class DateUtil.
     */
    @Test
    public void testFormatDate() {
        System.out.println("formatDate");
        
        LocalDate date = LocalDate.of(2024, 2, 15);
        String result = DateUtil.formatDate(date);
        
        assertEquals("Formatted date should match expected format", "2024-02-15", result);
        
        //  different date testing 
        LocalDate date2 = LocalDate.of(2023, 12, 31);
        String result2 = DateUtil.formatDate(date2);
        assertEquals("Formatted date should match expected format", "2023-12-31", result2);
    }

    /**
     * Test of parseDate method, of class DateUtil.
     */
    @Test
    public void testParseDate() {
        System.out.println("parseDate");
        
        String dateString = "2024-01-15";
        LocalDate result = DateUtil.parseDate(dateString);
        
        // "2024-01-15" from here date , month , year perfectly converted into local date
        assertNotNull("Parsed date should not be null", result);
        assertEquals("Year should be correct", 2024, result.getYear());
        assertEquals("Month should be correct", 1, result.getMonthValue());
        assertEquals("Day should be correct", 15, result.getDayOfMonth());
    }

    /**
     * Test of parseDateTime method, of class DateUtil.
     */
    @Test
    public void testParseDateTime() {
        System.out.println("parseDateTime");
        
        String dateTimeString = "2024-01-15 14:30:45";
        LocalDateTime result = DateUtil.parseDateTime(dateTimeString);
        
        assertNotNull("Parsed datetime should not be null", result);
        assertEquals("Year should be correct", 2024, result.getYear());
        assertEquals("Month should be correct", 1, result.getMonthValue());
        assertEquals("Day should be correct", 15, result.getDayOfMonth());
        assertEquals("Hour should be correct", 14, result.getHour());
        assertEquals("Minute should be correct", 30, result.getMinute());
        assertEquals("Second should be correct", 45, result.getSecond());
    }

    /**
     * Test of daysBetween method, of class DateUtil.
     */
    @Test
    public void testDaysBetween() {
        System.out.println("daysBetween");
        
        String startDate = "2024-01-01";
        String endDate = "2024-01-11";
        long result = DateUtil.daysBetween(startDate, endDate);
        
        assertEquals("Days between should be 10", 10, result);
        
        //  same date test
        long sameDateResult = DateUtil.daysBetween(startDate, startDate);
        assertEquals("Days between same date should be 0", 0, sameDateResult);
        
        // reverse order (negative result) test 
        long reverseResult = DateUtil.daysBetween(endDate, startDate);
        assertEquals("Days between in reverse should be -10", -10, reverseResult);
    }

    /**
     * Test of isValidDate method, of class DateUtil.
     */
    @Test
    public void testIsValidDate() {
        System.out.println("isValidDate");
        
        //  valid dates test
        assertTrue("Valid date should return true", DateUtil.isValidDate("2024-01-15"));
        assertTrue("Valid date should return true", DateUtil.isValidDate("2023-12-31"));
        
        // for Leap year
        assertTrue("Valid date should return true", DateUtil.isValidDate("2000-02-29")); 
        
        // invalid dates test
        assertFalse("Invalid format should return false", DateUtil.isValidDate("15-01-2024"));
        assertFalse("Invalid format should return false", DateUtil.isValidDate("2024/01/15"));
        assertFalse("Invalid date should return false", DateUtil.isValidDate("2024-13-01"));
        assertFalse("Invalid date should return false", DateUtil.isValidDate("2024-01-32"));
        assertFalse("Empty string should return false", DateUtil.isValidDate(""));
        assertFalse("Null should return false", DateUtil.isValidDate(null));
    }

    /**
     * Test of isValidDateTime method, of class DateUtil.
     */
    @Test
    public void testIsValidDateTime() {
        System.out.println("isValidDateTime");
        
        // valid datetimes test
        assertTrue("Valid datetime should return true", DateUtil.isValidDateTime("2024-01-15 14:30:45"));
        assertTrue("Valid datetime should return true", DateUtil.isValidDateTime("2023-12-31 23:59:59"));
        assertTrue("Valid datetime should return true", DateUtil.isValidDateTime("2000-01-01 00:00:00"));
        
        // invalid datetimes test
        assertFalse("Invalid format should return false", DateUtil.isValidDateTime("2024-01-15"));
        assertFalse("Invalid format should return false", DateUtil.isValidDateTime("15-01-2024 14:30:45"));
        assertFalse("Invalid time should return false", DateUtil.isValidDateTime("2024-01-15 25:30:45"));
        assertFalse("Empty string should return false", DateUtil.isValidDateTime(""));
        assertFalse("Null should return false", DateUtil.isValidDateTime(null));
    }

    /**
     * Test of formatDateTime method, of class DateUtil.
     */
    @Test
    public void testFormatDateTime() {
        System.out.println("formatDateTime");
        
        LocalDateTime dateTime = LocalDateTime.of(2024, 1, 15, 14, 30, 45);
        String result = DateUtil.formatDateTime(dateTime);
        
        assertEquals("Formatted datetime should match expected format", "2024-01-15 14:30:45", result);
    }

    /**
     * Test of addDays method, of class DateUtil.
     */
    @Test
    public void testAddDays() {
        System.out.println("addDays");
        
        String date = "2024-01-15";
        String result = DateUtil.addDays(date, 10);
        
        assertEquals("Adding 10 days should give correct result", "2024-01-25", result);
        
        // Test adding 0 days
        String sameResult = DateUtil.addDays(date, 0);
        assertEquals("Adding 0 days should return same date", date, sameResult);
        
        // Test adding negative days (should work as subtraction)
        String subtractResult = DateUtil.addDays(date, -5);
        assertEquals("Adding negative days should subtract", "2024-01-10", subtractResult);
    }

    /**
     * Test of subtractDays method, of class DateUtil.
     */
    @Test
    public void testSubtractDays() {
        System.out.println("subtractDays");
        
        String date = "2024-01-15";
        String result = DateUtil.subtractDays(date, 10);
        
        assertEquals("Subtracting 10 days should give correct result", "2024-01-05", result);
        
        // Test subtracting 0 days
        String sameResult = DateUtil.subtractDays(date, 0);
        assertEquals("Subtracting 0 days should return same date", date, sameResult);
    }

    /**
     * Test of isDateBefore method, of class DateUtil.
     */
    @Test
    public void testIsDateBefore() {
        System.out.println("isDateBefore");
        
        String date1 = "2024-01-15";
        String date2 = "2024-01-20";
        
        assertTrue("Earlier date should be before later date", DateUtil.isDateBefore(date1, date2));
        assertFalse("Later date should not be before earlier date", DateUtil.isDateBefore(date2, date1));
        assertFalse("Same date should not be before itself", DateUtil.isDateBefore(date1, date1));
    }

    /**
     * Test of isDateAfter method, of class DateUtil.
     */
    @Test
    public void testIsDateAfter() {
        System.out.println("isDateAfter");
        
        String date1 = "2024-01-15";
        String date2 = "2024-01-20";
        
        assertFalse("Earlier date should not be after later date", DateUtil.isDateAfter(date1, date2));
        assertTrue("Later date should be after earlier date", DateUtil.isDateAfter(date2, date1));
        assertFalse("Same date should not be after itself", DateUtil.isDateAfter(date1, date1));
    }

    /**
     * Test of isDateEqual method, of class DateUtil.
     */
    @Test
    public void testIsDateEqual() {
        System.out.println("isDateEqual");
        
        String date1 = "2024-01-15";
        String date2 = "2024-01-15";
        String date3 = "2024-01-20";
        
        assertTrue("Same dates should be equal", DateUtil.isDateEqual(date1, date2));
        assertFalse("Different dates should not be equal", DateUtil.isDateEqual(date1, date3));
    }

    /**
     * Test of getFirstDayOfMonth method, of class DateUtil.
     */
    @Test
    public void testGetFirstDayOfMonth() {
        System.out.println("getFirstDayOfMonth");
        
        String date = "2024-01-15";
        String result = DateUtil.getFirstDayOfMonth(date);
        
        assertEquals("First day of month should be correct", "2024-01-01", result);
        
        // Test with last day of month
        String lastDay = "2024-02-29"; // Leap year February
        String firstDay = DateUtil.getFirstDayOfMonth(lastDay);
        assertEquals("First day should be correct", "2024-02-01", firstDay);
    }

    /**
     * Test of getLastDayOfMonth method, of class DateUtil.
     */
    @Test
    public void testGetLastDayOfMonth() {
        System.out.println("getLastDayOfMonth");
        
        String date = "2024-01-15";
        String result = DateUtil.getLastDayOfMonth(date);
        
        assertEquals("Last day of January should be 31", "2024-01-31", result);
        
        // Test February in leap year
        String febDate = "2024-02-15";
        String febLast = DateUtil.getLastDayOfMonth(febDate);
        assertEquals("Last day of February 2024 should be 29", "2024-02-29", febLast);
        
        // Test February in non-leap year
        String febDate2023 = "2023-02-15";
        String febLast2023 = DateUtil.getLastDayOfMonth(febDate2023);
        assertEquals("Last day of February 2023 should be 28", "2023-02-28", febLast2023);
    }

    /**
     * Test of getDayOfWeek method, of class DateUtil.
     */
    @Test
    public void testGetDayOfWeek() {
        System.out.println("getDayOfWeek");
        
        // January 1, 2024 was a Monday (1)
        String monday = "2024-01-01";
        int result = DateUtil.getDayOfWeek(monday);
        
        assertEquals("Monday should return 1", 1, result);
        
        // Test known Saturday (January 6, 2024)
        String saturday = "2024-01-06";
        int satResult = DateUtil.getDayOfWeek(saturday);
        assertEquals("Saturday should return 6", 6, satResult);
        
        // Test known Sunday (January 7, 2024)
        String sunday = "2024-01-07";
        int sunResult = DateUtil.getDayOfWeek(sunday);
        assertEquals("Sunday should return 7", 7, sunResult);
    }

    /**
     * Test of getDayName method, of class DateUtil.
     */
    @Test
    public void testGetDayName() {
        System.out.println("getDayName");
        
        String monday = "2024-01-01"; // Known Monday
        String result = DateUtil.getDayName(monday);
        
        assertEquals("Monday should return MONDAY", "MONDAY", result);
        
        String saturday = "2024-01-06"; // Known Saturday
        String satResult = DateUtil.getDayName(saturday);
        assertEquals("Saturday should return SATURDAY", "SATURDAY", satResult);
    }

    /**
     * Test of getMonthName method, of class DateUtil.
     */
    @Test
    public void testGetMonthName() {
        System.out.println("getMonthName");
        
        String janDate = "2024-01-15";
        String result = DateUtil.getMonthName(janDate);
        
        assertEquals("January should return JANUARY", "JANUARY", result);
        
        String decDate = "2024-12-25";
        String decResult = DateUtil.getMonthName(decDate);
        assertEquals("December should return DECEMBER", "DECEMBER", decResult);
    }

    /**
     * Test of getYear method, of class DateUtil.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        
        String date = "2024-01-15";
        int result = DateUtil.getYear(date);
        
        assertEquals("Year should be 2024", 2024, result);
        
        String date2023 = "2023-12-31";
        int result2023 = DateUtil.getYear(date2023);
        assertEquals("Year should be 2023", 2023, result2023);
    }

    /**
     * Test of getMonth method, of class DateUtil.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        
        String janDate = "2024-01-15";
        int result = DateUtil.getMonth(janDate);
        
        assertEquals("January should return 1", 1, result);
        
        String decDate = "2024-12-25";
        int decResult = DateUtil.getMonth(decDate);
        assertEquals("December should return 12", 12, decResult);
    }

    /**
     * Test of getDay method, of class DateUtil.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        
        String date = "2024-01-15";
        int result = DateUtil.getDay(date);
        
        assertEquals("Day should be 15", 15, result);
        
        String firstDay = "2024-01-01";
        int firstResult = DateUtil.getDay(firstDay);
        assertEquals("Day should be 1", 1, firstResult);
        
        String lastDay = "2024-01-31";
        int lastResult = DateUtil.getDay(lastDay);
        assertEquals("Day should be 31", 31, lastResult);
    }

    /**
     * Test of isWeekend method, of class DateUtil.
     */
    @Test
    public void testIsWeekend() {
        System.out.println("isWeekend");
        
        String monday = "2024-01-01"; // Known Monday
        assertFalse("Monday should not be weekend", DateUtil.isWeekend(monday));
        
        String saturday = "2024-01-06"; // Known Saturday
        assertTrue("Saturday should be weekend", DateUtil.isWeekend(saturday));
        
        String sunday = "2024-01-07"; // Known Sunday
        assertTrue("Sunday should be weekend", DateUtil.isWeekend(sunday));
        
        String friday = "2024-01-05"; // Known Friday
        assertFalse("Friday should not be weekend", DateUtil.isWeekend(friday));
    }

    /**
     * Test of isLeapYear method, of class DateUtil.
     */
    @Test
    public void testIsLeapYear() {
        System.out.println("isLeapYear");
        
        String leapYear = "2024-01-01";
        assertTrue("2024 should be leap year", DateUtil.isLeapYear(leapYear));
        
        String nonLeapYear = "2023-01-01";
        assertFalse("2023 should not be leap year", DateUtil.isLeapYear(nonLeapYear));
        
        String century = "2000-01-01";
        assertTrue("2000 should be leap year", DateUtil.isLeapYear(century));
        
        String nonLeapCentury = "1900-01-01";
        assertFalse("1900 should not be leap year", DateUtil.isLeapYear(nonLeapCentury));
    }

    /**
     * Test of hoursBetween method, of class DateUtil.
     */
    @Test
    public void testHoursBetween() {
        System.out.println("hoursBetween");
        
        String startDateTime = "2024-01-01 10:00:00";
        String endDateTime = "2024-01-01 15:00:00";
        long result = DateUtil.hoursBetween(startDateTime, endDateTime);
        
        assertEquals("Hours between should be 5", 5L, result);
        
        // Test same time
        long sameResult = DateUtil.hoursBetween(startDateTime, startDateTime);
        assertEquals("Hours between same time should be 0", 0L, sameResult);
        
        // Test overnight
        String overnightEnd = "2024-01-02 10:00:00";
        long overnightResult = DateUtil.hoursBetween(startDateTime, overnightEnd);
        assertEquals("Hours between overnight should be 24", 24L, overnightResult);
    }

    /**
     * Test of minutesBetween method, of class DateUtil.
     */
    @Test
    public void testMinutesBetween() {
        System.out.println("minutesBetween");
        
        String startDateTime = "2024-01-01 10:00:00";
        String endDateTime = "2024-01-01 10:30:00";
        long result = DateUtil.minutesBetween(startDateTime, endDateTime);
        
        assertEquals("Minutes between should be 30", 30L, result);
        
        // Test hour difference
        String hourEnd = "2024-01-01 11:00:00";
        long hourResult = DateUtil.minutesBetween(startDateTime, hourEnd);
        assertEquals("Minutes between should be 60", 60L, hourResult);
    }

    /**
     * Test of addHours method, of class DateUtil.
     */
    @Test
    public void testAddHours() {
        System.out.println("addHours");
        
        String dateTime = "2024-01-01 10:00:00";
        String result = DateUtil.addHours(dateTime, 5);
        
        assertEquals("Adding 5 hours should give correct result", "2024-01-01 15:00:00", result);
        
        // Test overnight
        String overnightResult = DateUtil.addHours(dateTime, 24);
        assertEquals("Adding 24 hours should give next day", "2024-01-02 10:00:00", overnightResult);
    }

    /**
     * Test of addMinutes method, of class DateUtil.
     */
    @Test
    public void testAddMinutes() {
        System.out.println("addMinutes");
        
        String dateTime = "2024-01-01 10:00:00";
        String result = DateUtil.addMinutes(dateTime, 30);
        
        assertEquals("Adding 30 minutes should give correct result", "2024-01-01 10:30:00", result);
        
        // Test hour rollover
        String hourResult = DateUtil.addMinutes(dateTime, 90);
        assertEquals("Adding 90 minutes should give correct result", "2024-01-01 11:30:00", hourResult);
    }

    /**
     * Test of getCurrentTimestamp method, of class DateUtil.
     */
    @Test
    public void testGetCurrentTimestamp() {
        System.out.println("getCurrentTimestamp");
        
        String result = DateUtil.getCurrentTimestamp();
        
        assertNotNull("Current timestamp should not be null", result);
        assertTrue("Current timestamp should not be empty", result.length() > 0);
        assertTrue("Current timestamp should be numeric", result.matches("\\d+"));
        
        // Test that timestamp is reasonable (after year 2020)
        long timestamp = Long.parseLong(result);
        long year2020 = 1577836800000L; // Jan 1, 2020 00:00:00 UTC
        assertTrue("Timestamp should be after 2020", timestamp > year2020);
    }

    /**
     * Test of formatTimestamp method, of class DateUtil.
     */
    @Test
    public void testFormatTimestamp() {
        System.out.println("formatTimestamp");
        
        // Known timestamp: Jan 1, 2024 12:00:00 UTC
        long timestamp = 1704110400000L; // This might vary based on timezone
        String result = DateUtil.formatTimestamp(timestamp);
        
        assertNotNull("Formatted timestamp should not be null", result);
        assertTrue("Formatted timestamp should not be empty", result.length() > 0);
        assertTrue("Should contain year", result.contains("202"));
        assertTrue("Should contain time separator", result.contains(":"));
        assertEquals("Should have correct format length", 19, result.length());
    }

    /**
     * Test of parseTimestamp method, of class DateUtil.
     */
    @Test
    public void testParseTimestamp() {
        System.out.println("parseTimestamp");
        
        String dateTimeString = "2024-01-01 12:00:00";
        long result = DateUtil.parseTimestamp(dateTimeString);
        
        assertTrue("Parsed timestamp should be positive", result > 0);
        
        // Test round trip
        String formatted = DateUtil.formatTimestamp(result);
        assertEquals("Round trip should return same datetime", dateTimeString, formatted);
    }
}