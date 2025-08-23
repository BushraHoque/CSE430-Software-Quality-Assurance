package model;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TravelAgentTest {

    private TravelAgent agent;

    @Before
    public void setUp() {
        agent = new TravelAgent("AG001", "Alice", "alice@example.com", "password123", "01700000000");
    }

    @Test
    public void testGetRole() {
        assertEquals("AGENT", agent.getRole());
    }

    @Test
    public void testSetAndGetAgencyName() {
        agent.setAgencyName("Best Tours Ltd.");
        assertEquals("Best Tours Ltd.", agent.getAgencyName());
    }

    @Test
    public void testSetAndGetLicenseNumber() {
        agent.setLicenseNumber("LIC123456");
        assertEquals("LIC123456", agent.getLicenseNumber());
    }

    @Test
    public void testGetManagedPackagesInitiallyEmpty() {
        List<String> packages = agent.getManagedPackages();
        assertNotNull(packages);
        assertTrue(packages.isEmpty());
    }

    @Test
    public void testGetAndSetCommissionRate() {
        agent.setCommissionRate(0.15);
        assertEquals(0.15, agent.getCommissionRate(), 0.0001);
    }

    @Test
    public void testInheritanceFromUser() {
        assertEquals("AG001", agent.getId());
        assertEquals("Alice", agent.getName());
        assertEquals("alice@example.com", agent.getEmail());
        assertEquals("password123", agent.getPassword());
        assertEquals("01700000000", agent.getPhone());
    }
}
