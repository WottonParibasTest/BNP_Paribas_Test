import org.junit.Test;

public class CalculationTest {

    @Test (expected = IllegalArgumentException.class)
    public void TestAddNullBasketThrowsException() {
        new Calculation(null);
    }

}
