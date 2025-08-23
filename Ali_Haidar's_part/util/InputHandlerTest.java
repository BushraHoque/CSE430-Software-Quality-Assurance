package util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class InputHandlerTest {

    private final InputStream systemIn = System.in;

    @Before
    public void setUp() {
       
    }

    @After
    public void tearDown() {
        System.setIn(systemIn); 
    }

    @Test
    public void testGetString() {
        String input = "Hello World\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String result = InputHandler.getString("Enter a string: ");
        assertEquals("Hello World", result);
    }

    @Test
    public void testGetInt() {
        String input = "123\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result = InputHandler.getInt("Enter a number: ");
        assertEquals(123, result);
    }

    @Test
    public void testGetDouble() {
        String input = "45.67\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        double result = InputHandler.getDouble("Enter a double: ");
        assertEquals(45.67, result, 0.0001);
    }

    @Test
    public void testGetBooleanYes() {
        String input = "y\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        boolean result = InputHandler.getBoolean("Do you agree?");
        assertTrue(result);
    }

    @Test
    public void testGetBooleanNo() {
        String input = "n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        boolean result = InputHandler.getBoolean("Do you agree?");
        assertFalse(result);
    }

    @Test
    public void testPressEnterToContinue() {
        String input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputHandler.pressEnterToContinue();
        // No exception = success
    }

    @Test
    public void testCloseScanner() {
        InputHandler.closeScanner();
        // আবার ব্যবহার করলে exception হতে পারে, তাই এটা শুধু call করা হয়েছে
    }
}
