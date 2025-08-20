package model;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents an admin user with specific permissions and admin level.
 */
public class Admin extends User {
    private String adminLevel;
    private List<String> permissions;

    /**
     * Constructs an Admin with the given user details.
     */
    public Admin(String id, String name, String email, String password, String phone) {
        super(id, name, email, password, phone);
        this.adminLevel = "SUPER_ADMIN";
        this.permissions = new ArrayList<>();
    }

    /**
     * Returns the role of this user.
     */
    @Override
    public String getRole() {
        return "ADMIN";
    }

    // Getters and Setters

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    public List<String> getPermissions() {
        return new ArrayList<>(permissions); // Return a copy
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = (permissions != null) ? new ArrayList<>(permissions) : new ArrayList<>();
    }
}
