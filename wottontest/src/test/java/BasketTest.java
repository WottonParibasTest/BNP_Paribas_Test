import org.junit.Test;

public class BasketTest {

    @Test (expected = IllegalArgumentException.class)
    public void TestAddNullproductThrowsException() {
        Basket basket = new Basket();
        basket.AddToBasket(null, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestAddNegativeProductCountThrowsException() {
        Basket basket = new Basket();
        basket.AddToBasket(new Product("A", 0.1), -1);
    }

}
