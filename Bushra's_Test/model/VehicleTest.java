package model;

import enumtype.TransportType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class VehicleTest {

    private Vehicle vehicle;

    @Before
    public void setUp() {
        vehicle = new Vehicle("V001", "Model X", TransportType.CAR, 4);
        vehicle.setMake("Tesla");
        vehicle.setYear("2023");
        vehicle.setLicensePlate("ABC-123");
        vehicle.setDriverName("John Doe");
        vehicle.setDriverLicense("DL-456789");
        vehicle.setFuelCapacity(85.0);
        vehicle.setInsuranceDetails("Insured until 2026");
    }

    @Test
    public void testVehicleInitialization() {
        assertEquals("V001", vehicle.getVehicleId());
        assertEquals("Model X", vehicle.getModel());
        assertEquals(TransportType.CAR, vehicle.getVehicleType());
        assertEquals(4, vehicle.getSeatsAvailable());
        assertTrue(vehicle.isOperational());
    }

    @Test
    public void testSetAndGetFields() {
        vehicle.setModel("Model Y");
        vehicle.setMake("Tesla");
        vehicle.setYear("2022");
        vehicle.setSeatsAvailable(5);
        vehicle.setLicensePlate("XYZ-789");
        vehicle.setOperational(false);
        vehicle.setDriverName("Jane Smith");
        vehicle.setDriverLicense("DL-987654");
        vehicle.setFuelCapacity(90.0);
        vehicle.setInsuranceDetails("Insured until 2025");

        assertEquals("Model Y", vehicle.getModel());
        assertEquals("Tesla", vehicle.getMake());
        assertEquals("2022", vehicle.getYear());
        assertEquals(5, vehicle.getSeatsAvailable());
        assertEquals("XYZ-789", vehicle.getLicensePlate());
        assertFalse(vehicle.isOperational());
        assertEquals("Jane Smith", vehicle.getDriverName());
        assertEquals("DL-987654", vehicle.getDriverLicense());
        assertEquals(90.0, vehicle.getFuelCapacity(), 0.01);
        assertEquals("Insured until 2025", vehicle.getInsuranceDetails());
    }

    @Test
    public void testAddFeature() {
        vehicle.addFeature("GPS");
        vehicle.addFeature("Air Conditioning");

        assertTrue(vehicle.getFeatures().contains("GPS"));
        assertTrue(vehicle.getFeatures().contains("Air Conditioning"));
    }

    @Test
    public void testRemoveFeature() {
        vehicle.setFeatures(Arrays.asList("Bluetooth", "Heated Seats", "Cruise Control"));
        vehicle.removeFeature("Heated Seats");

        assertFalse(vehicle.getFeatures().contains("Heated Seats"));
        assertTrue(vehicle.getFeatures().contains("Bluetooth"));
    }
        // -------------------- CORNER CASE TESTS --------------------

    @Test
    public void testAddFeatureNullOrEmpty() {
        vehicle.addFeature(null);
        vehicle.addFeature("");
        assertTrue(vehicle.getFeatures().contains(null));
        assertTrue(vehicle.getFeatures().contains(""));
    }

    @Test
    public void testAddDuplicateFeature() {
        vehicle.addFeature("GPS");
        vehicle.addFeature("GPS"); // duplicate
        long count = vehicle.getFeatures().stream().filter(f -> "GPS".equals(f)).count();
        assertEquals(2, count); // assuming duplicates allowed
    }

    @Test
    public void testRemoveFeatureNotPresent() {
        vehicle.setFeatures(Arrays.asList("Bluetooth", "Cruise Control"));
        vehicle.removeFeature("Sunroof"); // not in list
        assertEquals(2, vehicle.getFeatures().size());
        assertTrue(vehicle.getFeatures().contains("Bluetooth"));
        assertTrue(vehicle.getFeatures().contains("Cruise Control"));
    }

    @Test
    public void testSetSeatsAvailableNegative() {
        vehicle.setSeatsAvailable(-5);
        assertEquals(-5, vehicle.getSeatsAvailable());
    }

    @Test
    public void testSetFuelCapacityNegative() {
        vehicle.setFuelCapacity(-50.0);
        assertEquals(-50.0, vehicle.getFuelCapacity(), 0.001);
    }

    @Test
    public void testOperationalToggle() {
        vehicle.setOperational(false);
        assertFalse(vehicle.isOperational());
        vehicle.setOperational(true);
        assertTrue(vehicle.isOperational());
    }

    @Test
    public void testMultipleFeatures() {
        vehicle.addFeature("GPS");
        vehicle.addFeature("Sunroof");
        vehicle.addFeature("Heated Seats");
        vehicle.removeFeature("Sunroof");
        assertEquals(2, vehicle.getFeatures().size());
        assertTrue(vehicle.getFeatures().contains("GPS"));
        assertTrue(vehicle.getFeatures().contains("Heated Seats"));
    }

    @Test
    public void testSetFieldsNullOrEmpty() {
        vehicle.setMake(null);
        vehicle.setModel("");
        vehicle.setYear(null);
        vehicle.setLicensePlate("");
        vehicle.setDriverName(null);
        vehicle.setDriverLicense("");
        vehicle.setInsuranceDetails(null);

        assertNull(vehicle.getMake());
        assertEquals("", vehicle.getModel());
        assertNull(vehicle.getYear());
        assertEquals("", vehicle.getLicensePlate());
        assertNull(vehicle.getDriverName());
        assertEquals("", vehicle.getDriverLicense());
        assertNull(vehicle.getInsuranceDetails());
    }

}
