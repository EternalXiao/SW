/**
 * ShoppingCart is a class characterised by a field variable
 * <pre>
 *  productList, a list of products
 * </pre>
 */

package shop;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Product> productList;

	/**
	 * Constructor for class ShoppingCart
	 */
	public ShoppingCart() {
		productList = new ArrayList<>();
	}
	
	/**
	 * Getter method for product list
	 * @return a list of products in the shoppingcart
	 */
	public ArrayList<Product> getProductList() {
		return productList;
	}

	/**
	 * Setter method for product list
	 * @param productList new product list to be set to shoppingcart
	 */
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	/**
	 * Method to add a new product to the shoppingcart
	 * @param p the new product to add
	 */
	public void add(Product p) {
		if(this.getProductList().contains(p)) {
			Product p1=this.getProductList().get(this.getProductList().indexOf(p));
			p1.setQuantity(p1.getQuantity()+p.getQuantity());
		}
		else this.getProductList().add(p);
	}
	
	/**
	 * toString method for printing
	 * @return the shoppingcart represented as a string
	 */
	public String toString() {
		String o = "";
		double sum = 0;
		for(Product p : this.getProductList()) {
			o += String.format("%2d * GBP %7.2f %-15s = GBP %7.2f",p.getQuantity(),p.getPrice(),p.getName(),p.getTotalPrice());
			o += "\n";
			if(p instanceof MultiBuyProduct) {
				o += String.format("  (Multibuy Discount: GBP %4.2f)", (100.0/(100-((MultiBuyProduct)p).getDiscountPercent())*p.getTotalPrice()-p.getTotalPrice()));
				o += "\n";
			}
			sum += p.getTotalPrice();
		}
		o += "                                --------------\n";
		o += String.format("                             TOTAL GBP %7.2f", sum);
		return o;
	}
}
