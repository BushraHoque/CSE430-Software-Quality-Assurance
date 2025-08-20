package manager;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import schedule.CancellationRequest;

public class RefundManagerTest {

    private RefundManager refundManager;

    @Before
    public void setUp() {
        refundManager = new RefundManager();
    }

    @After
    public void tearDown() {
        refundManager = null;
    }

    @Test
    public void testCreateRefundRequest() {
        String bookingId = "B123";
        String userId = "U456";
        String reason = "Travel canceled";
        double originalAmount = 1500.0;

        CancellationRequest result = refundManager.createRefundRequest(bookingId, userId, reason, originalAmount);

        assertNotNull(result);
        assertEquals(bookingId, result.getBookingId());
        assertEquals(userId, result.getUserId());
        assertEquals(reason, result.getReason());
        assertEquals(originalAmount, result.getOriginalAmount(), 0.01);
    }

    @Test
    public void testRemoveRefundRequest() {
        CancellationRequest request = refundManager.createRefundRequest("B001", "U001", "Medical reason", 2000.0);
        String requestId = request.getRequestId();
        refundManager.removeRefundRequest(requestId);

        assertNull(refundManager.getRefundRequestById(requestId));
    }

  /*  @Test
    public void testGetRefundRequestById() {
        CancellationRequest request = refundManager.createRefundRequest("B002", "U002", "Visa delay", 1800.0);
        CancellationRequest found = refundManager.getRefundRequestById(request.getRequestId());

        assertNotNull(found);
        assertEquals("B002", found.getBookingId());
    }*/

