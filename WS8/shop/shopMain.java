package shop;

public class shopMain {
	public static void main(String[] args) {
		Product p =new Product("Milk (1l)", 1.10, 1);
		Product p2 =new Product("Bread", 0.78, 2);
		Product p3 =new Product("Apples", 0.49, 4);
		Product p4 = new MultiBuyProduct("Tomato", 0.5, 20, 10, 3);
		//Product p5 = new MultiBuyProduct("Tomato", 0.5, 20, 10, 3);
		
		ShoppingCart c = new ShoppingCart();
		c.add(p);
		c.add(p2);
		c.add(p4);
		c.add(p3);
		//c.add(p5);
		
		System.out.println(c);
	}
}
