package shop;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Ex2MyTest {
	public static final double TOLERANCE = 0.00001;
	private Product product,multiBuyProduct;
	private ShoppingCart shoppingCart;
	
	@Before
	public void setUp() {
		product = new Product("Apple",2.535,5);
		multiBuyProduct = new MultiBuyProduct("Orange",1.686,10,5,3);
		shoppingCart = new ShoppingCart();
		shoppingCart.add(product);
		shoppingCart.add(multiBuyProduct);
	}
	
	//Test for total price for product
	@Test
	public void test1() {
		double expectedPrice = 12.68;
		double actualPrice = product.getTotalPrice();
		
		assertEquals(expectedPrice,actualPrice,TOLERANCE);
	}
	
	//Test for total price for multiBuyProduct with discount
	@Test
	public void test2() {
		double expectedPrice = 16.35;
		double actualPrice = multiBuyProduct.getTotalPrice();
		
		assertEquals(expectedPrice,actualPrice,TOLERANCE);
	}
	
	//Test for total price for multiBuyProduct without discount
	@Test
	public void test3() {
		multiBuyProduct.setQuantity(3);
		double expectedPrice = 5.06;
		double actualPrice = multiBuyProduct.getTotalPrice();
		
		assertEquals(expectedPrice,actualPrice,TOLERANCE);
	}
	
	//Test for adding two same products to shoppingCart
	@Test
	public void test4() {
		int expectedQuantity1 = 5;
		int actualQuantity1 = shoppingCart.getProductList().get(0).getQuantity();
		//Test quantity before adding the same product
		assertEquals(expectedQuantity1,actualQuantity1);
		
		Product product1 = new Product("Apple",2.535,8);
		shoppingCart.add(product1);
		int expectedQuantity2 = 13;
		int actualQuantity2 = shoppingCart.getProductList().get(0).getQuantity();
		//Test quantity after adding the same product
		assertEquals(expectedQuantity2,actualQuantity2);
	}
	
	//Test for adding two same multiBuyProducts to shoppingCart
	@Test
	public void test5() {
		int expectedQuantity1 = 10;
		int actualQuantity1 = shoppingCart.getProductList().get(1).getQuantity();
		//Test quantity before adding the same product
		assertEquals(expectedQuantity1,actualQuantity1);
		
		Product product1 = new MultiBuyProduct("Orange",1.686,15,5,3);
		shoppingCart.add(product1);
		int expectedQuantity2 = 25;
		int actualQuantity2 = shoppingCart.getProductList().get(1).getQuantity();
		//Test quantity after adding the same product
		assertEquals(expectedQuantity2,actualQuantity2);
	}
	
	//Test for toString method for shoppingCart
	@Test
	public void test6() {
		String expected = " 5 * GBP    2.54 Apple           = GBP   12.68\n" + 
						  "10 * GBP    1.69 Orange          = GBP   16.35\n" + 
						  "  (Multibuy Discount: GBP 0.51)\n" + 
						  "                                --------------\n" + 
						  "                             TOTAL GBP   29.03";
		String actual = shoppingCart.toString();
		
		assertEquals(expected,actual);
	}
}
