package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BackupManagerTest {
    
    public BackupManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            Files.createDirectories(Paths.get("data"));
            Files.write(Paths.get("data/test.txt"), "test".getBytes());
        } catch (IOException e) {}
    }
    
    @After
    public void tearDown() {
        deleteDir("data");
        deleteDir("backups");
    }

    // Test backup creation
    @Test
    public void testCreateBackup() {
        BackupManager.createBackup();
        assertTrue(new File("backups").exists());
    }

    // Test backup restore
    @Test
    public void testRestoreBackup() {
        BackupManager.createBackup();
        String backupName = new File("backups").listFiles()[0].getName();
        
        deleteDir("data");
        BackupManager.restoreBackup(backupName);
        
        assertTrue(new File("data").exists());
    }
    
    private void deleteDir(String dir) {
        try {
            if (Files.exists(Paths.get(dir))) {
                Files.walk(Paths.get(dir))
                    .sorted((a, b) -> b.compareTo(a))
                    .forEach(p -> {
                        try { Files.delete(p); } catch (IOException e) {}
                    });
            }
        } catch (IOException e) {}
    }
}
