import model.Tourist;
import org.junit.Test;

public class TouristExistenceTest {

    @Test
    public void testTouristClassLoads() {
        Tourist t = new Tourist();  // If this fails, Tourist is not accessible
    }
}
