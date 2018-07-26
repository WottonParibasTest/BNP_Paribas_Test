import java.util.ArrayList;

public class Calculation {
    private Basket _basket;
    private ArrayList<Discount> _discounts;

    public Calculation(Basket basket)
    {
        if (basket == null) {
            throw new IllegalArgumentException("Basket can not be null");
        }
        _basket = basket;
        _discounts = new ArrayList<Discount>();
    }

    public ArrayList<Discount> getDiscounts() {
        return _discounts;
    }

    public Basket getBasket() {
        return _basket;
    }

    public void AddDiscount(Product product, double discount, String discountText)
    {
        _discounts.add(new Discount(product, discount, discountText));
    }

    public double TotalBeforeDiscount() {
        double total = 0;
        for (Basket.BasketItem item : _basket.getBasket().values()) {
            total += item.getProduct().getItemPrice() * item.getCount();
        }

        return total;
    }

    public double TotalDiscount() {
        double total = 0;

        for (Discount discount : _discounts) {
            total += discount._discount;
        }

        return total;
    }

    public double TotalAfterDiscount() {
        return TotalBeforeDiscount() - TotalDiscount();
    }

    public boolean HasDiscounts() {
        return !_discounts.isEmpty();
    }



    public class Discount {
        private Product _product;
        private double _discount;
        private String _discountText;

        public Discount (Product product, double discount, String text)
        {
            _product = product;
            _discount = discount;
            _discountText = text;
        }


        public Product getProduct() {
            return _product;
        }

        public double getDiscount() {
            return _discount;
        }

        public String getDiscountText() {
            return _discountText;
        }
    }
}
