    package model;

    import java.util.List;
    import java.util.ArrayList;

    public class Tourist extends User {
        private List<String> preferences;
        private String nationality;
        private int loyaltyPoints;
        private List<String> bookingHistory;

        // Constructor with parameters
        public Tourist(String id, String name, String email, String password, String phone) {
            super(id, name, email, password, phone);
            this.preferences = new ArrayList<>();
            this.loyaltyPoints = 0;
            this.bookingHistory = new ArrayList<>();
            this.nationality = "";
        }

        // Default constructor calling parameterized User constructor with empty values
        public Tourist() {
            super("", "", "", "", ""); // ✅ Prevents error by explicitly calling User's constructor
            this.preferences = new ArrayList<>();
            this.loyaltyPoints = 0;
            this.bookingHistory = new ArrayList<>();
            this.nationality = "";
        }
    public class TravelAgent extends User {
        private List<String> managedPackages;

        public TravelAgent(...) {
            super(...);
            this.managedPackages = new ArrayList<>();
        }

        public List<String> getManagedPackages() {
            return managedPackages;
        }

        // Other methods...

            @Override
            public String getRole() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }

        public String getRole() {
            return "TOURIST";
        }

        public void addLoyaltyPoints(int points) {
            this.loyaltyPoints += points;
        }

        public List<String> getPreferences() {
            return new ArrayList<>(preferences); // Return copy
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
