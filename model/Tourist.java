package model;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a tourist user with preferences, nationality, loyalty points,
 * and booking history.
 */
public class Tourist extends User {
    private List<String> preferences;
    private String nationality;
    private int loyaltyPoints;
    private List<String> bookingHistory;

    /**
     * Constructs a Tourist with specified user details.
     */
    public Tourist(String id, String name, String email, String password, String phone) {
        super(id, name, email, password, phone);
        this.preferences = new ArrayList<>();
        this.loyaltyPoints = 0;
        this.bookingHistory = new ArrayList<>();
        this.nationality = "";
    }

    /**
     * Default constructor initializes fields with default values.
     * Assumes User does not have a no-arg constructor.
     */
    public Tourist() {
        super("", "", "", "", ""); // Safe default values
        this.preferences = new ArrayList<>();
        this.loyaltyPoints = 0;
        this.bookingHistory = new ArrayList<>();
        this.nationality = "";
    }

    @Override
    public String getRole() {
        return "TOURIST";
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    // Getters and Setters

    public List<String> getPreferences() {
        return new ArrayList<>(preferences);
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = (preferences != null) ? new ArrayList<>(preferences) : new ArrayList<>();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public List<String> getBookingHistory() {
        return new ArrayList<>(bookingHistory);
    }

    public void setBookingHistory(List<String> bookingHistory) {
        this.bookingHistory = (bookingHistory != null) ? new ArrayList<>(bookingHistory) : new ArrayList<>();
    }
}
