package model;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TourGuideTest {
    
    private TourGuide guide;

    @Before
    public void setUp() {
        guide = new TourGuide("G001", "Rakib Hasan", "01712345678", "rakib@example.com");
        guide.setSpecialization("Historical Sites");
        guide.setDailyRate(2500.0);
        guide.setExperience("5 years");
        guide.setCertifications("Certified Tour Guide");
    }

    @Test
    public void testAddLanguage() {
        guide.addLanguage("English");
        guide.addLanguage("Bangla");
        guide.addLanguage("English"); // duplicate, should not be added again
        List<String> expected = Arrays.asList("English", "Bangla");
        assertEquals(expected, guide.getLanguages());
    }

    @Test
    public void testUpdateRating() {
        guide.updateRating(4.0);
        guide.updateRating(5.0);
        assertEquals(4.5, guide.getRating(), 0.001);
        assertEquals(2, guide.getTotalReviews());
    }

    @Test
    public void testAssignAndCompleteTour() {
        guide.assignTour("T001");
        assertFalse(guide.isAvailable());
        assertTrue(guide.getAssignedTours().contains("T001"));

        guide.assignTour("T002");
        guide.completeTour("T001");
        assertFalse(guide.isAvailable());
        assertFalse(guide.getAssignedTours().contains("T001"));
        assertTrue(guide.getAssignedTours().contains("T002"));

        guide.completeTour("T002");
        assertTrue(guide.isAvailable());
    }

    @Test
    public void testGettersAndSetters() {
        guide.setGuideId("G100");
        assertEquals("G100", guide.getGuideId());

        guide.setName("Rahim Uddin");
        assertEquals("Rahim Uddin", guide.getName());

        guide.setPhone("01987654321");
        assertEquals("01987654321", guide.getPhone());

        guide.setEmail("rahim@example.com");
        assertEquals("rahim@example.com", guide.getEmail());

        List<String> newLangs = new ArrayList<>(Arrays.asList("Spanish", "French"));
        guide.setLanguages(newLangs);
        assertEquals(newLangs, guide.getLanguages());

        guide.setRating(4.7);
        assertEquals(4.7, guide.getRating(), 0.01);

        guide.setTotalReviews(10);
        assertEquals(10, guide.getTotalReviews());

        guide.setSpecialization("Mountain Tours");
        assertEquals("Mountain Tours", guide.getSpecialization());

        guide.setDailyRate(3000.0);
        assertEquals(3000.0, guide.getDailyRate(), 0.0);

        guide.setAvailable(false);
        assertFalse(guide.isAvailable());

        guide.setExperience("7 years");
        assertEquals("7 years", guide.getExperience());

        guide.setCertifications("Advanced Guide Certificate");
        assertEquals("Advanced Guide Certificate", guide.getCertifications());
    }

    @Test
    public void testGetAssignedToursInitiallyEmpty() {
        assertNotNull(guide.getAssignedTours());
        assertTrue(guide.getAssignedTours().isEmpty());
    }

    @Test
    public void testToStringOutput() {
        guide.addLanguage("English");
        guide.updateRating(5.0);
        String output = guide.toString();
        assertTrue(output.contains("Rakib Hasan"));
        assertTrue(output.contains("English"));
        assertTrue(output.contains("5.0"));
        assertTrue(output.contains("true"));
    }
        // -------------------- CORNER CASE TESTS --------------------

   

    @Test
    public void testAddLanguageCaseSensitivity() {
        guide.addLanguage("english");
        guide.addLanguage("ENGLISH");
        List<String> langs = guide.getLanguages();
        assertTrue(langs.contains("english"));
        assertTrue(langs.contains("ENGLISH"));
    }

    @Test
    public void testUpdateRatingZeroAndFive() {
        TourGuide newGuide = new TourGuide("G002", "Test Guide", "000", "test@example.com");
        newGuide.updateRating(0.0);
        assertEquals(0.0, newGuide.getRating(), 0.001);
        newGuide.updateRating(5.0);
        assertEquals(2.5, newGuide.getRating(), 0.001); // average of 0 and 5
    }

    @Test
    public void testUpdateRatingNegativeAndAboveMax() {
        TourGuide newGuide = new TourGuide("G003", "Test Guide", "000", "test@example.com");
        newGuide.updateRating(-1.0); // assuming class accepts negative, just check it doesn't crash
        newGuide.updateRating(6.0);  // above 5
        assertEquals(2.5, newGuide.getRating(), 0.001); // average of -1 and 6
        assertEquals(2, newGuide.getTotalReviews());
    }

    @Test
    public void testAssignTourDuplicateAndCompleteUnassigned() {
        guide.assignTour("T100");
        guide.assignTour("T100"); // duplicate
        assertEquals(2, guide.getAssignedTours().size());
        guide.completeTour("T999"); // not assigned
        assertEquals(2, guide.getAssignedTours().size());
    }

    @Test
    public void testCompleteTourEmptyList() {
        TourGuide newGuide = new TourGuide("G004", "Empty", "000", "empty@example.com");
        newGuide.completeTour("T001"); // nothing assigned
        assertTrue(newGuide.getAssignedTours().isEmpty());
    }

    @Test
    public void testSetLanguagesNullList() {
        guide.setLanguages(null);
        assertNull(guide.getLanguages());
    }

    @Test
    public void testSetDailyRateNegative() {
        guide.setDailyRate(-500.0);
        assertEquals(-500.0, guide.getDailyRate(), 0.001);
    }

    @Test
    public void testAssignAndCompleteMultipleTours() {
        guide.assignTour("T200");
        guide.assignTour("T201");
        guide.assignTour("T202");
        guide.completeTour("T201");
        List<String> assigned = guide.getAssignedTours();
        assertEquals(2, assigned.size());
        assertTrue(assigned.contains("T200"));
        assertTrue(assigned.contains("T202"));
        assertFalse(assigned.contains("T201"));
    }

}
