import java.util.ArrayList;
import java.util.HashMap;

public class PosCalculator {

    //BogOf = Buy one get one free
    HashMap<String, Product> _productListingBogOf;
    HashMap<String, Product>  _productListing3For2;

    public PosCalculator(ArrayList<Product> productListingBogOf, ArrayList<Product> productListing3For2) {
        _productListing3For2 = new HashMap<String, Product>();
        _productListingBogOf = new HashMap<String, Product>();

        if (productListing3For2 != null) {
            for (Product p : productListing3For2) {
                _productListing3For2.put(p.getId(), p);
            }
        }

        if (productListingBogOf != null) {
            for (Product p : productListingBogOf) {
                _productListingBogOf.put(p.getId(), p);
            }
        }
    }

    public Calculation CalculateBasketCost(Basket basket) {
        Calculation calculation = new Calculation(basket);

        for (Basket.BasketItem item : basket.getBasket().values()) {
            Product product = item.getProduct();
            int count = item.getCount();

            if (IsEntitledFor3For2(product)) {
                int numberFree = count / 3;
                if (numberFree > 0)
                {
                    double discountValue = product.getItemPrice() * numberFree;
                    calculation.AddDiscount(product, discountValue, String.format("3 for 2 on %1$s, %2$d free, save £%3$.2f", product.getName(), numberFree, discountValue) );
                }
            } else if (IsEntitledForBogOf(product)) {
                int numberFree = count / 2;
                if (numberFree > 0)
                {
                    double discountValue = product.getItemPrice() * numberFree;
                    calculation.AddDiscount(product, discountValue, String.format("BOGOF on %1$s, %2$d free, save £%3$.2f", product.getName(), numberFree, discountValue) );
                }
            }
        }

        return calculation;
    }

    public void PrintCalculation (Calculation calculation) {

        for (Basket.BasketItem item : calculation.getBasket().getBasket().values()) {
            Product product = item.getProduct();

            for (int i = 0; i < item.getCount(); i++) {
                System.out.println(String.format("%1$s %2$s", product.getNameWithRightPadding(), product.getItemPrice2DecimalPlaces()));
            }
        }

        if (calculation.HasDiscounts()) {
            System.out.println();
            System.out.println(String.format("Balance before savings £%.2f", calculation.TotalBeforeDiscount()));

            for (Calculation.Discount discount : calculation.getDiscounts()) {
                System.out.println(discount.getDiscountText());
            }
            System.out.println(String.format("Total discount £%.2f", calculation.TotalDiscount()));
            System.out.println();
        }

        System.out.println(String.format("Balance to pay £%.2f", calculation.TotalAfterDiscount()));
    }

    public void CalculateAndPrintBasket(Basket basket)
    {
        Calculation calculation = CalculateBasketCost(basket);
        PrintCalculation(calculation);
    }

    private boolean IsEntitledForBogOf(Product product) {
        return _productListingBogOf.containsKey(product.getId());
    }

    private boolean IsEntitledFor3For2(Product product) {
        return _productListing3For2.containsKey(product.getId());
    }

}
