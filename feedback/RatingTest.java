package feedback;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
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
public class RatingTest {
    
    public RatingTest() {
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
     * Test of markAsHelpful method, of class Rating.
     */
    @Test
    public void testMarkAsHelpful() {
        System.out.println("markAsHelpful");
        Rating instance = new Rating("R001", "U001", "P001", 4.5, "PACKAGE");
        instance.markAsHelpful();
        assertEquals(1, instance.getHelpfulCount());
    }

    /**
     * Test of verifyRating method, of class Rating.
     */
    @Test
    public void testVerifyRating() {
        System.out.println("verifyRating");
        Rating instance = new Rating("R001", "U001", "P001", 4.5, "PACKAGE");
        instance.verifyRating();
        assertTrue(instance.isVerified());
    }

    /**
     * Test of unverifyRating method, of class Rating.
     */
    @Test
    public void testUnverifyRating() {
        System.out.println("unverifyRating");
        Rating instance = new Rating("R001", "U001", "P001", 4.5, "PACKAGE");
        instance.verifyRating();
        instance.unverifyRating();
        assertFalse(instance.isVerified());
    }

    /**
     * Test of isValidRating method with valid value.
     */
    @Test
    public void testIsValidRatingValid() {
        System.out.println("isValidRating - valid");
        Rating instance = new Rating("R001", "U001", "P001", 4.5, "PACKAGE");
        boolean result = instance.isValidRating();
        assertTrue(result);
    }

    /**
     * Test of isValidRating method with invalid value.
     */
    @Test
    public void testIsValidRatingInvalid() {
        System.out.println("isValidRating - invalid");
        Rating instance = new Rating("R001", "U001", "P001", 6.0, "PACKAGE");
        boolean result = instance.isValidRating();
        assertFalse(result);
    }

    /**
     * Test of getRatingStars method with full stars.
     */
    @Test
    public void testGetRatingStarsFullStars() {
        System.out.println("getRatingStars - full stars");
        Rating instance = new Rating("R001", "U001", "P001", 5.0, "PACKAGE");
        String result = instance.getRatingStars();
        assertEquals("★★★★★", result);
    }

    /**
     * Test of getRatingStars method with partial stars.
     */
    @Test
    public void testGetRatingStarsPartialStars() {
        System.out.println("getRatingStars - partial stars");
        Rating instance = new Rating("R001", "U001", "P001", 3.5, "PACKAGE");
        String result = instance.getRatingStars();
        assertEquals("★★★☆☆", result);
    }

    /**
     * Test of getRatingCategory method with excellent rating.
     */
    @Test
    public void testGetRatingCategoryExcellent() {
        System.out.println("getRatingCategory - excellent");
        Rating instance = new Rating("R001", "U001", "P001", 4.8, "PACKAGE");
        String result = instance.getRatingCategory();
        assertEquals("Excellent", result);
    }

    /**
     * Test of getRatingCategory method with poor rating.
     */
    @Test
    public void testGetRatingCategoryPoor() {
        System.out.println("getRatingCategory - poor");
        Rating instance = new Rating("R001", "U001", "P001", 1.5, "PACKAGE");
        String result = instance.getRatingCategory();
        assertEquals("Poor", result);
    }

    /**
     * Test of isPositiveRating method with positive value.
     */
    @Test
    public void testIsPositiveRatingTrue() {
        System.out.println("isPositiveRating - true");
        Rating instance = new Rating("R001", "U001", "P001", 4.2, "PACKAGE");
        boolean result = instance.isPositiveRating();
        assertTrue(result);
    }

    /**
     * Test of isPositiveRating method with negative value.
     */
    @Test
    public void testIsPositiveRatingFalse() {
        System.out.println("isPositiveRating - false");
        Rating instance = new Rating("R001", "U001", "P001", 3.5, "PACKAGE");
        boolean result = instance.isPositiveRating();
        assertFalse(result);
    }

    /**
     * Test of isNegativeRating method with negative value.
     */
    @Test
    public void testIsNegativeRatingTrue() {
        System.out.println("isNegativeRating - true");
        Rating instance = new Rating("R001", "U001", "P001", 2.0, "PACKAGE");
        boolean result = instance.isNegativeRating();
        assertTrue(result);
    }

    /**
     * Test of isNegativeRating method with positive value.
     */
    @Test
    public void testIsNegativeRatingFalse() {
        System.out.println("isNegativeRating - false");
        Rating instance = new Rating("R001", "U001", "P001", 3.5, "PACKAGE");
        boolean result = instance.isNegativeRating();
        assertFalse(result);
    }

    /**
     * Test of isNeutralRating method with neutral value.
     */
    @Test
    public void testIsNeutralRatingTrue() {
        System.out.println("isNeutralRating - true");
        Rating instance = new Rating("R001", "U001", "P001", 3.0, "PACKAGE");
        boolean result = instance.isNeutralRating();
        assertTrue(result);
    }

    /**
     * Test of isNeutralRating method with non-neutral value.
     */
    @Test
    public void testIsNeutralRatingFalse() {
        System.out.println("isNeutralRating - false");
        Rating instance = new Rating("R001", "U001", "P001", 4.5, "PACKAGE");
        boolean result = instance.isNeutralRating();
        assertFalse(result);
    }

    /**
     * Test of getRatingDescription method with excellent rating.
     */
    @Test
    public void testGetRatingDescriptionExcellent() {
        System.out.println("getRatingDescription - excellent");
        Rating instance = new Rating("R001", "U001", "P001", 5.0, "PACKAGE");
        String result = instance.getRatingDescription();
        assertEquals("Excellent - Extremely satisfied", result);
    }

    /**
     * Test of getRatingDescription method with poor rating.
     */
    @Test
    public void testGetRatingDescriptionPoor() {
        System.out.println("getRatingDescription - poor");
        Rating instance = new Rating("R001", "U001", "P001", 2.0, "PACKAGE");
        String result = instance.getRatingDescription();
        assertEquals("Poor - Unsatisfied", result);
    }

    /**
     * Test of getRatingSummary method.
     */
    @Test
    public void testGetRatingSummary() {
        System.out.println("getRatingSummary");
        Rating instance = new Rating("R001", "U001", "P001", 4.5, "PACKAGE");
        instance.setUserName("John Doe");
        String result = instance.getRatingSummary();
        assertNotNull(result);
        assertTrue(result.contains("John Doe"));
        assertTrue(result.contains("4.5"));
    }

    /**
     * Test of updateRating method with valid values.
     */
    @Test
    public void testUpdateRatingValid() {
        System.out.println("updateRating - valid");
        Rating instance = new Rating("R001", "U001", "P001", 3.0, "PACKAGE");
        instance.updateRating(4.5, "Updated comment");
        assertEquals(4.5, instance.getRatingValue(), 0.0);
        assertEquals("Updated comment", instance.getComments());
    }

    /**
     * Test of updateRating method with invalid values.
     */
    @Test
    public void testUpdateRatingInvalid() {
        System.out.println("updateRating - invalid");
        Rating instance = new Rating("R001", "U001", "P001", 3.0, "PACKAGE");
        instance.updateRating(6.0, "Invalid rating");
        assertEquals(3.0, instance.getRatingValue(), 0.0);
    }

    /**
     * Test of getRatingLevel method.
     */
    @Test
    public void testGetRatingLevel() {
        System.out.println("getRatingLevel");
        Rating instance = new Rating("R001", "U001", "P001", 4.3, "PACKAGE");
        int result = instance.getRatingLevel();
        assertEquals(4, result);
    }

    /**
     * Test of getRatingPercentage method.
     */
    @Test
    public void testGetRatingPercentage() {
        System.out.println("getRatingPercentage");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        double result = instance.getRatingPercentage();
        assertEquals(80.0, result, 0.0);
    }

    /**
     * Test of isHighRating method with high value.
     */
    @Test
    public void testIsHighRatingTrue() {
        System.out.println("isHighRating - true");
        Rating instance = new Rating("R001", "U001", "P001", 4.5, "PACKAGE");
        boolean result = instance.isHighRating();
        assertTrue(result);
    }

    /**
     * Test of isHighRating method with low value.
     */
    @Test
    public void testIsHighRatingFalse() {
        System.out.println("isHighRating - false");
        Rating instance = new Rating("R001", "U001", "P001", 3.0, "PACKAGE");
        boolean result = instance.isHighRating();
        assertFalse(result);
    }

    /**
     * Test of isLowRating method with low value.
     */
    @Test
    public void testIsLowRatingTrue() {
        System.out.println("isLowRating - true");
        Rating instance = new Rating("R001", "U001", "P001", 1.5, "PACKAGE");
        boolean result = instance.isLowRating();
        assertTrue(result);
    }

    /**
     * Test of isLowRating method with high value.
     */
    @Test
    public void testIsLowRatingFalse() {
        System.out.println("isLowRating - false");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        boolean result = instance.isLowRating();
        assertFalse(result);
    }

    /**
     * Test of hasComments method with comments.
     */
    @Test
    public void testHasCommentsTrue() {
        System.out.println("hasComments - true");
        Rating instance = new Rating("U001", "P001", 4.0, "PACKAGE", "Great service!");
        boolean result = instance.hasComments();
        assertTrue(result);
    }

    /**
     * Test of hasComments method without comments.
     */
    @Test
    public void testHasCommentsFalse() {
        System.out.println("hasComments - false");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        boolean result = instance.hasComments();
        assertFalse(result);
    }

    /**
     * Test of getCommentsLength method with comments.
     */
    @Test
    public void testGetCommentsLengthWithComments() {
        System.out.println("getCommentsLength - with comments");
        Rating instance = new Rating("U001", "P001", 4.0, "PACKAGE", "Great service!");
        int result = instance.getCommentsLength();
        assertEquals(14, result);
    }

    /**
     * Test of getCommentsLength method without comments.
     */
    @Test
    public void testGetCommentsLengthWithoutComments() {
        System.out.println("getCommentsLength - without comments");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        int result = instance.getCommentsLength();
        assertEquals(0, result);
    }

    /**
     * Test of isDetailedRating method with detailed comments.
     */
    @Test
    public void testIsDetailedRatingTrue() {
        System.out.println("isDetailedRating - true");
        String longComment = "This is a very detailed comment that contains more than fifty characters to test the detailed rating functionality.";
        Rating instance = new Rating("U001", "P001", 4.0, "PACKAGE", longComment);
        boolean result = instance.isDetailedRating();
        assertTrue(result);
    }

    /**
     * Test of isDetailedRating method with short comments.
     */
    @Test
    public void testIsDetailedRatingFalse() {
        System.out.println("isDetailedRating - false");
        Rating instance = new Rating("U001", "P001", 4.0, "PACKAGE", "Good");
        boolean result = instance.isDetailedRating();
        assertFalse(result);
    }

    /**
     * Test of calculateAverageRating method with ratings.
     */
    @Test
    public void testCalculateAverageRatingWithRatings() {
        System.out.println("calculateAverageRating - with ratings");
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating("R001", "U001", "P001", 4.0, "PACKAGE"));
        ratings.add(new Rating("R002", "U002", "P001", 5.0, "PACKAGE"));
        ratings.add(new Rating("R003", "U003", "P001", 3.0, "PACKAGE"));
        
        double result = Rating.calculateAverageRating(ratings);
        assertEquals(4.0, result, 0.01);
    }

