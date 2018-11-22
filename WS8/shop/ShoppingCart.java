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
}
