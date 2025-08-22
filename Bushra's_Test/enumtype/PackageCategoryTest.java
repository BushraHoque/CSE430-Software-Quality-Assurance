package enumtype;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PackageCategoryTest {

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
    public void testValues() {
        PackageCategory[] expected = {PackageCategory.LOCAL, PackageCategory.INTERNATIONAL, PackageCategory.SEASONAL};
        PackageCategory[] actual = PackageCategory.values();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testValueOf() {
        assertEquals(PackageCategory.LOCAL, PackageCategory.valueOf("LOCAL"));
        assertEquals(PackageCategory.INTERNATIONAL, PackageCategory.valueOf("INTERNATIONAL"));
        assertEquals(PackageCategory.SEASONAL, PackageCategory.valueOf("SEASONAL"));
    }

    @Test
    public void testGetDisplayName() {
        assertEquals("Local Package", PackageCategory.LOCAL.getDisplayName());
        assertEquals("International Package", PackageCategory.INTERNATIONAL.getDisplayName());
        assertEquals("Seasonal Package", PackageCategory.SEASONAL.getDisplayName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Domestic destinations", PackageCategory.LOCAL.getDescription());
        assertEquals("Foreign destinations", PackageCategory.INTERNATIONAL.getDescription());
        assertEquals("Special seasonal offers", PackageCategory.SEASONAL.getDescription());
    }

    // ---------------- CORNER CASE TESTS ----------------

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfInvalidEnumName() {
        System.out.println("valueOf - invalid name");
        PackageCategory.valueOf("UNKNOWN"); // should throw IllegalArgumentException
    }

    @Test(expected = NullPointerException.class)
    public void testValueOfNull() {
        System.out.println("valueOf - null");
        PackageCategory.valueOf(null); // should throw NullPointerException
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfEmptyString() {
        System.out.println("valueOf - empty string");
        PackageCategory.valueOf(""); // should throw IllegalArgumentException
    }

    @Test
    public void testGetDisplayNameNotNull() {
        for (PackageCategory category : PackageCategory.values()) {
            assertNotNull("Display name should not be null", category.getDisplayName());
        }
    }

    @Test
    public void testGetDescriptionNotNull() {
        for (PackageCategory category : PackageCategory.values()) {
            assertNotNull("Description should not be null", category.getDescription());
        }
    }
}
