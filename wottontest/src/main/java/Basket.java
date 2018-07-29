import java.util.HashMap;

public class Basket {

    private HashMap<String, BasketItem> _basket;

    public Basket() {
        _basket = new HashMap<String, BasketItem>();
    }

    public void AddToBasket(Product product, int count) {
        if (count < 1) {
            throw new IllegalArgumentException(String.format("Product can not be added to basket with a negative count, count is: %1d", count));
        }

        if (product == null) {
               throw new IllegalArgumentException("Product can not be null");
        }

        String key = product.getId();

        if (_basket.containsKey(key)) {
             BasketItem item = _basket.get(key);
             item.IncrementCount(count);
        }
        else {
            BasketItem item = new BasketItem(product, count);
            _basket.put(key, item);
        }
    }

    public HashMap<String, BasketItem> getBasket() {
        return _basket;
    }

    public class BasketItem {

        private Product _product;
        private int _count;

        public BasketItem(Product product, int count) {

            _product = product;
            _count = count;
        }

        public void IncrementCount(int incrementBy) {
           _count += incrementBy;
        }

        public Product getProduct() {
            return _product;
        }

        public int getCount() {
            return _count;
        }


    }
}
