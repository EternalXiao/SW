package shop;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Product> productList = new ArrayList<>();

	public ShoppingCart() {
	}
	
	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public void add(Product p) {
		if(this.getProductList().contains(p)) {
			Product p1=this.getProductList().get(this.getProductList().indexOf(p));
			p1.setQuantity(p1.getQuantity()+p.getQuantity());
		}
		else this.getProductList().add(p);
	}
	
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
