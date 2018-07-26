import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PosCalculatorTest {

    private double _delta = 0.00000001;
    @Test
    public void TestBogOfAppliedCorrectly() {
        Product apple = new Product("Apple", 0.2);

        Basket basket = new Basket();
        basket.AddToBasket(apple, 5);

        ArrayList<Product> bogof = new ArrayList<Product>();
        bogof.add(apple);

        ArrayList<Product> threeForTwo = new ArrayList<Product>();

        PosCalculator calculator = new PosCalculator(bogof, threeForTwo);
        Calculation calc = calculator.CalculateBasketCost(basket);
        assertEquals(0.4, calc.TotalDiscount(), _delta);
    }

    @Test
    public void TestThreeForTwoCorrectlyApplied() {
        Product watermelon = new Product("Watermelon", 0.8);

        Basket basket = new Basket();

        basket.AddToBasket(watermelon, 5);

        ArrayList<Product> bogof = new ArrayList<Product>();

        ArrayList<Product> threeForTwo = new ArrayList<Product>();
        threeForTwo.add(watermelon);

        PosCalculator calculator = new PosCalculator(bogof, threeForTwo);
        Calculation calc = calculator.CalculateBasketCost(basket);
        assertEquals(0.8, calc.TotalDiscount(), _delta);
    }

    @Test
    public void TestMixedOffersTotalsCorrect() {
        Product apple = new Product("Apple", 0.2);
        Product orange = new Product("Orange", 0.5);
        Product watermelon = new Product("Watermelon", 0.8);

        Basket basket = new Basket();
        basket.AddToBasket(apple, 4);
        basket.AddToBasket(orange, 3);
        basket.AddToBasket(watermelon, 5);

        ArrayList<Product> bogof = new ArrayList<Product>();
        bogof.add(apple);

        ArrayList<Product> threeForTwo = new ArrayList<Product>();
        threeForTwo.add(watermelon);

        PosCalculator calculator = new PosCalculator(bogof, threeForTwo);
        Calculation calc = calculator.CalculateBasketCost(basket);
        assertEquals(6.3, calc.TotalBeforeDiscount(), _delta);
        assertEquals(5.1, calc.TotalAfterDiscount(), _delta);
        assertEquals(1.2, calc.TotalDiscount(), _delta);

    }


}

