import java.io.IOException;
import java.util.ArrayList;

public class Main {

    /*
    Based on the brief requirements I do not want to add unrequested functionality so am listing here my thoughts...

    Assumptions and observations based on requirements:
    * This is a very simple POS system where offers are applied to one product only and not across a range of products.
    * A basket may have multiple enteries for the same item
    * You may only buy discrete number of items, i.e. quantity is an integer, no loose items by weight are sold
    * No user interface is required, the basket, products and offers may be hardcoded
    * Prices do not vary over time and are only sold in Stirling.
    * Only the offers detailed in the script may be supported.
    * You can not put something in your basket which is not known.
    * At most only one offer can be applied to a product.
    * Assume code readability is prefered over performance for such a task.
    *  Output will follow usual receipt convention of:
     *      Calculate amount without discount on all items and show total
     *      Then apply discounts and show discount total
     *      Then show total due
     *      Assume order of products on the receipt is not important.
     *      Based on Marks and Spencer receipt multiple items are listed individually.
     */
    public static void main(String[] args)
    throws IOException {
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
        calculator.CalculateAndPrintBasket(basket);

        System.out.println();
        System.out.println("Press any key to exit");
        System.in.read();
    }
}
