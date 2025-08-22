package schedule;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScheduleTest {

    private Schedule instance;

    public ScheduleTest() {
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
        // Prepare a fully initialized Schedule object before each test
        instance = new Schedule("SCH001", "BKG001", "USR001", "PKG001");
        instance.setStartDate("2025-08-05");
        instance.setEndDate("2025-08-10");
        instance.setStartTime("10:00");
        instance.setEndTime("18:00");
        instance.setStatus("PLANNED");
        instance.setNotes("Test notes");
        instance.setConfirmed(false);
        instance.setScheduleItems(new ArrayList<>());
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testAddAndRemoveScheduleItem() {
        // Normal case: Add then remove an item
        instance.addScheduleItem("Tour", "City Tour", "2025-08-06", "10:00", "Dhaka");
        assertEquals(1, instance.getScheduleItems().size());

        String itemId = instance.getScheduleItems().get(0).getItemId();
        instance.removeScheduleItem(itemId);
        assertTrue(instance.getScheduleItems().isEmpty());
    }

    @Test
    public void testConfirmAndCancelSchedule() {
        // Basic flow: confirm then cancel
        instance.confirmSchedule();
        assertTrue(instance.isConfirmed());

        instance.cancelSchedule();
        assertEquals("CANCELLED", instance.getStatus());
    }

    @Test
    public void testCompleteSchedule() {
        // Basic flow: mark as completed
        instance.completeSchedule();
        assertEquals("COMPLETED", instance.getStatus());
    }

    @Test
    public void testUpdateScheduleItem() {
        // Normal update flow
        instance.addScheduleItem("Tour", "Old Dhaka", "2025-08-06", "11:00", "Dhaka");
        String itemId = instance.getScheduleItems().get(0).getItemId();

        instance.updateScheduleItem(itemId, "Tour Updated", "New Description", "2025-08-07", "12:00", "Chittagong");
        Schedule.ScheduleItem updated = instance.getScheduleItems().get(0);

        assertEquals("Tour Updated", updated.getTitle());
        assertEquals("Chittagong", updated.getLocation());
    }

    @Test
    public void testGetScheduleItemsByDate() {
        // Basic retrieval: filter by date
        instance.addScheduleItem("Visit", "Museum", "2025-08-06", "14:00", "Dhaka");
        List<Schedule.ScheduleItem> items = instance.getScheduleItemsByDate("2025-08-06");
        assertEquals(1, items.size());
    }

    @Test
    public void testHasConflictWithTime() {
        // Conflict case: same date/time as existing item
        instance.addScheduleItem("Trip", "Beach", "2025-08-08", "10:00", "Cox’s Bazar");
        boolean conflict = instance.hasConflictWithTime("2025-08-08", "10:00", "10:30");
        assertTrue("Expected conflict, but got none", conflict);
    }

    @Test
    public void testGenerateScheduleReport() {
        // Normal case: report should contain data
        instance.addScheduleItem("Trip", "Beach", "2025-08-08", "10:00", "Cox’s Bazar");
        String report = instance.generateScheduleReport();
        assertNotNull(report);
        assertTrue(report.toLowerCase().contains("report"));
    }

    @Test
    public void testBasicGettersAndSetters() {
        // Verify all basic property getters/setters
        assertEquals("SCH001", instance.getScheduleId());
        assertEquals("BKG001", instance.getBookingId());
        assertEquals("USR001", instance.getUserId());
        assertEquals("PKG001", instance.getPackageId());
        assertEquals("2025-08-05", instance.getStartDate());
        assertEquals("2025-08-10", instance.getEndDate());
        assertEquals("10:00", instance.getStartTime());
        assertEquals("18:00", instance.getEndTime());
        assertEquals("PLANNED", instance.getStatus());
        assertEquals("Test notes", instance.getNotes());
        assertFalse(instance.isConfirmed());
    }

    @Test
    public void testToString() {
        // Basic: toString() should return non-empty representation
        String str = instance.toString();
        assertNotNull(str);
        assertTrue(str.length() > 0);
    }

    // ---------  Corner Cases ---------

    @Test
    public void testRemoveNonExistingItem() {
        // Corner case: removing an item that doesn't exist should not throw an error
        instance.removeScheduleItem("NON_EXISTENT_ID");
        assertTrue(instance.getScheduleItems().isEmpty());
    }

    @Test
    public void testUpdateNonExistingItem() {
        // Corner case: updating an item that doesn't exist should not crash
        instance.updateScheduleItem("NON_EXISTENT_ID", "Title", "Desc", "2025-08-07", "12:00", "Dhaka");
        assertTrue(instance.getScheduleItems().isEmpty());
    }

    @Test
    public void testGetScheduleItemsByDateNoMatch() {
        // Corner case: querying a date with no items should return empty list
        List<Schedule.ScheduleItem> items = instance.getScheduleItemsByDate("2099-01-01");
        assertTrue(items.isEmpty());
    }

    @Test
    public void testHasConflictWithDifferentDate() {
        // Corner case: same time but different date should not be a conflict
        instance.addScheduleItem("Trip", "Hill", "2025-08-08", "10:00", "Bandarban");
        boolean conflict = instance.hasConflictWithTime("2025-08-09", "10:00", "10:30");
        assertFalse(conflict);
    }

    @Test
    public void testEmptyScheduleReport() {
        // Corner case: generating a report with no schedule items
        String report = instance.generateScheduleReport();
        assertNotNull(report);
        assertTrue(report.toLowerCase().contains("report")); // case-insensitive check
    }
    
    
        // --------- Null Tests ---------

    @Test
    public void testConstructorWithNullIds() {
        // Null case: creating a schedule with null IDs
        Schedule schedule = new Schedule(null, null, null, null);
        assertNull(schedule.getScheduleId());
        assertNull(schedule.getBookingId());
        assertNull(schedule.getUserId());
        assertNull(schedule.getPackageId());
    }

    @Test
    public void testAddScheduleItemWithNullValues() {
        // Null case: adding an item with null fields should not crash
        instance.addScheduleItem(null, null, null, null, null);
        assertEquals("Item should still be added even with null values", 
                     1, instance.getScheduleItems().size());
    }

    @Test
    public void testUpdateScheduleItemWithNullValues() {
        // Add a valid item first
        instance.addScheduleItem("Tour", "Dhaka Visit", "2025-08-06", "10:00", "Dhaka");
        String itemId = instance.getScheduleItems().get(0).getItemId();

        // Null case: update with null values
        instance.updateScheduleItem(itemId, null, null, null, null, null);
        Schedule.ScheduleItem updated = instance.getScheduleItems().get(0);

        assertNull(updated.getTitle());
        assertNull(updated.getDescription());
        assertNull(updated.getDate());
        assertNull(updated.getTime());
        assertNull(updated.getLocation());
    }

    @Test
    public void testGetScheduleItemsByDateWithNull() {
        // Null case: querying with null date should return empty list or not crash
        List<Schedule.ScheduleItem> items = instance.getScheduleItemsByDate(null);
        assertNotNull(items);
    }

    @Test
    public void testHasConflictWithNullValues() {
        // Null case: conflict check with null date/time should not crash
        boolean conflict = instance.hasConflictWithTime(null, null, null);
        assertFalse(conflict);
    }

}
