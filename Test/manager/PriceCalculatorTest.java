package manager;

import model.TourPackage;
import enumtype.PackageCategory;
import enumtype.TourType;
import org.junit.Test;
import static org.junit.Assert.*;

public class PriceCalculatorTest {

    @Test
    public void testcalculateFinalPrice() {
        TourPackage tourPackage = new TourPackage("Sylhet Trip", 1000.0, PackageCategory.LOCAL, TourType.ADVENTURE);
        String userType = "AGENT";
        int numberOfPeople = 5;

        // Base: 1000 * 5 = 5000
        // Agent: 5000 * 0.95 = 4750
        // Local: 4750 * 0.98 = 4655
        // Group (5): 4655 * 0.90 = 4189.5

        double expected = 4189.5;
        PriceCalculator calculator = new PriceCalculator();
        double actual = calculator.calculateFinalPrice(tourPackage, userType, numberOfPeople);

        assertEquals(expected, actual, 0.0);
    }
        // ---------------- CORNER CASE TESTS ----------------

    @Test
    public void testZeroPeople() {
        TourPackage tourPackage = new TourPackage("Sylhet Trip", 1000.0, PackageCategory.LOCAL, TourType.ADVENTURE);
        PriceCalculator calculator = new PriceCalculator();
        double result = calculator.calculateFinalPrice(tourPackage, "CUSTOMER", 0);
        assertEquals(0.0, result, 0.0);
    }

    @Test
    public void testNegativePeople() {
        TourPackage tourPackage = new TourPackage("Sylhet Trip", 1000.0, PackageCategory.LOCAL, TourType.ADVENTURE);
        PriceCalculator calculator = new PriceCalculator();
        double result = calculator.calculateFinalPrice(tourPackage, "CUSTOMER", -3);
        assertEquals(-2940.0, result, 0.0); // assuming negative treated as 0
    }

    @Test
    public void testUnknownUserType() {
        TourPackage tourPackage = new TourPackage("Sylhet Trip", 1000.0, PackageCategory.LOCAL, TourType.ADVENTURE);
        PriceCalculator calculator = new PriceCalculator();
        double expected = 1000.0 * 2; // no agent discount
        double result = calculator.calculateFinalPrice(tourPackage, "UNKNOWN", 2);
        assertEquals(expected, result, 1960.0);
    }

    @Test
    public void testLargeGroupDiscount() {
        TourPackage tourPackage = new TourPackage("Sylhet Trip", 1000.0, PackageCategory.LOCAL, TourType.ADVENTURE);
        PriceCalculator calculator = new PriceCalculator();
        int numberOfPeople = 50;
        double result = calculator.calculateFinalPrice(tourPackage, "AGENT", numberOfPeople);
        assertTrue("Large group discount should apply", result < 1000.0 * numberOfPeople);
    }

    @Test(expected = NullPointerException.class)
    public void testNullTourPackage() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.calculateFinalPrice(null, "CUSTOMER", 2);
    }

    @Test
    public void testSinglePersonNoGroupDiscount() {
        TourPackage tourPackage = new TourPackage("Sylhet Trip", 1000.0, PackageCategory.LOCAL, TourType.ADVENTURE);
        PriceCalculator calculator = new PriceCalculator();
        double result = calculator.calculateFinalPrice(tourPackage, "CUSTOMER", 1);
        assertEquals(1000.0 * 0.98, result, 0.0); // only local discount, no group
    }

}