    /**
     * Test of calculateAverageRating method with empty list.
     */
    @Test
    public void testCalculateAverageRatingEmpty() {
        System.out.println("calculateAverageRating - empty");
        List<Rating> ratings = new ArrayList<>();
        double result = Rating.calculateAverageRating(ratings);
        assertEquals(0.0, result, 0.0);
    }

    /**
     * Test of getRatingDistribution method.
     */
    @Test
    public void testGetRatingDistribution() {
        System.out.println("getRatingDistribution");
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating("R001", "U001", "P001", 5.0, "PACKAGE"));
        ratings.add(new Rating("R002", "U002", "P001", 4.0, "PACKAGE"));
        ratings.add(new Rating("R003", "U003", "P001", 4.0, "PACKAGE"));
        
        Map<Integer, Integer> result = Rating.getRatingDistribution(ratings);
        assertEquals(Integer.valueOf(2), result.get(4));
        assertEquals(Integer.valueOf(1), result.get(5));
        assertEquals(Integer.valueOf(0), result.get(1));
    }

    /**
     * Test of formatRatingDistribution method.
     */
    @Test
    public void testFormatRatingDistribution() {
        System.out.println("formatRatingDistribution");
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating("R001", "U001", "P001", 5.0, "PACKAGE"));
        ratings.add(new Rating("R002", "U002", "P001", 4.0, "PACKAGE"));
        
        String result = Rating.formatRatingDistribution(ratings);
        assertNotNull(result);
        assertTrue(result.contains("Rating Distribution"));
    }

    /**
     * Test of getRatingId method.
     */
    @Test
    public void testGetRatingId() {
        System.out.println("getRatingId");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        String result = instance.getRatingId();
        assertEquals("R001", result);
    }

    /**
     * Test of setRatingId method.
     */
    @Test
    public void testSetRatingId() {
        System.out.println("setRatingId");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setRatingId("R002");
        assertEquals("R002", instance.getRatingId());
    }

    /**
     * Test of getUserId method.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        String result = instance.getUserId();
        assertEquals("U001", result);
    }

    /**
     * Test of setUserId method.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setUserId("U002");
        assertEquals("U002", instance.getUserId());
    }

    /**
     * Test of getUserName method.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setUserName("John Doe");
        String result = instance.getUserName();
        assertEquals("John Doe", result);
    }

    /**
     * Test of setUserName method.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setUserName("Jane Smith");
        assertEquals("Jane Smith", instance.getUserName());
    }

    /**
     * Test of getEntityId method.
     */
    @Test
    public void testGetEntityId() {
        System.out.println("getEntityId");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        String result = instance.getEntityId();
        assertEquals("P001", result);
    }

    /**
     * Test of setEntityId method.
     */
    @Test
    public void testSetEntityId() {
        System.out.println("setEntityId");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setEntityId("P002");
        assertEquals("P002", instance.getEntityId());
    }

    /**
     * Test of getEntityType method.
     */
    @Test
    public void testGetEntityType() {
        System.out.println("getEntityType");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        String result = instance.getEntityType();
        assertEquals("PACKAGE", result);
    }

    /**
     * Test of setEntityType method.
     */
    @Test
    public void testSetEntityType() {
        System.out.println("setEntityType");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setEntityType("HOTEL");
        assertEquals("HOTEL", instance.getEntityType());
    }

    /**
     * Test of getRatingValue method.
     */
    @Test
    public void testGetRatingValue() {
        System.out.println("getRatingValue");
        Rating instance = new Rating("R001", "U001", "P001", 4.5, "PACKAGE");
        double result = instance.getRatingValue();
        assertEquals(4.5, result, 0.0);
    }

    /**
     * Test of setRatingValue method with valid value.
     */
    @Test
    public void testSetRatingValueValid() {
        System.out.println("setRatingValue - valid");
        Rating instance = new Rating("R001", "U001", "P001", 3.0, "PACKAGE");
        instance.setRatingValue(4.5);
        assertEquals(4.5, instance.getRatingValue(), 0.0);
    }

    /**
     * Test of setRatingValue method with invalid value.
     */
    @Test
    public void testSetRatingValueInvalid() {
        System.out.println("setRatingValue - invalid");
        Rating instance = new Rating("R001", "U001", "P001", 3.0, "PACKAGE");
        instance.setRatingValue(6.0);
        assertEquals(3.0, instance.getRatingValue(), 0.0);
    }

    /**
     * Test of getComments method.
     */
    @Test
    public void testGetComments() {
        System.out.println("getComments");
        Rating instance = new Rating("U001", "P001", 4.0, "PACKAGE", "Great experience!");
        String result = instance.getComments();
        assertEquals("Great experience!", result);
    }

    /**
     * Test of setComments method.
     */
    @Test
    public void testSetComments() {
        System.out.println("setComments");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setComments("Excellent service");
        assertEquals("Excellent service", instance.getComments());
    }

    /**
     * Test of getRatingDate method.
     */
    @Test
    public void testGetRatingDate() {
        System.out.println("getRatingDate");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        String result = instance.getRatingDate();
        assertNotNull(result);
    }

    /**
     * Test of setRatingDate method.
     */
    @Test
    public void testSetRatingDate() {
        System.out.println("setRatingDate");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setRatingDate("2023-12-01");
        assertEquals("2023-12-01", instance.getRatingDate());
    }

    /**
     * Test of isVerified method.
     */
    @Test
    public void testIsVerified() {
        System.out.println("isVerified");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        boolean result = instance.isVerified();
        assertFalse(result);
    }

    /**
     * Test of setVerified method.
     */
    @Test
    public void testSetVerified() {
        System.out.println("setVerified");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setVerified(true);
        assertTrue(instance.isVerified());
    }

    /**
     * Test of getCriteria method.
     */
    @Test
    public void testGetCriteria() {
        System.out.println("getCriteria");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        String result = instance.getCriteria();
        assertEquals("Overall", result);
    }

    /**
     * Test of setCriteria method.
     */
    @Test
    public void testSetCriteria() {
        System.out.println("setCriteria");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setCriteria("Service");
        assertEquals("Service", instance.getCriteria());
    }

    /**
     * Test of getHelpfulCount method.
     */
    @Test
    public void testGetHelpfulCount() {
        System.out.println("getHelpfulCount");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        int result = instance.getHelpfulCount();
        assertEquals(0, result);
    }

    /**
     * Test of setHelpfulCount method.
     */
    @Test
    public void testSetHelpfulCount() {
        System.out.println("setHelpfulCount");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setHelpfulCount(5);
        assertEquals(5, instance.getHelpfulCount());
    }

    /**
     * Test of isAnonymous method.
     */
    @Test
    public void testIsAnonymous() {
        System.out.println("isAnonymous");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        boolean result = instance.isAnonymous();
        assertFalse(result);
    }

    /**
     * Test of setAnonymous method.
     */
    @Test
    public void testSetAnonymous() {
        System.out.println("setAnonymous");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setAnonymous(true);
        assertTrue(instance.isAnonymous());
    }

    /**
     * Test of getAspectRated method.
     */
    @Test
    public void testGetAspectRated() {
        System.out.println("getAspectRated");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setAspectRated("Location");
        String result = instance.getAspectRated();
        assertEquals("Location", result);
    }

    /**
     * Test of setAspectRated method.
     */
    @Test
    public void testSetAspectRated() {
        System.out.println("setAspectRated");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setAspectRated("Quality");
        assertEquals("Quality", instance.getAspectRated());
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        String result = instance.toString();
        assertNotNull(result);
        assertTrue(result.contains("R001"));
        assertTrue(result.contains("P001"));
    }

    /**
     * Test of equals method with same object.
     */
    @Test
    public void testEqualsTrue() {
        System.out.println("equals - true");
        Rating instance1 = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        Rating instance2 = new Rating("R001", "U002", "P002", 3.0, "HOTEL");
        boolean result = instance1.equals(instance2);
        assertTrue(result);
    }

    /**
     * Test of equals method with different objects.
     */
    @Test
    public void testEqualsFalse() {
        System.out.println("equals - false");
        Rating instance1 = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        Rating instance2 = new Rating("R002", "U001", "P001", 4.0, "PACKAGE");
        boolean result = instance1.equals(instance2);
        assertFalse(result);
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        int result = instance.hashCode();
        assertEquals("R001".hashCode(), result);
    }
    
    // Corner Cases and Edge Cases
    
    /**
     * Test with minimum valid rating value.
     */
    @Test
    public void testMinimumValidRating() {
        System.out.println("minimum valid rating");
        Rating instance = new Rating("R001", "U001", "P001", 1.0, "PACKAGE");
        assertTrue(instance.isValidRating());
        assertEquals("Poor", instance.getRatingCategory());
        assertEquals("★☆☆☆☆", instance.getRatingStars());
    }
    
    /**
     * Test with maximum valid rating value.
     */
    @Test
    public void testMaximumValidRating() {
        System.out.println("maximum valid rating");
        Rating instance = new Rating("R001", "U001", "P001", 5.0, "PACKAGE");
        assertTrue(instance.isValidRating());
        assertEquals("Excellent", instance.getRatingCategory());
        assertEquals("★★★★★", instance.getRatingStars());
    }
    
    /**
     * Test with boundary rating value 2.0.
     */
    @Test
    public void testBoundaryRating2Point0() {
        System.out.println("boundary rating 2.0");
        Rating instance = new Rating("R001", "U001", "P001", 2.0, "PACKAGE");
        assertTrue(instance.isNegativeRating());
        assertFalse(instance.isNeutralRating());
        assertFalse(instance.isPositiveRating());
    }
    
    /**
     * Test with boundary rating value 4.0.
     */
    @Test
    public void testBoundaryRating4Point0() {
        System.out.println("boundary rating 4.0");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        assertTrue(instance.isPositiveRating());
        assertFalse(instance.isNeutralRating());
        assertFalse(instance.isNegativeRating());
    }
    
    /**
     * Test with null comments.
     */
    @Test
    public void testNullComments() {
        System.out.println("null comments");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setComments(null);
        assertFalse(instance.hasComments());
        assertEquals(0, instance.getCommentsLength());
        assertFalse(instance.isDetailedRating());
    }
    
    /**
     * Test with empty string comments.
     */
    @Test
    public void testEmptyStringComments() {
        System.out.println("empty string comments");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setComments("");
        assertFalse(instance.hasComments());
        assertEquals(0, instance.getCommentsLength());
        assertFalse(instance.isDetailedRating());
    }
    
    /**
     * Test with whitespace only comments.
     */
    @Test
    public void testWhitespaceOnlyComments() {
        System.out.println("whitespace only comments");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setComments("   ");
        assertFalse(instance.hasComments());
        assertEquals(3, instance.getCommentsLength());
        assertFalse(instance.isDetailedRating());
    }
    
   
    /**
     * Test calculateAverageRating with null list.
     */
    @Test
    public void testCalculateAverageRatingNull() {
        System.out.println("calculateAverageRating - null");
        double result = Rating.calculateAverageRating(null);
        assertEquals(0.0, result, 0.0);
    }
    
    /**
     * Test with single rating in list.
     */
    @Test
    public void testCalculateAverageRatingSingleRating() {
        System.out.println("calculateAverageRating - single rating");
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating("R001", "U001", "P001", 3.7, "PACKAGE"));
        
        double result = Rating.calculateAverageRating(ratings);
        assertEquals(3.7, result, 0.01);
    }
    
    /**
     * Test with identical ratings in list.
     */
    @Test
    public void testCalculateAverageRatingIdentical() {
        System.out.println("calculateAverageRating - identical");
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating("R001", "U001", "P001", 4.0, "PACKAGE"));
        ratings.add(new Rating("R002", "U002", "P001", 4.0, "PACKAGE"));
        ratings.add(new Rating("R003", "U003", "P001", 4.0, "PACKAGE"));
        
        double result = Rating.calculateAverageRating(ratings);
        assertEquals(4.0, result, 0.01);
    }
    
    /**
     * Test rating distribution with empty list.
     */
    @Test
    public void testRatingDistributionEmpty() {
        System.out.println("rating distribution - empty");
        List<Rating> ratings = new ArrayList<>();
        Map<Integer, Integer> result = Rating.getRatingDistribution(ratings);
        
        assertEquals(Integer.valueOf(0), result.get(1));
        assertEquals(Integer.valueOf(0), result.get(2));
        assertEquals(Integer.valueOf(0), result.get(3));
        assertEquals(Integer.valueOf(0), result.get(4));
        assertEquals(Integer.valueOf(0), result.get(5));
    }
    
    /**
     * Test rating distribution with all 5-star ratings.
     */
    @Test
    public void testRatingDistributionAllFiveStars() {
        System.out.println("rating distribution - all 5 stars");
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating("R001", "U001", "P001", 5.0, "PACKAGE"));
        ratings.add(new Rating("R002", "U002", "P001", 5.0, "PACKAGE"));
        
        Map<Integer, Integer> result = Rating.getRatingDistribution(ratings);
        assertEquals(Integer.valueOf(0), result.get(1));
        assertEquals(Integer.valueOf(0), result.get(4));
        assertEquals(Integer.valueOf(2), result.get(5));
    }
    
    /**
     * Test with very long rating ID.
     */
    @Test
    public void testVeryLongRatingId() {
        System.out.println("very long rating ID");
        String longId = "VeryLongRatingIDWithMoreThan50CharactersToTestSystemLimits12345";
        Rating instance = new Rating(longId, "U001", "P001", 4.0, "PACKAGE");
        assertEquals(longId, instance.getRatingId());
    }
    
    /**
     * Test with special characters in entity ID.
     */
    @Test
    public void testSpecialCharactersEntityId() {
        System.out.println("special characters entity ID");
        String specialId = "PKG@#$%^&*()_+{}|:<>?";
        Rating instance = new Rating("R001", "U001", specialId, 4.0, "PACKAGE");
        assertEquals(specialId, instance.getEntityId());
    }
    
    /**
     * Test with unicode characters in user name.
     */
    @Test
    public void testUnicodeCharactersUserName() {
        System.out.println("unicode characters user name");
        String unicodeName = "জন ডো 李明 Müller";
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setUserName(unicodeName);
        assertEquals(unicodeName, instance.getUserName());
    }
    
    /**
     * Test multiple helpful markings.
     */
    @Test
    public void testMultipleHelpfulMarkings() {
        System.out.println("multiple helpful markings");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        
        instance.markAsHelpful();
        instance.markAsHelpful();
        instance.markAsHelpful();
        
        assertEquals(3, instance.getHelpfulCount());
    }
    
    /**
     * Test verify then unverify multiple times.
     */
    @Test
    public void testVerifyUnverifyMultiple() {
        System.out.println("verify unverify multiple");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        
        instance.verifyRating();
        assertTrue(instance.isVerified());
        
        instance.unverifyRating();
        assertFalse(instance.isVerified());
        
        instance.verifyRating();
        assertTrue(instance.isVerified());
    }
    
    /**
     * Test update rating multiple times.
     */
    @Test
    public void testUpdateRatingMultipleTimes() {
        System.out.println("update rating multiple times");
        Rating instance = new Rating("R001", "U001", "P001", 3.0, "PACKAGE");
        
        instance.updateRating(4.0, "First update");
        assertEquals(4.0, instance.getRatingValue(), 0.0);
        assertEquals("First update", instance.getComments());
        
        instance.updateRating(4.5, "Second update");
        assertEquals(4.5, instance.getRatingValue(), 0.0);
        assertEquals("Second update", instance.getComments());
    }
    
    /**
     * Test rating percentage with extreme values.
     */
    @Test
    public void testRatingPercentageExtremes() {
        System.out.println("rating percentage extremes");
        Rating instance1 = new Rating("R001", "U001", "P001", 1.0, "PACKAGE");
        assertEquals(20.0, instance1.getRatingPercentage(), 0.0);
        
        Rating instance2 = new Rating("R002", "U002", "P002", 5.0, "PACKAGE");
        assertEquals(100.0, instance2.getRatingPercentage(), 0.0);
    }
    
    /**
     * Test equals with null object.
     */
    @Test
    public void testEqualsWithNull() {
        System.out.println("equals with null");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        assertFalse(instance.equals(null));
    }
    
    /**
     * Test equals with same instance.
     */
    @Test
    public void testEqualsWithSameInstance() {
        System.out.println("equals with same instance");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        assertTrue(instance.equals(instance));
    }
    
    /**
     * Test equals with different class object.
     */
    @Test
    public void testEqualsWithDifferentClass() {
        System.out.println("equals with different class");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        String otherObject = "Not a Rating";
        assertFalse(instance.equals(otherObject));
    }
    
    /**
     * Test constructor with all parameters.
     */
    @Test
    public void testConstructorWithAllParameters() {
        System.out.println("constructor with all parameters");
        Rating instance = new Rating("U001", "P001", 4.5, "PACKAGE", "Great experience", "Service");
        
        assertEquals("U001", instance.getUserId());
        assertEquals("P001", instance.getEntityId());
        assertEquals(4.5, instance.getRatingValue(), 0.0);
        assertEquals("PACKAGE", instance.getEntityType());
        assertEquals("Great experience", instance.getComments());
        assertEquals("Service", instance.getCriteria());
        assertFalse(instance.isVerified());
        assertEquals(0, instance.getHelpfulCount());
    }
    
    /**
     * Test anonymous rating summary.
     */
    @Test
    public void testAnonymousRatingSummary() {
        System.out.println("anonymous rating summary");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setAnonymous(true);
        
        String summary = instance.getRatingSummary();
        assertTrue(summary.contains("Anonymous"));
        assertFalse(summary.contains("null"));
    }
    
    /**
     * Test rating summary with aspect rated.
     */
    @Test
    public void testRatingSummaryWithAspectRated() {
        System.out.println("rating summary with aspect rated");
        Rating instance = new Rating("R001", "U001", "P001", 4.0, "PACKAGE");
        instance.setAspectRated("Location");
        
        String summary = instance.getRatingSummary();
        assertTrue(summary.contains("Aspect Rated: Location"));
    }
    
    /**
     * Test format rating distribution with single rating.
     */
    @Test
    public void testFormatRatingDistributionSingle() {
        System.out.println("format rating distribution - single");
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating("R001", "U001", "P001", 4.0, "PACKAGE"));
        
        String result = Rating.formatRatingDistribution(ratings);
        assertTrue(result.contains("4 ★: 1 ratings (100.0%)"));
        assertTrue(result.contains("5 ★: 0 ratings (0.0%)"));
    }
    
    /**
     * Test set rating value at boundaries.
     */
    @Test
    public void testSetRatingValueBoundaries() {
        System.out.println("set rating value boundaries");
        Rating instance = new Rating("R001", "U001", "P001", 3.0, "PACKAGE");
        
        // Test boundary values
        instance.setRatingValue(1.0);
        assertEquals(1.0, instance.getRatingValue(), 0.0);
        
        instance.setRatingValue(5.0);
        assertEquals(5.0, instance.getRatingValue(), 0.0);
        
        // Test invalid boundaries
        instance.setRatingValue(0.9);
        assertEquals(5.0, instance.getRatingValue(), 0.0); // Should remain unchanged
        
        instance.setRatingValue(5.1);
        assertEquals(5.0, instance.getRatingValue(), 0.0); // Should remain unchanged
    }
}