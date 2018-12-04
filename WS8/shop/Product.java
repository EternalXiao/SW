/**
 * Product is a class characterised by three field variables:
 * <pre>
 *  name, the name of the product
 *  price, the price of the product
 *  quantity, the number of product to buy
 * </pre>
 */

package shop;

public class Product {
	private String name;
	private double price;
	private int quantity;
	
	/**
	 * Constructor for Product
	 * @param name the name of the product
	 * @param price the unit price of the product
	 * @param quantity total number of product to buy
	 */
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * Getter for name
	 * @return the name of the product
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter method for name
	 * @param name new product name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter method for price
	 * @return the price of the product
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Setter method for price
	 * @param price new product price to be set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Getter method for product quantity
	 * @return the number of product to buy
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Setter method for product quantity
	 * @param quantity new product quantity to be set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Method to compute the total price of the product
	 * with unit price times quantity
	 * @return the total price for this product
	 */
	public double getTotalPrice() {
		return Math.round(this.getPrice()*this.getQuantity()*100)/100.0;
	}
	
	/**
	 * An overriden method to check whether two products
	 * are the same by comparing the product name and price
	 */
	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof Product)) return false;
		Product p = (Product) other;
		if(this.getName().equals(p.getName())&&this.getPrice()==p.getPrice()) return true;
		else return false;
	}
}
