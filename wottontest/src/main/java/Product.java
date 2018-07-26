public class Product {

    private double _price;
    private String _name;

    public Product(String name, double price)
    {
        _name = name;
        _price = price;
    }


    public double getItemPrice() {
        return _price;
    }


    public String getName() {
        return _name;
    }

    public String getId() {
        return _name.toLowerCase();
    }

    public String getNameWithRightPadding() {
        return String.format("%1$-20s", _name);
    }

    public String getItemPrice2DecimalPlaces() {
        return String.format("%1$.2f", _price);
    }

}
