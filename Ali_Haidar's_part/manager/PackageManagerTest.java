package manager;

import enumtype.PackageCategory;
import enumtype.TourType;
import java.util.List;
import java.util.Map;
import model.TourPackage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PackageManagerTest {

    private PackageManager instance;
    private TourPackage samplePackage1;
    private TourPackage samplePackage2;

    public PackageManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
        
    }

    @Before
    public void setUp() {
        instance = new PackageManager();

        samplePackage1 = new TourPackage("pkg001", "Beach Holiday", "Cox's Bazar", 15000.0, 5, "Relaxing beach vacation");
        samplePackage1.setCategory(PackageCategory.SEASONAL);
        samplePackage1.setTourType(TourType.ADVENTURE);
        samplePackage1.setCreatedBy("admin");
        samplePackage1.setActive(true);

        samplePackage2 = new TourPackage("pkg002", "Mountain Trek", "Sajek", 10000.0, 3, "Adventure trek in hills");
        samplePackage2.setCategory(PackageCategory.LOCAL);
        samplePackage2.setTourType(TourType.FAMILY);
        samplePackage2.setCreatedBy("user1");
        samplePackage2.setActive(false);

        instance.addPackage(samplePackage1);
        instance.addPackage(samplePackage2);
    }

    @After
    public void tearDown() {
       
    }

    @Test
    public void testAddPackage() {
        TourPackage newPackage = new TourPackage("pkg003", "City Tour", "Dhaka", 5000.0, 1, "Quick city sightseeing");
        newPackage.setCategory(PackageCategory.LOCAL);
        newPackage.setTourType(TourType.COUPLE);
        instance.addPackage(newPackage);

        assertNotNull(instance.getPackageById("pkg003"));
    }

    @Test
    public void testRemovePackage() {
        instance.removePackage("pkg001");
        assertNull(instance.getPackageById("pkg001"));
    }

    @Test
    public void testListPackages() {
        List<TourPackage> allPackages = instance.listPackages();
        assertTrue(allPackages.size() >= 2);
        assertTrue(allPackages.contains(samplePackage1));
        assertTrue(allPackages.contains(samplePackage2));
    }

    @Test
    public void testListActivePackages() {
        List<TourPackage> activePackages = instance.listActivePackages();
        assertTrue(activePackages.contains(samplePackage1));
        assertFalse(activePackages.contains(samplePackage2));
    }

    @Test
    public void testGetPackageById() {
        TourPackage pkg = instance.getPackageById("pkg001");
        assertEquals("Beach Holiday", pkg.getName());
    }

    @Test
    public void testSearchPackages() {
        List<TourPackage> result = instance.searchPackages("beach");
        assertTrue(result.contains(samplePackage1));
        assertFalse(result.contains(samplePackage2));
    }

    @Test
    public void testGetPackagesByCategory() {
        List<TourPackage> seasonalPkgs = instance.getPackagesByCategory(PackageCategory.SEASONAL);
        assertTrue(seasonalPkgs.contains(samplePackage1));
        assertFalse(seasonalPkgs.contains(samplePackage2));

        List<TourPackage> localPkgs = instance.getPackagesByCategory(PackageCategory.LOCAL);
        assertTrue(localPkgs.contains(samplePackage2));
    }

    @Test
    public void testGetPackagesByTourType() {
        List<TourPackage> adventurePkgs = instance.getPackagesByTourType(TourType.ADVENTURE);
        assertTrue(adventurePkgs.contains(samplePackage1));
        assertFalse(adventurePkgs.contains(samplePackage2));

        List<TourPackage> familyPkgs = instance.getPackagesByTourType(TourType.FAMILY);
        assertTrue(familyPkgs.contains(samplePackage2));
    }

    @Test
    public void testGetPackagesByPriceRange() {
        List<TourPackage> result = instance.getPackagesByPriceRange(9000, 16000);
        assertTrue(result.contains(samplePackage1));
        assertTrue(result.contains(samplePackage2));
    }

    @Test
    public void testGetPackagesByDuration() {
        List<TourPackage> result = instance.getPackagesByDuration(3, 5);
        assertTrue(result.contains(samplePackage1));
        assertTrue(result.contains(samplePackage2));
    }

    @Test
    public void testGetPackagesByLocation() {
        List<TourPackage> result = instance.getPackagesByLocation("Sajek");
        assertTrue(result.contains(samplePackage2));
        assertFalse(result.contains(samplePackage1));
    }

    @Test
    public void testGetPackagesByCreator() {
        List<TourPackage> adminPkgs = instance.getPackagesByCreator("admin");
        assertTrue(adminPkgs.contains(samplePackage1));
        assertFalse(adminPkgs.contains(samplePackage2));
    }

    @Test
    public void testUpdatePackage() {
        samplePackage1.setName("Beach Paradise");
        instance.updatePackage(samplePackage1);

        TourPackage updated = instance.getPackageById("pkg001");
        assertEquals("Beach Paradise", updated.getName());
    }

    @Test
    public void testActivateDeactivatePackage() {
        instance.deactivatePackage("pkg001");
        assertFalse(instance.getPackageById("pkg001").isActive());

        instance.activatePackage("pkg002");
        assertTrue(instance.getPackageById("pkg002").isActive());
    }

    @Test
    public void testGetTotalPackages() {
        int total = instance.getTotalPackages();
        assertTrue(total >= 2);
    }

    @Test
    public void testGetActivePackagesCount() {
        int activeCount = instance.getActivePackagesCount();
        assertEquals(1, activeCount);
    }

    @Test
    public void testGetAveragePackagePrice() {
        double avgPrice = instance.getAveragePackagePrice();
        assertTrue(avgPrice > 0);
    }

    @Test
    public void testGetMostExpensivePackage() {
        TourPackage expensive = instance.getMostExpensivePackage();
        assertEquals(samplePackage1, expensive);
    }

    @Test
    public void testGetCheapestPackage() {
        TourPackage cheapest = instance.getCheapestPackage();
        assertEquals(samplePackage2, cheapest);
    }

    @Test
    public void testGetPackageCountByCategory() {
        Map<PackageCategory, Long> countMap = instance.getPackageCountByCategory();
        assertEquals(Long.valueOf(1), countMap.get(PackageCategory.SEASONAL));
        assertEquals(Long.valueOf(1), countMap.get(PackageCategory.LOCAL));
        assertNull(countMap.get(PackageCategory.INTERNATIONAL));
    }

    @Test
    public void testGetPackageCountByTourType() {
        Map<TourType, Long> countMap = instance.getPackageCountByTourType();
        assertEquals(Long.valueOf(1), countMap.get(TourType.ADVENTURE));
        assertEquals(Long.valueOf(1), countMap.get(TourType.FAMILY));
    }

    @Test
    public void testGetAvailablePackages() {
        List<TourPackage> available = instance.getAvailablePackages();
        assertTrue(available.contains(samplePackage1));
        assertTrue(available.contains(samplePackage2));
    }

    @Test
    public void testGetFullyBookedPackages() {
        List<TourPackage> full = instance.getFullyBookedPackages();
        assertFalse(full.contains(samplePackage1));
        assertFalse(full.contains(samplePackage2));
    }
}
