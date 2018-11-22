package shop;

public class MultiBuyProduct extends Product{
	private int minDiscountedQuantity;
	private int discountPercent;
	public MultiBuyProduct(String name, double price, int quantity, int minDiscountedQuantity, int discountPercent) {
		super(name, price, quantity);
		this.minDiscountedQuantity = minDiscountedQuantity;
		this.discountPercent = discountPercent;
	}
	
	public int getMinDiscountedQuantity() {
		return minDiscountedQuantity;
	}

	public void setMinDiscountedQuantity(int minDiscountedQuantity) {
		this.minDiscountedQuantity = minDiscountedQuantity;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public double getTotalPrice() {
		if(this.getQuantity()>=this.getMinDiscountedQuantity()) 
			return super.getTotalPrice()*(1-this.getDiscountPercent()/100.0);
		else return super.getTotalPrice();
	}
}
