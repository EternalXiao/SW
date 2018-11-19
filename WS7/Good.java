public class Good {
	private String orderCode;
	private int price;
	private boolean availability;
	
	public Good(String orderCode, int price, boolean availability) { 
		this.orderCode = orderCode;
		this.price = price;
		this.availability = availability;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	
}
