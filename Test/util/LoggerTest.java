package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerTest {

    public LoggerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        Logger.enableDevelopmentMode(); // Default to development mode for tests
    }

    @AfterClass
    public static void tearDownClass() {
        Logger.disableAllLogging();
    }

    @Before
    public void setUp() {
        Logger.enableDevelopmentMode(); // Reset before each test
    }

    @After
    public void tearDown() {
        // Optional cleanup
    }

    @Test
    public void testLog() {
        Logger.setLogToConsole(false);
        Logger.setLogToFile(true);
        Logger.log("Test log message");
        assertTrue(Logger.isFileLoggingEnabled());
    }

    @Test
    public void testError() {
        Logger.error("Test error message");
        assertTrue(Logger.isFileLoggingEnabled());
    }

    @Test
    public void testInfo() {
        Logger.info("Test info message");
        assertTrue(Logger.isConsoleLoggingEnabled());
    }

    @Test
    public void testWarning() {
        Logger.warning("Test warning message");
        assertTrue(Logger.isConsoleLoggingEnabled());
    }

    @Test
    public void testDebug() {
        Logger.setDevelopmentMode(true);
        Logger.debug("Debugging in development mode");
        assertTrue(Logger.isDevelopmentMode());
    }

    @Test
    public void testSuccess() {
        Logger.success("Success message test");
        assertTrue(Logger.isConsoleLoggingEnabled());
    }

    @Test
    public void testCritical() {
        Logger.critical("Critical error occurred");
        assertTrue(true); // No exception thrown
    }

    @Test
    public void testSilent() {
        Logger.silent("Silent logging test");
        assertTrue(Logger.isFileLoggingEnabled());
    }

    @Test
    public void testSetLogToFile() {
        Logger.setLogToFile(false);
        assertFalse(Logger.isFileLoggingEnabled());

        Logger.setLogToFile(true);
        assertTrue(Logger.isFileLoggingEnabled());
    }

    @Test
    public void testSetLogToConsole() {
        Logger.setLogToConsole(false);
        assertFalse(Logger.isConsoleLoggingEnabled());

        Logger.setLogToConsole(true);
        assertTrue(Logger.isConsoleLoggingEnabled());
    }

    @Test
    public void testSetDevelopmentMode() {
        Logger.setDevelopmentMode(true);
        assertTrue(Logger.isDevelopmentMode());

        Logger.setDevelopmentMode(false);
        assertFalse(Logger.isDevelopmentMode());
    }

    @Test
    public void testEnableProductionMode() {
        Logger.enableProductionMode();
        assertFalse(Logger.isDevelopmentMode());
        assertFalse(Logger.isConsoleLoggingEnabled());
        assertTrue(Logger.isFileLoggingEnabled());
    }

    @Test
    public void testEnableDevelopmentMode() {
        Logger.enableDevelopmentMode();
        assertTrue(Logger.isDevelopmentMode());
        assertTrue(Logger.isConsoleLoggingEnabled());
        assertTrue(Logger.isFileLoggingEnabled());
    }

    @Test
    public void testEnableSilentMode() {
        Logger.enableSilentMode();
        assertFalse(Logger.isConsoleLoggingEnabled());
        assertTrue(Logger.isFileLoggingEnabled());
    }

    @Test
    public void testDisableAllLogging() {
        Logger.disableAllLogging();
        assertFalse(Logger.isConsoleLoggingEnabled());
        assertFalse(Logger.isFileLoggingEnabled());
    }

    @Test
    public void testIsConsoleLoggingEnabled() {
        Logger.setLogToConsole(true);
        assertTrue(Logger.isConsoleLoggingEnabled());
    }

    @Test
    public void testIsFileLoggingEnabled() {
        Logger.setLogToFile(true);
        assertTrue(Logger.isFileLoggingEnabled());
    }

    @Test
    public void testIsDevelopmentMode() {
        Logger.setDevelopmentMode(true);
        assertTrue(Logger.isDevelopmentMode());
    }

    @Test
    public void testClearLogFile() {
        Logger.log("Clearing log file test");
        Logger.clearLogFile();
        long size = Logger.getLogFileSize();
        assertEquals(40, size);
    }

    @Test
    public void testGetLogFileSize() {
        Logger.log("Testing log file size");
        long size = Logger.getLogFileSize();
        assertTrue(size >= 0);
    }

    @Test
    public void testBackupLogFile() {
        Logger.backupLogFile();
        assertTrue(Logger.getLogFileSize() >= 0);
    }

    @Test
    public void testLogSystemInfo() {
        Logger.logSystemInfo();
        assertTrue(Logger.isFileLoggingEnabled());
    }

    @Test
    public void testLogWithLevel() {
        Logger.logWithLevel("TEST", "This is a test message with a custom level");
        assertTrue(Logger.isFileLoggingEnabled());
    }
    // -------------------- LOGGER CORNER CASE TESTS --------------------

@Test
public void testLogNullMessage() {
    Logger.log(null);
    Logger.info(null);
    Logger.warning(null);
    Logger.error(null);
    Logger.debug(null);
    Logger.success(null);
    Logger.critical(null);
    Logger.silent(null);
    // শুধু ensure কোনো exception না হয়
    assertTrue(true);
}

@Test
public void testLogEmptyMessage() {
    Logger.log("");
    Logger.info("");
    Logger.warning("");
    Logger.error("");
    Logger.debug("");
    Logger.success("");
    Logger.critical("");
    Logger.silent("");
    assertTrue(true); // no exception
}

@Test
public void testToggleModesRapidly() {
    for (int i = 0; i < 10; i++) {
        Logger.enableDevelopmentMode();
        assertTrue(Logger.isDevelopmentMode());
        Logger.enableProductionMode();
        assertFalse(Logger.isDevelopmentMode());
        Logger.enableSilentMode();
        assertFalse(Logger.isConsoleLoggingEnabled());
        Logger.disableAllLogging();
        assertFalse(Logger.isFileLoggingEnabled());
    }
}

@Test
public void testMultipleSetLogToConsoleAndFile() {
    Logger.setLogToConsole(true);
    Logger.setLogToConsole(false);
    Logger.setLogToConsole(true);
    assertTrue(Logger.isConsoleLoggingEnabled());

    Logger.setLogToFile(true);
    Logger.setLogToFile(false);
    Logger.setLogToFile(true);
    assertTrue(Logger.isFileLoggingEnabled());
}

@Test
public void testClearEmptyLogFile() {
    Logger.clearLogFile(); // if log file already empty
    long size = Logger.getLogFileSize();
    assertTrue(size >= 0);
}

@Test
public void testBackupMultipleTimes() {
    Logger.backupLogFile();
    Logger.backupLogFile();
    long size = Logger.getLogFileSize();
    assertTrue(size >= 0); // should not fail even if backup done multiple times
}

@Test
public void testLogAfterDisablingAll() {
    Logger.disableAllLogging();
    Logger.log("Logging after disabling all");
    Logger.info("Info after disabling all");
    Logger.error("Error after disabling all");
    assertFalse(Logger.isConsoleLoggingEnabled());
    assertFalse(Logger.isFileLoggingEnabled());
}

@Test
public void testLogSystemInfoMultiple() {
    Logger.enableDevelopmentMode();
    Logger.logSystemInfo();
    Logger.logSystemInfo();
    assertTrue(Logger.isFileLoggingEnabled());
}



}
