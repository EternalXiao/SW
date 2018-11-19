public class Customer {
	private String name;
	private String address;
	private int turnOver;
	private boolean goldStatus;
	public Customer(String name, String address, int turnOver) {
		this.name = name;
		this.address = address;
		this.turnOver = turnOver;
		this.goldStatus = turnOver >= 200;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(int turnOver) {
		this.turnOver = turnOver;
	}

	public boolean isGoldStatus() {
		return goldStatus;
	}

	public void setGoldStatus(boolean goldStatus) {
		this.goldStatus = goldStatus;
	}

	public double toPay(int price) {
		if(this.goldStatus) return (double)price*0.95;
		return (double)price;
	}
	
}
