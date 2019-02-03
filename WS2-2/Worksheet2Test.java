import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Xiaolong Meng
 * 
 *
 */

public class Worksheet2Test {
	private Tree<Integer> BT1, BT2, BT3, BST1, BST2, BST3, AVL1, AVL2, AVL3;

	@Before
	public void setUp() {
		BT1 = new Tree<>(1,new Tree<>(2,new Tree<>(3),new Tree<>(4)),new Tree<>(5,new Tree<>(6),new Tree<>()));
		BT2 = new Tree<>(5,new Tree<>(-3,new Tree<>(),new Tree<>(8)),new Tree<>(9,new Tree<>(),new Tree<>(-10)));
		BT3 = new Tree<>(0,new Tree<>(1),new Tree<>(5,new Tree<>(-5),new Tree<>(9)));
		BST1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)), new Tree<>(8, new Tree<>(6), new Tree<>(9)));
		BST2 = new Tree<>(10,new Tree<>(5,new Tree<>(-3),new Tree<>(8)),new Tree<>(20,new Tree<>(),new Tree<>(100)));
		BST3 = new Tree<>(-9,new Tree<>(-100,new Tree<>(),new Tree<>(-50)),new Tree<>(100,new Tree<>(80,new Tree<>(60),new Tree<>()),new Tree<>()));
		AVL1 = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)), new Tree<>(8, new Tree<>(6), new Tree<>(9)));
		AVL2 = new Tree<>(10,new Tree<>(5,new Tree<>(-3),new Tree<>(8)),new Tree<>(20,new Tree<>(),new Tree<>(100)));
	}

	//Test for negateAll
	@Test
	public void test1() {
		Tree<Integer> expected1 = new Tree<>(-1,new Tree<>(-2,new Tree<>(-3),new Tree<>(-4)),new Tree<>(-5,new Tree<>(-6),new Tree<>()));
		Tree<Integer> expected2 = new Tree<>(-5,new Tree<>(3,new Tree<>(),new Tree<>(-8)),new Tree<>(-9,new Tree<>(),new Tree<>(10)));
		Tree<Integer> expected3 = new Tree<>(0,new Tree<>(-1),new Tree<>(-5,new Tree<>(5),new Tree<>(-9)));
		assertEquals(Worksheet2.negateAll(BT1),expected1);
		assertEquals(Worksheet2.negateAll(BT2),expected2);
		assertEquals(Worksheet2.negateAll(BT3),expected3);
	}
	
	//Test for allPositive
	@Test(expected=IllegalArgumentException.class)
	public void test2() {
		Tree<Integer> BT4 = new Tree<>();
		assertTrue(Worksheet2.allPositive(BT1));
		assertFalse(Worksheet2.allPositive(BT2));
		assertFalse(Worksheet2.allPositive(BT3));
		//Test for empty tree
		Worksheet2.allPositive(BT4);
	}
	
	//Test for level
	@Test
	public void test3() {
		int expected1 = 3;
		int expected2 = 2;
		int expected3 = 0;
		assertEquals(Worksheet2.level(BT1, 6),expected1);
		assertEquals(Worksheet2.level(BT1, 2),expected2);
		assertEquals(Worksheet2.level(BT1, 10),expected3);
	}
	
	//Test for postorder
	@Test
	public void test4() {
		List<Integer> expected1 = new List<>(3,new List<>(4,new List<>(2,new List<>(6,new List<>(5,new List<>(1,new List<>()))))));
		List<Integer> expected2 = new List<>(8,new List<>(-3,new List<>(-10,new List<>(9,new List<>(5,new List<>())))));
		List<Integer> expected3 = new List<>(1,new List<>(-5,new List<>(9,new List<>(5,new List<>(0,new List<>())))));
		assertEquals(Worksheet2.postorder(BT1),expected1);
		assertEquals(Worksheet2.postorder(BT2),expected2);
		assertEquals(Worksheet2.postorder(BT3),expected3);
	}
	
	//Test for isSearchTree
	@Test(expected=IllegalArgumentException.class)
	public void test5() {
		Tree<Integer> T = new Tree<>();
		assertFalse(Worksheet2.isSearchTree(BT1));
		assertFalse(Worksheet2.isSearchTree(BT2));
		assertTrue(Worksheet2.isSearchTree(BST1));
		assertTrue(Worksheet2.isSearchTree(BST2));
		Worksheet2.isSearchTree(T);
	}
	
	//Test for max
	@Test(expected=IllegalArgumentException.class)
	public void test6() {
		int expected1=9;
		int expected2=100;
		int expected3=100;
		Tree<Integer> T = new Tree<>();
		assertEquals(Worksheet2.max(BST1),expected1);
		assertEquals(Worksheet2.max(BST2),expected2);
		assertEquals(Worksheet2.max(BST3),expected3);
		Worksheet2.max(T);
	}
	
	//Test for delete
	@Test
	public void test7() {
		Tree<Integer> expected1 = new Tree<>(10,new Tree<>(5,new Tree<>(-3),new Tree<>(8)),new Tree<>(20));
		Tree<Integer> expected2 = new Tree<>(10,new Tree<>(5,new Tree<>(-3),new Tree<>(8)),new Tree<>(100));
		Tree<Integer> expected3 = new Tree<>(8,new Tree<>(5,new Tree<>(-3),new Tree<>()),new Tree<>(20,new Tree<>(),new Tree<>(100)));
		assertEquals(Worksheet2.delete(BST2, 100),expected1);
		assertEquals(Worksheet2.delete(BST2, 20),expected2);
		assertEquals(Worksheet2.delete(BST2, 10),expected3);
	}
	
	//Test for isHeightBalanced
	@Test
	public void test8() {
		assertFalse(Worksheet2.isHeightBalanced(BST3));
		assertTrue(Worksheet2.isHeightBalanced(AVL1));
		assertTrue(Worksheet2.isHeightBalanced(AVL2));
	}
	
	//Test for insertHB
	@Test 
	public void test9() {
		Tree<Integer> initialTree = new Tree<>(100,new Tree<>(50),new Tree<>(200));
		
		Tree<Integer> expected1 = new Tree<>(100,new Tree<>(50,new Tree<>(45),new Tree<>()),new Tree<>(200));
		Tree<Integer> actual1 = Worksheet2.insertHB(initialTree, 45);
		assertEquals(actual1,expected1);
		
		Tree<Integer> expected2 = new Tree<>(100,new Tree<>(47,new Tree<>(45),new Tree<>(50)),new Tree<>(200));
		Tree<Integer> actual2 = Worksheet2.insertHB(actual1, 47);
		assertEquals(actual2,expected2);
		
		Tree<Integer> expected3 = new Tree<>(50,new Tree<>(47,new Tree<>(45),new Tree<>()),new Tree<>(100,new Tree<>(51),new Tree<>(200)));
		Tree<Integer> actual3 = Worksheet2.insertHB(actual2, 51);
		assertEquals(actual3,expected3);
	}
	
	//Test for deleteHB
	@Test
	public void test10() {
		Tree<Integer> initialTree = new Tree<>(50,new Tree<>(47,new Tree<>(45),new Tree<>()),new Tree<>(100,new Tree<>(51),new Tree<>(200)));
		
		Tree<Integer> expected1 = new Tree<>(47,new Tree<>(45),new Tree<>(100,new Tree<>(51),new Tree<>(200)));
		Tree<Integer> actual1 = Worksheet2.deleteHB(initialTree, 50);
		assertEquals(actual1,expected1);
		
		Tree<Integer> expected2 = new Tree<>(100,new Tree<>(47,new Tree<>(),new Tree<>(51)),new Tree<>(200));
		Tree<Integer> actual2 = Worksheet2.deleteHB(actual1, 45);
		assertEquals(actual2,expected2);
		
		Tree<Integer> expected3 = new Tree<>(51,new Tree<>(47),new Tree<>(100));
		Tree<Integer> actual3 = Worksheet2.deleteHB(actual2, 200);
		assertEquals(actual3,expected3);
	}
}
