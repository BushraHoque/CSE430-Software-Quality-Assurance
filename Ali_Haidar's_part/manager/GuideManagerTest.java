package manager;

import java.util.*;
import manager.GuideManager;
import model.TourGuide;
import org.junit.*;
import static org.junit.Assert.*;

public class GuideManagerTest {

    private GuideManager manager;
    private TourGuide guide;

    @Before
    public void setUp() {
        manager = new GuideManager();
        guide = new TourGuide("1001", "Ali", "01234567890", "ali@example.com");
        guide.setLanguages(Arrays.asList("English", "Bangla"));
        guide.setSpecialization("Historical Sites");
        guide.setDailyRate(2000.0);
        guide.setRating(4.8);
        guide.setAvailable(true);

        manager.addGuide(guide);
    }

    @Test
    public void testAddGuide() {
        TourGuide result = manager.getGuideById("1001");
        assertNotNull(result);
        assertEquals("Ali", result.getName());
    }

    @Test
    public void testRemoveGuide() {
        manager.removeGuide("1001");
        assertNull(manager.getGuideById("1001"));
    }

    @Test
    public void testGetGuideById() {
        TourGuide result = manager.getGuideById("1001");
        assertEquals("Ali", result.getName());
    }

    @Test
    public void testUpdateGuide() {
        guide.setRating(5.0);
        manager.updateGuide(guide);
        assertEquals(5.0, manager.getGuideById("1001").getRating(), 0.01);
    }

    @Test
    public void testGetAllGuides() {
        List<TourGuide> guides = manager.getAllGuides();
        assertTrue(guides.size() >= 1);
    }

    @Test
    public void testGetAvailableGuides() {
        List<TourGuide> guides = manager.getAvailableGuides();
        assertTrue(guides.contains(guide));
    }

    @Test
    public void testGetGuidesByLanguage() {
        List<TourGuide> guides = manager.getGuidesByLanguage("Bangla");
        assertTrue(guides.contains(guide));
    }

    @Test
    public void testGetGuidesByRating() {
        List<TourGuide> guides = manager.getGuidesByRating(4.5);
        assertTrue(guides.contains(guide));
    }

    @Test
    public void testGetGuidesBySpecialization() {
        List<TourGuide> guides = manager.getGuidesBySpecialization("historical");
        assertTrue(guides.contains(guide));
    }

    @Test
    public void testSearchGuides() {
        List<TourGuide> guides = manager.searchGuides("Ali");
        assertTrue(guides.contains(guide));
    }

    @Test
    public void testGetTotalGuides() {
        assertEquals(1, manager.getTotalGuides());
    }

    @Test
    public void testGetAvailableGuidesCount() {
        assertEquals(1, manager.getAvailableGuidesCount());
    }

    @Test
    public void testGetAverageGuideRating() {
        assertEquals(4.8, manager.getAverageGuideRating(), 0.01);
    }

    @Test
    public void testGetTopRatedGuide() {
        assertEquals("Ali", manager.getTopRatedGuide().getName());
    }

    @Test
    public void testGetGuideCountByLanguage() {
        Map<String, Long> countMap = manager.getGuideCountByLanguage();
        assertTrue(countMap.get("English") >= 1);
    }

    @Test
    public void testUpdateGuideRating() {
        manager.updateGuideRating("1001", 4.0);
        assertEquals(4.0, manager.getGuideById("1001").getRating(), 0.01);
    }
}
