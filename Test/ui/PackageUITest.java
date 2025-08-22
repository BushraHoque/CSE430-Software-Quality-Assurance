package ui;

import manager.TourPackageManager;
import manager.UserManager;
import model.Admin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.Admin;
import model.User;
 

public class PackageUITest {
    
    private PackageUI packageUI;

    @Before
public void setUp() {
    Admin admin = new Admin("admin001", "Test Admin", "admin@example.com", "password123", "0123456789");

    UserManager userManager = new UserManager();
    TourPackageManager tourPackageManager = new TourPackageManager();

    packageUI = new PackageUI(admin, userManager, tourPackageManager);
}


    @After
    public void tearDown() {
        packageUI = null;
    }

    @Test
    public void testBrowseTourPackages() {
        System.out.println("✅ Running: browseTourPackages");
        packageUI.browseTourPackages();
    }

    @Test
    public void testSearchPackages() {
        System.out.println("✅ Running: searchPackages");
        packageUI.searchPackages();
    }

    @Test
    public void testViewPackageDetails() {
        System.out.println("✅ Running: viewPackageDetails");
        String packageId = "PKG001"; // Just a test value
        packageUI.viewPackageDetails(packageId);
    }

    @Test
    public void testCreateNewPackage() {
        System.out.println("✅ Running: createNewPackage");
        packageUI.createNewPackage();
    }

    @Test
    public void testEditPackage() {
        System.out.println("✅ Running: editPackage");
        String packageId = "PKG002"; // Just a test value
        packageUI.editPackage(packageId);
    }

    @Test
    public void testDisplayPackageManagement() {
        System.out.println("✅ Running: displayPackageManagement");
        packageUI.displayPackageManagement();
    }
}
