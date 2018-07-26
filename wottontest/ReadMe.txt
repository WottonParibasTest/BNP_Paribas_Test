This project should be built using Maven.
	
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
	 
	 
Sample output:

Orange               0.50
Orange               0.50
Orange               0.50
Apple                0.20
Apple                0.20
Apple                0.20
Apple                0.20
Watermelon           0.80
Watermelon           0.80
Watermelon           0.80
Watermelon           0.80
Watermelon           0.80

Balance before savings £6.30
BOGOF on Apple, 2 free, save £0.40
3 for 2 on Watermelon, 1 free, save £0.80
Total discount £1.20

Balance to pay £5.10

Press any key to exit