/**
 * 
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

	// Exercise 1

	static Tree<Integer> negateAll(Tree<Integer> t) {
		if (t.isEmpty())
			return new Tree<>();
		else
			return new Tree<>(-t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));
	}

	// Exercise 2

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

	static <E> List<E> postorder(Tree<E> a) {
		if (a.isEmpty())
			return new List<>();
		else
			return append(postorder(a.getLeft()), addToEnd(postorder(a.getRight()), a.getValue()));
	}

	// Exercise 5

	static boolean isSearchTree(Tree<Integer> a) {
		if (a.getLeft().isEmpty() && a.getRight().isEmpty())
			return true;
		else if (a.getLeft().isEmpty())
			return a.getValue() < a.getRight().getValue() & isSearchTree(a.getRight());
		else if (a.getRight().isEmpty())
			return a.getValue() > a.getLeft().getValue() & isSearchTree(a.getLeft());
		else
			return a.getValue() > a.getLeft().getValue() & a.getValue() < a.getRight().getValue()
					& isSearchTree(a.getLeft()) & isSearchTree(a.getRight());
	}

	// Exercise 6

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

	static int max(Tree<Integer> a) {
		if (a.getRight().isEmpty())
			return a.getValue();
		else
			return max(a.getRight());
	}

	// Exercise 8

	static Tree<Integer> delete(Tree<Integer> a, int x) {
		if (a.getLeft().isEmpty() & a.getRight().isEmpty())
			return new Tree<>();
		else if (a.getLeft().isEmpty())
			return new Tree<>(a.getRight().getValue(), a.getRight().getLeft(), a.getRight().getRight());
		else if (a.getRight().isEmpty())
			return new Tree<>(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight());
		else
			return new Tree<>(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), a.getRight());
	}

	// Exercise 9
	static <E> boolean isHeightBalanced(Tree<E> a) {
		if (a.isEmpty())
			return true;
		else
			return Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) <= 1 && isHeightBalanced(a.getLeft())
					&& isHeightBalanced(a.getRight());

	}

	// Exercise 10

	static Tree<Integer> insertHB(Tree<Integer> a, int x) {
		Tree<Integer> t = insert(x, a);
		if (isHeightBalanced(t))
			return t;
		else
			return heightBalance(t);
	}

	static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		Tree<Integer> t = delete(a, x);
		if (isHeightBalanced(t))
			return t;
		else
			return heightBalance(t);
	}

	public static <E> List<E> append(List<E> a, List<E> b) {
		if (a.isEmpty()) {
			return b;
		} else {
			return new List<>(a.getHead(), append(a.getTail(), b));
		}
	}

	public static <E> List<E> addToEnd(List<E> a, E x) {
		if (a.isEmpty()) {
			return new List<>(x, new List<>());
		} else {
			return new List<>(a.getHead(), addToEnd(a.getTail(), x));
		}
	}

	public static Tree<Integer> insert(int x, Tree<Integer> a) {

		if (a.isEmpty())
			return new Tree<>(x);

		else if (x < a.getValue())
			return new Tree<>(a.getValue(), insert(x, a.getLeft()), a.getRight());

		else
			return new Tree<>(a.getValue(), a.getLeft(), insert(x, a.getRight()));

	}

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

	public static void main(String[] args) {
		Tree<Integer> t = new Tree<>(5, new Tree<>(3, new Tree<>(1), new Tree<>(4)),
				new Tree<>(8, new Tree<>(6), new Tree<>(9)));
		Tree<Integer> g = new Tree<>(1, new Tree<>(2, new Tree<>(3), new Tree<>(4)),
				new Tree<>(5, new Tree<>(6), new Tree<>(7)));
		Tree<Integer> f = new Tree<>(1, new Tree<>(2, new Tree<>(3), new Tree<>(4)), new Tree<>());
		Tree<Integer> ins = new Tree<>(100, new Tree<>(47, new Tree<>(45), new Tree<>(50)), new Tree<>(200));
		Tree<Integer> t1;
		t1 = insertHB(ins, 51);
		System.out.println(t1);
		// printDescending(t);
	}
}
