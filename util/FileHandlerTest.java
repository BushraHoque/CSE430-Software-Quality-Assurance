package util;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

public class FileHandlerTest {
    
    private static final String TEST_FILE = "test.txt";
    private static final String DATA_DIR = "data";
    
    public FileHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        // Clean up all test files
        File testFile = new File(DATA_DIR + "/" + TEST_FILE);
        if (testFile.exists()) {
            testFile.delete();
        }
        File emptyFile = new File(DATA_DIR + "/empty.txt");
        if (emptyFile.exists()) {
            emptyFile.delete();
        }
        File specialCharsFile = new File(DATA_DIR + "/special@#$.txt");
        if (specialCharsFile.exists()) {
            specialCharsFile.delete();
        }
    }

    // Test writeToFile with normal data
    @Test
    public void testWriteToFile() {
        System.out.println("writeToFile");
        String filename = TEST_FILE;
        String data = "Test data line";
        
        FileHandler.writeToFile(filename, data);
        
        assertTrue("File should exist after writing", FileHandler.fileExists(filename));
        List<String> result = FileHandler.readFromFile(filename);
        assertEquals("Should contain one line", 1, result.size());
        assertEquals("Content should match", data, result.get(0));
    }

    // Test writeToFile with null filename
    @Test
    public void testWriteToFileWithNullFilename() {
        System.out.println("writeToFile with null filename");
        String filename = null;
        String data = "Test data";
        
        FileHandler.writeToFile(filename, data);
    }

    // Test writeToFile with empty filename
    @Test
    public void testWriteToFileWithEmptyFilename() {
        System.out.println("writeToFile with empty filename");
        String filename = "";
        String data = "Test data";
        
        FileHandler.writeToFile(filename, data);
        
    }

    // Test writeToFile with null data
    @Test
    public void testWriteToFileWithNullData() {
        System.out.println("writeToFile with null data");
        String filename = TEST_FILE;
        String data = null;
        
        FileHandler.writeToFile(filename, data);
        
        assertTrue("File should exist", FileHandler.fileExists(filename));
        List<String> result = FileHandler.readFromFile(filename);
        assertEquals("Should contain one line", 1, result.size());
        assertEquals("Content should be 'null'", "null", result.get(0));
    }

    // Test writeToFile with empty data
    @Test
    public void testWriteToFileWithEmptyData() {
        System.out.println("writeToFile with empty data");
        String filename = TEST_FILE;
        String data = "";
        
        FileHandler.writeToFile(filename, data);
        
        assertTrue("File should exist", FileHandler.fileExists(filename));
        List<String> result = FileHandler.readFromFile(filename);
        assertEquals("Should contain one line", 1, result.size());
        assertEquals("Content should be empty string", "", result.get(0));
    }

    // Test writeToFile with very long data
    @Test
    public void testWriteToFileWithLongData() {
        System.out.println("writeToFile with very long data");
        String filename = TEST_FILE;
        StringBuilder longData = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            longData.append("Very long data line with lots of text ");
        }
        String data = longData.toString();
        
        FileHandler.writeToFile(filename, data);
        
        assertTrue("File should exist", FileHandler.fileExists(filename));
        List<String> result = FileHandler.readFromFile(filename);
        assertEquals("Should contain one line", 1, result.size());
        assertEquals("Content should match", data, result.get(0));
    }

    // Test writeToFile with special characters
    @Test
    public void testWriteToFileWithSpecialCharacters() {
        System.out.println("writeToFile with special characters");
        String filename = TEST_FILE;
        String data = "Special chars: @#$%^&*(){}[]|\\:;\"'<>,.?/~`+=_-àáâãäåæçèéêë";
        
        FileHandler.writeToFile(filename, data);
        
        assertTrue("File should exist", FileHandler.fileExists(filename));
        List<String> result = FileHandler.readFromFile(filename);
        assertEquals("Should contain one line", 1, result.size());
        assertEquals("Content should match", data, result.get(0));
    }

    // Test writeToFile multiple times (append functionality)
    @Test
    public void testWriteToFileMultipleTimes() {
        System.out.println("writeToFile multiple times");
        String filename = TEST_FILE;
        
        FileHandler.writeToFile(filename, "Line 1");
        FileHandler.writeToFile(filename, "Line 2");
        FileHandler.writeToFile(filename, "Line 3");
        
        List<String> result = FileHandler.readFromFile(filename);
        assertEquals("Should contain three lines", 3, result.size());
        assertEquals("First line should match", "Line 1", result.get(0));
        assertEquals("Second line should match", "Line 2", result.get(1));
        assertEquals("Third line should match", "Line 3", result.get(2));
    }

    // Test readFromFile with existing file
    @Test
    public void testReadFromFile() {
        System.out.println("readFromFile");
        String filename = TEST_FILE;
        
        FileHandler.writeToFile(filename, "Line 1");
        FileHandler.writeToFile(filename, "Line 2");
        
        List<String> result = FileHandler.readFromFile(filename);
        
        assertEquals("Should contain two lines", 2, result.size());
        assertEquals("First line should match", "Line 1", result.get(0));
        assertEquals("Second line should match", "Line 2", result.get(1));
    }

    // Test readFromFile with non-existent file
    @Test
    public void testReadFromNonExistentFile() {
        System.out.println("readFromFile with non-existent file");
        String filename = "nonexistent.txt";
        
        List<String> result = FileHandler.readFromFile(filename);
        
        assertNotNull("Result should not be null", result);
        assertTrue("Result should be empty list", result.isEmpty());
    }

    // Test readFromFile with null filename
    @Test
    public void testReadFromFileWithNullFilename() {
        System.out.println("readFromFile with null filename");
        String filename = null;
        
        List<String> result = FileHandler.readFromFile(filename);
        
        assertNotNull("Result should not be null", result);
        assertTrue("Result should be empty list", result.isEmpty());
    }

    // Test readFromFile with empty filename
    @Test
    public void testReadFromFileWithEmptyFilename() {
        System.out.println("readFromFile with empty filename");
        String filename = "";
        
        List<String> result = FileHandler.readFromFile(filename);
        
        assertNotNull("Result should not be null", result);
        assertTrue("Result should be empty list", result.isEmpty());
    }

    // Test readFromFile with empty file
    @Test
    public void testReadFromEmptyFile() {
        System.out.println("readFromFile from empty file");
        String filename = "empty.txt";
        
        // This creates an empty file
        FileHandler.clearFile(filename); 
        
        List<String> result = FileHandler.readFromFile(filename);
        
        assertNotNull("Result should not be null", result);
        assertTrue("Result should be empty list", result.isEmpty());
    }

    // Test clearFile with existing file
    @Test
    public void testClearFile() {
        System.out.println("clearFile");
        String filename = TEST_FILE;
        
        FileHandler.writeToFile(filename, "Some data");
        FileHandler.writeToFile(filename, "More data");
        FileHandler.clearFile(filename);
        
        assertTrue("File should still exist", FileHandler.fileExists(filename));
        List<String> result = FileHandler.readFromFile(filename);
        assertTrue("File should be empty after clearing", result.isEmpty());
    }

    // Test clearFile with non-existent file
    @Test
    public void testClearNonExistentFile() {
        System.out.println("clearFile with non-existent file");
        String filename = "nonexistent.txt";
        
        FileHandler.clearFile(filename);
        
        assertTrue("File should exist after clearing", FileHandler.fileExists(filename));
        List<String> result = FileHandler.readFromFile(filename);
        assertTrue("File should be empty", result.isEmpty());
    }

    // Test clearFile with null filename
    @Test
    public void testClearFileWithNullFilename() {
        System.out.println("clearFile with null filename");
        String filename = null;
        
        FileHandler.clearFile(filename);
        
    }

    // Test clearFile with empty filename
    @Test
    public void testClearFileWithEmptyFilename() {
        System.out.println("clearFile with empty filename");
        String filename = "";
        
        FileHandler.clearFile(filename);
       
    }

    // Test fileExists with existing file
    @Test
    public void testFileExists() {
        System.out.println("fileExists");
        String filename = TEST_FILE;
        
        assertFalse("File should not exist initially", FileHandler.fileExists(filename));
        
        FileHandler.writeToFile(filename, "Test content");
        assertTrue("File should exist after writing", FileHandler.fileExists(filename));
    }

    // Test fileExists with non-existent file
    @Test
    public void testFileExistsWithNonExistentFile() {
        System.out.println("fileExists with non-existent file");
        String filename = "definitely_does_not_exist.txt";
        
        assertFalse("File should not exist", FileHandler.fileExists(filename));
    }

    // Test with filename containing special characters
    @Test
    public void testWithSpecialCharactersInFilename() {
        System.out.println("Test with special characters in filename");
        String filename = "special@#$.txt";
        String data = "Test data";
        
        FileHandler.writeToFile(filename, data);
        
        assertTrue("File should exist", FileHandler.fileExists(filename));
        List<String> result = FileHandler.readFromFile(filename);
        assertEquals("Should contain one line", 1, result.size());
        assertEquals("Content should match", data, result.get(0));
    }

    // Test with very long filename
    @Test
    public void testWithLongFilename() {
        System.out.println("Test with very long filename");
        StringBuilder longName = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            longName.append("long");
        }
        longName.append(".txt");
        String filename = longName.toString();
        String data = "Test data";
        
        FileHandler.writeToFile(filename, data);
        
        if (FileHandler.fileExists(filename)) {
            List<String> result = FileHandler.readFromFile(filename);
            assertEquals("Should contain one line", 1, result.size());
            assertEquals("Content should match", data, result.get(0));
            new File(DATA_DIR + "/" + filename).delete();
        }
    }

    // Test concurrent operations (multiple writes)
    @Test
    public void testConcurrentWrites() {
        System.out.println("Test concurrent operations");
        String filename = TEST_FILE;
        
        for (int i = 0; i < 100; i++) {
            FileHandler.writeToFile(filename, "Line " + i);
        }
        
        List<String> result = FileHandler.readFromFile(filename);
        assertEquals("Should contain 100 lines", 100, result.size());
        
        for (int i = 0; i < 100; i++) {
            assertEquals("Line " + i + " should match", "Line " + i, result.get(i));
        }
    }

    // Test write after clear
    @Test
    public void testWriteAfterClear() {
        System.out.println("Test write after clear");
        String filename = TEST_FILE;
        
        FileHandler.writeToFile(filename, "Initial data");
        FileHandler.clearFile(filename);
        FileHandler.writeToFile(filename, "New data");
        
        List<String> result = FileHandler.readFromFile(filename);
        assertEquals("Should contain one line", 1, result.size());
        assertEquals("Content should be new data", "New data", result.get(0));
    }

    // Test with newline characters in data
    @Test
    public void testWriteWithNewlineCharacters() {
        System.out.println("Test with newline characters in data");
        String filename = TEST_FILE;
        String data = "Line with\nnewline character";
        
        FileHandler.writeToFile(filename, data);
        
        List<String> result = FileHandler.readFromFile(filename);
        assertTrue("Should contain at least one line", result.size() >= 1);
        assertTrue("Should contain the data", result.toString().contains("Line with"));
    }

    // Test with tab characters in data
    @Test
    public void testWriteWithTabCharacters() {
        System.out.println("Test with tab characters in data");
        String filename = TEST_FILE;
        String data = "Data\twith\ttab\tcharacters";
        
        FileHandler.writeToFile(filename, data);
        
        List<String> result = FileHandler.readFromFile(filename);
        assertEquals("Should contain one line", 1, result.size());
        assertEquals("Content should match", data, result.get(0));
    }
}
