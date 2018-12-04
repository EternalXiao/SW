/**
 * MultiBuyProduct is a sub-class of class Product.
 * It is characterised by two additional field variables:
 * <pre>
 *  minDiscountedQuantity, the minimal quantity to get the discount
 *  discountPercent, the percentage of the discount
 * </pre> 
 */

package shop;

public class MultiBuyProduct extends Product{
	private int minDiscountedQuantity;
	private int discountPercent;
	
	/**
	 * Constructor for MultiBuyProduct
	 * @param name the name of the product
	 * @param price the unit price of the product
	 * @param quantity the number of product to buy
	 * @param minDiscountedQuantity the minimal number to get discount
	 * @param discountPercent the percentage of discount
	 */
	public MultiBuyProduct(String name, double price, int quantity, int minDiscountedQuantity, int discountPercent) {
		super(name, price, quantity);
		this.minDiscountedQuantity = minDiscountedQuantity;
		this.discountPercent = discountPercent;
	}
	
	/**
	 * Getter method for minDiscountedQuantity
	 * @return the minimal amount to get discount
	 */
	public int getMinDiscountedQuantity() {
		return minDiscountedQuantity;
	}

	/**
	 * Setter method for minDiscountedQuantity
	 * @param minDiscountedQuantity the new minimal amount for discount
	 */
	public void setMinDiscountedQuantity(int minDiscountedQuantity) {
		this.minDiscountedQuantity = minDiscountedQuantity;
	}

	/**
	 * Getter method for the percentage of discount
	 * @return the discount percentage
	 */
	public int getDiscountPercent() {
		return discountPercent;
	}

	/**
	 * Setter method for discount percentage
	 * @param discountPercent new discount percentage to be set
	 */
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * Method to compute the total price for the product
	 * @return the total price for this product
	 */
	public double getTotalPrice() {
		if(this.getQuantity()>=this.getMinDiscountedQuantity()) 
			return super.getTotalPrice()*(1-this.getDiscountPercent()/100.0);
		else return super.getTotalPrice();
	}
}
