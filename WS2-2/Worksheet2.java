/**
 * 
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1
	/**
	 * This method negate all the elements as the return tree
	 * 
	 * @param t an input tree
	 * @return element negated tree
	 */
	static Tree<Integer> negateAll(Tree<Integer> t) {
		if (t.isEmpty())
			return new Tree<>();
		else
			return new Tree<>(-t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));
	}

	// Exercise 2
	/**
	 * This method check whether all the elements of a given tree are positive
	 * 
	 * @param a an input tree
	 * @return true if all the elements are positive, else false
	 */
	static boolean allPositive(Tree<Integer> a) {
		if (a.isEmpty())
			throw new IllegalArgumentException();
		else if (a.getLeft().isEmpty() & a.getRight().isEmpty())
			return a.getValue() > 0;
		else if (a.getLeft().isEmpty())
			return a.getValue() > 0 & allPositive(a.getRight());
		else if (a.getRight().isEmpty())
			return a.getValue() > 0 & allPositive(a.getLeft());
		else
			return a.getValue() > 0 & allPositive(a.getLeft()) & allPositive(a.getRight());
	}

	// Exercise 3
	/**
	 * This method search the level of a given integer. If found, return the level
	 * in the tree, else return 0.
	 * 
	 * @param a an input tree
	 * @param x the integer to search
	 * @return the level of the given integer if found, else 0.
	 */
	static int level(Tree<Integer> a, int x) {
		if (a.isEmpty())
			return 0;
		else if (a.getValue() == x)
			return 1;
		else
			return (level(a.getLeft(), x) > 0 ? 1 + level(a.getLeft(), x) : 0)
					+ (level(a.getRight(), x) > 0 ? 1 + level(a.getRight(), x) : 0);
	}

	// Exercise 4
	/**
	 * This method traverse a tree in postorder
	 * 
	 * @param a the tree to traverse
	 * @return the postorder tree represented as a list
	 */
	static <E> List<E> postorder(Tree<E> a) {
		if (a.isEmpty())
			return new List<>();
		else
			return append(postorder(a.getLeft()), addToEnd(postorder(a.getRight()), a.getValue()));
	}

	// Exercise 5
	/**
	 * This method checks whether a given tree is a binary search tree
	 * 
	 * @param a the input tree
	 * @return true if it is a binary search tree, else false
	 */
	static boolean isSearchTree(Tree<Integer> a) {
		if (a.isEmpty())
			throw new IllegalArgumentException();
		else
			return sorted(inorder(a));
	}

	// Exercise 6
	/**
	 * This method print the elements of a binary search tree in descending order
	 * 
	 * @param a the input tree
	 */
	static void printDescending(Tree<Integer> a) {
		if (a.isEmpty())
			return;
		else {
			printDescending(a.getRight());
			System.out.println(a.getValue());
			printDescending(a.getLeft());
		}
	}

	// Exercise 7
	/**
	 * This method finds the maximum element in a binary search tree
	 * 
	 * @param a the input tree
	 * @return the maximum element
	 */
	static int max(Tree<Integer> a) {
		if (a.isEmpty())
			throw new IllegalArgumentException();
		else if (a.getRight().isEmpty())
			return a.getValue();
		else
			return max(a.getRight());
	}

	// Exercise 8
	/**
	 * This method deletes a given integer in the binary search tree and returns a
	 * binary search tree after deletion
	 * 
	 * @param a the input tree
	 * @param x an integer to be deleted
	 * @return the tree after deletion
	 */
	static Tree<Integer> delete(Tree<Integer> a, int x) {
		if (a.isEmpty())
			return new Tree<>();
		else if (a.getValue() == x) {
			if (a.getLeft().isEmpty() & a.getRight().isEmpty())
				return new Tree<>();
			else if (a.getLeft().isEmpty())
				return new Tree<>(a.getRight().getValue(), a.getRight().getLeft(), a.getRight().getRight());
			else if (a.getRight().isEmpty())
				return new Tree<>(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight());
			else
				return new Tree<>(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), a.getRight());
		} else if(a.getValue()>x)
			return new Tree<>(a.getValue(), delete(a.getLeft(), x), a.getRight());
		else {
			return new Tree<>(a.getValue(),a.getLeft(),delete(a.getRight(),x));
		}
	}

	// Exercise 9
	/**
	 * This method checks whether a given binary search tree is balanced
	 * 
	 * @param a the input tree
	 * @return true if the tree is balanced, else false
	 */
	static <E> boolean isHeightBalanced(Tree<E> a) {
		if (a.isEmpty())
			return true;
		else
			return Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) <= 1 && isHeightBalanced(a.getLeft())
					&& isHeightBalanced(a.getRight());

	}

	// Exercise 10
	/**
	 * This method inserts an element into a given AVL tree and returns an AVL tree
	 * after insertion
	 * 
	 * @param a the element to insert
	 * @param x the input tree
	 * @return the AVL tree after insertion
	 */
	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		Tree<Integer> t = insert(x, a);
		if (isHeightBalanced(t))
			return t;
		else
			return heightBalance(t);
	}

	/**
	 * This method deletes an element of a given AVL tree and returns an AVL tree
	 * after deletion
	 * 
	 * @param a the element to delete
	 * @param x the input tree
	 * @return the AVL tree after deletion
	 */
	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		Tree<Integer> t = delete(a, x);
		if (isHeightBalanced(t))
			return t;
		else
			return heightBalance(t);
	}

	/**
	 * This method concatenates a list b to the end of list a
	 * 
	 * @param a the first list
	 * @param b the second list
	 * @return the list after concatenation
	 */
	public static <E> List<E> append(List<E> a, List<E> b) {
		if (a.isEmpty()) {
			return b;
		} else {
			return new List<>(a.getHead(), append(a.getTail(), b));
		}
	}

	/**
	 * This method adds an element to the end of a list
	 * 
	 * @param a the element to add
	 * @param x the origin list
	 * @return the extended list
	 */
	public static <E> List<E> addToEnd(List<E> a, E x) {
		if (a.isEmpty()) {
			return new List<>(x, new List<>());
		} else {
			return new List<>(a.getHead(), addToEnd(a.getTail(), x));
		}
	}

	/**
	 * This method inserts an element into a binary search tree
	 * 
	 * @param x the element to insert
	 * @param a the binary search tree
	 * @return the binary search tree after insertion
	 */
	public static Tree<Integer> insert(int x, Tree<Integer> a) {

		if (a.isEmpty())
			return new Tree<>(x);

		else if (x < a.getValue())
			return new Tree<>(a.getValue(), insert(x, a.getLeft()), a.getRight());

		else
			return new Tree<>(a.getValue(), a.getLeft(), insert(x, a.getRight()));

	}

	/**
	 * This method performs the height balance algorithm to an unbalanced binary
	 * search tree
	 * 
	 * @param a the unbalanced binary search tree
	 * @return the height balanced binary search tree (AVL)
	 */
	public static Tree<Integer> heightBalance(Tree<Integer> a) {
		if (a.isEmpty())
			return new Tree<>();
		else if ((a.getRight().getHeight() - a.getLeft().getHeight()) == -2) {
			if (Math.abs(a.getLeft().getRight().getHeight() - a.getLeft().getLeft().getHeight()) == 2)
				return new Tree<>(a.getValue(), heightBalance(a.getLeft()), a.getRight());
			else if ((a.getLeft().getRight().getHeight() - a.getLeft().getLeft().getHeight()) <= 0)
				return new Tree<>(a.getLeft().getValue(), a.getLeft().getLeft(),
						new Tree<>(a.getValue(), a.getLeft().getRight(), a.getRight()));
			else
				return new Tree<>(a.getLeft().getRight().getValue(),
						new Tree<>(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight().getLeft()),
						new Tree<>(a.getValue(), a.getLeft().getRight().getRight(), a.getRight()));
		} else if ((a.getRight().getHeight() - a.getLeft().getHeight()) == 2) {
			if (Math.abs(a.getRight().getRight().getHeight() - a.getRight().getLeft().getHeight()) == 2)
				return new Tree<>(a.getValue(), a.getLeft(), heightBalance(a.getRight()));
			else if ((a.getRight().getRight().getHeight() - a.getRight().getLeft().getHeight()) >= 0)
				return new Tree<>(a.getRight().getValue(),
						new Tree<>(a.getValue(), a.getLeft(), a.getRight().getLeft()), a.getRight().getRight());
			else
				return new Tree<>(a.getRight().getLeft().getValue(),
						new Tree<>(a.getValue(), a.getLeft(), a.getRight().getLeft().getLeft()), new Tree<>(
								a.getRight().getValue(), a.getRight().getLeft().getRight(), a.getRight().getRight()));
		} else
			return new Tree<>(a.getValue(), heightBalance(a.getLeft()), heightBalance(a.getRight()));
	}

	/**
	 * This method traverses a binary tree in inorder
	 * 
	 * @param t the binary tree to traverse
	 * @return the inorder traversed tree represented as a list
	 */
	public static List<Integer> inorder(Tree<Integer> t) {
		if (t.isEmpty())
			return new List<>();
		else {
			return append(inorder(t.getLeft()), new List<>(t.getValue(), inorder(t.getRight())));
		}
	}

	/**
	 * This method checks whether a list is in ascending order (sorted)
	 * 
	 * @param a the input list
	 * @return true if sorted, else false
	 */
	static boolean sorted(List<Integer> a) {
		if (a.getTail().isEmpty())
			return true;
		else
			return a.getHead() <= a.getTail().getHead() & sorted(a.getTail());
	}

	public static void main(String[] args) {
		Tree<Integer> t = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>(9)));
		Tree<Integer> g = new Tree<>(29, new Tree<>(15, new Tree<>(3), new Tree<>(23, new Tree<>(22), new Tree<>())),
				new Tree<>(73, new Tree<>(59, new Tree<>(46), new Tree<>(65)),
						new Tree<>(83, new Tree<>(), new Tree<>(91))));
		Tree<Integer> f = new Tree<>(30, new Tree<>(20, new Tree<>(15), new Tree<>(25, new Tree<>(22), new Tree<>(31))),
				new Tree<>(40));
		Tree<Integer> ins = new Tree<>(100, new Tree<>(47, new Tree<>(45), new Tree<>(50)), new Tree<>(200));
		Tree<Integer> t1;
		t1 = insertHB(ins, 51);
		System.out.println(g);
		System.out.println(delete(g, 73));
		// printDescending(t);
	}
}