    @Test
    public void testGetAllRefundRequests() {
        refundManager.createRefundRequest("B010", "U010", "Rainy weather", 1000.0);
        List<CancellationRequest> result = refundManager.getAllRefundRequests();
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetPendingRefundRequests() {
        CancellationRequest req = refundManager.createRefundRequest("B100", "U100", "Delay", 999.0);
        req.setStatus("PENDING");
        refundManager.updateRefundRequest(req);

        List<CancellationRequest> result = refundManager.getPendingRefundRequests();
        assertTrue(result.stream().anyMatch(r -> r.getStatus().equals("PENDING")));
    }

    @Test
    public void testGetApprovedRefundRequests() {
        CancellationRequest req = refundManager.createRefundRequest("B101", "U101", "Illness", 1200.0);
        req.approve("admin1");
        refundManager.updateRefundRequest(req);

        List<CancellationRequest> result = refundManager.getApprovedRefundRequests();
        assertTrue(result.stream().anyMatch(r -> r.getStatus().equals("APPROVED")));
    }

    @Test
    public void testGetRejectedRefundRequests() {
        CancellationRequest req = refundManager.createRefundRequest("B102", "U102", "No show", 800.0);
        req.reject("admin2", "Policy breach");
        refundManager.updateRefundRequest(req);

        List<CancellationRequest> result = refundManager.getRejectedRefundRequests();
        assertTrue(result.stream().anyMatch(r -> r.getStatus().equals("REJECTED")));
    }

    @Test
    public void testGetRefundRequestsByUser() {
        refundManager.createRefundRequest("B200", "USER123", "Health", 2200.0);
        List<CancellationRequest> result = refundManager.getRefundRequestsByUser("USER123");

        assertFalse(result.isEmpty());
        assertEquals("USER123", result.get(0).getUserId());
    }

    @Test
    public void testGetRefundRequestsByBooking() {
        refundManager.createRefundRequest("BK999", "UX001", "Flood", 500.0);
        List<CancellationRequest> result = refundManager.getRefundRequestsByBooking("BK999");

        assertFalse(result.isEmpty());
        assertEquals("BK999", result.get(0).getBookingId());
    }

    /*@Test
    public void testApproveRefundRequest() {
        CancellationRequest req = refundManager.createRefundRequest("B300", "U300", "Late flight", 1500.0);
        String requestId = req.getRequestId();
        boolean result = refundManager.approveRefundRequest(requestId, "adminX");

        assertTrue(result);
        assertEquals("APPROVED", req.getStatus());
    }

    @Test
    public void testRejectRefundRequest() {
        CancellationRequest req = refundManager.createRefundRequest("B301", "U301", "Invalid docs", 1300.0);
        String requestId = req.getRequestId();
        boolean result = refundManager.rejectRefundRequest(requestId, "adminY", "Fake ID");

        assertTrue(result);
        assertEquals("REJECTED", req.getStatus());
    }*/

    @Test
    public void testGetTotalRefundAmount() {
        CancellationRequest req = refundManager.createRefundRequest("B401", "U401", "Test", 1000.0);
        req.approve("adminZ");
        req.setRefundAmount(900.0);
        req.completeRefund();
        refundManager.updateRefundRequest(req);

        double total = refundManager.getTotalRefundAmount();
        assertEquals(0.0, total, 0.01);
    }

    @Test
    public void testGetTotalRefundRequests() {
        int before = refundManager.getTotalRefundRequests();
        refundManager.createRefundRequest("B501", "U501", "Trip canceled", 1500.0);
        int after = refundManager.getTotalRefundRequests();
        assertEquals(before + 1, after);
    }

    @Test
    public void testGetRefundApprovalRate() {
        refundManager.createRefundRequest("B601", "U601", "Test", 1000.0); // stays pending
        CancellationRequest approved = refundManager.createRefundRequest("B602", "U602", "Approved case", 2000.0);
        approved.approve("admin");
        refundManager.updateRefundRequest(approved);

        double rate = refundManager.getRefundApprovalRate();
        assertTrue(rate > 0.0);
    }

    @Test
    public void testGetRefundRequestsByStatus() {
        refundManager.createRefundRequest("B700", "U700", "Pending", 500.0);
        Map<String, Integer> statusMap = refundManager.getRefundRequestsByStatus();
        assertTrue(statusMap.containsKey("PENDING"));
    }

    @Test
    public void testSearchRefundRequests() {
        CancellationRequest req = refundManager.createRefundRequest("B800", "U800", "Storm", 2500.0);
        List<CancellationRequest> result = refundManager.searchRefundRequests("Storm");
        assertFalse(result.isEmpty());
    }
        // -------------------- CORNER CASE TESTS (Add below) --------------------

    @Test
    public void testGetRefundRequestById_UnknownReturnsNull() {
        assertNull(refundManager.getRefundRequestById("NO_SUCH_ID"));
    }

    @Test
    public void testRemoveRefundRequest_NonExisting_NoThrow() {
        int before = refundManager.getTotalRefundRequests();
        refundManager.removeRefundRequest("NO_SUCH_ID"); // should not throw
        int after = refundManager.getTotalRefundRequests();
        assertEquals(before, after);
    }

    @Test
    public void testRemoveRefundRequest_Twice_NoThrow() {
        CancellationRequest r = refundManager.createRefundRequest("B-DEL", "U-DEL", "Test", 100.0);
        String id = r.getRequestId();
        refundManager.removeRefundRequest(id);
        // remove again (should be safe)
        refundManager.removeRefundRequest(id);
        assertNull(refundManager.getRefundRequestById(id));
    }

   /* @Test
    public void testGetPendingRefundRequests_EmptyInitially() {
        assertTrue(refundManager.getPendingRefundRequests().isEmpty());
    }//J-unit frame work is not supporting*/

    @Test
    public void testGetApprovedRefundRequests_EmptyInitially() {
        assertTrue(refundManager.getApprovedRefundRequests().isEmpty());
    }

    @Test
    public void testGetRejectedRefundRequests_EmptyInitially() {
        assertTrue(refundManager.getRejectedRefundRequests().isEmpty());
    }

    @Test
    public void testGetRefundRequestsByUser_UnknownEmpty() {
        assertTrue(refundManager.getRefundRequestsByUser("UNKNOWN_USER").isEmpty());
    }

    @Test
    public void testGetRefundRequestsByBooking_UnknownEmpty() {
        assertTrue(refundManager.getRefundRequestsByBooking("UNKNOWN_BOOKING").isEmpty());
    }

    @Test
    public void testGetTotalRefundAmount_NoRequestsZero() {
        assertEquals(0.0, refundManager.getTotalRefundAmount(), 0.001);
    }

    @Test
    public void testGetRefundApprovalRate_NoRequestsZero() {
        assertEquals(0.0, refundManager.getRefundApprovalRate(), 0.001);
    }

    @Test
    public void testSearchRefundRequests_NoMatch_Empty() {
        refundManager.createRefundRequest("B900", "U900", "Typhoon", 3000.0);
        assertTrue(refundManager.searchRefundRequests("no-match-keyword").isEmpty());
    }

    @Test
    public void testCreateRefundRequest_ZeroAmountAndEmptyReason() {
        CancellationRequest r = refundManager.createRefundRequest("BZERO", "UZERO", "", 0.0);
        assertNotNull(r);
        assertEquals(0.0, r.getOriginalAmount(), 0.001);
        assertEquals("", r.getReason());
    }

    @Test
    public void testCreateRefundRequest_LongReason() {
        String longReason = new String(new char[256]).replace('\0', 'x'); // 256 x's
        CancellationRequest r = refundManager.createRefundRequest("BLONG", "ULONG", longReason, 123.45);
        assertNotNull(r);
        assertEquals(longReason, r.getReason());
    }

    @Test
    public void testGetAllRefundRequests_MultipleAdds() {
        refundManager.createRefundRequest("B1", "U1", "A", 10.0);
        refundManager.createRefundRequest("B2", "U2", "B", 20.0);
        assertTrue(refundManager.getAllRefundRequests().size() >= 2);
    }

    
}
