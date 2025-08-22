package feedback;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PackageReviewTest {

    private PackageReview review;

    @Before
    public void setUp() {
        review = new PackageReview("U001", "P001", "Amazing experience!", 4.5, "Great Trip");
        review.setUserName("Bushra");
        review.setPackageName("Cox's Bazar Getaway");
        review.setReviewDate("2025-08-05");
    }

    @Test
    public void testMarkAsHelpful() {
        int previousCount = review.getHelpfulCount();
        review.markAsHelpful();
        assertEquals(previousCount + 1, review.getHelpfulCount());
    }

    @Test
    public void testVerifyReview() {
        review.verifyReview();
        assertTrue(review.isVerified());
    }

    @Test
    public void testUnverifyReview() {
        review.verifyReview();  // First verify it
        review.unverifyReview();  // Then unverify
        assertFalse(review.isVerified());
    }

    @Test
    public void testGetReviewSummary() {
        String summary = review.getReviewSummary();
        assertTrue(summary.contains("Review by Bushra"));
        assertTrue(summary.contains("Rating: 4.5/5.0"));
        assertTrue(summary.contains("Title: Great Trip"));
    }

    @Test
    public void testGetRatingStars() {
        String stars = review.getRatingStars();
        assertEquals("★★★★☆", stars);
    }

    @Test
    public void testIsPositiveReview() {
        assertTrue(review.isPositiveReview());
    }

    @Test
    public void testIsNegativeReview() {
        review.setRating(1.5);
        assertTrue(review.isNegativeReview());
    }

    @Test
    public void testIsNeutralReview() {
        review.setRating(3.0);
        assertTrue(review.isNeutralReview());
    }

    @Test
    public void testGetReviewCategory() {
        review.setRating(1.5);
        assertEquals("Negative", review.getReviewCategory());

        review.setRating(3.0);
        assertEquals("Neutral", review.getReviewCategory());

        review.setRating(5.0);
        assertEquals("Positive", review.getReviewCategory());
    }

    @Test
    public void testGetReviewLength() {
        assertEquals("Amazing experience!".length(), review.getReviewLength());
    }

    /*@Test
    public void testIsDetailedReview() {
        review.setReviewText("x".repeat(100));
        assertTrue(review.isDetailedReview());
    }*/

    @Test
    public void testUpdateReview() {
        review.verifyReview(); // First verify
        review.updateReview("Updated review content", 2.0);
        assertEquals("Updated review content", review.getReviewText());
        assertEquals(2.0, review.getRating(), 0.0);
        assertFalse(review.isVerified());
    }

    @Test
    public void testAddProsCons() {
        review.addProsCons("Clean beach", "Crowded during holidays");
        assertEquals("Clean beach", review.getPros());
        assertEquals("Crowded during holidays", review.getCons());
    }

    @Test
    public void testGetAndSetReviewId() {
        review.setReviewId("R001");
        assertEquals("R001", review.getReviewId());
    }

    @Test
    public void testGetAndSetUserId() {
        review.setUserId("User123");
        assertEquals("User123", review.getUserId());
    }

    @Test
    public void testGetAndSetUserName() {
        review.setUserName("Tanvir");
        assertEquals("Tanvir", review.getUserName());
    }

    @Test
    public void testGetAndSetPackageId() {
        review.setPackageId("PKG123");
        assertEquals("PKG123", review.getPackageId());
    }

    @Test
    public void testGetAndSetPackageName() {
        review.setPackageName("Sundarbans Tour");
        assertEquals("Sundarbans Tour", review.getPackageName());
    }

    @Test
    public void testGetAndSetReviewText() {
        review.setReviewText("Fantastic experience!");
        assertEquals("Fantastic experience!", review.getReviewText());
    }

    @Test
    public void testGetAndSetRating() {
        review.setRating(4.2);
        assertEquals(4.2, review.getRating(), 0.0);
        assertTrue(review.isRecommended());
    }

    @Test
    public void testGetAndSetReviewDate() {
        review.setReviewDate("2025-01-01");
        assertEquals("2025-01-01", review.getReviewDate());
    }

    @Test
    public void testIsAndSetVerified() {
        review.setVerified(true);
        assertTrue(review.isVerified());
    }

    @Test
    public void testGetAndSetHelpfulCount() {
        review.setHelpfulCount(3);
        assertEquals(3, review.getHelpfulCount());
    }

    @Test
    public void testGetAndSetReviewTitle() {
        review.setReviewTitle("Awesome Trip");
        assertEquals("Awesome Trip", review.getReviewTitle());
    }

    @Test
    public void testIsAndSetRecommended() {
        review.setRecommended(false);
        assertFalse(review.isRecommended());
    }

    @Test
    public void testGetAndSetTravelDate() {
        review.setTravelDate("2025-12-15");
        assertEquals("2025-12-15", review.getTravelDate());
    }

    @Test
    public void testGetAndSetTravelType() {
        review.setTravelType("Family");
        assertEquals("Family", review.getTravelType());
    }

    @Test
    public void testGetAndSetPros() {
        review.setPros("Affordable, Scenic");
        assertEquals("Affordable, Scenic", review.getPros());
    }

    @Test
    public void testGetAndSetCons() {
        review.setCons("Too hot during summer");
        assertEquals("Too hot during summer", review.getCons());
    }

    @Test
    public void testIsAndSetAnonymous() {
        review.setAnonymous(true);
        assertTrue(review.isAnonymous());
    }

    @Test
    public void testToStringMethod() {
        review.setReviewId("R0001");
        String result = review.toString();
        assertTrue(result.contains("R0001"));
        assertTrue(result.contains("rating=4.5"));
    }

    @Test
    public void testEqualsMethod() {
        PackageReview review2 = new PackageReview("R0001", "U001", "P001", "Good", 4.0);
        review2.setReviewId(review.getReviewId());
        assertEquals(review, review2);
    }

    @Test
    public void testHashCodeMethod() {
        PackageReview another = new PackageReview("U001", "P001", "Nice", 4.5, "Title");
        another.setReviewId(review.getReviewId());
        assertEquals(review.hashCode(), another.hashCode());
    }
        // ---------------- CORNER CASE TESTS ----------------

    @Test
    public void testMarkAsHelpfulMultipleTimes() {
        int count = review.getHelpfulCount();
        review.markAsHelpful();
        review.markAsHelpful();
        assertEquals(count + 2, review.getHelpfulCount());
    }

    @Test
    public void testUpdateReviewWithEmptyText() {
        review.updateReview("", 3.5);
        assertEquals("", review.getReviewText());
        assertEquals(3.5, review.getRating(), 0.0);
    }

    @Test
    public void testUpdateReviewWithNegativeRating() {
        review.updateReview("Bad rating", -2.0);
        assertEquals("Bad rating", review.getReviewText());
        assertEquals(-2.0, review.getRating(), 0.0); // depends on implementation
    }

    @Test
    public void testSetRatingZero() {
        review.setRating(0.0);
        assertEquals(0.0, review.getRating(), 0.0);
        assertTrue(review.isNegativeReview() || review.isNeutralReview()); // depending on threshold
    }

    @Test
    public void testSetRatingAboveFive() {
        review.setRating(6.0);
        assertEquals(6.0, review.getRating(), 0.0);
    }

    @Test
    public void testEqualsWithNull() {
        assertNotEquals(review, null);
    }

    @Test
    public void testEqualsWithDifferentClass() {
        assertNotEquals(review, "NotAReview");
    }

    @Test
    public void testEqualsWithSameObject() {
        assertEquals(review, review);
    }

    @Test
    public void testHashCodeDifferentIds() {
        PackageReview r1 = new PackageReview("U001", "P001", "Nice", 4.0, "Trip");
        r1.setReviewId("R100");
        PackageReview r2 = new PackageReview("U001", "P001", "Nice", 4.0, "Trip");
        r2.setReviewId("R200");
        assertNotEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    public void testToStringWithNullValues() {
        PackageReview r = new PackageReview(null, null, null, 0.0, null);
        String str = r.toString();
        assertNotNull(str);
        assertTrue(str.contains("rating=0.0"));
    }

    @Test
    public void testEmptyUserNameAndPackageName() {
        review.setUserName("");
        review.setPackageName("");
        String summary = review.getReviewSummary();
        assertTrue(summary.contains("Review by "));
    }

}
